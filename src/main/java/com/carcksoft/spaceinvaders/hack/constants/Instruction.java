package com.carcksoft.spaceinvaders.hack.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Instruction {

    UP("up"),
    DOWN("down"),
    LEFT("left"),
    RIGHT("right"),
    F_UP("fire-up"),
    F_DOWN("fire-down"),
    F_LEFT("fire-left"),
    F_RIGHT("fire-right");

    @JsonProperty
    private final String move;

    private static final Map<String,Instruction> ENUM_MAP;

    Instruction(String move) {
        this.move = move;
    }

    static {
        Map<String,Instruction> map = new ConcurrentHashMap<>();
        for (Instruction instance : Instruction.values()) {
            map.put(instance.getMove(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Instruction get (String move) {
        return ENUM_MAP.get(move);
    }
}
