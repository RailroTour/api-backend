package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonParser;

import oauth.dto.KakaoUserBean;
import oauth.dto.TokenBean;

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
	
	public TokenBean getTokenTime() { //access_token 정보 가져오기
		try {
			url = new URL(this.link+"/v1/user/access_token_info");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "Bearer "+this.access_token);
			conn.setDoOutput(true);
			
			//데이터 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String input="";
			StringBuilder json=new StringBuilder();
			while((input=br.readLine())!=null) {
				json.append(input);
			}

			//json 파싱
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> map = new HashMap<String, String>();
			map = mapper.readValue(json.toString(), new TypeReference<Map<String, String>>(){});

			TokenBean token = new TokenBean(map.get("id"), map.get("expiresInMillis"), map.get("expires_in"), map.get("appId"));
			
			return token;
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
		return null;
		
	}
	
	public KakaoUserBean getUserInfo() {
		String id = null;
		String nickname = null;
		String email = null;
		try {
			url = new URL(this.link+"/v2/user/me");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "Bearer "+this.access_token);
			conn.setDoOutput(true);
			
			//데이터 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String input="";
			StringBuilder json=new StringBuilder();
			while((input=br.readLine())!=null) {
				json.append(input);
			}
			
			//json 파싱
			JSONObject obj = new JSONObject(json.toString());
			id = obj.get("id").toString(); //ID값 저장
			obj = (JSONObject) obj.get("kakao_account");
			email = obj.get("email").toString(); // EMAIL 추출
			obj = (JSONObject)obj.get("profile");
			nickname = obj.get("nickname").toString(); // NICKNAME 추출
			
			return new KakaoUserBean(id, nickname, email);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
