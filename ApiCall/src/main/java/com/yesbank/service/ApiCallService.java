package com.yesbank.service;

import com.yesbank.ApiCallApplication;
import com.yesbank.model.Constants;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.XML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ApiCallService {

    public static Logger logger = Logger.getLogger(ApiCallService.class.getName());

    @SuppressWarnings("unchecked")
    public String callAPI(String requestFromClient, String mediaType) {
        JSONObject finalResult = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        try {
            finalResult.put(Constants.request, jsonParser.parse(requestFromClient));
            String request = ((JSONObject)finalResult.get(Constants.request)).get(Constants.request).toString();
            String endpoint = ((JSONObject)finalResult.get(Constants.request)).get(Constants.idpUrl).toString();
            logger.info("Request :: " + request);
            logger.info("URL :: " + endpoint);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost(endpoint);
            post.setHeader(Constants.contentType, mediaType);
            post.setHeader(Constants.cacheControl, Constants.noCache);
            post.setHeader(Constants.xIbmClientId, ApiCallApplication.properties.get(Constants.ibmClientName));
            post.setHeader(Constants.xIbmClientSecret, ApiCallApplication.properties.get(Constants.ibmClientValue));
            StringEntity params = new StringEntity(request);
            post.setEntity(params);
            CloseableHttpResponse RSSResponse = httpClient.execute(post);
            System.out.println(RSSResponse.getStatusLine().getStatusCode());
            StringBuffer response = new StringBuffer();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(RSSResponse.getEntity().getContent()));
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
            }catch (Exception e){
                e.getMessage();
            }
            logger.info("Response :: " + response);
            String str = (mediaType.equals(Constants.application_Xml) || mediaType.equals(Constants.text_Xml)) ? XML.toJSONObject(response.toString()).toString() : response.toString();
            finalResult.put(Constants.response, jsonParser.parse(str));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalResult.get(Constants.response).toString();
    }

}
