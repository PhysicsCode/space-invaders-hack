package com.carcksoft.spaceinvaders.hack.controller;

import com.carcksoft.spaceinvaders.hack.beans.GameBean;
import com.carcksoft.spaceinvaders.hack.constants.Instruction;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final GameBean gameBean;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping
    public String getMap() {

        return gameBean.getAsciiBoard();
    }

    @PostMapping
    public void setMap(@RequestBody String map) {

        gameBean.setAsciiBoard(map);
        simpMessagingTemplate.convertAndSend("/topic/map", map);
    }
}
