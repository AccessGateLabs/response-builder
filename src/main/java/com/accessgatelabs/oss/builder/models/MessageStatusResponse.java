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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The class for generating responses whenever the response is
 * related to SMS or Email. 
 * 
 * This class generates information:
 * <ul>
 * 		<li>
 * 			Type (SMS/EMAIL)
 * 		</li>
 * 		<li>
 * 			isSent (true/false)
 * 		</li>
 * 		<li>
 * 			isDelivered (true/false)
 * 		</li>
 * 		<li>
 * 			recipients (array of String)
 * 		</li>
 * 		<li>
 * 			ttd (time to delivery) - in seconds
 * 		</li>
 * </ul>
 *
 * @author Ekansh Tiwari
 * @version 1.0.0
 * @since   2020-06-02
 * @see <a href="https://github.com/AccessGateLabs/response-builder">AccessGate Labs Response Builder on GitHub</a>
 * @see <a href="http://www.opensource.org/licenses/mit-license.php">MIT License</a>
 */
@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageStatusResponse {
	private String type;
	private boolean isSent;
	private boolean isDelivered;
	private String[] receipients;
	private int ttd;
}
