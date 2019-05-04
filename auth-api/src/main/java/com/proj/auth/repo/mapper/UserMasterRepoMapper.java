package com.proj.auth.repo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.proj.auth.mapper.AuthMapper;
import com.proj.entity.quiz.UserMaster;

public class UserMasterRepoMapper implements RowMapper<UserMaster> {
	private final AuthMapper authMapper;

	public UserMasterRepoMapper(AuthMapper authMapper) {
		this.authMapper = authMapper;
	}

	@Override
	public UserMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserMaster userMaster = authMapper.resultSetToUserMaster(rs);
		if (!StringUtils.isEmpty(userMaster)) {
			userMaster.setUserAddress(authMapper.resultSetToUserAddress(rs));
			userMaster.setUserRole(authMapper.resultSetToUserRole(rs));
		}
		return userMaster;
	}

}
