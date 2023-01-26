package com.noah.solo.global.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.noah.solo.global.error.ErrorCode;
import com.noah.solo.global.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT Entity 조회 실패 filter
 */
@Component
public class JwtEntityNotFoundExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (UsernameNotFoundException exception) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_TOKEN);
            ObjectMapper objectMapper = new ObjectMapper();

            response.getWriter()
                    .write(objectMapper.writeValueAsString(errorResponse));
        }
    }

}
