package zucc.edu.cn.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zucc.edu.cn.model.ClassBean;
import zucc.edu.cn.tools.DBHelper;


//create table class
//(
// classid              varchar(80) not null,
// teacherid            varchar(32),
// classname            varchar(80),
// primary key (classid)
//);
public class ClassDAO {
	//创建班级
	public void createClass(ClassBean classBean) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into class(classid,classname,teacherid) value(?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, classBean.getClassid());
			pst.setString(2, classBean.getClassname());
			pst.setString(3, classBean.getTeacherid());
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pst != null){
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	//删除班级
	public void deleteClass(ClassBean classBean){
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from class where classid = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, classBean.getClassid());
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	//修改班级
	public void updateClass(ClassBean classBean){
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "update class set classname = ?,teacherid = ? where classid = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, classBean.getClassname());
			pst.setString(2, classBean.getTeacherid());
			pst.setString(3, classBean.getClassid());
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public List<ClassBean> searchClass(String classId,String className,String teacherId){
		List<ClassBean> result = new ArrayList<ClassBean>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select classid,teacherid,classname from class where classid like ?"
					+ " and teacherid like ? and classname like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+classId+"%");
			pst.setString(2, "%"+teacherId+"%");
			pst.setString(3, "%"+className+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				ClassBean classBean = new ClassBean();
				classBean.setClassid(rs.getString(1));
				classBean.setTeacherid(rs.getString(2));
				classBean.setClassname(rs.getString(3));
				result.add(classBean);
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
