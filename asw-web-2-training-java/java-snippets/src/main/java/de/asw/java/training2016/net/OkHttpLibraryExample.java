package de.asw.java.training2016.net;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpLibraryExample {

	public static void main(String[] args) throws Exception{

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("https://api.github.com").build();
		Response response = client.newCall(request).execute();
		
		System.out.println(response.body().string());
	}

}
