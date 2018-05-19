/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Objeto.MostrarAgenda;
import RestFull.BBDD;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.Map;
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
@Path("seleccionarAgenda")
public class SeleccionarAgendaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SeleccionarAgendaResource
     */
    public SeleccionarAgendaResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.SeleccionarAgendaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{user}")
    @Produces(MediaType.APPLICATION_XML)
    public MostrarAgenda getXml(@Context HttpHeaders httpheaders, 
            @PathParam("user")String user) {
        try {
            //GET   http://localhost:8080/RestFullServer/webresources/seleccionarAgenda
            //Authorization   eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoianVhbiJ9.UVuJjz-lZThM8dOQPyx6gAfJj2IyWSprURW03fSnHeM
            //cojo token de la cabecera authorizacion
            //https://jwt.io
            String token = httpheaders.getHeaderString("Authorization");
            System.out.println("TOKEN +"+token);
            //decodificas, interpretarlo
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
             DecodedJWT jwtv = verifier.verify(token);
             
             System.out.println(jwtv.getSubject());
            DecodedJWT jwt = JWT.decode(token);
            //obtengo el claim
            Map<String, Claim> claim = jwt.getClaims();
            user = claim.get("user").asString();
            System.out.println(user);
            
           
            BBDD bd = new BBDD();
            // Ahora cuando hagamos el get ya deberia si le pasaos el token mostrar las agendas asociadas a ese token
            MostrarAgenda ma = new MostrarAgenda();
            ma.setAgenda(bd.listarAgenda(user));
           return ma;
        } catch (IllegalArgumentException ex) {
           return null;
        } catch (UnsupportedEncodingException ex) {
            return null;
        }catch(JWTVerificationException ex){
            return null;
            
        }
        
    }

    
}
