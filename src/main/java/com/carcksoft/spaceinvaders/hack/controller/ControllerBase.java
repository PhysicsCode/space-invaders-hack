package com.carcksoft.spaceinvaders.hack.controller;

import com.carcksoft.spaceinvaders.hack.beans.GameBean;
import com.carcksoft.spaceinvaders.hack.constants.Instruction;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instruction")
@RequiredArgsConstructor
public class ControllerBase {

    private final GameBean gameBean;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping
    public String getInstruction() {

        return gameBean.getActiveInstruction().getMove();
    }

    @PostMapping
    public String setInstruction(@RequestBody String instruction) {

        gameBean.setActiveInstruction(Instruction.get(instruction));
        simpMessagingTemplate.convertAndSend("/topic/instruction", getInstruction());
        return getInstruction();
    }
}
