


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteurl")
public class DeleteServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String query = "delete from fdems where id = ? ";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
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
        pw.println(".btn {");
        pw.println("    display: inline-block;");
        pw.println("    padding: 10px 20px;");
        pw.println("    background-color: #2980b9;");
        pw.println("    color: black;");
        pw.println("    text-decoration: none;");
        pw.println("    border-radius: 4px;");
        pw.println("    transition: background-color 0.3s;");
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
        pw.println(".btn:hover {");
        pw.println("    background-color: #1c638e;");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<div class='office-image'></div>");
        pw.println("<h2> Data to be edited</h2>");
        pw.println("<div class='container'>");
        //get the values
        int id = Integer.parseInt(req.getParameter("id"));
        //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///usermgmt","root","root");
                PreparedStatement ps = con.prepareStatement(query);){
            //set the values
            ps.setInt(1, id);
            //execute the query
            int count = ps.executeUpdate();
            
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count==1) {
            	 pw.println("<h2 class='bg-danger text-light text-center'>Record Deleted Successfully</h2>");

            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Not Deleted</h2>");
            }
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("&nbsp; &nbsp;");
        pw.println("<a href='showdata'><button class='btn btn-outline-success'>Show User</button></a>");
        pw.println("</div>");
        //close the stram
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}

