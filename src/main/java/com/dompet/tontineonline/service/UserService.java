package com.dompet.tontineonline.service;

import com.dompet.tontineonline.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService   {

    public void create(User user);
}
