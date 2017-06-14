
package zucc.edu.cn.DAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class UserThread implements Runnable {
	private Socket s;
	
	public UserThread() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	
	public UserThread(Socket s){
		this.s = s;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			synchronized(this) {
				BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
	//			String line = null;
	//			while((line=br.readLine())!=null){
	//				bw.write(line);
	//				bw.flush();
	//			}
				
	//				String pathname = "D:\\develop\\eclipse_workspace\\danmu\\message.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
	//                File filename = new File(pathname); // 要读取以上路径的input。txt文件  
	//                InputStreamReader reader = new InputStreamReader(  
	//                        new FileInputStream(filename)); // 建立一个输入流对象reader  
	//                BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
	//                String line = null;   
	//                while ((line=br.readLine())!=null) {  
	//                	bos.write(line.getBytes());
	//                	bos.flush();
	//                }  
	                
	                
	                File file = new File("D:\\develop\\eclipse_workspace\\danmu\\message.txt");
	                InputStream in = null;
	                byte[] tempByte = new byte[1024];
	                int byteread = 0;
	               
	         
		                    in = new FileInputStream(file);
		                    while ((byteread = in.read(tempByte)) != -1 ) {
		                        System.out.write(tempByte, 0, byteread);
		                        bos.write(tempByte,0,byteread);
			                    bos.flush();
			                    
		                    }
		                    s.shutdownOutput();
		                  //写入操作
		                    BufferedWriter writer = new BufferedWriter(new FileWriter(new File("D:\\develop\\eclipse_workspace\\danmu\\message.txt")));
		                    writer.write("");
		                    writer.close();
		                    in.close();
		                    
                	
               
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
