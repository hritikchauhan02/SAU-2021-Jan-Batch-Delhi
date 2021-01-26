<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Calculator</title>
</head>
<body>
    <div style="text-align: center; justify-content: center">
        <h1>Calculator</h1>
        <form action="/" method="POST">
            <div>
                Number1 : <input name="num1" type="text" />
            </div>
            <br>
            <br>
            <div>
                Number2 : <input name="num2" type="text" />
            </div>
            <br>
            <br>
            <div>
                Operation : <select name="operation">
                            <option value="Add">Add</option>
                            <option value="Subtract">Subtract</option>
                            <option value="Multiply">Multiply</option>
                            <option value="Divide">Divide</option>
                        </select>
            </div>
            <br>
            <br>
            <input type="submit" />
        </form>
     </div>
</body>
</html>