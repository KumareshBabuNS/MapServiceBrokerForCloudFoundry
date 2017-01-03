package com.mapservicebroker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapservicebroker.model.Service;

/**
 * 
 * @author Santosh_Kar
 *
 */
public interface ServiceRepository extends JpaRepository<Service, String> {
}
