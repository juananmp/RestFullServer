/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import RestFull.BBDD;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("UpdateUsuario")
public class UpdateUsuarioResource {

    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpdateUsuarioResource
     */
    public UpdateUsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.UpdateUsuarioResource
     * @return an instance of java.lang.String
     */
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
   //@PathParam("/{nombre}/{correo}/{telefono}/{id}")
    public void putXml(@Context HttpHeaders httpheaders, UpdateObjeto uo) {
       
        try {
            String token = httpheaders.getHeaderString("Authorization");
            System.out.println("TOKEN +"+token);
            //decodificas, interpretarlo
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            DecodedJWT jwtv = verifier.verify(token);
            
            BBDD bd = new BBDD();
            bd.actualizarUsuario(uo);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UpdateUsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UpdateUsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
