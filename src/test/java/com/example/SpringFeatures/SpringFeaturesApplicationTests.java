package com.example.SpringFeatures;

import com.example.SpringFeatures.controllers.ProductController;
import com.example.SpringFeatures.dtos.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class SpringFeaturesApplicationTests {

	 @Autowired
	ProductController productController;
	@Test
	void contextLoads() {
	}

	@Test
	public void getRemoteEmployeeList(){
		System.out.println(productController.getAllEmployeesThroughRestClient().toString());
	}

	@Test
	public void getRemoteEmployeeById(){
		System.out.println(productController.getEmployeebyIdThroughRestClient(1L).toString());
	}

	@Test
	public void saveRemoteEmployeeById(){
		EmployeeDTO employeeDTO = new EmployeeDTO(
				1L,
				"Suprith",
				"suprith@gmail.com",
				28,
				LocalDate.of(2020, 6, 15),
				true
		);
		System.out.println(productController.createEmployeeThroughRestClient(employeeDTO).toString());
	}

}
