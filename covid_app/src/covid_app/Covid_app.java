/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid_app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonStructure;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author Tersornpat
 */
public class Covid_app {

    public static void main(String args[]) throws FileNotFoundException{
        javax.json.JsonReader reader = Json.createReader(new FileReader("C:\\Users\\Tersornpat\\Desktop\\Compo\\Covid\\data.json"));
        JsonStructure jsonst = reader.read();
        
        System.out.println(jsonst);
        String str = jsonst.toString();

        JSONArray arr = new JSONArray(str);
        for(int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            int year = obj.getInt("year");
            int weeknum = obj.getInt("weeknum");
            String province = obj.getString("province");
            int age = obj.getInt("age");
            String age_range = obj.getString("age_range");
            String occupation = obj.getString("occupation");
            int type = obj.getInt("type");
            String death_cluster = obj.getString("death_cluster");
            String update_date = obj.getString("update_date");
            
            Data cov = new Data(year, weeknum, province, age, age_range, occupation,
                                type, death_cluster, update_date);
          persist(cov);
        }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("covid_appPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
}
