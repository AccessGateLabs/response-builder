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

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The class for generating API responses. 
 * 
 * <p>This class generates two information:</p>
 * <ul>
 * 		<li>
 * 			Service Response Code
 * 		</li>
 * 		<li>
 * 			Service Response
 * 		</li>
 * </ul>
 * 
 * 
 * For details on Service Response Code and Service Response, refer @see ServiceResponse.
 *
 * @author Ekansh Tiwari
 * @version 1.0.5
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApiServiceResponse {
	@JsonProperty("responseCode")
	private int serviceResponseCode;
	@JsonProperty("response")
	private ServiceResponse serviceResponse;
}
