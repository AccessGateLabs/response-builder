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

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * The class that provides responses when a Resource is not found.
 * Extends @exception RuntimeException	When a run-time exception occurs
 * 
 * This class generates three information:
 * <ul>
 * 		<li>
 * 			Resource Name
 * 		</li>
 * 		<li>
 * 			Field Name
 * 		</li>
 * 		<li>
 * 			Field Value
 * 		</li>
 * </ul>
 * 
 * @author Ekansh Tiwari
 * @version 1.0.5
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}