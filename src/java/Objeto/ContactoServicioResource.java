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
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("contactoServicio")
public class ContactoServicioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContactoServicioResource
     */
    public ContactoServicioResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.ContactoServicioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public PersonaObj enviarPersona(@Context HttpHeaders httpheaders, @QueryParam("nombre") String nombre, @QueryParam("id_agenda") int id_agenda) {
        //get    http://localhost:8080/RestFullServer/webresources/contactoServicio?nombre=juanan&id_agenda=1
        //Authorization   eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoianVhbiJ9.UVuJjz-lZThM8dOQPyx6gAfJj2IyWSprURW03fSnHeM
        
        try {
            String token = httpheaders.getHeaderString("Authorization");
            System.out.println("TOKEN +"+token);
            //decodificas, interpretarlo
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            DecodedJWT jwtv = verifier.verify(token);
            
            BBDD bd = new BBDD();
            return bd.enviarPersona(nombre, id_agenda);
        } catch (IllegalArgumentException ex) {
            return null;
        } catch (UnsupportedEncodingException ex) {
           return null;
        } catch(JWTVerificationException ex){
            return null;
        }
             
             
    }

    /**
     * PUT method for updating or creating an instance of ContactoServicioResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void insertarPersona(@Context HttpHeaders httpheaders, Contacto contacto) {
        //este objeto que se genera es la tabla contacto de la bbdd
          try {
            String token = httpheaders.getHeaderString("Authorization");
            System.out.println("TOKEN +"+token);
            //decodificas, interpretarlo
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            DecodedJWT jwtv = verifier.verify(token);
            
            BBDD bd = new BBDD();
            bd.crearContacto(contacto.getPo(), contacto.getId_agenda());
        } catch (IllegalArgumentException ex) {
              System.out.println("no funciona");
        } catch (UnsupportedEncodingException ex) {
              System.out.println("no funciona");
        }
        
    }
}
