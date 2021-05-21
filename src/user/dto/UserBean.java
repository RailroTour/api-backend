package user.dto;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class UserBean{
	public int id;
	public String username;
	public String password;
	public String name;
	public String nickname;
	public String email;
	public String register_date;
	public String profile_img;
	
	public UserBean(int id, String username, String password, String name, String nickname, String email,
			String register_date, String profile_img) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.register_date = register_date;
		this.profile_img = profile_img;
	}


	public UserBean(String username, String password, String name, String nickname, String email,String profile_img) {
		// TODO Auto-generated constructor stub
super();
		
		this.username = username;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.profile_img = profile_img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	

	
	
}
