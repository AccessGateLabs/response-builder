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


/**
 * A base class for building standard Responses.
 * 
 * @author Ekansh Tiwari
 * @version 1.0.0
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
public class StateServiceResponseBuilder {
	
	/**
	 * Methods to Build standard Responses, a combination of
	 * @see HttpStatus, @see ServiceResponse and other parameters. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param fileUploadResponse @see FileUploadResponse
	 * @param message @see String
	 * @param ex @see Throwable
	 * 
	 *  @return an object of @see StateServiceResponse 
	 */
    
    
    /**
	 * Methods to Build @see StateServiceResponse 
	 * with
	 * @see HttpStatus @see ServiceResponse and @see String message. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param message @see String
	 * 
	 * @return an object of @see StateServiceResponse containing
	 * @see HttpResponse @see ApiServiceResponse and @see String message. 
	 */
    public StateServiceResponse build(HttpStatus httpStatus, ServiceResponse serviceResponse, String message) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), message);
    	return response;
    }
    
    /**
	 * Methods to Build @see StateServiceResponse, 
	 * with
	 * @see HttpStatus and @see ServiceResponse. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * 
	 *  @return an object of @see StateServiceResponse containing
	 *  @see HttpResponse and @see ApiServiceResponse. 
	 */
    public StateServiceResponse build(HttpStatus httpStatus, ServiceResponse serviceResponse) {
    	int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse));
    	return response;
    }
    
    /**
	 * Methods to Build @see StateServiceResponse 
	 * with
	 * @see HttpStatus and @see ServiceResponse @see FileUploadResponse and 
	 * @see String message. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param fileUploadResponse List<FileUploadResponse> @see FileUploadResponse
	 * @param message @see String
	 * 
	 *  @return an object of @see StateServiceResponse containing
	 *  @see HttpResponse @see ApiServiceResponse @see FileUploadResponse and 
	 *  @see String message. 
	 */
    public StateServiceResponse build(HttpStatus httpStatus, ServiceResponse serviceResponse, 
    		List<FileUploadResponse> fileUploadResponse, String message) {
    	int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), fileUploadResponse, message);
    	return response;
    }
    
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param fileUploadResponse @see List<FileUploadResponse>
	 * @param ex @see Throwable
	 * @param message @see String
	 * 
	 *  @return type @see ResponseEntity
	 *   
	 */
    
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus and @see ServiceResponse.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse));
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param message @see String
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus and @see ServiceResponse and String message.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse, String message) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), message);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param message @see String
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus, @see ServiceResponse, @see Object as response and @see String message.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse, Object objectAsResponse, String message) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), objectAsResponse, message);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param objectAsResponse @see Object
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus, @see ServiceResponse and @see Object as response.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse, Object objectAsResponse) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), objectAsResponse);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an @see Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param fileUploadResponse List<FileUploadResponse> @see FileUploadResponse
	 * @param objectAsResponse @see Object
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus @see ServiceResponse @see FileUploadResponse and @see Object as response.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse,
    		List<FileUploadResponse> fileUploadResponse, Object objectAsResponse) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), fileUploadResponse, objectAsResponse);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param fileUploadResponse List<FileUploadResponse> @see FileUploadResponse
	 * @param objectAsResponse @see Object
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus @see ServiceResponse @see FileUploadResponse @see Object 
	 *  and @see String message as response.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse,
    		List<FileUploadResponse> fileUploadResponse, Object objectAsResponse, String message) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), fileUploadResponse, objectAsResponse, message);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param fileUploadResponse List<FileUploadResponse> @see FileUploadResponse
	 * @param message @see String
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus @see ServiceResponse @see FileUploadResponse and @see String message.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse, 
    		List<FileUploadResponse> fileUploadResponse, String message) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), fileUploadResponse, message);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param fileUploadResponse List<FileUploadResponse> @see FileUploadResponse
	 * @param ex @see Throwable
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus, @see ServiceResponse and @exception Exception localized message.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse, 
    		List<FileUploadResponse> fileUploadResponse, Throwable ex) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), fileUploadResponse, ex.getLocalizedMessage());
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param messageStatusResponse @see MessageStatusResponse
	 * @param objectAsResponse @see Object
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus, @see ServiceResponse, @see MessageStatusResponse and @see Object as response.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse,
    		MessageStatusResponse messageStatusResponse, Object objectAsResponse) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), messageStatusResponse, objectAsResponse);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param messageStatusResponse @see MessageStatusResponse
	 * @param serviceResponse @see ServiceResponse
	 * @param objectAsResponse @see Object
	 * @param message @see String
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus, @see ServiceResponse, @see MessageStatusResponse, @see Object 
	 *  and @see String message as response.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse,
    		MessageStatusResponse messageStatusResponse, Object objectAsResponse, String message) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), messageStatusResponse, objectAsResponse, message);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param messageStatusResponse @see MessageStatusResponse
	 * @param message @see String
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus, @see ServiceResponse, @see MessageStatusResponse and @see String message.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse, 
    		MessageStatusResponse messageStatusResponse, String message) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), messageStatusResponse, message);
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
    
    /**
	 * Methods to Build and Return @see StateServiceResponse as an Object
	 * wrapped in a @see ResponseEntity body
	 * along with standard @see HttpStatus status. 
	 * 
	 * @param httpStatus @see HttpStatus
	 * @param serviceResponse @see ServiceResponse
	 * @param messageStatusResponse @see MessageStatusResponse
	 * @param ex @see Throwable
	 * 
	 *  @return an object of @see ResponseEntity containing
	 *  an object of @see HttpStatus, @see ServiceResponse and @exception Exception localized message.
	 *   
	 */
    public ResponseEntity<?> buildResponse(HttpStatus httpStatus, ServiceResponse serviceResponse, 
    		MessageStatusResponse messageStatusResponse, Throwable ex) {
		int serviceResponseValue = serviceResponse.value();
    	StateServiceResponse response = new StateServiceResponse(new ApiServiceResponse(serviceResponseValue, serviceResponse), messageStatusResponse, ex.getLocalizedMessage());
    	return ResponseEntity.status(httpStatus).body(response);
    }
    
	
}
