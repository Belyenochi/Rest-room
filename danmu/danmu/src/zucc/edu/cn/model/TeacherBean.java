package zucc.edu.cn.model;
/*
 * create table teacher
(
   teacherid            varchar(32) not null,
   teacherpwd           varchar(200),
   teachername          varchar(32),
   teachertype          varchar(20),
   primary key (teacherid)
);
 */
public class TeacherBean {
	private String teacherid;
	private String teacherpwd;
	private String teachername;
	private String teachertype;
	public TeacherBean(String teacherid, String teacherpwd, String teachername,
			String teachertype) {
		super();
		this.teacherid = teacherid;
		this.teacherpwd = teacherpwd;
		this.teachername = teachername;
		this.teachertype = teachertype;
	}
	public TeacherBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeacherpwd() {
		return teacherpwd;
	}
	public void setTeacherpwd(String teacherpwd) {
		this.teacherpwd = teacherpwd;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeachertype() {
		return teachertype;
	}
	public void setTeachertype(String teachertype) {
		this.teachertype = teachertype;
	}
	
	
}
