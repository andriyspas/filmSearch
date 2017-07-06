package filmsearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class CorsResponseFilter implements Filter {

    @Value("${server.allowed.origins}")
    private String[] allowedOrigins;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        Set<String> allowedOrigins = new HashSet<>(Arrays.asList(this.allowedOrigins));
        HttpServletRequest request = (HttpServletRequest) req;
        String originHeader = request.getHeader("Origin");
        if(allowedOrigins.contains(originHeader)) {
            HttpServletResponse response = (HttpServletResponse) res;
            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Headers",
                    "origin, content-type, accept, authorization, X-Requested-With, X-XSRF-TOKEN");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        }
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}
}
