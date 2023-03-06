package com.matrimony.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.dao.AdminDao;
import com.matrimony.dto.CreateCustomerRequest;
import com.matrimony.dto.CustomerDetails;
import com.matrimony.entity.Customer;
import com.matrimony.exception.AuthorizedUserRoleNotFoundException;
import com.matrimony.exception.MisMatchInputException;
import com.matrimony.exception.NotLoggedInException;
import com.matrimony.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
	
@Autowired
	CustomerService customerService;

@Autowired
private AdminDao aDao;

@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/addcustomer")
public String addCustomer(HttpServletRequest request, @RequestBody CreateCustomerRequest requestData)
		throws AuthorizedUserRoleNotFoundException, NotLoggedInException {
	String userName = (String) request.getSession().getAttribute("user");
	System.out.println(userName);
	if (userName == null) {
		throw new NotLoggedInException("You have not logged in");
	}
	String userRole = (String) request.getSession().getAttribute("role");
	if (!userRole.equalsIgnoreCase("Admin")) {
		throw new AuthorizedUserRoleNotFoundException("you are not authorized to add the Customer");
	}

 @SuppressWarnings("unused")
Customer add=new Customer(requestData.getCustomerName(),requestData.getCustomerAge(),requestData.getCustomerCaste(),requestData.getCustomerIncome(),requestData.getCustomerEducation(),requestData.getCustomerGender(),requestData.getCustomerCaste(),requestData.getCustomerProfession(),requestData.getCustomerPhonenumber());	
Customer cust = null;
if(cust==customerService.addCustomer(add)) {
	return"Customer added";
}
return "Customer not added";

}

@PutMapping("/editCustomer")
public String editCustomer(HttpServletRequest request, @RequestBody CustomerDetails requestData)
		throws AuthorizedUserRoleNotFoundException {
	String userName = (String) request.getSession().getAttribute("user");
	if (userName == null) {
		throw new NotLoggedInException("You have not logged in");
	}
	String userRole = (String) request.getSession().getAttribute("role");
	if (!userRole.equalsIgnoreCase("Admin")) {
		throw new AuthorizedUserRoleNotFoundException("you are not authorized to edit the Customer");
	}
	@SuppressWarnings("unused")
	boolean cust = true;
	System.out.println("start");
	System.out.println((aDao.existsById(requestData.getCustomerId())));
	if((aDao.existsById(requestData.getCustomerId()))) {
		
		
		Customer custom = new Customer();
	System.out.println("passing to service layer");
		if (customerService.editCustomer(custom)) {
			return "Address successfully edited";
		}
		return "Address is not edited";}
		else {
			throw new MisMatchInputException("The CustomerId doesn't exist in the database, kindly click on add customer option or retype the already existing customer id to edit");}
		
	}

@GetMapping("/findall/customer")
List<Customer> findAllCustomers(HttpServletRequest request){
	List<Customer> li = new ArrayList<Customer>();
	li=customerService.findAllCustomers();
	return li;
	}


@DeleteMapping("/deleteCustomer/{cId}")
public String deleteCustomer(@PathVariable ("cId")  Integer custId ,HttpServletRequest request) throws NotLoggedInException, AuthorizedUserRoleNotFoundException {
	String userName = (String) request.getSession().getAttribute("user");
	System.out.println(userName);
	if (userName == null) {
		throw new NotLoggedInException("You have not logged in");
	}
	String userRole = (String) request.getSession().getAttribute("role");
	if (!userRole.equalsIgnoreCase("Admin")) {
		throw new AuthorizedUserRoleNotFoundException("you are not authorized to add the Customer");
	}
	if(customerService.deleteCustomer(custId)) {
	return "Customer deleted";
		
	}
		return "Customer not deleted";
	
	}



}
