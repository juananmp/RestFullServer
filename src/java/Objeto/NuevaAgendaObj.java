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
@XmlRootElement(name="NuevaAgendaObj")
public class NuevaAgendaObj implements Serializable{
    @XmlElement
    ArrayList <String> nuevaAgendaObj= new ArrayList <String> ();

    public NuevaAgendaObj() {
    }

    public ArrayList<String> getNuevaAgendaObj() {
        return nuevaAgendaObj;
    }

    public void setNuevaAgendaObj(ArrayList<String> nuevaAgendaObj) {
        this.nuevaAgendaObj = nuevaAgendaObj;
    }

    
}

