package com.carcksoft.spaceinvaders.hack.beans;

import com.carcksoft.spaceinvaders.hack.constants.Instruction;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class GameBean {

    private Instruction activeInstruction = Instruction.UP;

    private String asciiBoard = "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■<br>" +
                                "■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□·X······□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□········□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□········□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□···P··O·□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■■■■■■■■■□■·······□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□■·····O·□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■□□□□□□□□□■·······□□□□□□□□□□□□□□□□□□□□□□□□□□□■<br>" +
                                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■<br>";
    private Boolean isInstructionActive = false;

}
