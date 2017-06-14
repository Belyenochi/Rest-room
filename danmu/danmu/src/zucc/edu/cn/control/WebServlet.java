package zucc.edu.cn.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import zucc.edu.cn.DAO.ClassDAO;
import zucc.edu.cn.DAO.DanmuDAO;
import zucc.edu.cn.DAO.TeacherDAO;
import zucc.edu.cn.DAO.UserDAO;
import zucc.edu.cn.model.ClassBean;
import zucc.edu.cn.model.DanmuBean;
import zucc.edu.cn.model.TeacherBean;
import zucc.edu.cn.model.UserBean;
import zucc.edu.cn.tools.BaseException;
import zucc.edu.cn.tools.JSONHelper;

/**
 * Servlet implementation class WebServlet
 */
public class WebServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebServlet() {
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		System.out.println(method);
		if (method.equals("login")) {
			checkLogin(request, response);
		}
		if (method.equals("searchclass")){
			searchClass(request,response);
		}
		if (method.equals("insertdanmu")){
			DanmuBean dmb = new DanmuBean();
			dmb.setDmcontent(request.getParameter("dmcontent"));
			dmb.setClassid(request.getParameter("classid"));
			dmb.setDmsenddate(request.getParameter("dmsenddate"));
			dmb.setDmstyle(request.getParameter("dmstyle"));
			dmb.setUserid(request.getParameter("userid"));
			
			try {
				insertDanmu(request,response,dmb);
			} catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (method.equals("searchDanmu")){
			searchDanmu(request,response);
		}
		if (method.equals("updateuser")){
			updateUser(request,response);
		}
		if (method.equals("updateteacher")){
			updateTeacher(request,response);
		}
		if (method.equals("deletesession")){
			deletesession(request,response);
		}
		
		
	}
	
	private String receiveJSON(HttpServletRequest request) {
		String acceptJSON = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			acceptJSON = sb.toString();
			System.out.println(acceptJSON);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return acceptJSON;
	}
	
	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException,
	ServletException{
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		UserDAO ud = new UserDAO();
		UserBean user = new UserBean();
		user.setUserid(userId);
		user.setUserpwd(userPwd);
		System.out.println("进入密码验证环节");
		if (ud.checkUser(user)) {
			user = ud.getUser(userId);
			//向前端写入session:userId,userName
			if (user.getUsertype() != null && !user.getUsertype().equals("")) {
				if (user.getUsertype().equals("student")) {
					System.out.println("success login");
					session.setAttribute("userId", user.getUserid());
					System.out.println("sucess session");
					session.setAttribute("userName", user.getUsername());
					response.getWriter().write("student");
				}
			}
			else{
				
			}
		}else{
			//账号密码错误
			throw new ServletException("用户账号或者密码错误");
		}
	}

	private void searchClass(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ClassDAO cd = new ClassDAO();
		List<ClassBean> list = cd.searchClass("", "", "");
		JSONObject jsonObject = JSONHelper.classListToJSON(list);
		jsonObject.put("count", list.size());
		System.out.println("查询所有班级");
		System.out.println(jsonObject.toString());
		response.getWriter().write(jsonObject.toString());
		
	}
	
	private void insertDanmu(HttpServletRequest request, HttpServletResponse response,DanmuBean dmb) throws IOException, BaseException{
		if (dmb.getUserid() == null || dmb.getUserid().equals("")) {
			throw new BaseException("传入用户id数据为空");
		} else {
			DanmuDAO danmu = new DanmuDAO();
			
			danmu.createDanmu(dmb);
			System.out.println("插入弹幕成功！");
		}
		
	}
	private void searchDanmu(HttpServletRequest request, HttpServletResponse response) throws IOException{
		DanmuDAO cd = new DanmuDAO();
		String classId = request.getParameter("classId");
		List<DanmuBean> list = cd.searchDanmu(classId);
		JSONObject jsonObject = JSONHelper.danmuListToJSON(list);
		jsonObject.put("count", list.size());
		System.out.println("查询所有弹幕");
		System.out.println(jsonObject.toString());
		response.getWriter().write(jsonObject.toString());
		
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newpwd");
		
		UserBean userBean = new UserBean();
		UserDAO ud = new UserDAO();
		List<UserBean> ub = ud.searchUser(userId, "", "");
		if(ub.get(0).getUserpwd().equals(userPwd)){
			userBean.setUserid(userId);
			userBean.setUserpwd(newPwd);
			ud.updateUserPwd(userBean);
		}else{
			throw new ServletException();
		}
	}
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String teacherId = request.getParameter("teacherId");
		String teacherPwd = request.getParameter("teacherPwd");
		String newpwd = request.getParameter("newpwd");
		
		TeacherBean teacherBean = new TeacherBean();
		TeacherDAO td = new TeacherDAO();
		
		List<TeacherBean> tb = td.searchTeacher(teacherId, "", "", teacherPwd);
		if(tb.get(0).getTeacherpwd().equals(teacherPwd)){
			teacherBean.setTeacherid(teacherId);
			teacherBean.setTeacherpwd(newpwd);
			td.updateTeacher(teacherBean);
		}else{
			throw new ServletException();
		}
		
	}
	
	private void deletesession(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("userId");
		request.getSession().removeAttribute("userName");
	}
}
