package com.example.logviewer.user;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ResetPasswordInterceptor extends HandlerInterceptorAdapter {

    @Setter
    private String resetPath;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = (Authentication) request.getUserPrincipal();
        if (authentication == null) {
            return true;
        }
        Object principal = authentication.getPrincipal();

        if (principal instanceof CompanyUserDetails) {
            CompanyUserDetails user = (CompanyUserDetails) principal;
            if (user.getCompanyUser().getPasswordExpired()) {
                response.sendRedirect(request.getContextPath() + resetPath);
                return false;
            }
            log.debug("is customer");
            return true;
        }

        return true;
    }
}
