package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
 
/**
 * Servlet implementation class Test1
 */
@WebServlet("/Test1")
public class Sevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		System.out.println(name);
		System.out.println(url);
 
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");// 注意設置為utf-8否則前端接收到的中文為亂碼
		PrintWriter out = response.getWriter();
 
		Gson gson = new Gson();
		ArrayList<Test1Object> arraylistTest = new ArrayList<Test1Object>();
 
		Test1Object t1 = new Test1Object();
		Test1Object t2 = new Test1Object();
 
		t1.setName(name);
		t1.setUrl(url);
		t2.setName(name);
		t2.setUrl(url);
 
		arraylistTest.add(t1);
		arraylistTest.add(t2);
 
		String info = gson.toJson(arraylistTest);
		// 打印出檢查
		System.out.println(info);
		// 返回給前端
//		out.write(info);
		IamOptions options = new IamOptions.Builder()
				  .apiKey("By62W_ehSwS2_zEXPdH2EvCQF_Hk6LaE_0JxkqOR34ht")
				  .build();

				VisualRecognition visualRecognition = new VisualRecognition("2018-03-19", options);

				ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
				  .url("https://watson-developer-cloud.github.io/doc-tutorial-downloads/visual-recognition/640px-IBM_VGA_90X8941_on_PS55.jpg")
				  .build();
				Response<ClassifiedImages> result = visualRecognition.classify(classifyOptions).execute();
				System.out.println(result.getResult());
				out.write(result.getResult().toString());
	}
}