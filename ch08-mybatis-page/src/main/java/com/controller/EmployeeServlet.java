package com.controller;

import com.entity.Employee;
import com.github.pagehelper.PageInfo;
import com.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author cj
 * @date 2019/10/12
 */

@WebServlet("/index")
public class EmployeeServlet extends HttpServlet {
   /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeService();
//当前页
        int pageNum = Integer.parseInt(req.getParameter("page"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<Employee> emps = employeeService.getEmpsByCustom(pageNum, pageSize);
        int count = employeeService.getEmpsCount();
        //上一页
        int prev = pageNum -1;
        //下一页
        int next = pageNum + 1;
        //得到总页数
        int pages = (int) Math.ceil(count*1.0 /pageSize);
        //最后一页
        int last = pages;
        req.setAttribute("emps", emps);
        req.setAttribute("prev", prev);
        req.setAttribute("next", next);
        req.setAttribute("last", last);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
*/


   /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeService();
//当前页
        int pageNum = Integer.parseInt(req.getParameter("page"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<Employee> emps = employeeService.getEmpsByCustom(pageNum, pageSize);
        int count = employeeService.getEmpsCount();
        Pagination pagination = new Pagination(pageNum, count, pageSize);

        req.setAttribute("pagination", pagination);
        req.setAttribute("emps", emps);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
*/

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeService();
//当前页
        int pageNum = Integer.parseInt(req.getParameter("page"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<Employee> emps = employeeService.getEmpsByPageHelper(pageNum, pageSize);
        // 导航数字的生成逻辑是尽量让当前页的数字在中间
        //比如:有100页,当前页是20页,导航数字的总个数3
        //那么生成的导航数字就是19,20,21
        //如果导航数字的个数为4 ,那么就是:18,19,20,21

        //PageInfo的构造函数的第二个参数就是设定导航数字的个数的.
        PageInfo<Employee> pageInfo = new PageInfo<>(emps,3);
        req.setAttribute("pageInfo", pageInfo);

        req.getRequestDispatcher("index2.jsp").forward(req, resp);
    }
}
