package trending;

public class TrendingKeywordBean {
	String keyword;
	int frequency;
	public TrendingKeywordBean(String keyword, int frequency) {
		super();
		this.keyword = keyword;
		this.frequency = frequency;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
}
