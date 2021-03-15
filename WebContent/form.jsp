<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Info</title>
</head>
<body>
	<p>Name is: <%= request.getAttribute("fname") %>.</p>
	<p>Username is: <%= request.getAttribute("pass") %>.</p>
	<p>Password is <%= request.getAttribute("un") %>.</p>
	
	<form action="controllerServlet" method="post">
    Change name: <input type="text" name="yourName" id="yourName"> <br><br>
    Change username: <input type="text" name="yourUN" id="yourUN"> <br><br>
    Change password: <input type="text" name="yourPass" id="yourPass"> <br><br>
    <input type="hidden" name="sameid" id="sameid" value= <%= request.getAttribute("uid") %>> <br><br>
    <input type="submit" value="Submit"/>
    </form>
	
</body>
</html>