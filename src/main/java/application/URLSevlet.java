package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLSevlet extends HttpServlet{

private static final long serialVersionUID = 1L;

@Override

protected void doGet(HttpServletRequest req, HttpServletResponse resp)

throws ServletException, IOException{

super.doGet(req, resp);

}

@Override

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

String username =req.getParameter("username"); //获取username所对应的value

String password =req.getParameter("password"); //获取password所对应的value

System.out.println("Thereceived username and password is: " + username + "/" +password);

// 向请求端发回反馈信息

PrintWriter out =resp.getWriter();

out.print("OK");

out.flush();

out.close();

super.doPost(req, resp);

}

}
