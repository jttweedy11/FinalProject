package com.skilldistillery.enginex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.enginex.entities.Client;
import com.skilldistillery.enginex.entities.User;
import com.skilldistillery.enginex.repositories.ClientRepository;
import com.skilldistillery.enginex.repositories.UserRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Client update(String username, Client client, int clientId) {
		User user = userRepo.findByUsername(username);
		
		Optional<Client> opt = clientRepo.findById(clientId);
		
		if(opt.isPresent() && opt.get().getUser().getId() == user.getId()) {
			Client dbClient = opt.get();
			dbClient.setFirstName(client.getFirstName());
			dbClient.setLastName(client.getLastName());
			dbClient.setEmail(client.getEmail());
			dbClient.setPhoneNumber(client.getPhoneNumber());
			dbClient.setImageUrl(client.getImageUrl());
			return clientRepo.saveAndFlush(dbClient);
			
			} else {
				
				return null;
			}
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepo.findAll();
	}

	@Override
	public Boolean delete(String username, int clientId) {
		User user = userRepo.findByUsername(username);
		
		Optional<Client> opt = clientRepo.findById(clientId);
		if(opt.isPresent() && opt.get().getUser().getId() == user.getId()) {
			Client client = opt.get();
			user.setClient(null);
			clientRepo.delete(client);
			userRepo.saveAndFlush(user);
			return true;
		}
			return false;

	}

	@Override
	public Client getClientById(int clientId) {
		Optional<Client> client = clientRepo.findById(clientId);
		if (client.isPresent()) {
			return client.get();
		} else {
			return null;

		}
	}

	@Override
	public Client create(String username, Client client) {
		User user = userRepo.findByUsername(username);
				
		client.setUser(user);
			
		return clientRepo.saveAndFlush(client);
		

	}

}
