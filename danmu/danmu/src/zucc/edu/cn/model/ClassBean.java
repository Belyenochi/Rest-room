package zucc.edu.cn.model;
//create table class
//(
//   classid              varchar(80) not null,
//   teacherid            varchar(32),
//   classname            varchar(80),
//   primary key (classid)
//);

public class ClassBean {
	private String classid;
	private String teacherid;
	private String classname;
	public ClassBean(String classid, String teacherid, String classname) {
		super();
		this.classid = classid;
		this.teacherid = teacherid;
		this.classname = classname;
	}
	public ClassBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	
}
