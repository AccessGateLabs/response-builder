package com.accessgatelabs.oss.builder.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ExceptionResponseBuilder extends ApiSubError {
	
	private String location;
    private String key;
    private Object rejectedValue;
    private ViolationType violation;
    private String dataType;
    private String type;
    private String message;
	
	
}
