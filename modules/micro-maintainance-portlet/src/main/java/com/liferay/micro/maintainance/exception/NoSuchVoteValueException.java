package com.liferay.micro.maintainance.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
@ProviderType
public class NoSuchVoteValueException extends NoSuchModelException {

	public NoSuchVoteValueException() {
	}

	public NoSuchVoteValueException(String msg) {
		super(msg);
	}

	public NoSuchVoteValueException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchVoteValueException(Throwable cause) {
		super(cause);
	}

}