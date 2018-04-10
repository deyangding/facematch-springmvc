package com.framework.security;

public enum Roles {
	ADMIN(0L, "管理员");

	private Long code;
	private String name;

	private Roles(Long code, String name) {
		this.code = code;
		this.name = name;
	}

	public Long getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
