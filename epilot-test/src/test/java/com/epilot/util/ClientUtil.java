package com.epilot.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientUtil {

	public HttpResponse sendPost(String url, String json) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		HttpResponse res = null;

		try {
			if (null != json && !json.isEmpty()) {
				StringEntity s = new StringEntity(json);
				s.setContentEncoding("UTF-8");
				s.setContentType("application/json");
				post.setEntity(s);
			}

			res = client.execute(post);			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return res;
	}
}
