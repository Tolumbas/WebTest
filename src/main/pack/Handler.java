package main.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Handler
 */
@WebServlet("/submit")
public class Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> usernames = new ArrayList<String>();
	List<String> personal = new ArrayList<String>();
	
    public Handler() {
    	super();
    	usernames.add("Anton");
    	personal.add("Obicha da si beatboxira na ulicata");
    	usernames.add("Georgi");
    	personal.add("Ne go poznavan");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	    PrintWriter out = response.getWriter();
	    String in = request.getParameter("name");
	    for (int a=0;a<usernames.size();a++){
	    	if (in.compareTo(usernames.get(a)) == 0){
	    		 out.println("<html>");
	    		 out.println("<body>");
	    		 out.printf("name: %s\nPersonal Info: %s", usernames.get(a),personal.get(a));
	    		 out.println("</BODY></HTML>");
	    		 return;
	    	}
	    }
	    
	    out.println("<html>");
	    out.println("<body>");
	    out.println("Wrong username");
	    out.println("</BODY></HTML>");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
	}
}

