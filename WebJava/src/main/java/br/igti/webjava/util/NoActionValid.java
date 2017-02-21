package br.igti.webjava.util;

public class NoActionValid extends GamaException{
	
    private static final long serialVersionUID = 1149241039409861914L;
    
    public NoActionValid(String msg){
    	super(msg);
    }
    public NoActionValid(){
    	super("Ação não encontrada");
    	
    }

}
