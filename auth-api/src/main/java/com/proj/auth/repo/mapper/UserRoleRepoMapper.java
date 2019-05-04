package com.proj.auth.repo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proj.auth.mapper.AuthMapper;
import com.proj.entity.quiz.UserRole;

public class UserRoleRepoMapper implements RowMapper<UserRole> {

	private final AuthMapper authMapper;

	public UserRoleRepoMapper(AuthMapper authMapper) {
		this.authMapper = authMapper;
	}

	@Override
	public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		return authMapper.resultSetToUserRole(rs);
	}

}
