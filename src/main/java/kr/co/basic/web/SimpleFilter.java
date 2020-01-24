package kr.co.basic.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@Slf4j
@WebFilter(filterName="simple" ,urlPatterns = "/simple")
public class SimpleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Filter - Hello World");
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        String username = (String) session.getAttribute("username");
        if(username == null){
            log.info("new user");
            session.setAttribute("username","user01");
        }else{
            log.info("user -> "+ username);
        }

        filterChain.doFilter(servletRequest,servletResponse);
        Writer writer = servletResponse.getWriter();
        writer.write("Hello World");

    }
}
