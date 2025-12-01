package com.scaler1.scalerProject_1.inheritanceDemo.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryTPC extends JpaRepository<UserTPC, Long> { }
