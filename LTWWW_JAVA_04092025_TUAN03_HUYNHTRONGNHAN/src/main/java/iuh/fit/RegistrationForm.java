package iuh.fit;

import iuh.fit.Models.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionID = 1L;

    public RegistrationForm(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.getWriter().append("Server at: ").append(request.getContextPath());


        String firstName= request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String birthdate = request.getParameter("birthdate"); // Format: yyyy-MM-dd
        String[] parts = birthdate.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];

        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String[] hobbiesArray = request.getParameterValues("chkHobbies");
        String otherHobby = request.getParameter("otherHobby");

        String hobbies = "";
        if (hobbiesArray != null) {
            hobbies = String.join(", ", hobbiesArray);
            if (otherHobby != null && !otherHobby.trim().isEmpty()) {
                hobbies += ", " + otherHobby.trim();
            }
        } else {
            if (otherHobby != null && !otherHobby.trim().isEmpty()) {
                hobbies = otherHobby.trim();
            }
        }

        String course = request.getParameter("course");

        Student sv = new Student();
        sv.setFirstName(firstName);
        sv.setLastName(lastName);
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setDatePfBirth(birthdate);


        request.setAttribute("student", sv);


        RequestDispatcher rd = request.getRequestDispatcher("resultForm.jsp");
        rd.forward(request,response);

    }
}
