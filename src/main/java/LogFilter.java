import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class LogFilter implements Filter {

    private FilterConfig filterConfig;
    private static final Logger log = Logger.getLogger(LogFilter.class.getName());

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        log.info("Log filter processed a voteChecker request");
        chain.doFilter(request, response);
    }
}
