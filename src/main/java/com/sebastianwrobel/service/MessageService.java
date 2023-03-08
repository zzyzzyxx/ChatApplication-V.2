package com.sebastianwrobel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.Channel;
import com.sebastianwrobel.domain.Message;
import com.sebastianwrobel.domain.User;
import com.sebastianwrobel.repository.MessageRepository;
import com.sebastianwrobel.dto.MessageDto;

@Service
public class MessageService {
@Autowired
private MessageRepository messageRepo;
@Autowired
private ChannelService channelService;
@Autowired
private UserService userService;

	
	public void createMessage(MessageDto message, Long channelId) {
		Channel channel = channelService.findById(channelId);
		Message newMessage = new Message();
		User user = new User();
		user = userService.findByUserId(message.getUserId());
		newMessage.setUser(user);
		newMessage.setMessage(message.getMessage());
		newMessage.setChannel(channel);
		messageRepo.save(newMessage);
		
	}


//	public List<messageDto> getAllMessages() {
//		
//		List<Message> messageList = messageRepo.findAll();
//		List<messageDto> messagesDto = new ArrayList<>();
//		for (Message message:messageList) {
//			messageDto messageDto = new messageDto();
//			messageDto.setMessage(message.getMessage());
//			messageDto.setUserId(message.getUser().getUserId());
//			messageDto.setChannelId(message.getMessageId());
//			messageDto.setUsername(message.getUser().getUsername());
//			messagesDto.add(messageDto);
//		}
//		return messagesDto;
//	}


	public List<MessageDto> getMessageByChannelId(Long channelId) {
		List<Message> messageList = messageRepo.findAllByChannelId(channelId);
		List<MessageDto> messagesDto = new ArrayList<>();
		for (Message message:messageList) {
			MessageDto messageDto = new MessageDto();
			messageDto.setMessage(message.getMessage());
			messageDto.setUserId(message.getUser().getUserId());
			messageDto.setChannelId(message.getMessageId());
			messageDto.setUsername(message.getUser().getUsername());
			messagesDto.add(messageDto);
		}
		return messagesDto;
	}
}	