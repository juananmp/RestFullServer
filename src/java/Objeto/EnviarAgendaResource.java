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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("EnviarAgenda")
public class EnviarAgendaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EnviarAgendaResource
     */
    public EnviarAgendaResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.EnviarAgendaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
   @Path("{idAgenda}")
    public AgendaObject getXml(@Context HttpHeaders httpheaders,@PathParam("idAgenda")String id) throws UnsupportedEncodingException {
        try {
            //TODO return proper representation object
            String token = httpheaders.getHeaderString("Authorization");
            //decodificas, interpretarlo
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            System.out.println("++++++++En Persona+++++++++--->"+token);
            DecodedJWT jwtv = verifier.verify(token);
            BBDD con = new BBDD();
            return con.EnviarAgenda(id);
            
        } catch (IllegalArgumentException ex) {
            //Logger.getLogger(MostrarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no valido");
        } catch (UnsupportedEncodingException ex) {
           // Logger.getLogger(MostrarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no valido");
        }
        return null;
        
       
    }

  

}
