package com.kitchen.util;

public class StaticContent {

	// server configuration
	public static final String SERVER = "http://localhost";

	// DB configuration
	public static final String DB_NAME = "test";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "marcelo12";
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useUnicode=true";

	// DB configuration
	public static final String MONGO_CLIENT = "127.0.0.1";

	// hibernate confi
	public static final String DB_DDL = "hibernate.hbm2ddl.auto";
	public static final String DB_DDL_VALUE = "update";
	public static final String DB_DIALECT = "hibernate.dialect";
	public static final String DB_DIALECT_VALUE = "org.hibernate.dialect.MySQL5Dialect";
	public static final String DB_SHOW_SQL = "show_sql";
	public static final String DB_SHOW_SQL_VALUE = "true";

	// ROLES
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String HAS_ROLE_USER = "hasRole('ROLE_USER')";

	// LOGIN USER PARAMETER
	public static final String LOGIN_PARAM_USERNAME = "username";
	public static final String LOGIN_PARAM_PASSWORD = "password";

	// jwt
	public static final String JWTS_SECRET = "juca";

	// COOKIE
	public static final String COOKIE_XSRF_TOKEN = "XSRF-TOKEN";
	public static final String COOKIE_X_XSRF_TOKEN = "X-XSRF-TOKEN";
	public static final int COOKIE_TIME = (60 * 60 * 24 * 30);
	public static final String COOKIE_PATH = "/";
	public static final String COOKIE_AUTH_NAME = "X-AUTH-TOKEN";
	public static final String COOKIE_USER_ID = "USER-ID";

	public static final String COOKIE_MISSING_NOT_MATCHING = "Missing or non-matching XSRF-TOKEN";

	// exception;
	public static final String EXCEPTION_USER_NOT_FOUND = "user not found";
	public static final String EXCEPTION_ACCESS_DENIED = "Missing or non-matching XSRF-TOKEN";

	// log
	public static final String LOG_SEPARATOR = " -> ";

}