package zucc.edu.cn.model;
/*
 * create table user
(
   userid               varchar(20) not null,
   userpwd              varchar(20),
   username             varchar(32),
   usertype             varchar(20),
   primary key (userid)
);
 */
public class UserBean {
	private String userid;
	private String userpwd;
	private String username;
	private String usertype;
	public UserBean(String userid, String userpwd, String username,
			String usertype) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.usertype = usertype;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
}
