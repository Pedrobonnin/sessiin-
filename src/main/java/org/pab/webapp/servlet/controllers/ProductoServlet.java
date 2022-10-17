package org.pab.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.pab.webapp.servlet.models.Producto;
import org.pab.webapp.servlet.services.LoginService;
import org.pab.webapp.servlet.services.LoginServiceSessionImpl;
import org.pab.webapp.servlet.services.ProductoService;
import org.pab.webapp.servlet.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})

public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> cookieOptional = auth.getUsername(req);

        resp.setContentType("text/html; charset=UTF-8"); //definimos el tipo de respuesta

        try (PrintWriter out = resp.getWriter()) { //Imprimimos la estructura HTML ---mostrando los "productos" en una tabla----


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <link rel=\"stylesheet\" href=\"./style.css\">");
            out.println("        <title>Listado de Productos</title>");
            out.println("    </head>");
            out.println("    <body>");


            if (cookieOptional.isPresent()) {
                out.println("        <div class=\"container\">");
                out.println("        <h1>Listado de productos</h1>");
                out.println("        <table>");
                out.println("           <thead>");
                out.println("               <tr>");
                out.println("                    <th>Id</th>");
                out.println("                    <th>Nombre</th>");
                out.println("                    <th>Tipo</th>");
                out.println("                   <th>Precio</th>");
                out.println("               </tr>");
                out.println("           </thead>");

                productos.forEach(p -> {
                    out.println("           <tbody>");
                    out.println("             <tr>");
                    out.println("                  <td>" + p.getId() + "</td>");
                    out.println("                  <td>" + p.getNombre() + "</td>");
                    out.println("                  <td>" + p.getTipo() + "</td>");
                    out.println("                  <td>" + p.getPrecio() + "</td>");
                    out.println("              </tr>");
                    out.println("           </tbody>");
                });
                out.println("        </table>");
                out.println("        </div>");
                out.println("        <br>");
                out.println("        </div>");
                out.println("        <div id=\"lista\">");
                out.println("           <ul> ");
                out.println("               <li><a href='"+req.getContextPath()+"/index.html'>volver</a></li>");
                out.println("               <li><a href='"+req.getContextPath()+"/logout'>cerrar sesion</a></li>");
                out.println("           </ul> ");


            }else{

                out.println("        <div id=\"lista\">");
                out.println("        <h1>Inicie sesion para ver los productos </h1>");
                out.println("        <ul> ");
                out.println("           <li><a  href=\"/webapp-session\">volver</a></li>");
                out.println("           <li><a  href=\"/webapp-session/login\">Login</a></li>");
                out.println("        </ul> ");


            }

            out.println("    </body>");
            out.println("</html>");

        }


    }
}
