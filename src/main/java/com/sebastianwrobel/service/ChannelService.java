package com.sebastianwrobel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.Channel;
import com.sebastianwrobel.repository.ChannelRepository;

@Service
public class ChannelService {
	@Autowired
	private ChannelRepository channelRepo;

	public Channel createChannel(Channel channel) {
		channel.setName("General");
		return channelRepo.save(channel);
	}

	public Channel findById(Long channelId) {
		return channelRepo.findByChannelId(channelId);
	}

	public List<Channel> findAll() {
		return channelRepo.findAll();
	}

	public void createCustomChannel(Channel channel) {
		channelRepo.save(channel);
	}
}