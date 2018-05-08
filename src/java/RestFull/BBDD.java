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
import Objeto.PersonaObj;
import Objeto.UsuarioObj;
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
//    public AgendaObject cargarAgenda(String usuario) {
//        init();
//        Connection connection = null;
//        AgendaObject a = new AgendaObject();
//        try {
//            //System.out.println("ENTROOOOOO");
//            String query = null;
//            query = "select nombre, correo, telefono from agenda.contactos where id_agenda = (select id from agenda.agendas where id_usuario = (select id from agenda.usuarios where Nombre = '"+usuario+"')); ";
//            
//
//            connection= datasource.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                PersonaObj per = new PersonaObj();
//                per.setName(resultSet.getString("nombre"));
//                per.setEmail(resultSet.getString("correo"));
//                per.setTelephone(Integer.parseInt(resultSet.getString("telefono")));
//                a.getPersonaObj().add(per);
//            }
//            return a;
//        } catch (SQLException ex) {
//            System.out.println("No siguiente palabra");
//            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
//
//        }finally {
//        destroy(connection);
//    }
//        return a;
//    }

    
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