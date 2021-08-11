package com.mscloud.hruser.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

	private int status;
	private String message;
	private Date timestamp;
}
