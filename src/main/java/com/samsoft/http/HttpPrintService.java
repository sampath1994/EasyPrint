package com.samsoft.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.samsoft.service.DocSettings;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpPrintService {

	private EasyPrintApi printApi;
	
	HttpPrintService(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        printApi = retrofit.create(EasyPrintApi.class); 
	}
	
	List<DocSettings> getDocSettings(String username) throws IOException{
		return printApi.pollServer(username).execute().body();
	}
	
	void downloadFile(String downloadLink, String fileName) throws IOException {
		
		File tempDir = new File(System.getProperty("user.home")+File.separator+".easyPrint");
		if(!tempDir.exists()) {
		tempDir.mkdir();
		}
		
		ResponseBody resBody = printApi.downloadDoc(downloadLink).execute().body();
		InputStream inputStream = resBody.byteStream();
		File targetFile = new File(System.getProperty("user.home")+File.separator+".easyPrint"+File.separator+fileName+".pdf");
		java.nio.file.Files.copy(inputStream,targetFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
		inputStream.close();
	}
	
}
