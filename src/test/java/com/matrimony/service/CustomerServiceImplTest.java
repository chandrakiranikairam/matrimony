package com.matrimony.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.matrimony.entity.Customer;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(CustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceImplTest {

	@Autowired
	private CustomerService custService;
	@Autowired
	private EntityManager eManager;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setupbeforeclass");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	System.out.println("teardownafterclass");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
	System.out.println("teardown");
	}
	@Test
	void testFindAll() {
		List<Customer> cust= custService.findAllCustomers();
		assertTrue(!cust.isEmpty());
	}
	@Test
	void testAdd() {
		Customer cust= new Customer("shivani",20,"India",20.000,"Bsc","Female","oc","software",8106633432L);
		eManager.persist(cust);
		Customer c=custService.addCustomer(cust);
		assertEquals(cust.getCustomerName(),c.getCustomerName());
	}
}
