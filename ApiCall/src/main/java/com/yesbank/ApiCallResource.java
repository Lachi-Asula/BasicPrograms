/*
 *    Licensed Materials - Property of IBM
 *    5725-I43 (C) Copyright IBM Corp. 2015, 2016. All Rights Reserved.
 *    US Government Users Restricted Rights - Use, duplication or
 *    disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

package com.yesbank;

import com.ibm.mfp.adapter.api.OAuthSecurity;
import com.yesbank.model.Constants;
import com.yesbank.service.ApiCallService;

import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ApiCallResource {
	static Logger logger = Logger.getLogger(ApiCallResource.class.getName());

	@POST
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	@OAuthSecurity(enabled = false)
	@Path("IdpCall")
	public Response idpCall(String obj) {
		logger.info("Entry IdpCall Request :: ");
		String response = "";
		try {
			ApiCallService apiCallService = new ApiCallService();
			response = apiCallService.callAPI(obj, Constants.application_Json);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Exit IdpCall :: ");
		return Response.ok(response).build();
	}

	@POST
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	@OAuthSecurity(enabled = false)
	@Path("IdpCallXML")
	public Response idpCallXML(String obj) {
		logger.info("Entry IdpCallXML Request :: ");
		String response = "";
		try {
			ApiCallService apiCallService = new ApiCallService();
			response = apiCallService.callAPI(obj, Constants.application_Xml);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Exit IdpCallXML");
		return Response.ok(response).build();
	}

}
