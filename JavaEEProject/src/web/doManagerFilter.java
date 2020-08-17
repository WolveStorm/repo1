package web;

import pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * @ClassName doManagerFilter
 * @Description TODO
 * @Author 89255
 */
public class doManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 =(HttpServletRequest) servletRequest;
        HttpSession session = servletRequest1.getSession();
        User user = (User)session.getAttribute("manager");
        if(user==null){
            servletRequest1.getSession().setAttribute("signal","no");
            servletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
    @Override
    public void destroy() {

    }
}
