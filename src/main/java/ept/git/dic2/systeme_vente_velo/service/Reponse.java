package ept.git.dic2.systeme_vente_velo.service;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Reponse")
public class Reponse {
    private  String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Reponse() {

    }
    public Reponse(String msg) {
        this.msg = msg;
    }
}
