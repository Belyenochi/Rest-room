package zucc.edu.cn.model;
//create table danmu
//(
//   dmcontent            varchar(200),
//   dmid                 int(20) not null,
//   userid               varchar(20),
//   classid              varchar(80),
//   dmstyle              varchar(20),
//   dmsenddate           varchar(32),
//   primary key (dmid)
//);
public class DanmuBean {
	private String dmcontent;
	private int dmid;
	private String userid;
	private String classid;
	private String dmstyle;
	private String dmsenddate;
	public DanmuBean(String dmcontent, int dmid, String userid,
			String classid, String dmstyle, String dmsenddate) {
		super();
		this.dmcontent = dmcontent;
		this.dmid = dmid;
		this.userid = userid;
		this.classid = classid;
		this.dmstyle = dmstyle;
		this.dmsenddate = dmsenddate;
	}
	public DanmuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDmcontent() {
		return dmcontent;
	}
	public void setDmcontent(String dmcontent) {
		this.dmcontent = dmcontent;
	}
	public int getDmid() {
		return dmid;
	}
	public void setDmid(int dmid) {
		this.dmid = dmid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getDmstyle() {
		return dmstyle;
	}
	public void setDmstyle(String dmstyle) {
		this.dmstyle = dmstyle;
	}
	public String getDmsenddate() {
		return dmsenddate;
	}
	public void setDmsenddate(String dmsenddate) {
		this.dmsenddate = dmsenddate;
	}
	
	
}
