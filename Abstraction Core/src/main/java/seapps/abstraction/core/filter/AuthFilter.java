package seapps.abstraction.core.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seapps.abstraction.core.domain.AccessedUser;
import seapps.abstraction.core.repository.AccessedUserRepository;
import seapps.abstraction.core.security.SecurityManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthFilter implements Filter {

    private final SecurityManager securityManager;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String token = req.getHeader("token");
        if (token.equals("")) resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        if (securityManager.authenticate(token))
            chain.doFilter(request, response);
        else
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}