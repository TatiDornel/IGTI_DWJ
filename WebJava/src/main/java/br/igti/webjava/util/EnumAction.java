package br.igti.webjava.util;


public enum EnumAction {
	
	NOVO_FUNCIONARIO,
	ALTERAR_SENHA,
	REGISTRAR_PONTO,
	LOGAR,
	FIND,
	INVALID;
	
	public static EnumAction getEnum(String action){
		if (Util.isNull(action)) return INVALID;
		if (action.equals("NOVO_FUNCIONARIO")) return NOVO_FUNCIONARIO;
		else if (action.equals("ALTERAR_SENHA")) return ALTERAR_SENHA;
		else if (action.equals("REGISTRAR_PONTO")) return REGISTRAR_PONTO;
		else if (action.equals("LOGAR")) return LOGAR;
		else if (action.equals("FIND")) return FIND;
		else return INVALID;
	}
}
