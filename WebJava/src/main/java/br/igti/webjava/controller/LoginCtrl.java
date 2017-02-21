package br.igti.webjava.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.igti.webjava.dao.FuncionarioDAO;
import br.igti.webjava.dao.IWebJavaDAO;
import br.igti.webjava.entity.Funcionario;
import br.igti.webjava.util.EnumAction;
import br.igti.webjava.util.LoginNotFound;
import br.igti.webjava.util.NoActionValid;

/**
 * Servlet implementation class LoginCtrl
 */
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnumAction action = EnumAction.getEnum(request.getParameter("action"));
		if (action==EnumAction.INVALID) throw new NoActionValid();
		
		IWebJavaDAO<Funcionario, Integer> dao = new FuncionarioDAO();
		if (action==EnumAction.LOGAR){
			Funcionario func = 
					((FuncionarioDAO)dao).findByLogin(request.getParameter("login")
					, request.getParameter("senha"));
			
			if (func==null) throw new LoginNotFound();
			else{
				Cookie fCookie = new Cookie("Login", func.getId().toString());
				response.addCookie(fCookie);	
				response.setContentType("application/text");
				response.getWriter().println("Ok");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
