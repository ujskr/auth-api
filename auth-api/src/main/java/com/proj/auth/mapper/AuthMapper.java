package com.proj.auth.mapper;

import static com.proj.auth.constants.AuthMapperConstants.DATE_COLUMN_10;
import static com.proj.auth.constants.AuthMapperConstants.INTEGER_COLUMN_17;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_1;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_11;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_12;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_13;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_14;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_15;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_16;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_18;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_2;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_3;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_4;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_5;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_6;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_7;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_8;
import static com.proj.auth.constants.AuthMapperConstants.STRING_COLUMN_9;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proj.entity.quiz.UserAddress;
import com.proj.entity.quiz.UserMaster;
import com.proj.entity.quiz.UserRole;

@Mapper(componentModel = "spring")
public interface AuthMapper {

	@Mapping(target = "userId", expression = STRING_COLUMN_1)
	@Mapping(target = "userName", expression = STRING_COLUMN_2)
	@Mapping(target = "userPassword", expression = STRING_COLUMN_3)
	@Mapping(target = "firstName", expression = STRING_COLUMN_4)
	@Mapping(target = "lastName", expression = STRING_COLUMN_5)
	@Mapping(target = "emailId", expression = STRING_COLUMN_6)
	@Mapping(target = "organisation", expression = STRING_COLUMN_7)
	@Mapping(target = "university", expression = STRING_COLUMN_8)
	@Mapping(target = "lastLogin", expression = STRING_COLUMN_9)
	@Mapping(target = "dob", expression = DATE_COLUMN_10)
	UserMaster resultSetToUserMaster(ResultSet rs) throws SQLException;

	@Mapping(target = "addressId", expression = STRING_COLUMN_12)
	@Mapping(target = "addressLine1", expression = STRING_COLUMN_13)
	@Mapping(target = "area", expression = STRING_COLUMN_14)
	@Mapping(target = "city", expression = STRING_COLUMN_15)
	@Mapping(target = "state", expression = STRING_COLUMN_16)
	@Mapping(target = "pinCode", expression = INTEGER_COLUMN_17)
	UserAddress resultSetToUserAddress(ResultSet rs) throws SQLException;

	@Mapping(target = "userRoleId", expression = STRING_COLUMN_11)
	@Mapping(target = "userRole", expression = STRING_COLUMN_18)
	UserRole resultSetToUserRole(ResultSet rs) throws SQLException;

}
