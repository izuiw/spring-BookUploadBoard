package controller;

public class ListCommand {
	
	private String keyword;
	private String option;
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	@Override
	public String toString() {
		return "ListCommand [keyword=" + keyword + ", option=" + option + "]";
	}
	
	
	
	
	

}
