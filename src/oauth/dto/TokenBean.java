package oauth.dto;

public class TokenBean {
	String id;
	String expiresInMillis;
	String expires_in;
	String appId;
	
	public TokenBean(String id, String expiresInMillis, String expires_in, String appId) {
		super();
		this.id = id;
		this.expiresInMillis = expiresInMillis;
		this.expires_in = expires_in;
		this.appId = appId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpiresInMillis() {
		return expiresInMillis;
	}
	public void setExpiresInMillis(String expiresInMillis) {
		this.expiresInMillis = expiresInMillis;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
}
