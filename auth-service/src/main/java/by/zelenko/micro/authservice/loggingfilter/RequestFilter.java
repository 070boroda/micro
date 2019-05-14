package by.zelenko.micro.authservice.loggingfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class RequestFilter extends AbstractRequestLoggingFilter {

    private long time = 0;

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String s) {
        time = System.currentTimeMillis();
        log.info("Request URI:" + httpServletRequest.getRequestURI());
        log.info("Reqest URL: " + httpServletRequest.getRequestURL());
        log.info("Request User: " + httpServletRequest.getRemoteUser());
        log.info("Remote host: " + httpServletRequest.getRemoteHost());

    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String s) {
        log.info("Working time: " + (System.currentTimeMillis() - time));
    }
}
