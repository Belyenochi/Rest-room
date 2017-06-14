package zucc.edu.cn.DAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.CharBuffer;

public class Usercheck implements Runnable {
private Socket s;
	
	public Usercheck(Socket s){
		this.s = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			
			//BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("qingchun.png"));
//			String line = null;
//			while((line=br.readLine())!=null){
//				bw.write(line);
//				bw.flush();
//			}
			
			
			byte[] bys = new byte[2048];
			int len = bis.read(bys);
			String msg = new String(bys, 0, len);
			String[] strArray = null;   
		    strArray = msg.split("&"); //拆分字符为"," ,然后把结果交给数组strArray 
		    String teacherId = strArray[0];
		    String teacherPwd = strArray[1];
		    TeacherDAO td = new TeacherDAO();
		    int count = td.searchTeacher(teacherId, "", "", teacherPwd).size();
		    System.out.println(count);
			//给一个反馈
		    if(count>0){
				OutputStream os = s.getOutputStream();
				os.write("验证登陆成功".getBytes());
		    }else{
				OutputStream os = s.getOutputStream();
				os.write("账号密码错误".getBytes());
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
