package community_comment;

public class CommentBean {
	public int id;
	public int board_id;
	public String username;
	public String content;
	public String register_date;
	public CommentBean(int id, int board_id, String username, String content, String register_date) {
		super();
		this.id = id;
		this.board_id = board_id;
		this.username = username;
		this.content = content;
		this.register_date = register_date;
	}
	public CommentBean(String username, String content) {
		super();
		this.username = username;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public CommentBean(int board_id, String content) {
		super();
		this.board_id = board_id;
		this.content = content;
	}

}
