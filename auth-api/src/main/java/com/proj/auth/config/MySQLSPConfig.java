package com.proj.auth.config;

import static com.proj.auth.constants.DatabaseConstants.IN_PARAMETER_USER_NAME;
import static com.proj.auth.constants.DatabaseConstants.RESULTS_SET_UD;
import static com.proj.auth.constants.DatabaseConstants.SCHEMA_NAME;
import static com.proj.auth.constants.DatabaseConstants.SP_NAME;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.proj.auth.mapper.AuthMapper;
import com.proj.auth.repo.mapper.UserMasterRepoMapper;

@Configuration
public class MySQLSPConfig {

	private final DataSource dataSource;
	private final AuthMapper authMapper;

	public MySQLSPConfig(DataSource dataSource, AuthMapper authMapper) {
		this.dataSource = dataSource;
		this.authMapper = authMapper;
	}

	@Bean("createUSRAUTHSPInstance")
	public SimpleJdbcCall createUSRAUTHSPInstance() {
		SimpleJdbcCall authSP = new SimpleJdbcCall(dataSource).withSchemaName(SCHEMA_NAME).withProcedureName(SP_NAME)
				.declareParameters(new SqlParameter(IN_PARAMETER_USER_NAME, Types.VARCHAR))
				.returningResultSet(RESULTS_SET_UD, new UserMasterRepoMapper(authMapper));				
		authSP.compile();
		return authSP;
	}

}
