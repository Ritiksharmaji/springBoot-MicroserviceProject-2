package com.scaler1.scalerProject_1.inheritanceDemo.MappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryMSC extends JpaRepository<StudentMSC, Long> { }
