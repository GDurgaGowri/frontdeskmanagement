import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
private static final String query = "insert into user(Name,Purpose,Meetingperson,Gender,Mobile,City,Date,Intime,Outtime,Email) values(?,?,?,?,?,?,?,?,?,?)";


@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter pw=res.getWriter();
    res.setContentType("text/html");
    pw.println("<link rel='stylesheet' href='ttps://fonts.googleapis.com/css?family=Roboto:300,400,500,700'></link>");
    String Name=req.getParameter("userName");
    String Purpose=req.getParameter("purpose");
    String Meetingperson=req.getParameter("meetingperson");
    String Gender=req.getParameter("gender");
    String Mobile=req.getParameter("mobile");
    String City=req.getParameter("city");
    String Date=req.getParameter("date");
    String Intime=req.getParameter("intime");
    String Outtime=req.getParameter("outtime");
    String Email=req.getParameter("email");
    LocalTime currentTime = LocalTime.now();

    // Check if the intime is before the current time
    if (LocalTime.parse(Intime).equals(currentTime)) {
        pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
        pw.println("<h2 class='bg-danger text-light text-center'>Intime should be greater than or equal to current time</h2>");
        pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
        pw.close();
        return;
    }
    if (LocalTime.parse(Outtime).isBefore(LocalTime.parse(Intime))) {
        pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
        pw.println("<h2 class='bg-danger text-light text-center'>Outtime should be greater than intime</h2>");
        pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
        pw.close();
        return;
    }
    ServletUtils myClass = new ServletUtils();
    boolean success = myClass.insertData(Name, Purpose, Meetingperson, Gender, Mobile, City, Date, Intime, Outtime, Email);
    if (success) {
        pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
        pw.println("<h2 class='bg-success text-light text-center'>Registration successful!</h2>");
        pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
    } else {
        pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
        pw.println("<h2 class='bg-danger text-light text-center'>Registration failed. Please try again later.</h2>");
        pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
    }
    pw.close();
}

	  

  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}
}
