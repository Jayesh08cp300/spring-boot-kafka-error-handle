package com.example.service;

import com.example.dto.User;
import com.example.producer.MessageProducer;
import com.example.util.CsvReaderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
	@Autowired
	private MessageProducer messageProducer;

	public void sendMessage() {
		List<User> users = CsvReaderUtils.readDataFromCsv();
		users.forEach(usr -> messageProducer.sendEvents(usr));
	}

	public void sendMessageByEmpId(int id) {
		List<User> users = CsvReaderUtils.readDataFromCsv();
		users.stream()
				.filter(u -> u.getId() == id)
				.forEach(usr -> messageProducer.sendEvents(usr));
	}
}
