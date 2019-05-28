package com.qbros.securityJpaDb.springStuff;

import com.qbros.securityJpaDb.persistance.entities.security.Role;
import com.qbros.securityJpaDb.persistance.entities.security.UserInfo;
import com.qbros.securityJpaDb.persistance.repositories.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@AllArgsConstructor
@Component
public class Init implements CommandLineRunner {

    private UserInfoRepository userInfoRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userInfoRepository.save(new UserInfo("sd0", bCryptPasswordEncoder.encode("jj"), new HashSet<Role>() {{
            add(Role.VIEWER);
        }}));
        userInfoRepository.save(new UserInfo("sd1", bCryptPasswordEncoder.encode("jj"), new HashSet<Role>() {{
            add(Role.USER);
        }}));
        userInfoRepository.save(new UserInfo("sd2", bCryptPasswordEncoder.encode("jj"), new HashSet<Role>() {{
            add(Role.ADMIN);
        }}));
        userInfoRepository.save(new UserInfo("sd3", bCryptPasswordEncoder.encode("jj"), new HashSet<Role>() {{
            add(Role.ADMIN);
            add(Role.USER);
        }}));
        System.out.println("init finish!");
    }
}
