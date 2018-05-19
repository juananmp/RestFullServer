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
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("VerAgenda")
public class VerAgendaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VerAgendaResource
     */
    public VerAgendaResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.VerAgendaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
   @Path("/{id_agenda}")
    public AgendaObject getXml(@PathParam("id_agenda") String id) {
        //devuelve todas las personas de la agenda 1 = http://localhost:8080/RestFullServer/webresources/VerAgenda?id_agenda=1
        BBDD bd = new BBDD();
       return bd.EnviarAgenda(id);
    }

    /**
     * PUT method for updating or creating an instance of VerAgendaResource
     * @param content representation for the resource
     */
  
}
