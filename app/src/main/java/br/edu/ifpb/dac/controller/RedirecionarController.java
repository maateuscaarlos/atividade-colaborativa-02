package br.edu.ifpb.dac.controller;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class RedirecionarController implements Serializable {


    public String telaVendas() {
        return "telaVendas.xhtml";
    }



}
