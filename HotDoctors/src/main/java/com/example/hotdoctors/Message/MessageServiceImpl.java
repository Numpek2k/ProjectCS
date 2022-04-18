package com.example.hotdoctors.Message;

import com.example.hotdoctors.Schedule.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements ScheduleService {
    
    private final MessageRepository messageRepository;
}
