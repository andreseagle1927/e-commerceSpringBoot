package com.abadia.first.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.first.entity.ActivityRegister;

public interface IActivityRegisterRepository extends CrudRepository<ActivityRegister, String> {

}
