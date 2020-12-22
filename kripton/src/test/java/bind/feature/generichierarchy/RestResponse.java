/*******************************************************************************
 * Copyright 2015, 2017 Francesco Benincasa (info@abubusoft.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package bind.feature.generichierarchy;

import java.io.Serializable;

import bind.feature.generichierarchy.ServiceStatusType;


/**
 * The Class RestResponse.
 */
public abstract class RestResponse  implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1707936337366965471L;

	/** The status. */
	protected ServiceStatusType status;
	
	/** The detail message. */
	protected String detailMessage;

	/**
	 * Gets the detail message.
	 *
	 * @return the detail message
	 */
	public String getDetailMessage() {
		return detailMessage;
	}

	/**
	 * Sets the detail message.
	 *
	 * @param detailMessage the new detail message
	 */
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}


	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ServiceStatusType status) {
		this.status = status;
	}
	

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ServiceStatusType getStatus() {
		return status;
	}
	
	/**
	 * Checks if is successfull.
	 *
	 * @return true, if is successfull
	 */
	public boolean isSuccessfull()
	{
		return status.isSuccessfull();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestResponse [status=" + status + "]";
	}

}
