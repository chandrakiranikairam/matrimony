package com.matrimony.exception;

@SuppressWarnings("serial")
public class AuthorizedUserRoleNotFoundException extends Exception {
	public AuthorizedUserRoleNotFoundException (String msg) {
		super(msg);
	}
}
