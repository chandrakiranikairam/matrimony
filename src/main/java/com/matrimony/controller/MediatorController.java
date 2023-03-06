package com.matrimony.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.dao.AdminDao;
import com.matrimony.dto.CreateMediatorRequest;
import com.matrimony.dto.EditMediatorRequest;
import com.matrimony.entity.Mediator;
import com.matrimony.exception.AuthorizedUserRoleNotFoundException;
import com.matrimony.exception.MisMatchInputException;
import com.matrimony.exception.NotLoggedInException;
import com.matrimony.service.AdminService;


	@RestController
	@RequestMapping("/customer")
	@CrossOrigin("http://localhost:4200")

	public class MediatorController {

		@Autowired
		private AdminService aService;
		
		@Autowired
		private AdminDao aDao;
		
		
		
		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping("/addmediator")
		public String addMediator(HttpServletRequest request, @RequestBody CreateMediatorRequest requestData)
				throws AuthorizedUserRoleNotFoundException, NotLoggedInException {
			String userName = (String) request.getSession().getAttribute("user");
			System.out.println(userName);
			if (userName == null) {
				throw new NotLoggedInException("You have not logged in");
			}
			String userRole = (String) request.getSession().getAttribute("role");
			if (!userRole.equalsIgnoreCase("Admin")) {
				throw new AuthorizedUserRoleNotFoundException("you are not authorized to add the Mediator");
			}
		
		//@SuppressWarnings("unused")
		Mediator mediator=null;
		Mediator add=new Mediator(requestData.getName(),requestData.getMobileNo());	
		if(mediator==aService.addMediator(add)) {
			return"Mediator added";
		}
		return "Mediator not added";
		
		}
		
		@PutMapping("/editMediator")
		public String editMediator(HttpServletRequest request, @RequestBody EditMediatorRequest requestData)
				throws AuthorizedUserRoleNotFoundException {
			String userName = (String) request.getSession().getAttribute("user");
			if (userName == null) {
				throw new NotLoggedInException("You have not logged in");
			}
			String userRole = (String) request.getSession().getAttribute("role");
			if (!userRole.equalsIgnoreCase("Admin")) {
				throw new AuthorizedUserRoleNotFoundException("you are not authorized to edit the Mediator");
			}
			@SuppressWarnings("unused")
			boolean mediator = true;
			System.out.println("start");
			System.out.println((aDao.existsById(requestData.getMediatorId())));
			if((aDao.existsById(requestData.getMediatorId()))) {
				
				
		 Mediator med = new Mediator(requestData.getName(),requestData.getMobileNo());
			System.out.println("passing to service layer");
				if (aService.editMediator(med)) {
					return "Details successfully edited";
				}
				return "Details are not edited";}
				else {
					throw new MisMatchInputException("The MediatorId doesn't exist in the database, kindly click on add mediator option or retype the already existing mediator id to edit");}
				
			}

		@DeleteMapping("/deleteMediator/{mId}")
		public String deleteMediator(@PathVariable ("mId")  Integer medId ,HttpServletRequest request) throws NotLoggedInException, AuthorizedUserRoleNotFoundException {
			String userName = (String) request.getSession().getAttribute("user");
			System.out.println(userName);
			if (userName == null) {
				throw new NotLoggedInException("You have not logged in");
			}
			String userRole = (String) request.getSession().getAttribute("role");
			if (!userRole.equalsIgnoreCase("Admin")) {
				throw new AuthorizedUserRoleNotFoundException("you are not authorized to delete the Mediator");
			}
			if(aService.deleteMediator(medId)) {
			return "Mediator deleted";
				
			}
				return "Mediator not deleted";
			
			}
			

	}


