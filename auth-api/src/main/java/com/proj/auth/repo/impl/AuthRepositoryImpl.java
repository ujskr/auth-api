package com.proj.auth.repo.impl;

import static com.proj.auth.constants.DatabaseConstants.RESULTS_SET_UD;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.proj.auth.repo.AuthRepository;
import com.proj.entity.quiz.UserMaster;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AuthRepositoryImpl implements AuthRepository {

	SimpleJdbcCall createUSRAUTHSPInstance;

	public AuthRepositoryImpl(@Qualifier("createUSRAUTHSPInstance") SimpleJdbcCall createUSRAUTHSPInstance) {
		this.createUSRAUTHSPInstance = createUSRAUTHSPInstance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserMaster findUserByUserName(String userName) {
		UserMaster userMaster = null;
		log.info("START method findUserByUserName in AuthRepositoryImpl");
		try {
			Map<String, Object> results = createUSRAUTHSPInstance.execute(userName);
			List<UserMaster> userMasters = (List<UserMaster>) results.get(RESULTS_SET_UD);
			userMaster = (!CollectionUtils.isEmpty(userMasters) ? userMasters.get(0) : null);

		} catch (UncategorizedSQLException ex) {
			log.info("Error in fetching data - " + ex.getLocalizedMessage());
		}
		log.info("END method findUserByUserName in AuthRepositoryImpl");
		return userMaster;
	}

}
