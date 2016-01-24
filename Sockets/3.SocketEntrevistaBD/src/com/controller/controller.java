package com.controller;

import com.baseDatos.Respuestas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class controller {
    public String controll(String mensage){
        String msg = null;
        System.out.println(mensage+"controller");
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("socketPU");
            EntityManager em = emf.createEntityManager();
            Query q= em.createNamedQuery("respuesta");
            q.setParameter(1,mensage);
            java.util.List lista=q.getResultList();
            Respuestas obj;
            for(int i=0; i <lista.size();i++){
                obj = (Respuestas)lista.get(i);
                msg = obj.getMensage2();
                System.out.println(msg);
            }
        }catch(Exception e){
            System.out.println("Error: controller"+e.getMessage());
        } 
        return msg;
    }
}
