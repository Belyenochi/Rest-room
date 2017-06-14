package zucc.edu.cn.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import zucc.edu.cn.model.UserBean;
import zucc.edu.cn.tools.DBHelper;

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
public class UserDAO {
	public void createUser(UserBean userBean){
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into user(userid,userpwd,username,usertype) value(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userBean.getUserid());
			pst.setString(2, userBean.getUserpwd());
			pst.setString(3, userBean.getUsername());
			pst.setString(4, userBean.getUsertype());
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
				}
				if(pst != null){
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public void deleteUser(UserBean userBean){
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from user where userid = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userBean.getUserid());
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
				}
				if(pst != null){
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void updateUser(UserBean userBean){
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "update user set userpwd = ?, username = ?, usertype = ? where userid = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userBean.getUserpwd());
			pst.setString(2, userBean.getUsername());
			pst.setString(3, userBean.getUsertype());
			pst.setString(4, userBean.getUserid());
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
				}
				if(pst != null){
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void updateUserPwd(UserBean userBean){
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "update user set userpwd = ? where userid = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userBean.getUserpwd());
			pst.setString(2, userBean.getUserid());
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
				}
				if(pst != null){
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public List<UserBean> searchUser(String userId,String userName,String userType){
		List<UserBean> result = new ArrayList<UserBean>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "select userid,userpwd,username,usertype from user where userid like ? and"
					+ "username like ? and usertype like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+userId+"%");
			pst.setString(2, "%"+userName+"%");
			pst.setString(3, "%"+userType+"%");
			rs = pst.executeQuery();
			while(rs.next()){
				UserBean userBean = new UserBean();
				userBean.setUserid(rs.getString(1));
				userBean.setUserpwd(rs.getString(2));
				userBean.setUsername(rs.getString(3));
				userBean.setUsertype(rs.getString(4));
				result.add(userBean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
				}
				if(pst != null){
					pst.close();
				}
				if(pst != null){
					rs.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean checkUser(UserBean userBean) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where userid=? and userpwd=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userBean.getUserid());
			pst.setString(2, userBean.getUserpwd());
			rs = pst.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return result;
	}
	
	public UserBean getUser(String userid) {
		UserBean user = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select userid,userpwd,username,usertype from user where userid=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserid(rs.getString(1));
				user.setUserpwd(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setUsertype(rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return user;
	}
}


