package com.carcksoft.spaceinvaders.hack.controller;

import com.carcksoft.spaceinvaders.hack.beans.GameBean;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activator")
@RequiredArgsConstructor
public class ActivatorController {

    private final GameBean gameBean;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping
    public String isActive() {

        return String.valueOf(gameBean.getIsInstructionActive());
    }

    @PostMapping
    public void setActive(@RequestBody String active) {

        gameBean.setIsInstructionActive(Boolean.valueOf(active));
        simpMessagingTemplate.convertAndSend("/topic/activator", active);
    }
}
