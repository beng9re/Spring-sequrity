package com.kim.sequrity.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//JPA 기본
//@Repository 없어도 IOC
public interface UserRepository extends JpaRepository<User,Long> {
}
