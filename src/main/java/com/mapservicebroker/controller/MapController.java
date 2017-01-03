package com.mapservicebroker.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class MapController {


    @Autowired
    MapService service;


    @RequestMapping(value = "/mapservice/{instanceId}/{key}", method = RequestMethod.PUT)
    public ResponseEntity<String> put(@PathVariable("instanceId") String instanceId,
                                      @PathVariable("key") String key,
                                      @RequestBody String value) {
        service.put(instanceId, key, value);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/mapservice/{instanceId}/{key}", method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable("instanceId") String instanceId,
                                      @PathVariable("key") String key) {
    	
    	System.out.println("------------------------------------------------");
    	System.out.println(service.findAll());
    	System.out.println("------------------------------------------------");
    	
        Object result = service.get(instanceId, key);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("{}", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/mapservice/{instanceId}/{key}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("instanceId") String instanceId,
                                         @PathVariable("key") String key) {
        Object result = service.get(instanceId, key);
        if (result != null) {
            service.delete(instanceId, key);
            return new ResponseEntity<>("{}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{}", HttpStatus.GONE);
        }
    }

}
