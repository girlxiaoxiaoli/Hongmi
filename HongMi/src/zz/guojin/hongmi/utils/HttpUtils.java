package zz.guojin.hongmi.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
	public static byte[] request(String urlpath){
		ByteArrayOutputStream baos=null;
		 try {
			//1����URL
			 URL url=new URL(urlpath);
			 //2����openConnnection();
			 HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			 //3���ò���
			 connection.setConnectTimeout(10000);
			 connection.setReadTimeout(10000);
			 //4����
			 connection.connect();
			 //5��������
			 if(connection.getResponseCode()==200){
				 InputStream is=connection.getInputStream();
				 baos=new ByteArrayOutputStream();
				 byte[] buf=new byte[1024*4];
				 int len=0;
				 while((len=is.read(buf))!=-1){
					 baos.write(buf,0,len);
					 
				 }
				 is.close();
				 return baos.toByteArray();
				 
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	     return null;
	}
}
