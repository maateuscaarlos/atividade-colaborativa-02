package br.edu.ifpb.dac.rest;


import javax.ws.rs.core.Application;
import java.util.Set;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.edu.ifpb.dac.rest.ResourcesProduto.class);
    }
}
