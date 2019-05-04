package com.proj.auth.repo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proj.auth.mapper.AuthMapper;
import com.proj.entity.quiz.UserAddress;

public class UserAddressRepoMapper implements RowMapper<UserAddress> {

	private final AuthMapper authMapper;

	public UserAddressRepoMapper(AuthMapper authMapper) {
		this.authMapper = authMapper;
	}

	@Override
	public UserAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
		return authMapper.resultSetToUserAddress(rs);
	}

}
