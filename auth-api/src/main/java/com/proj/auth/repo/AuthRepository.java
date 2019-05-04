package com.proj.auth.repo;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.proj.entity.quiz.UserMaster;

@Repository
public interface AuthRepository {
	public UserMaster findUserByUserName(String userName) throws SQLException;
}
