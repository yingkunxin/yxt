package com.yk.config;

import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationTokenFilter implements Filter {


    private static final String TOKEN = "token";





    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            String token = ((HttpServletRequest) servletRequest).getHeader(TOKEN);
            if (!Strings.isNullOrEmpty(token)) {

            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
