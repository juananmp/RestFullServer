/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author janto
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Objeto.BorrarContactoResource.class);
        resources.add(Objeto.ContactoServicioResource.class);
        resources.add(Objeto.CrearUsuario.class);
        resources.add(Objeto.EnviarAgendaResource.class);
        resources.add(Objeto.IniciarSesion.class);
        resources.add(Objeto.NuevaAgendaServicioResource.class);
        resources.add(Objeto.ObtenerIdUsuarioResource.class);
        resources.add(Objeto.SeleccionarAgendaResource.class);
        resources.add(Objeto.UpdateUsuarioResource.class);
        resources.add(Objeto.ValidarAgendaResource.class);
        resources.add(Objeto.ValidarPersonaResource.class);
        resources.add(Objeto.VerAgendaResource.class);
       
    }
    
}
