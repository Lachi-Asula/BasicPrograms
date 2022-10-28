/*
 *    Licensed Materials - Property of IBM
 *    5725-I43 (C) Copyright IBM Corp. 2015, 2016. All Rights Reserved.
 *    US Government Users Restricted Rights - Use, duplication or
 *    disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
*/

package com.yesbank;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.ibm.mfp.adapter.api.ConfigurationAPI;
import com.ibm.mfp.adapter.api.MFPJAXRSApplication;

import javax.ws.rs.core.Context;

public class ApiCallApplication extends MFPJAXRSApplication{

	@Context
	ConfigurationAPI configurationAPI;

	static Logger logger = Logger.getLogger(ApiCallApplication.class.getName());

	public static Map<String, String> properties = new HashMap<String, String>();

	protected void init() throws Exception {
		logger.info("Adapter initialized!");

		properties.put("accessValue", configurationAPI.getPropertyValue("accessValue"));
		properties.put("ibmClientName", configurationAPI.getPropertyValue("ibmClientName"));
		properties.put("ibmClientValue", configurationAPI.getPropertyValue("ibmClientValue"));
	}
	

	protected void destroy() throws Exception {
		logger.info("Adapter destroyed!");
	}
	

	protected String getPackageToScan() {
		//The package of this class will be scanned (recursively) to find JAX-RS resources. 
		//It is also possible to override "getPackagesToScan" method in order to return more than one package for scanning
		return getClass().getPackage().getName();
	}
}
