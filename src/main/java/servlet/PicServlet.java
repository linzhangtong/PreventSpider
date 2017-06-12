package servlet;

import Commons.Encrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elric on 2017/6/11.
 */
public class PicServlet extends HttpServlet{
    private String token = "yourToken";
    String params = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().print(params);
        this.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            params = Encrypt.GetMD5Code(token);
            System.out.println("服务器的params："+params);
        }catch (Exception e){
            e.printStackTrace();
        }
        String getToken = req.getParameter("token");
        System.out.println("客户端的params:"+getToken);
        if (getToken.equals(params)){
            resp.getWriter().print( "<img src='Pic/me.jpg'  alt='测试图片' />\n");
        }
    }
}
