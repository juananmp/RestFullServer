/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Lista")
public class ListaContacto implements Serializable{
    
   @XmlElement
   ArrayList<PersonaObj> persona = new ArrayList<PersonaObj>();
   @XmlElement
   ArrayList<String> idContacto = new ArrayList<String>();

    public ListaContacto() {
    }

    public ArrayList<PersonaObj> getPersona() {
        return persona;
    }

    public void setPersona(ArrayList<PersonaObj> persona) {
        this.persona = persona;
    }

    

    public ArrayList<String> getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(ArrayList<String> idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public String toString() {
        return "ListaContacto{" + "persona=" + persona.toString() + ", idContacto=" + idContacto.toString() + '}';
    }

}

