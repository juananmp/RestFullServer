/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import RestFull.BBDD;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("ObtenerIdUsuario")
public class ObtenerIdUsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ObtenerIdUsuarioResource
     */
    public ObtenerIdUsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.ObtenerIdUsuarioResource
     * @return an instance of java.lang.String
     */
    
    /**
     * PUT method for updating or creating an instance of ObtenerIdUsuarioResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public String postXml(UsuarioObj us) {
        //POST   http://localhost:8080/RestFullServer/webresources/ObtenerIdUsuario
        //Authorization eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoianVhbiJ9.UVuJjz-lZThM8dOQPyx6gAfJj2IyWSprURW03fSnHeM
        //Content-Type  application/xml
        //<Usuario> <user>juan</user> <password>juan</password></Usuario>
        BBDD bd = new BBDD();
        System.out.println(us.getUser()+ us.getPassword());
        return bd.IdUsuario(us.getUser(),us.getPassword());    
    
    }
}
