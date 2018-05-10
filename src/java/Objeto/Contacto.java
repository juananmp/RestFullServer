/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author janto
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Contacto")
public class Contacto implements Serializable{
    
    @XmlElement
    PersonaObj po = new PersonaObj();
    @XmlElement
    int id_agenda;

    public Contacto() {
    }

    public PersonaObj getPo() {
        return po;
    }

    public void setPo(PersonaObj po) {
        this.po = po;
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }
    
    
    
    
}
