package zucc.edu.cn.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import zucc.edu.cn.model.TeacherBean;
import zucc.edu.cn.tools.DBHelper;


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
public class TeacherDAO {
	//添加教师
		public void createTeacher(TeacherBean teacherBean) {
			Connection conn = null;
			PreparedStatement pst = null;
			try {
				conn = DBHelper.getConnection();
				String sql = "insert into teacher(teacherid,teacherpwd,teachername,teachertype) "
						+ "value(?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, teacherBean.getTeacherid());
				pst.setString(2, teacherBean.getTeacherpwd());
				pst.setString(3, teacherBean.getTeachername());
				pst.setString(4, teacherBean.getTeachertype());
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
		public void deleteTeacher(TeacherBean teacherBean){
			Connection conn = null;
			PreparedStatement pst = null;
			try {
				conn = DBHelper.getConnection();
				String sql = "delete from teacher where teacherid = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, teacherBean.getTeacherid());
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
		//修改教师
		public void updateTeacher(TeacherBean teacherBean){
			Connection conn = null;
			PreparedStatement pst = null;
			try {
				conn = DBHelper.getConnection();
				String sql = "update teacher set teachername = ?,teacherpwd = ?,teachertype = ? where teacherid = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, teacherBean.getTeachername());
				pst.setString(2, teacherBean.getTeacherpwd());
				pst.setString(3, teacherBean.getTeachertype());
				pst.setString(4, teacherBean.getTeacherid());
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
		
		public void updateTeacherpwd(TeacherBean teacherBean){
			Connection conn = null;
			PreparedStatement pst = null;
			try {
				conn = DBHelper.getConnection();
				String sql = "update teacher set teacherpwd = ?where teacherid = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, teacherBean.getTeacherpwd());
				pst.setString(2, teacherBean.getTeacherid());
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
		public List<TeacherBean> searchTeacher(String teacherId,String teacherType,String teacherName,String teacherPwd){
			List<TeacherBean> result = new ArrayList<TeacherBean>();
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				conn = DBHelper.getConnection();
				String sql = "select teacherid,teacherpwd,teachername,teachertype from teacher where teacherid like ?"
						+ " and teachername like ? and teachertype like ? and teacherpwd = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, "%"+teacherId+"%");
				pst.setString(2, "%"+teacherName+"%");
				pst.setString(3, "%"+teacherType+"%");
				pst.setString(4, teacherPwd);
				rs = pst.executeQuery();
				while(rs.next()) {
					TeacherBean teacherBean = new TeacherBean();
					teacherBean.setTeacherid(rs.getString(1));
					teacherBean.setTeacherpwd(rs.getString(2));
					teacherBean.setTeachername(rs.getString(3));
					teacherBean.setTeachertype(rs.getString(4));
					result.add(teacherBean);
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
