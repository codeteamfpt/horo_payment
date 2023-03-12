package fpt.horo.payment.config;

import fpt.horo.payment.entity.ClientConfigEntity;
import fpt.horo.payment.entity.ClientUrlConfigEntity;
import fpt.horo.payment.repository.ClientConfigRepository;
import fpt.horo.payment.repository.ClientUrlConfigRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Slf4j
public class FilterConfig extends OncePerRequestFilter {
    @Autowired
    ClientConfigRepository clientConfigRepository;

    @Autowired
    ClientUrlConfigRepository clientUrlConfigRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {

        String command = httpServletRequest.getRequestURI();
        String clientId = "default";
        String clientSecret = "default";
        if (httpServletRequest.getHeader("Client-Id") != null && httpServletRequest.getHeader("Client-Secret") != null) {
            clientId = httpServletRequest.getHeader("Client-Id");
            clientSecret = httpServletRequest.getHeader("Client-Secret");
        }
        ClientConfigEntity clientConfig = clientConfigRepository.findFirstByClientId(clientId);
        if (clientConfig == null) {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            log.info("ClientId not found !!");
            return;
        }
        ClientUrlConfigEntity clientUrlConfig =  clientUrlConfigRepository.findFirstByClientIdAndClientUrl(clientId, command);
        if (clientUrlConfig == null) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("ClientUrl Invalid !!");
            return;
        }
        ClientConfigEntity clientConfigCheck = clientConfigRepository.findByClientIdAndClientSecret(clientId, clientSecret);
        if (!clientConfigCheck.getClientSecret().equals(clientSecret)) {
            log.info("Secret not correct !!");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}