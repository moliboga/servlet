import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

public class LogFilter implements Filter {

    private static final Logger log = Logger.getLogger(LogFilter.class.getName());
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        double incomingTime = System.currentTimeMillis();
        chain.doFilter(request, response); // here request goes to server
        double outgoingTime = System.currentTimeMillis();

        double diffInTime = outgoingTime - incomingTime ;
        log.info("Difference in the request and response : "
                + diffInTime/1000.0);
    }
}
