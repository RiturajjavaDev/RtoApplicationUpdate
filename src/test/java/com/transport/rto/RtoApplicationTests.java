package com.transport.rto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureMockMvc

class RtoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test_getVehicleDetails_1() throws Exception {
		MockHttpServletRequestBuilder builders=MockMvcRequestBuilders.get("/findVehicleDetails/KR 67 VES").contentType(MediaType.APPLICATION_JSON);		
		MvcResult result = mockMvc.perform(builders).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String content = response.getContentAsString();
		System.out.println(content+"=======================>");
		if(content.equals("")) {
			fail();
		}
		assertNotNull(content);
	}
	
	@Test
	public void test_getVehicleDetails_2() throws Exception {
		MockHttpServletRequestBuilder builders=MockMvcRequestBuilders.get("/findVehicleDetails/KR 67 VES").contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builders).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		System.out.println(status+"...."+HttpStatus.OK.value());
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	

}
