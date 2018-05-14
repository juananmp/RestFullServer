/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author janto
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UpdateObjeto")
public class UpdateObjeto {
    
    
      @XmlElement(name = "name")
    public String name;
    @XmlElement(name = "email")
    public String email;
    @XmlElement(name = "telephone")
    public int telephone;
     @XmlElement(name = "id")
    public String id;

    public UpdateObjeto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
