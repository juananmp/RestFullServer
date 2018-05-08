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
 * @author janto
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Agenda")
public class AgendaObject implements Serializable {

        @XmlElement(name="Persona")
        ArrayList<PersonaObj> persona;

    public AgendaObject(){
        persona = new ArrayList<>();
    }
    public ArrayList<PersonaObj> getPersonaObj() {
        return persona;
    }

    public void setPersonaObj(PersonaObj persona) {
        this.persona.add(persona);
    }

    @Override
    public String toString() {
        return "Agenda{" + "persona=" + persona.toString() + '}';
    }
    
}
