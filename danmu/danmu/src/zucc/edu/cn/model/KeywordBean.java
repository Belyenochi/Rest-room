package zucc.edu.cn.model;

//create table  keyword
//(
//   keyword              varchar(32) not null,
//   primary key (keyword)
//);
public class KeywordBean {
	private String keyword;

	public KeywordBean(String keyword) {
		super();
		this.keyword = keyword;
	}
	

	public KeywordBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
