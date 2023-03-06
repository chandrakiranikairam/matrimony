package com.matrimony.utill;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.matrimony.dto.CustomerDetails;
import com.matrimony.entity.Customer;

public class CustomerUtil {
	
	
	
	public static CustomerDetails toDetails(Customer add) {
				return new CustomerDetails(add.getCustomerName(),add.getCustomerAge(),add.getCustomerCaste(),add.getCustomerIncome(),add.getCustomerEducation(),add.getCustomerGender(),add.getCustomerCaste(),add.getCustomerProfession(),add.getCustomerPhonenumber());

						}
	
	public static List<CustomerDetails> toDetails(Collection<Customer> cust) {
		 List<CustomerDetails> detailList = new ArrayList<>();
	        for (Customer cust1 : cust) {
	           CustomerDetails details = toDetails(cust1);
	            System.out.println(details);
	            detailList.add(details);
	        }
	        return detailList;
	}

}
