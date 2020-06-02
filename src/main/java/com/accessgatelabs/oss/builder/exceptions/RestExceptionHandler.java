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

package com.accessgatelabs.oss.builder.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accessgatelabs.oss.builder.models.ApiServiceResponse;
import com.accessgatelabs.oss.builder.models.ExceptionResponseBuilder;
import com.accessgatelabs.oss.builder.models.HttpResponse;
import com.accessgatelabs.oss.builder.models.ServiceResponse;
import com.accessgatelabs.oss.builder.models.StateServiceResponse;
import com.accessgatelabs.oss.builder.models.ViolationType;

import lombok.extern.slf4j.Slf4j;

/**
 * A base class for @see ControllerAdvice
 * that provides centralized exception handling across all
 * RequestMapping methods through ExceptionHandler methods.
 *
 * <p>
 * 		This class provides ExceptionHandler methods for handling
 * 		multiple exceptions. This method returns a @see StateServiceResponse
 * 		for writing to the response with a @see HttpResponse.
 * </p>
 *
 * <p>
 * 		Note that in order for a controller or method to call this base class,  
 * 		a class/interface must be called to extends this base class,
 * 		annotated with @see ControllerAdvice indicating base package 
 * 		or controller address.
 * </p>
 *
 * @author Ekansh Tiwari
 * @version 1.0.0
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
@Validated
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	/**
     * Handle MissingServletRequestParameterException. Triggered when a 'required' request parameter is missing.
     *
     * @param ex		Request Parameter exception		@see MissingServletRequestParameterException
     * @param headers 	HttpHeader  @see HttpHeaders
     * @param status	HttpStatus  @see HttpStatus
     * @param request	Request		@see WebRequest
     * @return			StateServiceResponse Object @see StateServiceResponse
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
    	String error = ex.getParameterName() + " parameter is missing";
    	
    	StateServiceResponse stateServiceResponse = new StateServiceResponse(new HttpResponse(status.value(), BAD_REQUEST));
        stateServiceResponse.setMessage(error);
        stateServiceResponse.setPath(uriPath(request));
        
        stateServiceResponse.setExceptionResponseBuilder(
        		new ExceptionResponseBuilder(
        				null, ex.getParameterName(), null, ViolationType.Missing_Key, ex.getParameterType(), "PARAMETER", ex.getMessage()));
        
        stateServiceResponse.setApiServiceResponse(
        		new ApiServiceResponse(ServiceResponse.REQUIRED_REQUEST_URI_PARAMETER_MISSING.value(), 
        				ServiceResponse.REQUIRED_REQUEST_URI_PARAMETER_MISSING));
        
        return buildResponseEntity(stateServiceResponse);
    }
    
    
    
    
    
    /**
     * Handle Standard Servlet Multipart. Triggered when a multipart exception is generated.
     *
     * @param ex	Multipart exception		@see MultipartException
     * @param redirectAttributes	RedirectAttributes 			@see RedirectAttributes
     * @return StateServiceResponse			@see StateServiceResponse object
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(MultipartException.class)
    public ResponseEntity<?> multipartException(MultipartException ex, RedirectAttributes redirectAttributes) {
    	return new ResponseEntity(
    			new StateServiceResponse(ex.getMostSpecificCause()), HttpStatus.BAD_REQUEST);
    }
    
    
    
    
    /**
     * Handle Common Servlet Multipart. Triggered when a 'Maximum Upload size exceed' exception is generated.
     *
     * @param ex	MaxUploadExceededException	@see MaxUploadExceededException
     * @param redirectAttributes	RedirectAttributes 				@see RedirectAttributes
     * @return StateServiceResponse	Object		@see StateServiceResponse
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<?> maxUploadSizeExceededException(MaxUploadSizeExceededException ex, RedirectAttributes redirectAttributes) {
	    return new ResponseEntity(new StateServiceResponse(
	    		"Multipart file size exceeded the length", ex.getMostSpecificCause()), 
	    		HttpStatus.BAD_REQUEST);
    }
    
    
    
    
    /**
     * Handle org.springframework.security.access.AccessDeniedException. Triggered when an 'unauthorized' call is performed.
     *
     * @param ex	AccessDeniedException	@see AccessDeniedException
     * @param request	HttpServletRequest						@see HttpServletRequest
     * @param response 	HttpServletResponse						@see HttpServletResponse
     * @return StateServiceResponse Object	@see StateServiceResponse
     * @throws IOException	If an input or output exception occurred
     * @throws ServletException	If servlet exception occurred
     */
    @ExceptionHandler(value = { AccessDeniedException.class })
    public ResponseEntity<?> handleAccessDeniedException(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException ex) throws IOException, ServletException {
    	StateServiceResponse stateServiceResponse = new StateServiceResponse(
    			new ApiServiceResponse(ServiceResponse.NO_VALID_AUTHORIZATION.value(), ServiceResponse.NO_VALID_AUTHORIZATION), 
	    		"Not authorized to access this call");
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(stateServiceResponse);
    	
    }
    
    
    
    
    /**
     * Handle @exception HttpMediaTypeNotSupportedException. This one triggers when JSON is invalid as well.
     *
     * @param ex	HttpMediaTypeNotSupportedException	@see HttpMediaTypeNotSupportedException
     * @param headers	HttpHeaders 									@see HttpHeaders
     * @param status  	HttpStatus								@see HttpStatus
     * @param request 	WebRequest								@see WebRequest
     * @return StateServiceResponse object 				@see StateServiceResponse
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
        return buildResponseEntity(new StateServiceResponse(
        		builder.substring(0, builder.length() - 2), ex));
    }
    
    
    
    
    /**
     * Handle @see MethodArgumentNotValidException. Triggered when an object fails validation.
     *
     * @param ex      the @see MethodArgumentNotValidException that is thrown when validation fails
     * @param headers	HttpHeaders @see HttpHeaders
     * @param status	HttpStatus  @see HttpStatus
     * @param request	WebRequest @see WebRequest
     * @return StateServiceResponse Object @see StateServiceResponse object
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
    	
    	StateServiceResponse stateServiceResponse = new StateServiceResponse(new HttpResponse(status.value(), BAD_REQUEST));
        stateServiceResponse.setMessage("Validation error");
        stateServiceResponse.addValidationExceptions(ex.getBindingResult().getFieldErrors());
        stateServiceResponse.setErrorCount(ex.getBindingResult().getErrorCount());
        stateServiceResponse.setPath(uriPath(request));
        stateServiceResponse.setApiServiceResponse(
        		new ApiServiceResponse(ServiceResponse.VALIDATION_EXCEPTION.value(), ServiceResponse.VALIDATION_EXCEPTION));
        
        return buildResponseEntity(stateServiceResponse);
    }
    
    
    
    
   /**
     * Handles @see EntityNotFoundException. Created to encapsulate errors with more detail than javax.persistence.EntityNotFoundException.
     *
     * @param ex	EntityNotFoundException	@see EntityNotFoundException
     * @return StateServiceResponse Object 	@see StateServiceResponse
     */
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
    	StateServiceResponse stateServiceResponse = new StateServiceResponse(
    			new ApiServiceResponse(ServiceResponse.ENTITY_NOT_FOUND.value(), ServiceResponse.ENTITY_NOT_FOUND));
        stateServiceResponse.setMessage(ex.getMessage());
        return buildResponseEntity(stateServiceResponse);
    }
    
    
    
    
    /**
     * Handle @see HttpMessageNotReadableException. Happens when request JSON is malformed.
     *
     * @param ex	HttpMessageNotReadableException	@see HttpMessageNotReadableException
     * @param headers	HttpHeaders @see HttpHeaders
     * @param status	HttpStatus  @see HttpStatus
     * @param request	WebRequest	@see WebRequest
     * @return StateServiceResponse Object @see StateServiceResponse
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        log.info("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
        StateServiceResponse stateServiceResponse = new StateServiceResponse(new HttpResponse(status.value(), BAD_REQUEST));
        stateServiceResponse.setMessage(ex.getMostSpecificCause().getMessage());
        stateServiceResponse.setPath(uriPath(request));
        
        stateServiceResponse.setApiServiceResponse(
        		new ApiServiceResponse(ServiceResponse.MALFORMED_JSON_PAYLOAD.value(), ServiceResponse.MALFORMED_JSON_PAYLOAD));
        return buildResponseEntity(stateServiceResponse);
    }
    
    
    
    
    /**
     * Handle @see HttpMessageNotWritableException.
     *
     * @param ex	HttpMessageNotWritableException	@see HttpMessageNotWritableException
     * @param headers	HttpHeaders @see HttpHeaders
     * @param status	HttpStatus  @see HttpStatus
     * @param request	WebRequest @see WebRequest
     * @return StateServiceResponse Object @see StateServiceResponse
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Error writing JSON output";
        return buildResponseEntity(
        		new StateServiceResponse(
        				error, ex));
    }
    
    
    
    
    /**
     * Handle @see NoHandlerFoundException.
     *
     * @param ex	NoHandlerFoundException @see NoHandlerFoundException
     * @param headers	HttpHeaders @see HttpHeaders
     * @param status	HttpStatus @see HttpStatus
     * @param request	WebRequest @see WebRequest
     * @return StateServiceResponse Object @see StateServiceResponse
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	StateServiceResponse stateServiceResponse = new StateServiceResponse(new HttpResponse(status.value(), BAD_REQUEST));
        stateServiceResponse.setMessage(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));
        stateServiceResponse.setDebugMessage(ex.getMessage());
        return buildResponseEntity(stateServiceResponse);
    }
    
    
    
    
    /**
     * Handle Exception, handle generic Exception.class
     *
     * @param ex Exception @see Exception
     * @param request	WebRequest @see WebRequest
     * @return StateServiceResponse Object @see StateServiceResponse
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                      WebRequest request) {
    	StateServiceResponse stateServiceResponse = new StateServiceResponse(new HttpResponse(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST));
        stateServiceResponse.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
        stateServiceResponse.setDebugMessage(ex.getMessage());
        return buildResponseEntity(stateServiceResponse);
    }
    
    
    /**
     * Returns the path of the request @see URI 
     *
     * @param webRequest	WebRequest @see WebRequest
     * @return path URI path @see String
     */
    public static String uriPath(WebRequest webRequest) {
    	String path = webRequest.getContextPath() + (String) webRequest.getAttribute(
    	        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE, 0);
    	return path;
    }
    
    
    /**
     * Build the Response Entity Object
     *
     * @param stateServiceResponse	StateServiceResponse @see StateServiceResponse
     * @return 	an Object of @see ResponseEntity
     */
    public static ResponseEntity<Object> buildResponseEntity(StateServiceResponse stateServiceResponse) {
    	return new ResponseEntity<>(stateServiceResponse, stateServiceResponse.getHttpResponse().getStatus());
    }
    
}
