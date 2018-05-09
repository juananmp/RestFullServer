/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import java.io.Serializable;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author janto
 */
 @XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Lista")
public class MostrarAgenda implements Serializable {
  


    @XmlElement(name="Agenda")
    Map<String, Integer> agenda;
//    String token;
public MostrarAgenda(){
    
}

    public Map<String, Integer> getAgenda() {
        return agenda;
    }

    public void setAgenda(Map<String, Integer> agenda) {
        this.agenda = agenda;
    }

 }