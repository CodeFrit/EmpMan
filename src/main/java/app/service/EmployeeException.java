package app.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeException extends RuntimeException {

	private static final long serialVersionUID = 1869047526506271422L;

	public EmployeeException(String msg) {
		super(msg);
	}
}
