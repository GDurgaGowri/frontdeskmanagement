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

	 try {
         Class.forName("com.mysql.cj.jdbc.Driver");
     }catch(Exception e) {
         e.printStackTrace();
     }
	
	try(Connection con = DriverManager.getConnection("jdbc:mysql:///fdem","root","root");
          PreparedStatement ps = con.prepareStatement(query);){
          ps.setString(1, Name);
          ps.setString(2, Purpose);
          ps.setString(3, Meetingperson);
          ps.setString(4, Gender);
          ps.setString(5, Mobile);
          ps.setString(6, City);
          ps.setString(7, Date);
          ps.setString(8,Intime);
          ps.setString(9, Outtime);
          ps.setString(10, Email);
          //execute the query
          int count = ps.executeUpdate();
          pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
          if(count==1) {
              pw.println("<h2 class='bg-sucess text-light text-center'>Record Registered Successfully</h2>");
          }else {
              pw.println("<h2 class='bg-danger text-light text-center'>Record Not Registered</h2>");
          }
      }catch(SQLException se) {
          pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
          se.printStackTrace();
      }catch(Exception e) {
          e.printStackTrace();
      }
      pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
      pw.println("</div>");
    
      pw.close();
  }
	  

  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}
}
