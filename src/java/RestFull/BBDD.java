/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestFull;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import Objeto.AgendaObject;
import Objeto.NuevaAgendaObj;
import Objeto.PersonaObj;
import Objeto.UsuarioObj;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
/**
 *
 * @author janto
 */
public class BBDD extends HttpServlet {


    DataSource datasource;
   @Override
   public void init() {
        try {
            InitialContext initialContext = new InitialContext();

            datasource = (DataSource) initialContext.lookup("jdbc/restfull");
        } catch (NamingException ex) {
            System.out.println(ex);
        }

    }    

    public void crearUsuario(String user, String password) {
        init();
        String query = null;
           query = "INSERT INTO usuario(user, password) VALUES ('" + user + "', '" + password + "')";
          Statement statement = null; 
        Connection connection = null;
        try {
            
           System.out.println("Hola");
           connection = datasource.getConnection();
            statement = connection.createStatement();
            statement.execute(query);
            System.out.println("usuario despues update query" + user);
            statement.close();
            connection.close();
            System.out.println("usuario despues close" + user);

        } catch (SQLException ex) {
           
            System.out.println("Error al crear usuario");
//        }finally {
//        destroy(connection);
    }
        
        

    }
    public boolean InicioSesion(UsuarioObj u){
         init();
        Connection connection = null;
    Statement statement = null; 
       ResultSet resultSet;
        try {
            //System.out.println("ENTROOOOOO");
            String query = null;
            query = "select user, password from usuario where user ='"+u.getUser()+"' and password = '"+u.getPassword()+"'";
            

            connection= datasource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                return true;
                }

        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public PersonaObj enviarPersona(String nombre, int id_agenda){
         init();
        Connection connection = null;
    Statement statement = null; 
       ResultSet resultSet;
        try {
            //System.out.println("ENTROOOOOO");
            String query = null;
            query = "select * from contactos where nombre ='"+nombre+"' and id_agenda = '"+id_agenda+"'";
            

            connection= datasource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            PersonaObj po = new PersonaObj();
            
            while (resultSet.next()) {
               po.setName(resultSet.getString("nombre"));
               po.setEmail(resultSet.getString("correo"));
               po.setTelephone(Integer.parseInt(resultSet.getString("telefono")));
                }

            return po;
        } catch (SQLException ex) {
            return null;
        }
       
    }
    
    public void crearContacto(PersonaObj po, int id_agenda){
         init();
        Connection connection = null;
        Statement statement = null; 
       ResultSet resultSet;
        try {
            String query = null;
            query = "insert into contactos values(null,'" + po.getName() + "', '"+po.getEmail()+"','"+po.getTelephone()+"',"+id_agenda+")";

            connection = datasource.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al crear usuario");
        }
    }

    public void NuevaAgenda(String id_user, String nombre) {
        init();
        Connection connection = null;
         Statement statement = null; 
       ResultSet resultSet;
        try {
            String query = null;
            query = "insert into agenda(nombre, id_usuario) values('" + nombre + "', '" + id_user + "')";

            connection = datasource.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al crear agenda");
        }
    }
    
    public Map<String, Integer> listarAgenda(String usuario){
        init();
        Connection connection = null;
    Statement statement = null; 
       ResultSet resultSet;
        try {
            System.out.println("ENTROOOOOO");
            String query = null;
             query = "select nombre, id_usuario from agenda where id_usuario= (select id from usuario where user = '"+usuario+"');";      
             Map<String, Integer> lista = new HashMap<String, Integer>();
             
            connection= datasource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Hola");
                lista.put(resultSet.getString("nombre"), resultSet.getInt("id_usuario"));
               
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("No siguiente palabra");
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}