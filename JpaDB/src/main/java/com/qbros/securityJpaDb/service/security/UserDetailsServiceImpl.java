package com.qbros.securityJpaDb.service.security;

import com.qbros.securityJpaDb.persistance.entities.security.UserInfo;
import com.qbros.securityJpaDb.persistance.repositories.UserInfoRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by V.Ghasemi
 * on 5/13/2019.
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //we define our users in our own model (entity)
        UserInfo userInfo = userInfoRepository.findByUserName(userName)
                .orElseThrow(()-> new UsernameNotFoundException(userName));
        return new User(userInfo.getUserName(),userInfo.getPassword(),userInfo.getRole());

//----if our custom defined roles are not instance of GrantedAuthority (interface) then we need to convert them
//        List<SimpleGrantedAuthority> simpleGrantedAuthorities = userInfo.getRole()
//                .stream().map(role -> new SimpleGrantedAuthority(role.name()))
//                .collect(Collectors.toList());
//
//        //spring security works with its own user definitions (we have to convert ours to theirs)
//        return new User(userInfo.getUserName(),userInfo.getPassword(),simpleGrantedAuthorities);
    }
}
