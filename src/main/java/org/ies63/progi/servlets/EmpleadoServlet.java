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

    String accion=req.getParameter("accion");
    if(accion==null){  accion="listar";    }
    RequestDispatcher rd=null;

    switch (accion){
      case "listar":
        List<Empleado> lista = new ArrayList<>();
        lista= empleadoDao.getAll();
        // seteo los atributos de la request
        req.setAttribute("lista", lista);
        // envio con distpacher
        rd= req.getRequestDispatcher("listado2.jsp");
        try {
          rd.forward(req,res); // redirijo a listado2.jsp
        } catch (Exception e) {
          System.out.println("no pudo obtener el listado");
        }
        break;
      case "nuevo":
        try {
          rd= req.getRequestDispatcher("formulario-empleado.jsp");
          rd.forward(req,res); // redirijo a formulario.jsp
        } catch (Exception e) {
          System.out.println( e.getMessage() + " " + e.getCause());
        }
        break;
      case "editar":
        String  strId= req.getParameter("id");
        int id= Integer.parseInt(strId);    // converti a entero
        // busco x id si existe el empleado en la bd y lo guardo en variable
        Empleado empleadoaEditar= empleadoDao.getById(id);
        /// tengo que pasar el empleado al formulario para que muestre sus datos
        req.setAttribute("empleado", empleadoaEditar );
        try {
          rd= req.getRequestDispatcher("formulario-empleado.jsp");
          rd.forward(req,res); // redirijo a formulario.jsp
        } catch (Exception e) {
          System.out.println( e.getMessage() + " " + e.getCause());
        }
        break;



    }// cierra switch accion

  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) {
    // se va a encargar de guardar uno nuevo o hacer update si ya existe
    // usa empleado y el dao

      //1.guardo los datos del formulario que vienen en la request en variables
                        // uso los name que puse a los input en el form
      String strId=req.getParameter("txtId");
      String strNombre=req.getParameter("txtNombre");
      String strApellido=req.getParameter("txtApellido");
      String strSalarioBase=req.getParameter("txtSalarioBase");
      //2.creo empleado seteando los datos
      Empleado empleado=new Empleado();
      empleado.setNombre(strNombre);
      empleado.setApellido(strApellido);
      if(strSalarioBase!=null || !strSalarioBase.isEmpty()  )
        empleado.setSalarioBase(Double.parseDouble(strSalarioBase));
      // 3. guardo
      if(strId==null || strId.isEmpty()){// es nuevo
        empleadoDao.insert(empleado);      }
      else
      { empleado.setId(Integer.parseInt(strId) );
        empleadoDao.update(empleado);      }
      RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
    try {
      rd.forward(req,res);}
    catch (Exception e) {
      throw new RuntimeException(e);}


  }


  }
