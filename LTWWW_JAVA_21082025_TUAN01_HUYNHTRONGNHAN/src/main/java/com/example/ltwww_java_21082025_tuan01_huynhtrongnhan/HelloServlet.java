package com.example.ltwww_java_21082025_tuan01_huynhtrongnhan;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "FormData", value = "/form-data")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("first-name");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String shortbio = request.getParameter("bio");

        String html = "<html>"
                + "<head><title>Result Page</title></head>"
                + "<body>"
                + "<h1>Submitted Information</h1>"
                + "<p><strong>Name:</strong> " + name + "</p>"
                + "<p><strong>Email:</strong> " + email + "</p>"
                + "<p><strong>Facebook:</strong> " + facebook + "</p>"
                + "<p><strong>Short Bio:</strong> " + shortbio + "</p>"
                + "</body>"
                + "</html>";

        out.println(html);
    }

    public void destroy() {
    }
}