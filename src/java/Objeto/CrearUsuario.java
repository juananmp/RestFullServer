/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import RestFull.BBDD;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("registro")
public class CrearUsuario {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CrearUsuario
     */
    public CrearUsuario() {
    }

//    /**
//     * Retrieves representation of an instance of Objeto.CrearUsuario
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public String getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }

    /**
     * PUT method for updating or creating an instance of CrearUsuario
     * @param content representation for the resource
     */
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(UsuarioObj u) {
      BBDD bd = new BBDD();
        System.out.println("kldfjwjopej4pojgp356");
        System.out.println("antes metodo put" + u.user);
      bd.crearUsuario(u.getUser(), u.getPassword());
      System.out.println("despues metodo put" + u.user);
    }
}
