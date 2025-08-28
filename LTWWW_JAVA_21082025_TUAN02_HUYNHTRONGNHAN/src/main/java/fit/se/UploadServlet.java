package fit.se;

import fit.se.MariaDB.DBConnection;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.mariadb.jdbc.Connection;

import java.io.*;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "uploadServlet", value = "/uploadDB")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private String uploadPathToSource;

    @Override
    public void init(ServletConfig config) throws
            ServletException {
        super.init(config);
        String userDir = System.getProperty("user.dir");
        if (userDir.contains("tomcat") &&
                userDir.endsWith("bin")) {
            userDir = new File(userDir).getParent();
            userDir = new File(userDir).getParent();
        }
        uploadPathToSource =
                "T:\\LTWWW_HuynhTrongNhan_22679471\\LTWWW_JAVA_21082025_TUAN02_HUYNHTRONGNHAN\\src\\main\\webapp\\upload";
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        InputStream inputStream = null;
// luồng dữ liệu nhập của upload file
// lấy thông tin tập tin upload trong form, form này gồm nhiều phần dữ liệu text và file (multipart request)
        Part filePart = req.getPart("photo");
        String fileUploadName = "";
        if (filePart != null && filePart.getSubmittedFileName()
                != null && !filePart.getSubmittedFileName().isEmpty()) {
            fileUploadName = filePart.getSubmittedFileName();
            inputStream = filePart.getInputStream();
        }
        String message = null;


// try-with-resources
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Insert");
// Insert dữ liệu vào CSDL UploadFileServletDB, trường hợp này bảng contacts (khóa tự động tăng)
            String sqlInsert = "INSERT INTO contacts(first_name, last_name, photo) values (?, ?, ?)";
            PreparedStatement statement =
                    conn.prepareStatement(sqlInsert);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            if (inputStream != null) {
                statement.setBlob(3, inputStream);
            }
            int row = statement.executeUpdate();
// thực hiện lưu thông tin vào CSDL
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
// đọc CSDL lưu file
            String filePath = uploadPathToSource +
                    fileUploadName;
            String sqlSelect = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
            statement = conn.prepareStatement(sqlSelect);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("photo");
                inputStream = blob.getBinaryStream();
                OutputStream outputStream = new
                        FileOutputStream(filePath);
                int bytesRead = -1;
                byte[] buffer = new byte[1024];
                while ((bytesRead = inputStream.read(buffer))
                        != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();

            }
        } catch (SQLException e) {


            message = "ERROR: " + e.getMessage();
            e.printStackTrace();
        }
// Forward đến servlet MessageServlet
        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/message").
                forward(req, resp);
    }
}
