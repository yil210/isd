package yil210;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BadgeServlet
 */
@WebServlet("/BadgeServlet")
public class BadgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BadgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	response.setContentType("text/html;charset=UTF-8");
    	
    	Params params = new Params();
    	params.setMsg(request.getParameter("MESSAGE"));
    	params.setShape(request.getParameter("SHAPE"));
    	params.setColor(request.getParameter("COLOR"));
    	params.setBgcolor(request.getParameter("BGCOLOR"));
    	params.setX(Integer.parseInt(request.getParameter("X")));
    	params.setY(Integer.parseInt(request.getParameter("Y")));
    	params.setX1(Integer.parseInt(request.getParameter("X1")));
    	params.setY1(Integer.parseInt(request.getParameter("Y1")));
    	params.setFtstyle(request.getParameter("FTSTYLE"));
    	params.setFtsize(Integer.parseInt(request.getParameter("FTSIZE")));
    
    	
    	
    	//store the parameter into session and forward to web page
        HttpSession session = request.getSession();
        session.setAttribute("Params", params);
//        PrintWriter out=response.getWriter();
//      out.println(request.getParameter("X1"));
//      out.println(request.getParameter("Y1"));
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");;
        dispatcher.forward(request, response);
        
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
