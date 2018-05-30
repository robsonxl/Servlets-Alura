<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!<br/>
	
	<c:if test="${not empty usuarioLogado}">
		Logado como: ${usuarioLogado.email}<br />
	</c:if>
			
	<form action="novaEmpresa" method="POST">
		Nome: <input type="text" name="nome"/>
		<input type="submit" value="enviar"/	>
	</form>
	
	<form action="login" method="POST">
		Email: <input type="email" name="email"	/>
		Senha: <input type="password" name="password">
			   <input type="submit" value="Enviar">
	</form>
	
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="logout" >
	    <input type="submit" value="Logout" />
	</form>
	</body>
</html>