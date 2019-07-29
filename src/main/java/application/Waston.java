package application;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

public class Waston {
	public static void main(String[] args) {
		IamOptions options = new IamOptions.Builder()
				  .apiKey("By62W_ehSwS2_zEXPdH2EvCQF_Hk6LaE_0JxkqOR34ht")
				  .build();

				VisualRecognition visualRecognition = new VisualRecognition("2018-03-19", options);

				ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
				  .url("https://watson-developer-cloud.github.io/doc-tutorial-downloads/visual-recognition/640px-IBM_VGA_90X8941_on_PS55.jpg")
				  .build();
				Response<ClassifiedImages> result = visualRecognition.classify(classifyOptions).execute();
				System.out.println(result.getResult());
	}

}
