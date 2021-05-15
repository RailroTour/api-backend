package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class KakaoAPI {
	String link;
	String key;
	URL url;
	String access_token;
	
	public KakaoAPI(String access_token) {
		this.link = "https://kapi.kakao.com";
		this.key = "991800116c8a1e9fdcc210e4691bec26";
		this.access_token = access_token;
	}
	
	public int getTokenTime() {
		try {
			url = new URL(this.link+"/v1/user/access_token_info");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "Bearer "+this.access_token);
			conn.setDoOutput(true);
			
			//request하기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String input2="";
			StringBuilder sb2=new StringBuilder();
			while((input2=br.readLine())!=null) {
				sb2.append(input2);
			}
			
			System.out.println("sb2.toString() : "+sb2.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
