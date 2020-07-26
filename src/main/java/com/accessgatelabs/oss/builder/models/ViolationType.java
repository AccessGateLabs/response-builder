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


/**
 * Collection of Violations of exceptions
 * 
 * Further can be appended
 * 
 * @author Ekansh Tiwari
 * @version 1.0.0
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
public enum ViolationType {
	
	Email_Not_Formatted
	(
			"Email"
	),
	
	Key_Value_Is_Null
	(
			"NotNull"
	),

	Invalid_Pattern
	(
			"Pattern"
	),

	Invalid_Value_Length
	(
			"Size"
	),
	
	Missing_Key
	(
			null
	)
	
	;
	
	private final String fieldErrorCode;

	/**
	 * Return the violation field code (actual code)
	 * @return fieldErrorCode String
	 */
	public String fieldErrorCode() {
		return this.fieldErrorCode;
	}
	
	private ViolationType(String fieldErrorCode) { this.fieldErrorCode = fieldErrorCode; }
	
	public static ViolationType getViolation(String fieldErrorCode) {
		for (ViolationType v : ViolationType.values()) { 
			if (v.fieldErrorCode.equals(fieldErrorCode)) {
				return v;
			}
		}
		throw new IllegalArgumentException("Violation type not found. Amputated?");
	}
	
}
