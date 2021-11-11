package com.skilldistillery.enginex.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.enginex.entities.Chat;
import com.skilldistillery.enginex.entities.User;
import com.skilldistillery.enginex.repositories.ChatRepository;
import com.skilldistillery.enginex.repositories.UserRepository;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatRepository chatRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Chat> findBySenderId(String username, int userId, int senderId) {
		User sender = userRepo.findByUsername(username);
		if(sender.getId() == userId) {
			
			return chatRepo.findBySender(sender);
		}
		return null;
	}

	@Override
	public List<Chat> findByReceiverId(String username, int userId, int receiverId) {
		User receiver = userRepo.findByUsername(username);
		if(receiver.getId() == userId) {
			
			return chatRepo.findByReceiver(receiver);
		}
		return null;
	}

	@Override
	public Chat retrieveByChatId(String username, int userId, int chatId) {
		User user = userRepo.findByUsername(username);
		Chat chat = chatRepo.findById(chatId);
		if(user.getId() == userId && chat.getSender().getId() == user.getId() 
										|| chat.getReceiver().getId() == user.getId()) {
			
			return chat;
		}
		return null;
				
	}

	@Override
	public Chat createChat(String username, Chat chat, int senderId, int receiverId) {
		User sender = userRepo.findByUsername(username);
		Optional<User> opt = userRepo.findById(receiverId);
		
		if (sender.getId() == senderId && opt.isPresent()) {
			Chat dbChat = new Chat();
			dbChat.setDateTimeStamp(LocalDateTime.now());
			dbChat.setSubject(chat.getSubject());
			dbChat.setMessage(chat.getMessage());
			dbChat.setSender(sender);
			dbChat.setReceiver(opt.get());
			dbChat = chatRepo.saveAndFlush(dbChat);
			return dbChat;
		}
		
		return null;
	}

	@Override
	public Chat replyToChat(String username, Chat chat, int senderId, int receiverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteChat(String username, int chatId, int senderId) {
		User sender = userRepo.findByUsername(username);
		Chat chat = chatRepo.findById(chatId);
		if (sender.getId() == senderId && chat != null) {
			chatRepo.delete(chat);
		}
		
	}

	@Override
	public Chat editChat(String username, Chat chat, int userId, int receiverId) {
		User sender = userRepo.findByUsername(username);
		Optional<User> opt = userRepo.findById(receiverId);
		Chat editChat = chatRepo.findById(chat.getId());
		if (sender.getId() == userId && editChat.getSender().getId() == userId && opt.isPresent()) {
			editChat.setDateTimeStamp(LocalDateTime.now());
			editChat.setSubject(chat.getSubject());
			editChat.setMessage(chat.getMessage());
			editChat.setReceiver(opt.get());
			editChat = chatRepo.saveAndFlush(editChat);
			return editChat;
		}
		
		return null;
	}

}
