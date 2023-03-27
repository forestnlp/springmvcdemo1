package com.demo.service.impl;

import com.demo.dto.Player;
import com.demo.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerMapper playerMapper;
    @Override
    public boolean addPlayer(Player player) {
        return playerMapper.addPlayer(player)>0;
    }

    @Override
    public List<Player> getAllPlayer() {
        return  playerMapper.getAllPlayer();
    }
}
