package com.samsoft.http;

import java.util.List;

import com.samsoft.service.DocSettings;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface EasyPrintApi {

	/**
	 * @param username username of the print shop login
	 * @return list of document settings 
	 * 
	 * This should poll server time to time 
	 */
	@GET("easyprint/api/poll/{username}")
	Call<List<DocSettings>> pollServer(@Path("username") String username);
	
	
	/**
	 *=Download files from File server
	 */
	@Streaming
	@GET
	Call<ResponseBody> downloadDoc(@Url String fileUrl);
	
}
