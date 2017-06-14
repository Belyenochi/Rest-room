package zucc.edu.cn.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import zucc.edu.cn.model.KeywordBean;
import zucc.edu.cn.tools.DBHelper;

//create table  keyword
//(
// keyword              varchar(32) not null,
// primary key (keyword)
//);
public class KeywordDAO {
	public void createKeyword(KeywordBean keyWord){
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into keyword(keyword) value(?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, keyWord.getKeyword());
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if (conn != null) {
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
	public void deleteKeyword(KeywordBean keyWord){
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from keyword where keyword = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, keyWord.getKeyword());
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if (conn != null) {
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
}
