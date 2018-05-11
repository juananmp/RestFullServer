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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("NuevaAgendaServicio")
public class NuevaAgendaServicioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NuevaAgendaServicioResource
     */
    public NuevaAgendaServicioResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.NuevaAgendaServicioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of NuevaAgendaServicioResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(@Context HttpHeaders httpheaders,NuevaAgendaObj na) throws UnsupportedEncodingException {
//POST http://localhost:8080/RestFullServer/webresources/NuevaAgendaServicio
//Authorization   eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoianVhbiJ9.UVuJjz-lZThM8dOQPyx6gAfJj2IyWSprURW03fSnHeM
//Content-Type     application/xml
//<NuevaAgendaObj> <nuevaAgendaObj>1</nuevaAgendaObj><nuevaAgendaObj>juananAgenda</nuevaAgendaObj></NuevaAgendaObj>  
        try {
            //TODO return proper representation object
            String token = httpheaders.getHeaderString("Authorization");
            //decodificas, interpretarlo
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            System.out.println("++++++++En Persona+++++++++--->"+token);
            DecodedJWT jwtv = verifier.verify(token);
            
            BBDD bd = new BBDD();
            //get(0) id_agenda y get(1) nombre agenda
            System.out.println(na.getNuevaAgendaObj().get(0)+"....-------------...."+ na.getNuevaAgendaObj().get(1));
            bd.NuevaAgenda(na.getNuevaAgendaObj().get(0), na.getNuevaAgendaObj().get(1));
        } catch (IllegalArgumentException ex) {
            System.out.println("fallo");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("fallo");
        }catch(JWTVerificationException e){
            System.out.println("fallo");
        }

    }
}
