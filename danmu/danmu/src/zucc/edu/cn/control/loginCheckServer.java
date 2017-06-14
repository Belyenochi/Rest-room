package zucc.edu.cn.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import zucc.edu.cn.DAO.UserThread;
import zucc.edu.cn.DAO.Usercheck;

public class loginCheckServer {
	public static void main(String[] args) throws IOException {
		//PC端Socket连接
	    ServerSocket check = new ServerSocket(11112);
	    
	    while(true){
	    	Socket s = check.accept();
	    	System.out.println("成功连接");
	    	new Thread(new Usercheck(s)).start();
	    }
	    
	    
	}
	
}
