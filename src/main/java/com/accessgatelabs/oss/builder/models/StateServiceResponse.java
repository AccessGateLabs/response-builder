package com.accessgatelabs.oss.builder.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import com.accessgatelabs.oss.builder.exceptions.LowerCamelCaseClassNameResolver;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

import lombok.Getter;
import lombok.Setter;

/**
 * A base class for building service responses based on exceptions.
 * 
 * <p>
 * 		This class constructs custom responses upon calling other sub classes.
 *</p>
 *
 * <p>
 * 		The constructors can be modified for usages.
 * </p>
 *
 * @author Ekansh Tiwari
 * @version 1.0.0
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
@Getter
@Setter
@JsonTypeInfo(include = JsonTypeInfo.As.EXISTING_PROPERTY, use = JsonTypeInfo.Id.NAME, visible = true)
@JsonTypeIdResolver(LowerCamelCaseClassNameResolver.class)
@JsonPropertyOrder({ "timestamp", "message", "errorCount", "path", "apiServiceResponse" })
public class StateServiceResponse {
	
	@JsonProperty("http")
	private HttpResponse httpResponse;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    
	private String path;
	
	@JsonProperty("api")
	private ApiServiceResponse apiServiceResponse;
    
	private String message;
	
	private Integer errorCount;
    
	private String debugMessage;
    
	@JsonProperty("exceptions")
	private List<ApiSubError> subErrors;
    
	@JsonProperty("object")
	private Object objectAsResponse;
	
	@JsonProperty("fileResponse")
	private List<FileUploadResponse> fileUploadResponse;
	
	@JsonProperty("messageResponse")
	private MessageStatusResponse messageStatusResponse;
	
	
	@JsonProperty("exception")
	private ExceptionResponseBuilder exceptionResponseBuilder;
	
	
	/**
	 * Constructor for initializing @see LocalDateTime
	 * @see LocalDateTime is returned on every response by default. 
	 *
	 */
	private StateServiceResponse() {
        timestamp = LocalDateTime.now();
    }
    
	
	/**
	 * Constructor for initializing @see HttpResponse
	 * @see HttpResponse is returned as a subset on every call. 
	 * 
	 * @param httpResponse	HttpResponse
	 *
	 */
    public StateServiceResponse(HttpResponse httpResponse) {
        this();
        this.httpResponse = httpResponse;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse and @see ApiServiceResponse
	 * @see ApiServiceResponse returns an object of API response status along with code.
	 * 
	 * Refer @see ServiceResponse for list of API response status and codes.
	 * Note that @see ApiServiceResponse is returned on every call.
	 * 
	 * @param apiServiceResponse ApiServiceResponse
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse) {
        this();
        this.apiServiceResponse = apiServiceResponse;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and @see FileUploadResponse
	 * @see FileUploadResponse returns an object containing details of file and status of upload.
	 * 
	 * Refer @see FileUploadResponse for return values.
	 * Note that @see FileUploadResponse is returned on specific calls related to File Upload.
	 * 
	 * @param apiServiceResponse	APIServiceResponse
	 * @param fileUploadResponse	FileUploadResponse
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		List<FileUploadResponse> fileUploadResponse) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.fileUploadResponse = fileUploadResponse;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, 
	 * @see FileUploadResponse and @see Throwable
	 * 
	 * @see FileUploadResponse returns an object containing details of file and status of upload.
	 * 
	 * Refer @see FileUploadResponse for return values.
	 * 
	 * @param apiServiceResponse	APIServiceResponse
	 * @param fileUploadResponse	List of FileUploadResponse
	 * @param ex	Exception
	 * 
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		List<FileUploadResponse> fileUploadResponse, Throwable ex) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.fileUploadResponse = fileUploadResponse;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and @see MessageStatusResponse
	 * @see MessageStatusResponse returns an object containing details of message that is sent.
	 * 
	 * Refer @see MessageStatusResponse for return values.
	 * Note that @see MessageStatusResponse is returned on specific calls related to SMS/Email triggering.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param messageStatusResponse		MessageStatusResponse
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		MessageStatusResponse messageStatusResponse) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.messageStatusResponse = messageStatusResponse;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, 
	 * @see MessageStatusResponse and @see Throwable
	 * 
	 * @see FileUploadResponse returns an object containing details of message that is sent.
	 * 
	 * Refer @see MessageStatusResponse for return values.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param messageStatusResponse		MessageStatusResponse
	 * @param ex Exception
	 * 
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		MessageStatusResponse messageStatusResponse, Throwable ex) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.messageStatusResponse = messageStatusResponse;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and @see ExceptionResponseBuilder
	 * @see ExceptionResponseBuilder builds and returns an object when exceptions are generated.
	 * 
	 * Refer @see ExceptionResponseBuilder for return values and super class details.
	 * Note that @see ExceptionResponseBuilder is returned on specific calls upon triggering of exceptions.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param exceptionResponseBuilder	ExceptionResponseBuilder
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		ExceptionResponseBuilder exceptionResponseBuilder) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.exceptionResponseBuilder = exceptionResponseBuilder;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse and @see Throwable
	 * 
	 * Applicable for exceptions
	 * 
	 * @param ex	Exception
	 */
    public StateServiceResponse(Throwable ex) {
        this();
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and @see Throwable
	 * 
	 * Applicable for exceptions
	 * 
	 * @param apiServiceResponse	APIServiceResponse
	 * @param ex					Exception
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, Throwable ex) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    /**
	 * Constructor for initializing @see HttpResponse and @see String message
	 * 
	 * Called when a message along with HttpResponse is passed to the @see StateServiceResponse
	 * 
	 * @param message	the response message
	 */
    public StateServiceResponse(String message) {
        this();
        this.message = message;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and @see String path
	 * 'path' is the URI of API call. 
	 * 
	 * Called when path along with @see HttpResponse and message is passed to the @see StateServiceResponse
	 * 
	 * @param message	the response message
	 * @param path		the URI path
	 */
    public StateServiceResponse(String message, String path) {
        this();
        this.message = message;
        this.path = path;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and @see Integer errorCount
	 * 'errorCount' indicates the total number of errors encountered on a specific API call.
	 * 
	 * Note that this is called when error count is passed along with @see HttpResponse and message
	 * 
	 * @param message		the response message
	 * @param errorCount	the error counts
	 */
    public StateServiceResponse(String message, Integer errorCount) {
        this();
        this.message = message;
        this.errorCount = errorCount;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see Integer errorCount
	 * and @see String path
	 * 
	 * Note that this is called when @see HttpResponse, message, errorCount and @see URI path get passed.
	 * 
	 * @param message		the response message
	 * @param errorCount	the error counts
	 * @param path			the URI path
	 */
    public StateServiceResponse(String message, Integer errorCount, String path) {
        this();
        this.message = message;
        this.errorCount = errorCount;
        this.path = path;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and @see String message.
	 *
	 * This constructor is called when @see HttpResponse, @see ApiServiceResponse and message is passed.
	 * 
	 * @param apiServiceResponse	APIServiceResponse
	 * @param message				the response message
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, String message) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.message = message;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see Object objectAsResponse
	 * and @see String message.
	 *
	 * This constructor is called when @see HttpResponse, @see ApiServiceResponse, @see Object objectAsResponse,
	 * and message is passed.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param objectAsResponse			Object for response
	 * @param message					the response message
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, Object objectAsResponse, String message) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.objectAsResponse = objectAsResponse;
        this.message = message;
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse and 
	 * @see Object objectAsResponse
	 *
	 * This constructor is called when @see HttpResponse, @see ApiServiceResponse 
	 * and @see Object objectAsResponse is passed.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param objectAsResponse			Object for response
	 * 
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, Object objectAsResponse) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.objectAsResponse = objectAsResponse;
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see FileUploadResponse,
	 * @see Object objectAsResponse and @see String message.
	 *
	 * This constructor is called when @see HttpResponse, @see ApiServiceResponse, @see FileUploadResponse,
	 * @see Object objectAsResponse and message is passed.
	 * 
	 * @param apiServiceResponse	APIServiceResponse
	 * @param fileUploadResponse	List of FileUploadResponse
	 * @param message				Response message
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse,
    		List<FileUploadResponse> fileUploadResponse, Object objectAsResponse, String message) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.fileUploadResponse = fileUploadResponse;
        this.objectAsResponse = objectAsResponse;
        this.message = message;
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see Object objectAsResponse
	 * and @see FileUploadResponse.
	 *
	 * This constructor is called when @see HttpResponse, @see ApiServiceResponse and 
	 * @see Object objectAsResponse is passed.
	 * 
	 * @param apiServiceResponse	APIServiceResponse
	 * @param fileUploadResponse	List of FileUploadResponse
	 * @param objectAsResponse		Actual response object
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse,
    		List<FileUploadResponse> fileUploadResponse, Object objectAsResponse) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.fileUploadResponse = fileUploadResponse;
        this.objectAsResponse = objectAsResponse;
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see FileUploadResponse
	 * and @see String message.
	 * 
	 * Refer @see FileUploadResponse for return values.
	 * Note that it is called when message along with @see FileUploadResponse is passed.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param fileUploadResponse		List of FileUploadResponse
	 * @param message					the response message
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		List<FileUploadResponse> fileUploadResponse, String message) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.fileUploadResponse = fileUploadResponse;
        this.message = message;
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see MessageStatusResponse,
	 * @see Object objectAsResponse and @see String message.
	 *
	 * This constructor is called when @see HttpResponse, @see ApiServiceResponse, @see MessageStatusResponse,
	 * @see Object objectAsResponse and message is passed.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param messageStatusResponse		MessageStatusResponse
	 * @param objectAsResponse			Object for response
	 * @param message					the response message	
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse,
    		MessageStatusResponse messageStatusResponse, Object objectAsResponse, String message) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.messageStatusResponse = messageStatusResponse;
        this.objectAsResponse = objectAsResponse;
        this.message = message;
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see Object objectAsResponse
	 * and @see MessageStatusResponse.
	 *
	 * This constructor is called when @see HttpResponse, @see ApiServiceResponse and 
	 * @see Object objectAsResponse is passed.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param messageStatusResponse		MessageStatusResponse
	 * @param objectAsResponse			Object for response
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse,
    		MessageStatusResponse messageStatusResponse, Object objectAsResponse) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.messageStatusResponse = messageStatusResponse;
        this.objectAsResponse = objectAsResponse;
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see MessageStatusResponse
	 * and @see String message.
	 * 
	 * Refer @see MessageStatusResponse for return values.
	 * Note that it is called when message along with @see MessageStatusResponse is passed.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param messageStatusResponse		MessageStatusResponse
	 * @param message					the response message
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		MessageStatusResponse messageStatusResponse, String message) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.messageStatusResponse = messageStatusResponse;
        this.message = message;
    }
    
    
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see String message and @see Throwable.
	 * 
	 * Note that it is called when exception gets passed along with
	 * @see String message and @see HttpResponse.
	 * 
	 * @param message		the response message
	 * @param ex			Exception
	 */
    public StateServiceResponse(String message, Throwable ex) {
        this();
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, 
	 * @see String message and @see Throwable.
	 * 
	 * Note that it is called when exception gets passed along with
	 * @see String message, @see ApiServiceResponse and @see HttpResponse.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param message					the response message
	 * @param ex						Exception
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		String message, Throwable ex) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    
    /**
	 * Constructor for initializing @see HttpResponse, @see ApiServiceResponse, @see FileUploadResponse,
	 * @see String message and @see Throwable.
	 * 
	 * Note that it is called when exception gets passed along with
	 * @see String message, @see FileUploadResponse, @see ApiServiceResponse and @see HttpResponse.
	 * 
	 * @param apiServiceResponse		APIServiceResponse
	 * @param fileUploadResponse		List of FileUploadResponse
	 * @param message					the response message
	 * @param ex						Exception
	 */
    public StateServiceResponse(ApiServiceResponse apiServiceResponse, 
    		List<FileUploadResponse> fileUploadResponse, String message, Throwable ex) {
        this();
        this.apiServiceResponse = apiServiceResponse;
        this.fileUploadResponse = fileUploadResponse;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    
    /**
	 * Adding Sub errors upon @see ValidationException
	 * 
	 * @param subError	an object of APISubError @see ApiSubError
	 */
    private void addSubError(ApiSubError subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }
    
    
    /**
	 * Method to construct @see ValidationException response.
	 * 
	 * @param keyLocation String
	 * @param key String
	 * @param rejectedValue Object
	 * @param violatedConstraint ViolationType
	 * @param keyDataType String
	 * @param violatedEntity String
	 * @param exceptionMessage String
	 * 
	 */
    private void constructValidationException(String keyLocation, String key, Object rejectedValue, 
    		ViolationType violatedConstraint, String keyDataType, String violatedEntity, String exceptionMessage) {
        addSubError(new ExceptionResponseBuilder(keyLocation, key, rejectedValue, violatedConstraint, keyDataType, 
        		violatedEntity, exceptionMessage));
    }
    
    /**
	 * Method to build @see ValidationException construct.
	 * @param fieldError @see FieldError
	 * 
	 * Constructs keyLocation, rejectedValue, fieldErrorCode, violationType, keyDataType and exceptionMessage
	 * from @see FieldError object.
	 * 
	 * @param fieldError	an object of FieldError
	 */
    private void buildValidationExceptions(FieldError fieldError) {
    	String keyLocation = fieldError.getObjectName() + "." + fieldError.getField();
    	String key = fieldError.getField();
    	Object rejectedValue = fieldError.getRejectedValue();
    	String fieldErrorCode = fieldError.getCode();
    	
    	ViolationType violationType = ViolationType.getViolation(fieldErrorCode);
    	
    	String keyDataType = null;
    	String violatedEntity = "FIELD";
    	String exceptionMessage = fieldError.getDefaultMessage();
    	this.constructValidationException(
        		keyLocation,
                key,
                rejectedValue,
                violationType,
                keyDataType,
                violatedEntity,
                exceptionMessage);
    }
    
    
    /**
	 * Method to add @see ValidationException from List of @see FieldError.
	 * @param fieldErrors List of FieldError
	 * 
	 * For each fieldError, call buildValidationExceptions method
	 * 
	 * @param fieldErrors	List of FieldError object
	 */
    public void addValidationExceptions(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::buildValidationExceptions);
    }
	
}