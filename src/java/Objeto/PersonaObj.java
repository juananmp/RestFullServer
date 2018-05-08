/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

/**
 *
 * @author janto
 */
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
@XmlRootElement(name = "Persona")
public class PersonaObj implements Serializable {

    //Agenda agenda = new Agenda();
    @XmlElement(name = "name")
    public String name;
    @XmlElement(name = "email")
    public String email;
    @XmlElement(name = "telephone")
    public int telephone;

    public PersonaObj() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public PersonaObj(String name, String email, int telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public String toString() {
        String a = "Nombre: " + name + " Correo: " + email + " Telefono: " + telephone + ";";
        return a;
    }

}
