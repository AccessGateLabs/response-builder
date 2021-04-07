/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.accessgatelabs.oss.builder.models;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

/**
 * Collection of Response along with respective codes
 * and HTTP status mapped. 
 * 
 * Further can be appended
 * 
 * @author Ekansh Tiwari
 * @version 1.0.0
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
public enum ServiceResponse {
	
	/*
	 * Information Responses
	 */
	
	CREATION_IN_PROGRESS
	(
		1010,
		"Creation In Progress",
		HttpStatus.PROCESSING
	),
	
	UPLOADING_IN_PROGRESS
	(
		1020,
		"Uploading In Progress",
		HttpStatus.PROCESSING
	),
	
	DELETION_IN_PROGRESS
	(
		1030,
		"Deletion In Progress",
		HttpStatus.PROCESSING
	),
	
	COPYING_IN_PROGRESS
	(
		1040,
		"Copying In Progress",
		HttpStatus.PROCESSING
	),
	
	BATCH_PROCESSING_IN_PROGRESS
	(
		1050,
		"Batch Processing In Progress",
		HttpStatus.PROCESSING
	),
	
	CLONING_IN_PROGRESS
	(
		1060,
		"Cloning In Progress",
		HttpStatus.PROCESSING
	),
	
	SANITIZATION_IN_PROGRESS
	(
		1070,
		"Sanitization In Progress",
		HttpStatus.PROCESSING
	),
	
	LAUNCH_IN_PROGRESS
	(
		1080,
		"Launch In Progress",
		HttpStatus.PROCESSING
	),
	
	JOB_IN_PROGRESS
	(
		1090,
		"Job In Progress",
		HttpStatus.PROCESSING
	),
	
	ALREADY_VERIFIED
	(
			1110, 
			"Already Verified", 
			HttpStatus.CONTINUE
	),
	
	ALREADY_CREATED
	(
			1130, 
			"Already Created", 
			HttpStatus.CONTINUE
	),
	
	ALREADY_DELETED
	(
			1150, 
			"Already Deleted", 
			HttpStatus.CONTINUE
	),
	
	ALREADY_UPDATED
	(
			1170, 
			"Already Updated", 
			HttpStatus.CONTINUE
	),
	
	ALREADY_COPIED
	(
			1190, 
			"Already Copied", 
			HttpStatus.CONTINUE
	),
	
	ALREADY_CLONED
	(
			1210, 
			"Already Cloned", 
			HttpStatus.CONTINUE
	),
	
	ALREADY_REMOVED
	(
			1230, 
			"Already Removed", 
			HttpStatus.CONTINUE
	),
	
	ALREADY_MOVED
	(
			1250, 
			"Already Moved", 
			HttpStatus.CONTINUE
	),
	
	/*
	 * Successful Responses
	 */
	
	CREATED
	(
			2010, 
			"Created", 
			HttpStatus.CREATED
	),
	
	
	UPLOADED
	(
			2020, 
			"Uploaded", 
			HttpStatus.CREATED
	),
	
	UPDATED
	(
			2030, 
			"Updated", 
			HttpStatus.OK
	),
	
	FETCHED
	(
			2040, 
			"Fetched", 
			HttpStatus.OK
	),
	
	DELETED
	(
			2050, 
			"Deleted", 
			HttpStatus.OK
	),
	
	RESOURCE_REMOVED
	(
			2060, 
			"Resource Removed", 
			HttpStatus.OK
	),
	
	RESOURCE_MOVED
	(
			2070, 
			"Resource Moved", 
			HttpStatus.OK
	),
	
	RESOURCE_COPIED
	(
			2080, 
			"Resource Copied", 
			HttpStatus.OK
	),
	
	RESOURCE_CLONED
	(
			2090, 
			"Resource Cloned", 
			HttpStatus.OK
	),
	
	JWT_TOKEN_INITIALIZED
	(
			2110, 
			"Jwt Token Initialized", 
			HttpStatus.OK
	),
	
	TOKEN_INITIALIZED
	(
			2130, 
			"Token Initialized", 
			HttpStatus.OK
	),
	
	TOKEN_DELETED
	(
			2150, 
			"Token Deleted", 
			HttpStatus.OK
	),
	
	MAIL_SENT
	(
			2170, 
			"Mail Sent", 
			HttpStatus.OK
	),
	
	OTP_SMS_SENT
	(
			2190, 
			"OTP SMS Sent", 
			HttpStatus.OK
	),
	
	OTP_EMAIL_SENT
	(
			2210, 
			"OTP Email Sent", 
			HttpStatus.OK
	),
	
	OTP_SENT
	(
			2230, 
			"OTP Sent", 
			HttpStatus.OK
	),
	
	LOGGED_IN_SUCCESS
	(
			2250,
			"Logged In Success",
			HttpStatus.OK
	),
	
	
	VERIFIED
	(
			2270, 
			"Verified", 
			HttpStatus.OK
	),
	
	
	/*
	 * Non severe Information/Error Responses 
	 */
	
	NO_SUCH_EMAIL
	(
			3010, 
			"No Such Email", 
			HttpStatus.BAD_REQUEST
	),
	
	NO_SUCH_PHONE
	(
			3030, 
			"No Such Phone", 
			HttpStatus.BAD_REQUEST
	),
	
	NO_SUCH_USER
	(
			3050, 
			"No Such User", 
			HttpStatus.BAD_REQUEST
	),
	
	NO_SUCH_USERNAME
	(
			3070, 
			"No Such Username", 
			HttpStatus.BAD_REQUEST
	),
	
	NO_SUCH_USER_GROUP
	(
			3090, 
			"No Such User Group", 
			HttpStatus.BAD_REQUEST
	),
	
	EMAIL_IN_USE
	(
			3110, 
			"Email In Use", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	PHONE_IN_USE
	(
			3130, 
			"Phone In Use", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	USERNAME_IN_USE
	(
			3150, 
			"Username In Use", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_ROLE_DEFINED
	(
			3170, 
			"No Role Defined", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_PERMISSION_DEFINED
	(
			3190, 
			"No Permission Defined", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_EMAIL_DEFINED
	(
			3210, 
			"No Email Defined", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_PHONE_DEFINED
	(
			3230, 
			"No Phone Defined", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_USERNAME_DEFINED
	(
			3250, 
			"No Username Defined", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_AUTHENTICATION_DEFINED
	(
			3270, 
			"No Authentication Defined", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	FILE_SIZE_EXCEEDED
	(
			3290, 
			"File Size Exceeded", 
			HttpStatus.BAD_REQUEST
	),
	
	NUMBER_OF_FILES_EXCEEDED
	(
			3310, 
			"Number Of Files Exceeded", 
			HttpStatus.BAD_REQUEST
	),
	
	
	EMAIL_NOT_VERIFIED
	(
			3330, 
			"Email Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	PHONE_NOT_VERIFIED
	(
			3350, 
			"Phone Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	USER_NOT_VERIFIED
	(
			3370, 
			"User Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	ACCOUNT_NOT_VERIFIED
	(
			3390, 
			"Account Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	NOT_FOUND
	(
			3410, 
			"Not Found", 
			HttpStatus.NOT_FOUND
	),
	
	ENTITY_NOT_FOUND
	(
			3430, 
			"Entity Not Found", 
			HttpStatus.NOT_FOUND
	),
	
	OBJECT_NOT_FOUND
	(
			3450, 
			"Object Not Found", 
			HttpStatus.NOT_FOUND
	),
	
	RESULT_NOT_FOUND
	(
			3470, 
			"Result Not Found", 
			HttpStatus.NOT_FOUND
	),
	
	RESULT_NOT_FOUND_FOR_QUERY
	(
			3490, 
			"Result Not Found For Query", 
			HttpStatus.NOT_FOUND
	),
	
	VALIDATION_EXCEPTION
	(
			3510, 
			"Validation Exception", 
			HttpStatus.BAD_REQUEST
	),
	
	ALREADY_EXISTS
	(
			3530, 
			"Already Exists", 
			HttpStatus.BAD_REQUEST
	),
	
	EXPIRED_EMAIL_OTP
	(
			3550, 
			"Expired Email OTP", 
			HttpStatus.BAD_REQUEST
	),
	
	EXPIRED_PHONE_OTP
	(
			3570, 
			"Expired Phone OTP", 
			HttpStatus.BAD_REQUEST
	),
	
	EXPIRED_OTP
	(
			3590, 
			"Expired OTP", 
			HttpStatus.BAD_REQUEST
	),
	
	INVALID_EMAIL_OTP
	(
			3610, 
			"Invalid Email OTP", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	INVALID_PHONE_OTP
	(
			3630, 
			"Invalid Phone OTP", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	INVALID_OTP
	(
			3650, 
			"Invalid OTP", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	EMAIL_AND_PHONE_NOT_VERIFIED
	(
			3670, 
			"Email And Phone Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	EMAIL_AND_PHONE_IN_USE
	(
			3690, 
			"Email And Phone In Use", 
			HttpStatus.BAD_REQUEST
	),
	
	MALFORMED_JSON_PAYLOAD
	(
			3710,
			"Malformed JSON Payload",
			HttpStatus.BAD_REQUEST
	),
	
	MALFORMED_REQUEST
	(
			3730,
			"Malformed Request",
			HttpStatus.BAD_REQUEST
	),
	
	MALFORMED_HEADER
	(
			3750,
			"Malformed Header",
			HttpStatus.BAD_REQUEST
	),
	
	MALFORMED_AUTHORIZATION
	(
			3770,
			"Malformed Authorization",
			HttpStatus.BAD_REQUEST
	),
	
	REQUIRED_REQUEST_URI_PARAMETER_MISSING
	(
			3790,
			"Required Request URI Parameter Missing",
			HttpStatus.BAD_REQUEST
	),
	
	
	NUMBER_FORMAT_EXCEPTION
	(
			3810,
			"Number Format Exception",
			HttpStatus.BAD_REQUEST
	),
	
	NAME_UNAVAILABLE
	(
			3830,
			"Name Unavailable",
			HttpStatus.BAD_REQUEST
	),
	
	
	SIGNED_STATE
	(
			3850,
			"Signed State",
			HttpStatus.BAD_REQUEST
	),
	
	
	ALREADY_APPROVED
	(
			3870, 
			"Already Approved", 
			HttpStatus.OK
	),
	
	ALREADY_REJECTED
	(
			3890, 
			"Already Rejected", 
			HttpStatus.OK
	),
	
	ALREADY_INVITED
	(
			3910, 
			"Already Invited", 
			HttpStatus.OK
	),
	
	ALREADY_INITIATED
	(
			3930, 
			"Already Initiated", 
			HttpStatus.OK
	),

	INSUFFICIENT_CREDIT
	(
			3950,
			"Insufficient Credit",
			HttpStatus.OK
	),
	
	/*
	 * Authentication Errors
	 */
	
	INVALID_JWT_TOKEN
	(
			4010, 
			"Invalid JWT Token", 
			HttpStatus.UNAUTHORIZED
	),
	
	INVALID_TOKEN
	(
			4030, 
			"Invalid Token", 
			HttpStatus.UNAUTHORIZED
	),
	
	TAMPERED_JWT_TOKEN
	(
			4050, 
			"Tampered JWT Token", 
			HttpStatus.UNAUTHORIZED
	),
	
	TAMPERED_TOKEN
	(
			4070, 
			"Tampered Token", 
			HttpStatus.UNAUTHORIZED
	),
	
	INVALID_KEY
	(
			4090, 
			"Invalid Key", 
			HttpStatus.UNAUTHORIZED
	),
	
	TAMPERED_KEY
	(
			4110, 
			"Tampered Key", 
			HttpStatus.UNAUTHORIZED
	),
	
	INVALID_PASSWORD
	(
			4130, 
			"Invalid Password", 
			HttpStatus.UNAUTHORIZED
	),
	
	INVALID_AUTHENTICATION
	(
			4150, 
			"Invalid Authentication", 
			HttpStatus.UNAUTHORIZED
	),
	
	INVALID_FINGERPRINT
	(
			4170, 
			"Invalid Fingerprint", 
			HttpStatus.UNAUTHORIZED
	),
	
	INVALID_FACE_RECOGNITION
	(
			4190, 
			"Invalid Face Recognition", 
			HttpStatus.UNAUTHORIZED
	),
	
	EXPIRED_JWT_TOKEN
	(
			4210, 
			"Expired JWT Token", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	EXPIRED_TOKEN
	(
			4230, 
			"Invalid Token", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	EXPIRED_KEY
	(
			4250, 
			"Expired Key", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	LOGIN_ATTEMPT_EXCEEDED
	(
			4270, 
			"Login Attempt Exceeded", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	LOGIN_DENIED
	(
			4290, 
			"Login Denied", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	AUTHORIZATION_SUSPENDED
	(
			4310, 
			"Authorization Suspended", 
			HttpStatus.NOT_ACCEPTABLE
	),

	
	/*
	 * Server Error 
	 */
	
	INTERNAL_DISPUTE
	(
			5010, 
			"Internal Dispute", 
			HttpStatus.INTERNAL_SERVER_ERROR
	),
	
	CONNECTION_ERROR
	(
			5030, 
			"Connection error", 
			HttpStatus.INTERNAL_SERVER_ERROR
	),
	
	CONFLICT
	(
			5050, 
			"Conflict", 
			HttpStatus.CONFLICT
	),
	
	MAIL_SENT_ERROR
	(
			5070, 
			"Mail Sent Error", 
			HttpStatus.SERVICE_UNAVAILABLE
	),
	
	NO_UNIQUE_RESULT
	(
			5090, 
			"No Unique Result", 
			HttpStatus.CONFLICT
	),
	
	OTP_EMAIL_SENT_ERROR
	(
			5110, 
			"OTP Email Sent Error", 
			HttpStatus.SERVICE_UNAVAILABLE
	),
	
	OTP_PHONE_SENT_ERROR
	(
			5130, 
			"OTP Phone Sent Error", 
			HttpStatus.SERVICE_UNAVAILABLE
	),
	
	OTP_SENT_ERROR
	(
			5150, 
			"OTP Sent Error", 
			HttpStatus.SERVICE_UNAVAILABLE
	),
	
	UPLOAD_FAILED
	(
			5170, 
			"Upload Failed", 
			HttpStatus.INTERNAL_SERVER_ERROR
	),
	
	SERVER_ERROR
	(
			5190, 
			"Server Error", 
			HttpStatus.INTERNAL_SERVER_ERROR
	),
	
	
	TOKEN_GENERATE_ERROR
	(
			5210,
			"Token Generate Error",
			HttpStatus.INTERNAL_SERVER_ERROR
	)
	
	;
	
	
	private final int value;
	private final String reasonPhrase;
	private final HttpStatus httpStatus;

	ServiceResponse(int value, String reasonPhrase, HttpStatus httpStatus) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
		this.httpStatus = httpStatus;
	}


	/**
	 * Return the integer value of this status code.
	 * @return value of status code
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Return the reason phrase of this status code.
	 * @return reason phrase of status code
	 */
	public String getReasonPhrase() {
		return this.reasonPhrase;
	}
	
	/**
	 * Return the HttpStatus of this status code.
	 * @return Http status
	 */
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
	
	/**
	 * Return a string representation of this status code.
	 * @return String representation
	 */
	@Override
	public String toString() {
		return this.value + " " + name();
	}
	
	
	/**
	 * Call the @see StateServiceBuilder 
	 * build() method
	 * and returns the @see StateServiceResponse 
	 * object.
	 * 
	 * @return status @see HttpStatus 
	 * and 
	 * @see ServiceResponse
	 * for 
	 * @see StateServiceResponse
	 */
	public StateServiceResponse build() {
		return new StateServiceResponseBuilder().build(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()));
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns the @see ResponseEntity 
	 * object.
	 * 
	 * @return status @see HttpStatus 
	 * and 
	 * @see ServiceResponse
	 */
	public ResponseEntity<?> buildResponse() {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()));
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns the 
	 * @see ResponseEntity 
	 * object.
	 * 
	 * @param message the response message
	 * @return status @see HttpStatus 
	 * @see ServiceResponse
	 * and @see String message 
	 * for @see StateServiceResponse
	 */
	public ResponseEntity<?> buildResponse(String message) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				message);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns 
	 * @see ResponseEntity 
	 * object.
	 * 
	 * @param objectAsResponse the object for response building
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see Object objectAsResponse 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(Object objectAsResponse) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				objectAsResponse
				);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns 
	 * @see ResponseEntity 
	 * object.
	 * 
	 * @param objectAsResponse the object for response building
	 * @param message the response message
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see Object objectAsResponse 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(Object objectAsResponse, String message) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				objectAsResponse,
				message);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns the @see ResponseEntity 
	 * object.
	 * 
	 * @param fileUploadResponse	FileUploadResponse
	 * @param message				the response message
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see FileUploadResponse 
	 * and @see String message 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(List<FileUploadResponse> fileUploadResponse, String message) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				fileUploadResponse,
				message);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns @see ResponseEntity 
	 * object.
	 * 
	 * @param fileUploadResponse	FileUploadResponse
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse and
	 * @see FileUploadResponse 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(List<FileUploadResponse> fileUploadResponse) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				fileUploadResponse);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns @see ResponseEntity 
	 * object.
	 * 
	 * @param fileUploadResponse	FileUploadResponse
	 * @param objectAsResponse		Object for response building
	 * @param message				the response message
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see FileUploadResponse
	 * @see Object objectAsResponse 
	 * @see String message for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(List<FileUploadResponse> fileUploadResponse, Object objectAsResponse, String message) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				fileUploadResponse,
				objectAsResponse,
				message);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns the 
	 * @see ResponseEntity 
	 * object.
	 * 
	 * @param fileUploadResponse	FileUploadResponse
	 * @param objectAsResponse		Object for response building
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see FileUploadResponse
	 * and @see Object objectAsResponse 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(List<FileUploadResponse> fileUploadResponse, Object objectAsResponse) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				fileUploadResponse,
				objectAsResponse);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns @see ResponseEntity 
	 * object.
	 * 
	 * @param messageStatusResponse	MessageStatusResponse
	 * @param message				the response message
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see MessageStatusResponse and
	 * @see String message 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(MessageStatusResponse messageStatusResponse, String message) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				messageStatusResponse,
				message);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns the @see ResponseEntity 
	 * object.
	 * 
	 * @param messageStatusResponse		MessageStatusResponse
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * and @see MessageStatusResponse 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(MessageStatusResponse messageStatusResponse) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				messageStatusResponse);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns the @see ResponseEntity 
	 * object.
	 * 
	 * @param messageStatusResponse		MessageStatusResponse
	 * @param objectAsResponse			Object for response building
	 * @param message					the response message
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see MessageStatusResponse
	 * @see Object objectAsResponse and @see String message 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(MessageStatusResponse messageStatusResponse, Object objectAsResponse, String message) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				messageStatusResponse,
				objectAsResponse,
				message);
	}
	
	/**
	 * Call the @see StateServiceBuilder 
	 * buildResponse() method
	 * and returns the @see ResponseEntity 
	 * object.
	 * 
	 * @param messageStatusResponse		MessageStatusResponse
	 * @param objectAsResponse			Object for response building
	 * 
	 * @return status @see HttpStatus
	 * @see ServiceResponse
	 * @see FileUploadResponse
	 * and @see Object objectAsResponse 
	 * for 
	 * @see ResponseEntity
	 */
	public ResponseEntity<?> buildResponse(MessageStatusResponse messageStatusResponse, Object objectAsResponse) {
		return new StateServiceResponseBuilder().buildResponse(
				this.getHttpStatus(), 
				ServiceResponse.valueOf(this.name()),
				messageStatusResponse,
				objectAsResponse);
	}
	
	
	
	
	/**
	 * Return the enum constant of this type with the specified numeric value.
	 * @param serviceResponse the numeric value of the enum to be returned
	 * @return ServiceResponse the enum constant with the specified numeric value
	 * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
	 */
	public static ServiceResponse valueOf(int serviceResponse) {
		ServiceResponse serviceResponseStatus = resolve(serviceResponse);
		if (serviceResponseStatus == null) {
			throw new IllegalArgumentException("No matching constant for [" + serviceResponse + "]");
		}
		return serviceResponseStatus;
	}

	/**
	 * Resolve the given Service Response code to an @see ServiceResponse, if possible.
	 * @param serviceResponseCode the service response code @see ServiceResponse code (potentially non-standard)
	 * @return the corresponding @see ServiceResponse or null if not found
	 */
	@Nullable
	public static ServiceResponse resolve(int serviceResponseCode) {
		for (ServiceResponse serviceResponse : values()) {
			if (serviceResponse.value == serviceResponseCode) {
				return serviceResponse;
			}
		}
		return null;
	}
	
}