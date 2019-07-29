package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestIOT{

public static void main(String[] args)throws Exception{

// 服务地址

URL url = new URL("http://127.0.0.1:8080/test/upload");
//URL url = new URL("http://173.193.92.174:31070/model/predict");

// 设定连接的相关参数

HttpURLConnection connection= (HttpURLConnection) url.openConnection();

connection.setDoOutput(true);

connection.setRequestMethod("POST");

OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");

// 向服务端发送key = value对

out.write("username=kevin&password=pass");

out.flush();

out.close();

// 获取服务端的反馈

String strLine="";

String strResponse ="";

InputStream in =connection.getInputStream();

BufferedReader reader = new BufferedReader(new InputStreamReader(in));

while((strLine =reader.readLine()) != null)

{

strResponse +=strLine +"\n";

}

System.out.print(strResponse);

}

}
