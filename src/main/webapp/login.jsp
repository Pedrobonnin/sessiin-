<%@page contentType="text/html" pageEncoding= "UTF-8"  %>
<%@page import ="java.util.List"  %>

    <%  //etiquetas JSP para colocar codigo Java
        List <String> errores = (List<String>)request.getAttribute("errores");

         //siempre hay que hacer un cash de los atibutos que obtenemos

    %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="error">
     <%
        if(errores!= null && errores.size()>0){
        %>
        <ul>
        <%
        for(String error:errores){
        %>

        <li>
        <%out.print(error);  %>
        </li>

        <%}%>
        </ul>
        <%}
        %>
    </div>
    <div class="box">
       <h1>Formulario</h1>
       <form action="/webapp-session/login" method="post">
           <fieldset>
                <br>
                <div class="inputBox">
                    <input class="inputUser" type="text" name="username" id="username">
                    <label class="labelInput" for="username">Usuario</label>
                </div>
                <br><br>
                <div class="inputBox" >
                    <input class="inputUser" type="password" name="password" id="password">
                     <label class="labelInput" for="password">Contraseña</label>
                </div>
                <br><br>
                <div>
                    <input id="submit" type="submit" name="submit" value="Inicio Sesion">
                </div>
           </fieldset>
       </form>
    </div>
    <div id="lista">
               <ul>
                    <li><a href="/webapp-session">volver</a></li>
               </ul>
    </div>
</body>
</html>