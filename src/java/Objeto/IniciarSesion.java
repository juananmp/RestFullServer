/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import RestFull.BBDD;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("iniciarSesion")
public class IniciarSesion {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of IniciarSesion
     */
    public IniciarSesion() {
    }

    /**
     * Retrieves representation of an instance of Objeto.IniciarSesion
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
       return "<hola>holaaa</hola>"; 
    }

    /**
     * PUT method for updating or creating an instance of IniciarSesion
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public String putXml(UsuarioObj u) throws IllegalArgumentException {
        try {
            BBDD bd = new BBDD();
            Algorithm algorithmHS = Algorithm.HMAC256("secret");
            if (bd.InicioSesion(u)) {
//Lo que metemos      .witClaim()    //Firma
                String token = JWT.create().withClaim("user", u.getUser()).sign(algorithmHS);
                System.out.println(token);
                return token;
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
