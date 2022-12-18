/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam; 
/**
 *
 * @author Tersornpat
 */
@WebService(serviceName = "webservice")
public class webservice {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("webPU");
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findByAge")
    public data findByAge(@WebParam(name = "age") int age) {
        EntityManager em = emf.createEntityManager();
        data cov = em.find(data.class, age);
        return cov;
    }
    
}
