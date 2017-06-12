package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Elric on 2017/3/6.
 */
@WebServlet(name = "CheckServlet")
public class CheckServlet extends HttpServlet {
 public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
     response.setContentType("text/html");
     response.setCharacterEncoding("utf-8");
     PrintWriter out = response.getWriter();
     String uname = request.getParameter("uname");
     if("`  ".equals(uname)){
         out.println("用户名输入正确");
     }else{
         out.println("用户名输入不正确");
     }
     out.flush();
     out.close();
 }
}
