package br.igti.webjava.controller;

import static br.igti.webjava.util.Util.agora;
import static br.igti.webjava.util.Util.isNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.igti.webjava.dao.FuncionarioDAO;
import br.igti.webjava.dao.IWebJavaDAO;
import br.igti.webjava.dao.PontoDAO;
import br.igti.webjava.entity.Ponto;
import br.igti.webjava.util.EnumAction;
import br.igti.webjava.util.NoActionValid;
/**
 * Servlet implementation class FuncionarioAction
 */
public class PontoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PontoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EnumAction action = EnumAction.getEnum(request.getParameter("action")); 
		if (action==null) new NoActionValid();
		IWebJavaDAO<Ponto, Integer> dao = new PontoDAO();
		
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
 
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
        
		if (action==EnumAction.REGISTRAR_PONTO){						
			dao.save(loadForm(request));	
			out.println("Ponto registrado com sucesso");
		}else if (action==EnumAction.FIND){
			Cookie c = request.getCookies()[0];
			String id = c.getValue();
			Ponto p = ((PontoDAO)dao).findByDia(Integer.valueOf(id));
			if (p==null) {
				p = new Ponto();
				p.setData(LocalDate.now());
				p.setFuncionario(new FuncionarioDAO().findById(Integer.valueOf(id)));
			}
				 
	        Gson gson = new Gson(); 
	        JsonObject myObj = new JsonObject();
	 
	        
	        JsonElement elemento = gson.toJsonTree(p);
	        myObj.addProperty("success", true);
	        
	        myObj.add("ponto", elemento);
	        out.println(myObj.toString());
	 
	       
			
		}
		out.close();
		
	}
	private Ponto loadForm(HttpServletRequest request){
		Ponto p = new Ponto();
		if (isNull( request.getParameter("idPonto") )){
			p.setData(LocalDate.now());
			p.setEntrada(agora());
			Cookie c = request.getCookies()[0];
			String id = c.getValue();
			p.setFuncionario(new FuncionarioDAO().findById(Integer.valueOf(id)));
		}else{
			
			p = new PontoDAO().findById(Integer.valueOf(request.getParameter("idPonto")));
			if (isNull(p.getIntervalo())) p.setIntervalo(agora());
			else if (isNull(p.getRetorno())) p.setRetorno(agora());
			else if (isNull(p.getSaida())) p.setSaida(agora());
		}
		
		return p;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
