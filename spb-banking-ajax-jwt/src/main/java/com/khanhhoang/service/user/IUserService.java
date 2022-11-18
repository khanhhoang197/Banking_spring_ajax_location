package com.khanhhoang.service.user;

import com.khanhhoang.model.User;
import com.khanhhoang.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User getByUsername(String username);

    Boolean existsByUsername(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
