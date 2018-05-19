/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Objeto.AgendaObject;
import RestFull.BBDD;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import javax.servlet.ServletContext;
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
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * REST Web Service
 *
 * @author janto
 */
@Path("ValidarAgendaSinAutenticar")
public class ValidarAgendaSinAutenticarResource {

    @Context
    private UriInfo context;
      @Context
    private ServletContext servletContext;

    /**
     * Creates a new instance of ValidarAgendaSinAutenticarResource
     */
    public ValidarAgendaSinAutenticarResource() {
    }

    /**
     * Retrieves representation of an instance of Objeto.ValidarAgendaSinAutenticarResource
     * @return an instance of java.lang.String
     */
    @GET
    
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String ValAgenda(@QueryParam("agenda") String agenda) {
    try {
        //http://localhost:8080/RestFullServer/webresources/ValidarAgendaSinAutenticar?agenda=<Agenda><Persona><name>juan</name><email>j@g.com</email><telephone>231</telephone></Persona> </Agenda>
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            URL resourceXSD = null;
            URL resourceXML = null;
            JAXBContext jAXBcontext = JAXBContext.newInstance(AgendaObject.class);
            Marshaller marshaller = jAXBcontext.createMarshaller();

            resourceXSD = servletContext.getResource("/ValidarAgenda.xsd");
//            System.out.println("-------->"+ resourceXSD.getFile());
            Schema schema = sf.newSchema(resourceXSD);
            Validator val = schema.newValidator();
            marshaller.setSchema(schema);
            System.out.println("----------------------");
          
             JAXBContext jaxbContext = JAXBContext.newInstance(AgendaObject.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
             StringReader reader = new StringReader(agenda);
            AgendaObject agendaobj = (AgendaObject) unmarshaller.unmarshal(reader);
        
            
           
            File fich = new File("Agenda.xml");
            marshaller.marshal(agendaobj, fich);
            val.validate(new StreamSource(fich));
            System.out.println("----------------------");
            
            return "Valido";

        } catch (IOException ex) {
           // Logger.getLogger(ValidarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            //Logger.getLogger(ValidarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            //Logger.getLogger(ValidarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No valido";
    }
}
