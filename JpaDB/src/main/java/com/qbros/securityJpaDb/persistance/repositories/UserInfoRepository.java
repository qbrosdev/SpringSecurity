package com.qbros.securityJpaDb.persistance.repositories;

import com.qbros.securityJpaDb.persistance.entities.security.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by V.Ghasemi
 * on 5/13/2019.
 */

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    Optional<UserInfo> findByUserName(String userName);
}
