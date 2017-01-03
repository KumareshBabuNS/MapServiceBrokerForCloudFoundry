package com.mapservicebroker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mapservicebroker.controller.MapController;

@RunWith(MockitoJUnitRunner.class)
public class MapServiceBrokerApplicationTests {

	private MockMvc mockMvc;
	
	@InjectMocks
	private MapController controller;
	
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setMessageConverters(new MappingJackson2HttpMessageConverter())
				.build();
		System.out.println(mockMvc);
		
	}
	
	@Test
	public void contextLoads() {
		System.out.println(controller);
	}

}
