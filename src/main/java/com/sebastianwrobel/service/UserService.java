package com.sebastianwrobel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.Channel;
import com.sebastianwrobel.domain.User;
import com.sebastianwrobel.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public User createUser(String username, Channel channel) {
		User newUser = new User();
		newUser.getChannel().add(channel);
		newUser.setUsername(username);
		return userRepo.save(newUser);
	}

	public User findByUserId(Long userId) {
		return userRepo.findByUserId(userId);
	}
}