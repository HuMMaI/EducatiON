package org.lgs.lviv.education.config;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UserDetails principal = (UserDetails)authentication.getPrincipal();
        Optional<User> userMaybe = userService.findByEmail(principal.getUsername());

        userMaybe.ifPresent(user -> {
            request.getSession().setAttribute("userFirstName", user.getFirstName());
            request.getSession().setAttribute("userLastName", user.getLastName());
            request.getSession().setAttribute("userId", user.getId());
            request.getSession().setAttribute("userEmail", user.getEmail());
        });

        //todo add current url
        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        String redirectUrl = savedRequest == null ? "/" : savedRequest.getRedirectUrl();

        response.sendRedirect(redirectUrl);
    }
}
