package com.mapservicebroker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapservicebroker.model.ServiceInstance;

/**
 * 
 * @author Santosh_Kar
 *
 */
public interface ServiceInstanceRepository extends JpaRepository<ServiceInstance, String> {
}
