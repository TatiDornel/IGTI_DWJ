
function redirectFuncionario(){
	
	$(document).ready( function() {
	      url = "page/criarFuncionario.html";
	      $( location ).attr("href", url);
	   });
}
function saveFuncionario(){
	
	$.ajax({
	    url : '/WebJava/FuncionarioCtrl',
	    type : 'post',
	    data : {
	    	   action: "NOVO_FUNCIONARIO",	
	    	   nome: $("#nome").val(),	    
		       login: $("#login").val(),
			   senha: $("#senha").val()	},
	    dataType: 'json',
	  
	   
	    timeout: 3000,    
	    success: function(retorno){
	      $('#msg').html(retorno);
	    },
	    error: function(erro){
	      $('#msg').html(erro);
	    }       
	  })
	  
	
}

function loginPonto(){
	
	$.ajax({
	    url : '/WebJava/LoginCtrl',
	    type : 'post',
	    data : {
	    	   action: "LOGAR",	
	    	   login: $("#login").val(),
			   senha: $("#senha").val()	},
	    dataType: 'text',
	       
	    success: function(retorno){
	    	
	    	$(document).ready( function() {
	    	      url = "page/registrarPonto.html";
	    	      $( location ).attr("href", url);
	    	   });
	    },
	    error: function(erro){
	    	alert(erro);
	      
	    }       
	  })
	
}

function getPonto(){
	$.ajax({
	    url : '/WebJava/PontoCtrl',
	    type : 'post',
	    data : {
	    	   action: "FIND"	
	    	  },
	    dataType: 'json',
	   
	   
	    success: function(retorno){
	    	alert("ok"+retorno.ponto.funcionario.nome)
	    	$("#id").val(retorno.ponto.id);
	    	$("#idFuncionario").val(retorno.ponto.funcionario.id);
	    	$("#data").val(retorno.ponto.data.day + "/" +retorno.ponto.data.month + "/" + retorno.ponto.data.year );
	    	$("#hora_1").val(retorno.ponto.entrada);
	    	$("#hora_2").val(retorno.ponto.intervalo);
	    	$("#hora_3").val( retorno.ponto.retorno);
	    	$("#hora_4").val(retorno.ponto.saida);
	    	$("#funcionario").val(retorno.ponto.funcionario.nome);
	    },
	    error: function(erro){
	    	alert("err"+erro);
	    }       
	  })
	
}

function registrarPonto(){
	$.ajax({
	    url : '/WebJava/PontoCtrl',
	    type : 'post',
	    data : {
	    	   action: "REGISTRAR_PONTO",
	    	   id: $("#id").val(),
	    	   data: $("#data").val(),
	    	   hora_1: $("#hora_1").val(),
	    	   hora_2: $("#hora_2").val(),
	    	   hora_3: $("#hora_3").val(),
	    	   hora_4: $("#hora_4").val()
		       },
	    dataType: 'html',
	     
	    success: function(retorno){
	     alert(retorno);
	    },
	    error: function(erro){
	    	alert(erro);
	    }       
	  })
	  
	
}