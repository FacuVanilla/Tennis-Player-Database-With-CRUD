package com.oluwaseun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oluwaseun.model.Player;
import com.oluwaseun.repository.PlayerRepository;

@Service
public class PlayerServices {

	@Autowired
	private PlayerRepository repo;
	
	public List<Player> listAll(){
		return repo.findAll();
	}
	
	public void save(Player student) {
		repo.save(student);
	}
	
	public Player get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}

