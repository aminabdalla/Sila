package at.app.sila.mainactivity;


import java.util.Map;

import at.app.sila.service.people.PeopleService;
import at.app.sila.service.ServiceProvider;

/**
 * Created by AAbdalla on 17.01.2016.
 */
public class ServiceRegistry {

    private Map<String, ServiceProvider<PeopleService>> serviceRegistry;

    public void registerService(String servicename,ServiceProvider<PeopleService> service){
        serviceRegistry.put(servicename,service);
    }

    public static Map<String,ServiceProvider<PeopleService>> getService(String service){
    return null;
    }

}
