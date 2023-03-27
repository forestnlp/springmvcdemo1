package com.demo.mapper;

import com.demo.dto.Player;

import java.util.List;

public interface PlayerMapper {
    int addPlayer(Player player);

    List<Player> getAllPlayer();
}
