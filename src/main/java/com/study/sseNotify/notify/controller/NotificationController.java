package com.study.sseNotify.notify.controller;

import com.study.sseNotify.notify.dto.DataDto;
import com.study.sseNotify.notify.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping(value = "/subscribe/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(
            @PathVariable Long id) {
        return notificationService.subscribe(id);
    }

    @PostMapping("/send-data/{id}")
    public void sendDataTest(@PathVariable Long id, @RequestBody DataDto dataDto) {

        notificationService.notify(id, dataDto);
    }
}