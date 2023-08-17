package hello.exception.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterCeptor implements HandlerInterceptor {

    public static final String REQUEST_UUID = "requestUUID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String requestUUID = UUID.randomUUID().toString();
        request.setAttribute(REQUEST_UUID, requestUUID);
        log.info("REQUEST [{}][{}][{}][{}]", requestUUID, request.getDispatcherType(), requestURI, handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String requestUUID = (String) request.getAttribute(REQUEST_UUID);
        log.info("RESPONSE [{}][{}][{}]", requestUUID, request.getDispatcherType(), requestURI);

        if (ex != null) {
            log.error("afterCompletion error!!", ex);
        }
    }
}
