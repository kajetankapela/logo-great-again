package com.logogreatagain.config;

import com.logogreatagain.model.Player;
import com.logogreatagain.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsAdapter implements UserDetailsService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        Player playerByName = playerRepository.findByName(login);
        if (playerByName == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(playerByName.getName())
                .password("{noop}")
                .build();
    }
}
