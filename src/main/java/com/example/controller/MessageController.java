package com.example.controller;

import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/")
	public ResponseEntity<?> publishEvent() {
		try {
			messageService.sendMessage();
			return ResponseEntity.ok("Message published successfully");
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> publishEventByEmpId(@PathVariable int id) {
		try {
			messageService.sendMessageByEmpId(id);
			return ResponseEntity.ok("Message published successfully");
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
}