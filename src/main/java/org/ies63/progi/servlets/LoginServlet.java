package org.ies63.progi.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ies63.progi.dao.UsuarioDao;
import org.ies63.progi.entities.Usuario;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {

  UsuarioDao usuarioDao=null;

  @Override
  public void init() throws ServletException {
    usuarioDao=new UsuarioDao();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) {

    String accion= req.getParameter("accion");
    if(accion==null) accion="ingresar";

    RequestDispatcher rd= null;
    switch (accion)
    {  case "ingresar":
            rd= req.getRequestDispatcher("login.jsp");
          try {
              rd.forward(req,res);
          } catch (Exception e) {
            System.out.println( e.getMessage() + " " + e.getCause());
          }
      break;
      case "salir":
        if(req.getSession().getId()!=null)
        {
          req.getSession().invalidate();
          req.setAttribute("mensaje", "La sesion se cerró");
        }
        rd=req.getRequestDispatcher("index.jsp");

        try {
          rd.forward(req,res);
        } catch (Exception e) {
          System.out.println("Sesión Cerrada");;
        }


    }


  }
  public void doPost(HttpServletRequest req, HttpServletResponse res){

      String strUsuario="";
      String strClave="";
      // recibo los datos del formulario

    if(req.getParameter("txtNombre")!=null)
      strUsuario=req.getParameter("txtNombre");
    if (req.getParameter("txtClave")!=null)
        strClave=req.getParameter("txtClave");

    // usar  dao para  chequear en BD si usuario y clave existen y son correctas
    RequestDispatcher rd;
    Usuario usuario =   usuarioDao.getByNombreYClave(strUsuario,strClave);
    if (usuario !=null)
    {
        HttpSession sesion= req.getSession();
        sesion.setAttribute("usuario", usuario);
        sesion.setAttribute("mensaje", "Logueo Exitoso");
        sesion.setAttribute("nombre", usuario.getNombre());
        sesion.setMaxInactiveInterval(5*60);
        rd= req.getRequestDispatcher("index.jsp");
    }
    else {
        rd= req.getRequestDispatcher("login.jsp");
    }
    try {
      rd.forward(req,res); } catch (Exception e) {
      System.out.println("Servlet Login No pudo redirigir");}


  }

  }// cierra clase
