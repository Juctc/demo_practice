package actiton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class OneFileUpload extends ActionSupport{
        private File uploadOneFile;
        private String uploadOneFileContentType;
        private String uploadOneFileFileName;
        
	
      



		public File getUploadOneFile() {
			return uploadOneFile;
		}






		public void setUploadOneFile(File uploadOneFile) {
			this.uploadOneFile = uploadOneFile;
		}






		public String getUploadOneFileContentType() {
			return uploadOneFileContentType;
		}






		public void setUploadOneFileContentType(String uploadOneFileContentType) {
			this.uploadOneFileContentType = uploadOneFileContentType;
		}






		public String getUploadOneFileFileName() {
			return uploadOneFileFileName;
		}






		public void setUploadOneFileFileName(String uploadOneFileFileName) {
			this.uploadOneFileFileName = uploadOneFileFileName;
		}






		public String execute()  {
			try{
			 //�ļ�������
			   InputStream is =new FileInputStream(uploadOneFile);
			 //�����ļ��ϴ�Ŀ¼
			   String path=ServletActionContext.getServletContext().getRealPath("/uploadOne");
			 //����Ŀ���ļ�
			   File f=new File(path,this.getUploadOneFileFileName());
			  //����һ�������
			   OutputStream os=new FileOutputStream(f);
			   //���û���
			   byte[] buffer =new byte[1024];
			   int len=0;
			   while((len=is.read(buffer))>0){
				   os.write(buffer, 0, len);
				     
			   }
			   os.close();
			   is.close();
			}
			catch(FileNotFoundException e){
				System.out.println("û���ҵ��ļ�");
			}
			catch(IOException e){
				System.out.println("��д����");
			}
			   return "success";
			   
		}
        
}
