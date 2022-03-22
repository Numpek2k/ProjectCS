package com.example.hotdoctors.Message;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {
    
    private final MessageRepository messageRepository;
}
