package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Yougo;
import com.example.demo.repository.YougoRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class YougoService {
	
	@Autowired
	  private YougoRepository yougoRepository;
	
	public List<Yougo> searchAll() {
	    return yougoRepository.findAll();
	  }

}
