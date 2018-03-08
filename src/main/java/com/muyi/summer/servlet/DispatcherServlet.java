package com.muyi.summer.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: muyi-corp
 * @Date: Created in 18:41 2018/1/26
 * @Description:
 */
@WebServlet("DispatcherServlet")
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    List<String> packageNames = new ArrayList<String>();

    //所有类的实例，key是注解的value，value是所有类的实例
    Map<String, Object> instanceMap = new HashMap<String, Object>();
    Map<String, Object> handerMap = new HashMap<String, Object>();

    public DispatcherServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
