package br.igti.webjava.util;

import javax.servlet.ServletException;

public class GamaException extends ServletException{
	
    private static final long serialVersionUID = 1149241039409861914L;
    
    public GamaException(String msg){
    	super(msg);
    }

}
