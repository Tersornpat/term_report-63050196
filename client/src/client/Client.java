/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Tersornpat
 */
public class Client {

public class SoapClient {


    public static void main(String[] args) {
        data str = finByAge(83);
        //System.out.println(str);
    }

    private static data findByAge(int age) {
        services.CovidWebService_Service service = new services.CovidWebService_Service();
        services.CovidWebService port = service.getCovidWebServicePort();
        return port.findByAge(age);
    }
}
}
