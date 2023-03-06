package com.matrimony.service;

import org.springframework.stereotype.Service;

import com.matrimony.entity.Mediator;

@Service
public interface AdminService {

	

	Mediator addMediator(Mediator add);

	boolean editMediator(Mediator med);

	boolean deleteMediator(Integer medId);

}
