package com.abadia.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.entity.ActivityRegister;

import java.util.List;

public interface IActivityRegisterRepository extends CrudRepository<ActivityRegister, String> {

}
