package hello.exception.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class ErrorPageController {

    @RequestMapping("/error-page/404")
    public String errorPage404(HttpServletRequest request, HttpServletResponse response) {
        log.info("errorPage 404");
        printErrorInfo(request);
        return "/error-page/404";
    }

    private void printErrorInfo(HttpServletRequest request) {
        log.info("ERROR exception : {}", request.getAttribute("javax.servlet.error.exception"));
        log.info("ERROR exception_type : {}", request.getAttribute("javax.servlet.error.exception_type"));
        log.info("ERROR message : {}", request.getAttribute("javax.servlet.error.message"));
        log.info("ERROR request_uri : {}", request.getAttribute("javax.servlet.error.request_uri"));
        log.info("ERROR servlet_name : {}", request.getAttribute("javax.servlet.error.servlet_name"));
        log.info("ERROR status_code : {}", request.getAttribute("javax.servlet.error.status_code"));
    }

    @RequestMapping("/error-page/500")
    public String errorPage500(HttpServletRequest request, HttpServletResponse response) {
        log.info("errorPage 500");
        printErrorInfo(request);
        return "error-page/500";
    }

}
