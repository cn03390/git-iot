package application;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.visual_recognition.v3.model.DetectedFaces;

public class DetectFace {
	public static void main(String[] args) throws FileNotFoundException {
		IamOptions options = new IamOptions.Builder()
				  .apiKey("By62W_ehSwS2_zEXPdH2EvCQF_Hk6LaE_0JxkqOR34ht")
				  .build();

				VisualRecognition service = new VisualRecognition("2018-03-19", options);

				DetectFacesOptions detectFacesOptions = new DetectFacesOptions.Builder()
				  .imagesFile(new File("/Users/cn03390/fxq.jpg"))
				  .build();
				DetectedFaces result = service.detectFaces(detectFacesOptions).execute().getResult();
				System.out.println(result);
	}

}
