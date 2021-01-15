package seapps.abstraction.core.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seapps.abstraction.core.security.SecurityManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthFilter implements Filter {

    private final SecurityManager securityManager;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String token = req.getHeader("token");

        if (token == null) resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        else if (securityManager.authenticate(token))
            chain.doFilter(request, response);
        else
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}