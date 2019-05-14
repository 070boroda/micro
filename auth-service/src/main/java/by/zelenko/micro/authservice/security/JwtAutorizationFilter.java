package by.zelenko.micro.authservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static by.zelenko.micro.authservice.property.SecurityConstants.*;

@Slf4j
public class JwtAutorizationFilter extends BasicAuthenticationFilter {


    public JwtAutorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        log.info("Попытка получить хедэр {}", request.getHeader(HEADER_STRING));
        String header = request.getHeader(HEADER_STRING);
        log.info("Получили хедэр {} ", header);
        if(header == null || !header.startsWith(TOKEN_PREFIX)){
            chain.doFilter(request, response);
            log.info("vs cltcm 2");
            return;
        }
        log.info("vs cltcm 3");
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        log.info("vs cltcm4");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.info("vs cltcm 5");
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        log.info("Header get " + token);
        if (token != null) {
            log.info("try verify token");
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        }
        log.info("token is null");
        return null;
    }
}
