//package com.example.pet.config.jwt;
//
//import com.example.pet.config.exception.CustomException;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//public class JwtTokenFilter extends OncePerRequestFilter {
//    private JwtTokenProvider jwtTokenProvider;
//
//    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//        String token = jwtTokenProvider.resolveToken(request);
//        try {
//            if (token != null && jwtTokenProvider.validateToken(token)) {
//                Authentication auth = jwtTokenProvider.getAuthentication(token);
//                // 정상 토큰이면 토큰을 통해 생성한 Authentication 객체를 SecurityContext에 저장
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//        } catch (CustomException e) {
//            SecurityContextHolder.clearContext();
//            response.sendError(e.getHttpStatus().value(), e.getMessage());
//            return;
//        }
//
//        filterChain.doFilter(request, response); // 다음 필터 체인 실행
//    }
//}