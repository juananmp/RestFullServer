/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

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
        resources.add(Servicios.BorrarContactoResource.class);
        resources.add(Servicios.ContactoServicioResource.class);
        resources.add(Servicios.CrearUsuario.class);
        resources.add(Servicios.EnviarAgendaResource.class);
        resources.add(Servicios.IniciarSesion.class);
        resources.add(Servicios.NuevaAgendaServicioResource.class);
        resources.add(Servicios.ObtenerIdUsuarioResource.class);
        resources.add(Servicios.SeleccionarAgendaResource.class);
        resources.add(Servicios.UpdateUsuarioResource.class);
        resources.add(Servicios.ValidarAgendaResource.class);
        resources.add(Servicios.ValidarAgendaSinAutenticarResource.class);
        resources.add(Servicios.ValidarPersonaResource.class);
        resources.add(Servicios.ValidarPersonaSinAutenticarResource.class);
        resources.add(Servicios.VerAgendaResource.class);
       
    }
    
}
