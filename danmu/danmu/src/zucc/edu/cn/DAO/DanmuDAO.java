package zucc.edu.cn.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import zucc.edu.cn.model.DanmuBean;
import zucc.edu.cn.tools.DBHelper;

//create table danmu
//(
// dmcontent            varchar(200),
// dmid                 int(20) not null,
// userid               varchar(20),
// classid              varchar(80),
// dmstyle              varchar(20),
// dmsenddate           varchar(32),
// primary key (dmid)
//);
public class DanmuDAO {
	//添加弹幕
	public void createDanmu(DanmuBean danmuBean){
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into danmu(dmcontent,userid,classid,dmstyle,dmsenddate) "
					+ "value(?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, danmuBean.getDmcontent());
			pst.setString(2, danmuBean.getUserid());
			pst.setString(3, danmuBean.getClassid());
			pst.setString(4, danmuBean.getDmstyle());
			pst.setString(5, danmuBean.getDmsenddate());

			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try {
				if (conn != null){
					conn.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
	}
	//删除弹幕
	public void deleteDanmu(DanmuBean danmuBean){
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from danmu where dmid = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, danmuBean.getDmid());
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if (conn != null){
					conn.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public List<DanmuBean> searchDanmu(String classId){
		List<DanmuBean> result = new ArrayList<DanmuBean>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select dmcontent,dmid,userid,classid,dmsenddate,dmstyle from "
					+ "danmu where classid = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, classId);
			rs = pst.executeQuery();
			while(rs.next()) {
				DanmuBean danmuBean = new DanmuBean();
				danmuBean.setDmcontent(rs.getString(1));
				danmuBean.setDmid(rs.getInt(2));
				danmuBean.setUserid(rs.getString(3));
				danmuBean.setClassid(rs.getString(4));
				danmuBean.setDmsenddate(rs.getString(5));
				danmuBean.setDmstyle(rs.getString(6));
				
				result.add(danmuBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
	
}
