package fit.se;

import java.io.*;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UploadFiles", value = "/uploadFiles")
@MultipartConfig
public class UploadFiles extends HttpServlet {
    private String message;
    private static final String UPLOAD_DIR = "T:\\LTWWW_HuynhTrongNhan_22679471\\LTWWW_JAVA_21082025_TUAN02_HUYNHTRONGNHAN\\src\\main\\webapp\\upload";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uploadPath = UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
            boolean created = uploadDir.mkdirs();
        }

        Collection<Part> parts = request.getParts();

        for (Part part : parts) {
            String fileName = getFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                String filePath = uploadPath + File.separator + fileName;
                try (InputStream inputStream = part.getInputStream();
                     FileOutputStream outputStream = new FileOutputStream(filePath)) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Kết quả Upload</title></head><body>");
        out.println("<h2>Upload thành công!</h2>");
        out.println("<a href='index.jsp'>Quay lại</a>");
        out.println("</body></html>");
        System.out.println("Upload path: " + uploadPath);
    }
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1)
                        .replace("\\", "/")
                        .substring(token.lastIndexOf("/") + 1);
            }
        }
        return null;
    }
    public void destroy() {
    }
}