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
	
	public HttpPrintService(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        printApi = retrofit.create(EasyPrintApi.class); 
	}
	
	public List<DocSettings> getDocSettings(String username) throws IOException{
		return printApi.pollServer(username).execute().body();
	}
	
	public String downloadFile(String downloadLink, String fileName) throws Exception {   //changed from IOException to Exception
		
		File tempDir = new File(System.getProperty("user.home")+File.separator+".easyPrint");
		if(!tempDir.exists()) {
		tempDir.mkdir();
		}
		
		ResponseBody resBody = printApi.downloadDoc(downloadLink).execute().body();
		InputStream inputStream = resBody.byteStream();
		String targetPath = System.getProperty("user.home")+File.separator+".easyPrint"+File.separator+fileName+".pdf";
		File targetFile = new File(targetPath);
		java.nio.file.Files.copy(inputStream,targetFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
		inputStream.close();
		return targetPath;
	}
	
}
