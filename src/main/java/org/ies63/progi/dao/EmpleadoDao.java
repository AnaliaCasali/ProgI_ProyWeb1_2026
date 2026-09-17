package org.ies63.progi.dao;

import java.util.ArrayList;
import java.util.List;
import org.ies63.progi.entities.Empleado;
import org.ies63.progi.interfaces.AdministradorConexiones;
import org.ies63.progi.interfaces.Dao;

import java.sql.*;

public class EmpleadoDao implements AdministradorConexiones, Dao<Empleado, Integer> {
    private final String SQL_GETALL="SELECT * FROM empleados";
    private final String SQL_GETBY_ID="SELECT * FROM empleados WHERE idEmpleado=?";
    private  final String SQL_DELETE_BY_ID=
            "DELETE FROM empleados WHERE idEmpleado=?";

    private final String SQL_INSERT=
            "INSERT INTO empleados (nombre, apellido, salarioBase)" +
                           " VALUES (?,      ?,          ?)";

    private final String SQL_UPDATE=
            "UPDATE empleados SET nombre=?, apellido=?, salarioBase=? WHERE idEmpleado=?";

    @Override
    public List<Empleado> getAll() {
        List<Empleado> lista=new ArrayList<>();
        try {
            Connection conn = this.obtenerConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_GETALL);
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setSalarioBase(rs.getDouble("salarioBase"));
                lista.add(empleado);
            }
            // cierro
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Empleado getById(Integer id) {
        try {
            //1. conectar
            Connection conn= this.obtenerConexion();
           //  2. creo preparedStatement con el string de la consulta
            PreparedStatement pst=conn.prepareStatement(SQL_GETBY_ID) ;
            //3. reemplazar ? con el valor
            pst.setInt(1, id);

            //4. ejecutar:  se guarda una fila de datos obtenida en el resulset
            ResultSet rs=pst.executeQuery();
            // si encontro el empleado con ese id resulset tiene una fila
            Empleado empleado = new Empleado();
            if(rs.next()){
                                          // tipo             //nombre de la columna de bd
                empleado.setSalarioBase(rs.getDouble("salarioBase"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setId(rs.getInt( "idEmpleado"));
            }
            //  cierro
            rs.close();
            pst.close();
            conn.close();
            return empleado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Empleado objeto) {
        try {
            // 1. creo conexion
            Connection conn = this.obtenerConexion();
            // 2. creo preparedstatement                            // para la clave generada
            PreparedStatement pst=conn.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
            // 3. reemplazo los ???
            pst.setString(1, objeto.getNombre());
            pst.setString(2, objeto.getApellido());
            pst.setDouble(3, objeto.getSalarioBase());

            //4. ejecuto
            pst.execute();

            //4.a guardo las claves en un resulset (para las clases)
            ResultSet rs=pst.getGeneratedKeys();
            if(rs.next()){
                objeto.setId(rs.getInt(1)); // le asigno al objeto el id que le puso la bd
            }

            //5. cierro
            pst.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Empleado objeto) {

        try {
            Connection conn = this.obtenerConexion();
            PreparedStatement pst=conn.prepareStatement(SQL_UPDATE);
            // reemplaza ?

            System.out.println("EL ID A MODIFICAR ES " + objeto.getId());
            pst.setString(1, objeto.getNombre());
            pst.setString(2, objeto.getApellido());
            pst.setDouble(3, objeto.getSalarioBase());
            pst.setInt(4, objeto.getId());
             // ejecuto
            pst.executeUpdate();
            // cierro
            pst.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean delete(Integer id) {
        boolean elimino=false;
        if (!this.exists(id))
        { return elimino; }
        else {
            try {
                // 1. conecto
                Connection conn = this.obtenerConexion();
                // 2. creo consulta
                PreparedStatement pst=conn.prepareStatement(SQL_DELETE_BY_ID);
                // 3. completo consulta con id reemplazando el ?
                pst.setInt(1, id);
                // 4. ejecuto
                pst.execute();
                // 5. cierro
                pst.close();
                conn.close();
                elimino=true;

            } catch (SQLException e) {
                elimino=false;
                throw new RuntimeException(e);
            }
        }

        return elimino;
    }

    @Override
    public boolean exists(Integer id) {
        boolean existe=false;
        try {
            //1. conectar
            Connection conn= this.obtenerConexion();
            //  2. creo preparedStatement con el string de la consulta
            PreparedStatement pst=conn.prepareStatement(SQL_GETBY_ID) ;
            //3. reemplazar ? con el valor
            pst.setInt(1, id);
            //4. ejecutar:  se guarda una fila de datos obtenida en el resulset
            ResultSet rs=pst.executeQuery();
            // si encontro el empleado con ese id resulset tiene una fila

            if(rs.next()){
                existe=true;
            }
            //  cierro
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return existe;

    }
}
