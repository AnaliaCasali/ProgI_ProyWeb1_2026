package org.ies63.progi;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

public class HelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

      req.setAttribute("mensaje","Bienvenido a mi primer servlet");
      req.setAttribute("fecha",  LocalDate.now().toString());
    req.setAttribute("fecha2","otro");

    RequestDispatcher rd= req.getRequestDispatcher("hola.jsp");
    rd.forward(req,resp);

    //super.doGet(req, resp);
  }

}
