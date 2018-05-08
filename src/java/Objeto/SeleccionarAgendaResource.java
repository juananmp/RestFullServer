/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@Context HttpHeaders httpheaders) {
        //GET   http://localhost:8080/RestFullServer/webresources/seleccionarAgenda
        //Authorization   eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoianVhbiJ9.UVuJjz-lZThM8dOQPyx6gAfJj2IyWSprURW03fSnHeM
        //cojo token de la cabecera authorizacion
       String token = httpheaders.getHeaderString("Authorization");
       //decodificas, interpretarlo
        DecodedJWT jwt = JWT.decode(token);
        //obtengo el claim 
        Map<String, Claim> claim = jwt.getClaims();
        String user = claim.get("user").asString();
        System.out.println(user);
        return null;
    }

    
}
