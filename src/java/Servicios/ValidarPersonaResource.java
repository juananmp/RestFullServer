/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import Objeto.AgendaObject;
import Objeto.PersonaObj;
import RestFull.BBDD;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.File;
import java.io.IOException;
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
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * REST Web Service
 *
 * @author rafael
 */
@Path("ValidarPersona")
public class ValidarPersonaResource {

    @Context
    private UriInfo context;
    @Context
    private ServletContext servletContext;
    /**
     * Creates a new instance of ValidarPersonaResource
     */
    public ValidarPersonaResource() {
    }

    /**
     * Retrieves representation of an instance of REST.ValidarPersonaResource
     * @return an instance of java.lang.String
     */
   
    /**
     * PUT method for updating or creating an instance of ValidarPersonaResource
     * @param content representation for the resource
     */
    @GET
   // @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{nombre}/{correo}/{telefono}")
    public String ValPersona(@Context HttpHeaders httpheaders, @PathParam("nombre") String nombre,@PathParam("correo") String correo,@PathParam("telefono") int telefono) {
    try {
            //GET http://localhost:8080/RestFullServer/webresources/ValidarPersona?nombre=rafa&correo=j@g.com&telefono=21
         System.out.println(" ENTRO?????? Servidor: "+nombre + " " + correo + " " + telefono);
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            String token = httpheaders.getHeaderString("Authorization");
            System.out.println("TOKEN +"+token);
            //decodificas, interpretarlo
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
             DecodedJWT jwtv = verifier.verify(token);
             
             System.out.println(jwtv.getSubject());
            DecodedJWT jwt = JWT.decode(token);
            URL resourceXSD = null;
            URL resourceXML = null;
            JAXBContext jAXBcontext = JAXBContext.newInstance(AgendaObject.class);
            Marshaller marshaller = jAXBcontext.createMarshaller();
//            OutputStream outputStream = new FileOutputStream(ubicacionAgenda.getPath());
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders",
//                "\n<!DOCTYPE Agenda SYSTEM  \"Agenda.dtd\">");
//        //File XMLfile = new File("Agenda.xml");
//        marshaller.marshal(agenda, outputStream);
            resourceXSD = servletContext.getResource("/ValidarAgenda.xsd");
            System.out.println("-------->"+resourceXSD.getFile());
            Schema schema = sf.newSchema(resourceXSD);
            Validator val = schema.newValidator();
            marshaller.setSchema(schema);
            System.out.println("----------------------");
            
            BBDD bd = new BBDD();
            PersonaObj per = new PersonaObj();
            per.setName(nombre);
            per.setEmail(correo);
            per.setTelephone(telefono);
            AgendaObject agenda = new AgendaObject();
            agenda.getPersonaObj().add(per);
            File fich = new File("Agenda.xml");
            marshaller.marshal(agenda, fich);
            val.validate(new StreamSource(fich));
            System.out.println("----------------------");
            
            return "Valido";

        } catch (IOException ex) {
           // Logger.getLogger(ValidarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
           return "no valido";
        } catch (JAXBException ex) {
            //Logger.getLogger(ValidarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
        return "no valido";
        } catch (SAXException ex) {
            //Logger.getLogger(ValidarAgendaResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No valido";
    }
}
