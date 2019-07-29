package application;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")//这里和ajax里面的url一致，代表请求的是这个servlet
public class Servlet extends HttpServlet{
//	public class login  {
		////前面请求类型为post函数
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			//从前端传递的request中取值
			System.out.println("前端传递过来的名字是"+request.getParameter("name"));
			//构造json字符串传递回前端，\为java转义符号为了转义双引号
			//注意这里格式要求很严格，不能用单引号，建议使用第三方框架自动生成json字符串
			String s= "{\"name\":\"张三\",\"password\":\"123456\"}";
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");//返回的格式必须设置为application/json
			response.getWriter().write(s);//写入到返回结果中
			//完成，执行到这里就会返回数据给前端，前端结果为success，调用success里面的内容
		}

}
