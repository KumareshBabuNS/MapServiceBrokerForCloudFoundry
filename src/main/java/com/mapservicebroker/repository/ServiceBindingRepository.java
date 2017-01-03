package com.mapservicebroker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapservicebroker.model.ServiceBinding;
/**
 * 
 * @author Santosh_Kar
 *
 */
public interface ServiceBindingRepository extends JpaRepository<ServiceBinding, String> {
}
