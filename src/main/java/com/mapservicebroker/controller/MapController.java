package com.mapservicebroker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mapservicebroker.service.MapService;

@Controller
/**
 * 
 * @author Santosh_Kar
 *
 */
@ComponentScan(basePackages={"com.mapservicebroker"})
public class MapController {


    @Autowired
    private MapService service;


    @RequestMapping(value = "/mapservice/{instanceId}/{key}", method = RequestMethod.PUT)
    public ResponseEntity<Object> put(@PathVariable("instanceId") String instanceId,
                                      @PathVariable("key") String key,
                                      @RequestBody String value) {
    	
    	System.out.println("-----------------In Put -------------------------------");
    	System.out.println("instanceId = "+instanceId);
    	System.out.println("key = "+key);
    	System.out.println("value = "+value);
    	System.out.println("------------------------------------------------");
        service.put(instanceId, key, value);
        return new ResponseEntity<>(service.findAll(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/mapservice/{instanceId}/{key}", method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable("instanceId") String instanceId,
                                      @PathVariable("key") String key) {
    	System.out.println("------------------------------------------------");
    	System.out.println(service.findAll());
        Object result = service.get(instanceId, key);
        System.out.println("Object found : "+result);
        System.out.println("------------------------------------------------");
        
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("{}", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/mapservice/{instanceId}/{key}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("instanceId") String instanceId,
                                         @PathVariable("key") String key) {
    	
    	Object deletedValue = null;
    	
    	System.out.println("-------------Before Delete -----------------------------------");
    	System.out.println(service.findAll());
    	System.out.println("------------------------------------------------");
        Object result = service.get(instanceId, key);
        if (result != null) {
        	deletedValue = service.get(instanceId, key);
            service.delete(instanceId, key);
            return new ResponseEntity<>("{}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(deletedValue, HttpStatus.GONE);
        }
    }

}
