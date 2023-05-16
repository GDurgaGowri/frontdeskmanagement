import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import javax.servlet.ServletException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registr")
public class RegisterServlet extends HttpServlet {

	 
	private static final long serialVersionUID = 1L;




@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
    PrintWriter pw=res.getWriter();
    res.setContentType("text/html");
    pw.println("<!DOCTYPE html>");
    pw.println("<html>");
    pw.println("<head>");
    pw.println("<meta charset='UTF-8'>");
    pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    pw.println("<title>User Data</title>");
    pw.println("<style>");
    pw.println("body {");
   
    pw.println("    font-family: Arial, sans-serif;");
    pw.println("    background-color: #f7f7f7;");
    pw.println("    margin: 0;");
    pw.println("}");
    
    pw.println("h2 {");
    pw.println("    background-color: #2980b9;");
    pw.println("    color: #fff;");
    pw.println("    text-align: center;");
    pw.println("    padding: 20px 0;");
    pw.println("    margin: 0;");
    pw.println("}");
    pw.println("table {");
    pw.println("    width: 100%;");
    pw.println("    border-collapse: collapse;");
    pw.println("}");
    pw.println("th {");
    pw.println("    background-color: #2980b9;");
    pw.println("    color: #fff;");
    pw.println("    text-align: left;");
    pw.println("    padding: 8px;");
    pw.println("}");
    pw.println("td {");
   
    pw.println("    text-align: left;");
    pw.println("    padding: 8px;");
    pw.println("}");
    pw.println("tr:nth-child(even) {");
    pw.println("    background-color: #f2f2f2;");
    pw.println("}");
    pw.println(".container {");
    pw.println("    max-width: 1200px;");
    pw.println("    margin: 0 auto;");
    pw.println("    padding: 20px;");
    pw.println("}");
    pw.println(".container {");
    pw.println("  position: relative;");
    pw.println("  width: 100%;");
    pw.println("  height: 100vh;");
    pw.println("  overflow: hidden;");
    pw.println("}");
    pw.println(".cracker {");
    pw.println("  position: absolute;");
    pw.println("  width: 50px;");
    pw.println("  height: 80px;");
    pw.println("  border: 5px solid #c49b63;");
    pw.println("  border-bottom: 50px solid #c49b63;");
    pw.println("  border-radius: 0 0 50px 50px;");
    pw.println("  background: linear-gradient(to bottom, #f8d68b, #c49b63);");
    pw.println("  animation: burst 2s forwards;");
    pw.println("}");
    pw.println("@keyframes burst {");
    pw.println("  from {");
    pw.println("    transform: translateY(0) rotateZ(0deg);");
    pw.println("    opacity: 1;");
    pw.println("  }");
    pw.println("  to {");
    pw.println("    transform: translateY(100vh) rotateZ(1080deg);");
    pw.println("    opacity: 0;");
    pw.println("  }");
    pw.println("}");
    pw.println(".image-container {");
    pw.println("    position: fixed;");
    pw.println("    bottom: 0;");
    pw.println("    left: 0;");
    pw.println("    right: 0;");
    pw.println("    height: 200px;");
    pw.println("    background-image: url('https://www.google.com/search?q=chainsys+logo&rlz=1C1ONGR_enIN1056IN1056&oq=chainsys+logo&aqs=chrome..69i57.5524j0j15&sourceid=chrome&ie=UTF-8#imgrc=1FPQHl9g4oG4rM');");
    pw.println("    background-repeat: no-repeat;");
    pw.println("    background-size: cover;");
    pw.println("}");
    pw.println(".btn {");
    pw.println("    display: inline-block;");
    pw.println("    padding: 10px 20px;");
    pw.println("    background-color: #2980b9;");
    pw.println("    color: black;");
    pw.println("    text-decoration: none;");
    pw.println("    border-radius: 4px;");
    pw.println("    transition: background-color 0.3s;");
    pw.println("}");
    pw.println(".btn:hover {");
    pw.println("    background-color: #1c638e;");
    pw.println("}");
    pw.println("</style>");
    pw.println("</head>");
    pw.println("<body>");
    pw.println("<div class='office-image'></div>");
   
    pw.println("<div class='container'>");
    pw.println("<div class='office-image'></div>");
    pw.println("<button class='btn'><a href='home.html'>Home</a></button>");
    
    pw.println("<div class='container'>");
    pw.println("<div class='image-container' href='https://www.google.com/search?q=chainsys+logo&rlz=1C1ONGR_enIN1056IN1056&oq=chainsys+logo&aqs=chrome..69i57.5524j0j15&sourceid=chrome&ie=UTF-8#imgrc=1FPQHl9g4oG4rM'></div>");
   

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
    
    boolean success = ServletUtils.insertData(Name, Purpose, Meetingperson, Gender, Mobile, City, Date, Intime, Outtime, Email);
    boolean succ = Dup.insertData(Name, Purpose, Meetingperson, Gender, Mobile, City, Date, Intime, Outtime, Email);
    
    if (success &succ) {
        pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
        
        pw.println("<h2 class='bg-danger text-light text-center' style='margin-top: 100px;'>Registration sucess</h2>");
        
        
        pw.println("</div>");
    } else {
        pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
        pw.println("<h2 class='bg-danger text-light text-center'>Registration failed. Please try again later.</h2>");
        
        pw.println("</div>");
    }
   
    pw.close();
    
}

	  

  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}
}
