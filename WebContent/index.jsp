<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<script type="text/javascript">
function empty() 
{
    var x;
    x = document.getElementById("uID").value;

    if (x == "") 
    {
    	alert("Enter a Valid input");
        return false;
    };
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User ID</title>
</head>
<body>
    <form action="controllerServlet" method="GET">
    User ID: <input type="text" name="uID" id="uID"> <br><br>
    <input type="submit" value="Submit" onClick="return empty()"/>
	</form>
	
</body>
</html>