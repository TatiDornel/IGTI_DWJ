package br.igti.webjava.util;

public class LoginNotFound extends GamaException{
	
    private static final long serialVersionUID = 1149241039409861914L;
    
    public LoginNotFound(String msg){
    	super(msg);
    }
    public LoginNotFound(){
    	super("Login não encontrado");
    	
    }

}
