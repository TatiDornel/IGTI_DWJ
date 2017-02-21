package br.igti.webjava.controller;

import static br.igti.webjava.util.Util.isNull;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.igti.webjava.dao.FuncionarioDAO;
import br.igti.webjava.dao.IWebJavaDAO;
import br.igti.webjava.entity.Funcionario;
import br.igti.webjava.util.EnumAction;
import br.igti.webjava.util.NoActionValid;

/**
 * Servlet implementation class FuncionarioAction
 */
public class FuncionarioCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionarioCtrl() {
        super();      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
			EnumAction action = EnumAction.getEnum(request.getParameter("action"));
			if (action==EnumAction.INVALID) throw new NoActionValid();
			
			IWebJavaDAO<Funcionario, Integer> dao = new FuncionarioDAO();
			if (action==EnumAction.NOVO_FUNCIONARIO){
				dao.save(loadForm(request));
				response.getWriter().append("Funcionário salvo com sucesso");
			}else if (action==EnumAction.ALTERAR_SENHA){
				dao.update(loadForm(request));
				response.getWriter().append("Funcionário salvo com sucesso");
			}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private Funcionario loadForm(HttpServletRequest request){
		Funcionario f = new Funcionario();
		if (isNull( request.getParameter("idFuncionario") )){
			f.setLogin(request.getParameter("login"));
			f.setNome(request.getParameter("nome"));
			f.setSenha(request.getParameter("senha"));
		}else{
			f = new FuncionarioDAO().findById(Integer.valueOf(request.getParameter("idFuncionario")));
			if (isNull(request.getParameter("senha"))) f.setSenha(request.getParameter("senha"));
		}
		
		return f;
	}

	@Override
	public void destroy() {			
		super.destroy();
	}
}
