package org.ies63.progi.servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ies63.progi.dao.EmpleadoDao;
import org.ies63.progi.entities.Empleado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/empleados")
public class EmpleadoServlet  extends HttpServlet {
  EmpleadoDao empleadoDao;

  @Override
  public void init(){
    empleadoDao=new EmpleadoDao();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res){
    // get devuelve la lista de todos los empleados pasando atributo
    List<Empleado> lista = new ArrayList<>();
    lista= empleadoDao.getAll();
    // seteo los atributos de la request
    req.setAttribute("lista", lista);
    // envio con distpacher
    RequestDispatcher rd= req.getRequestDispatcher("listado2.jsp");
    try {
      rd.forward(req,res); // redirijo a listado2.jsp
    } catch (Exception e) {
      System.out.println("no pudo obtener el listado");
    }
  }


}
