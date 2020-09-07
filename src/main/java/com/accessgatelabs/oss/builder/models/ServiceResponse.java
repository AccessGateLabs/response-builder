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
	
	CREATED
	(
			1000, 
			"Created", 
			HttpStatus.CREATED
	),
	
	UPLOADED
	(
			1001, 
			"Uploaded", 
			HttpStatus.ACCEPTED
	),
	
	UPDATED
	(
			1003, 
			"Updated", 
			HttpStatus.ACCEPTED
	),
	
	JWT_TOKEN_INITIALIZED
	(
			1004, 
			"Jwt Token Initialized", 
			HttpStatus.ACCEPTED
	),
	
	MAIL_SENT
	(
			1005, 
			"Mail Sent", 
			HttpStatus.OK
	),
	
	FETCHED
	(
			1006, 
			"Fetched", 
			HttpStatus.OK
	),
	
	OTP_SMS_SENT
	(
			1007, 
			"OTP SMS Sent", 
			HttpStatus.OK
	),
	
	
	LOGGED_IN
	(
			1008,
			"Logged In",
			HttpStatus.OK
	),
	
	
	VERIFIED
	(
			2000, 
			"Verified", 
			HttpStatus.OK
	),
	
	ALREADY_VERIFIED
	(
			2001, 
			"Already Verified", 
			HttpStatus.OK
	),
	
	
	REMOVED
	(
			3000, 
			"Removed", 
			HttpStatus.OK
	),
	
	DELETED
	(
			3001, 
			"Deleted", 
			HttpStatus.OK
	),
	
	
	IN_PROCESS
	(
		3002,
		"In Process",
		HttpStatus.BAD_REQUEST
	),
	
	
	IN_PROGRESS
	(
		3003,
		"In Progress",
		HttpStatus.OK
	),
	
	
	INVALID_TOKEN
	(
			4000, 
			"Invalid Token", 
			HttpStatus.UNAUTHORIZED
	),
	
	EXPIRED_TOKEN
	(
			4002, 
			"Expired Token", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_SUCH_EMAIL
	(
			4005, 
			"No Such Email", 
			HttpStatus.BAD_REQUEST
	),
	
	EMAIL_IN_USE
	(
			4006, 
			"Email In Use", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	NO_ROLE_DEFINED
	(
			4007, 
			"No Role Defined", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	INVALID_PASSWORD
	(
			4008, 
			"Invalid Password", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	FILE_SIZE_EXCEEDED
	(
			4001, 
			"File Size Exceeded", 
			HttpStatus.BAD_REQUEST
	),
	
	NO_SUCH_USER
	(
			4003, 
			"No Such User", 
			HttpStatus.NO_CONTENT
	),
	
	NO_SUCH_USER_GROUP
	(
			4004, 
			"No Such User Group", 
			HttpStatus.NO_CONTENT
	),
	
	EMAIL_NOT_VERIFIED
	(
			4009, 
			"Email Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	ENTITY_NOT_FOUND
	(
			4014, 
			"Entity Not Found", 
			HttpStatus.NOT_FOUND
	),
	
	VALIDATION_EXCEPTION
	(
			4015, 
			"Validation Exception", 
			HttpStatus.BAD_REQUEST
	),
	
	ALREADY_EXISTS
	(
			4016, 
			"Already Exists", 
			HttpStatus.CONFLICT
	),
	
	CONTACT_NUMBER_NOT_VERIFIED
	(
			4017, 
			"Contact Number Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	EXPIRED_OTP
	(
			4018, 
			"Expired OTP", 
			HttpStatus.REQUEST_TIMEOUT
	),
	
	INVALID_OTP
	(
			4019, 
			"Invalid OTP", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	EMAIL_AND_CONTACT_NUMBER_NOT_VERIFIED
	(
			4021, 
			"Email And Contact Number Not Verified", 
			HttpStatus.BAD_REQUEST
	),
	
	CONTACT_NUMBER_IN_USE
	(
			4022, 
			"Contact Number In Use", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	EMAIL_AND_CONTACT_NUMBER_IN_USE
	(
			4023, 
			"Email And Contact Number In Use", 
			HttpStatus.NOT_ACCEPTABLE
	),
	
	OBJECT_NOT_FOUND
	(
			4024, 
			"Object Not Found", 
			HttpStatus.NOT_FOUND
	),
	
	ORGANIZATION_NOT_FOUND
	(
			4025, 
			"Organization Not Found", 
			HttpStatus.NOT_FOUND
	),
	
	MALFORMED_JSON_PAYLOAD
	(
			4026,
			"Malformed JSON Payload",
			HttpStatus.BAD_REQUEST
	),
	
	REQUIRED_REQUEST_URI_PARAMETER_MISSING
	(
			4027,
			"Required Request URI Parameter Missing",
			HttpStatus.BAD_REQUEST
	),
	
	
	NUMBER_FORMAT_EXCEPTION
	(
			4028,
			"Number Format Exception",
			HttpStatus.BAD_REQUEST
	),
	
	NAME_UNAVAILABLE
	(
			4029,
			"Name Unavailable",
			HttpStatus.BAD_REQUEST
	),
	
	
	SIGNED_STATE
	(
			4030,
			"Signed State",
			HttpStatus.BAD_REQUEST
	),
	
	
	INVALID_LOGIN_REQUEST
	(
			4031,
			"Invalid Login Request",
			HttpStatus.BAD_REQUEST
	),
	
	ALREADY_APPROVED
	(
			4032, 
			"Already Approved", 
			HttpStatus.OK
	),
	
	ALREADY_REJECTED
	(
			4033, 
			"Already Rejected", 
			HttpStatus.OK
	),
	
	ALREADY_INVITED
	(
			4034, 
			"Already Invited", 
			HttpStatus.OK
	),
	
	ALREADY_INITIATED
	(
			4035, 
			"Already Initiated", 
			HttpStatus.OK
	),

	INSUFFICIENT_CREDIT
	(
			4036,
			"Insufficient Credit"
	),

	
	INTERNAL_CONNECTION_DISPUTE
	(
			5005, 
			"Internal Connection Dispute", 
			HttpStatus.INTERNAL_SERVER_ERROR
	),
	
	CLOUD_CONNECTION_ERROR
	(
			5006, 
			"Cloud Connection error", 
			HttpStatus.INTERNAL_SERVER_ERROR
	),
	
	CONFLICT
	(
			5007, 
			"Conflict", 
			HttpStatus.CONFLICT
	),
	
	NO_VALID_AUTHORIZATION
	(
			5008, 
			"No Valid Authorization", 
			HttpStatus.UNAUTHORIZED
	),
	
	MAIL_SEND_ERROR
	(
			5009, 
			"Mail Sent Error", 
			HttpStatus.SERVICE_UNAVAILABLE
	),
	
	NO_UNIQUE_RESULT
	(
			5010, 
			"No Unique Result", 
			HttpStatus.CONFLICT
	),
	
	OTP_SMS_SEND_ERROR
	(
			5011, 
			"OTP SMS Send Error", 
			HttpStatus.SERVICE_UNAVAILABLE
	),
	
	UPLOAD_FAILED
	(
			5012, 
			"Upload Failed", 
			HttpStatus.BAD_GATEWAY
	),
	
	SERVER_ERROR
	(
			5013, 
			"Server Error", 
			HttpStatus.INTERNAL_SERVER_ERROR
	),
	
	
	TOKEN_GENERATE_ERROR
	(
			5014,
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