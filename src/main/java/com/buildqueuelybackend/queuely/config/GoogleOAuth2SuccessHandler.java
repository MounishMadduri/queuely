package com.buildqueuelybackend.queuely.config;

import com.buildqueuelybackend.queuely.entity.Role;
import com.buildqueuelybackend.queuely.entity.User;
import com.buildqueuelybackend.queuely.repository.UserRepository;
import com.buildqueuelybackend.queuely.security.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public GoogleOAuth2SuccessHandler(UserRepository userRepository,
                                      JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // Extract user details from Google
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        // Check if user exists, else create new
        User user = userRepository.findByEmail(email)
                .orElseGet(() -> userRepository.save(new User(name, email, Role.USER)));

        // Generate JWT
        String token = jwtTokenProvider.generateToken(user);

        // Send token back to frontend
        response.setContentType("application/json");
        response.getWriter().write("{\"token\":\"" + token + "\"}");
    }
}

