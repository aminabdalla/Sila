package at.app.sila.mainactivity;


import java.util.Map;

import at.app.sila.people.PeopleService;
import at.app.sila.people.ServiceFactory;

/**
 * Created by AAbdalla on 17.01.2016.
 */
public class ServiceRegistry {

    private Map<String, ServiceFactory<PeopleService>> serviceRegistry;

    public void registerService(String servicename,ServiceFactory<PeopleService> service){
        serviceRegistry.put(servicename,service);
    }

    public static Map<String,ServiceFactory<PeopleService>> getService(String service){
    return null;
    }

}
