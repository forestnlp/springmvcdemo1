package com.demo.service.impl;

import com.demo.dto.Player;

import java.util.List;

public interface PlayerService {
    boolean addPlayer(Player player);

    List<Player> getAllPlayer();
}
