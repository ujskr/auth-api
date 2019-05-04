package com.proj.auth.service;

import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.proj.auth.repo.AuthRepository;
import com.proj.entity.quiz.UserMaster;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService {

	private final AuthRepository authRepository;

	public AuthService(AuthRepository authRepository) {
		this.authRepository = authRepository;
	}

	public UserMaster authenticateUser(String userName, String password) throws SQLException {
		log.info("START method authenticateUser in AuthService");

		UserMaster userMaster = authRepository.findUserByUserName(userName);
		if (!StringUtils.isEmpty(userMaster)) {
			if (BCrypt.checkpw(password, userMaster.getUserPassword())) {
				userMaster.setUserPassword(null);
				log.info("END method authenticateUser in AuthService");
				return userMaster;
			}
		}
		log.info("END method authenticateUser in AuthService - NO USER FOUND");
		return null;
	}
}
