package uk.gergely.kiss.training.tutorials.persistence.web.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import uk.gergely.kiss.training.tutorials.persistence.util.RequestContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class RequestContextInitializationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestContext.init();
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
