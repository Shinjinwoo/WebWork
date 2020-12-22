package no2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



@WebServlet("/ss")
public class FileUpload extends HttpServlet {
   private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doHandle(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doHandle(request, response);
   }

   private void doHandle(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
         String encoding="utf-8";
         //업로드할 파일 경로 지정함
         File currentDirPath = new File("D:\\file_repo"); //파일 안만들어서 업로드하지못했음 ㅎㅎ 
         DiskFileItemFactory factory = new DiskFileItemFactory();
         //파일 경로 설정
         factory.setRepository(currentDirPath);
         //파일 업로드 가능한 파일 크기 설정
         factory.setSizeThreshold(1024 * 1024);
         ServletFileUpload upload = new ServletFileUpload(factory);
         try {
        	 // request 객체에서 매개변수를 List로 가졌습니다.
            List items = upload.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
               FileItem fileItem = (FileItem) items.get(i);
   
               if (fileItem.isFormField()) {
                  System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
               } else {
                  System.out.println("파라미터명:" + fileItem.getFieldName());
                  System.out.println("파일명:" + fileItem.getName());
                  System.out.println("파일크기:" + fileItem.getSize() + "bytes");
   
                  if (fileItem.getSize() > 0) {
                     int idx = fileItem.getName().lastIndexOf("\\");
                     if (idx == -1) {
                        idx = fileItem.getName().lastIndexOf("/");
                     }
                     String fileName = fileItem.getName().substring(idx + 1);
                     File uploadFile = new File(currentDirPath + "\\" + fileName);
                     fileItem.write(uploadFile);
                  } // end if
               } // end if
            } // end for
            
         } catch (Exception e) {
            e.printStackTrace();
         }
   }

}
/* * ServletFileUPload 클래스가 제공하는 메서드
* parseRequest() 전송된 매개변수를 List 객체로 얻습니다.abstract
* getItemIterator() 전송된 매개변수를 Iterator 타입으로 얻습니다.*/