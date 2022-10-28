package com.practice.MavenCheck.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    //    String request = "{ \"GetAllAccountsReq\": { \"ReqHdr\": { \"ConsumerContext\": { \"RequesterID\": \"WRK\" }, \"ServiceContext\": { \"ServiceName\": \"CustomerManagementV2\", \"ReqRefNum\": \"23617433157313878248\", \"ReqRefTimeStamp\": \"2021-02-03T10:54:47.682\", \"ServiceVersionNo\": \"1.0\" } }, \"ReqBody\": { \"CustomerId\": \"239\", \"GetSavingsAcc\": true, \"GetCurAcc\": true, \"GetFDAcc\": false, \"GetRDAcc\": false } } }";
        String request = "{ \"GetCASADetailsExtRes\": { \"ResHdr\": { \"ServiceResponse\": { \"EsbResStatus\": \"0\", \"EsbResTimeStamp\": \"2022-10-14 16:22:28.349217\" }, \"ServiceContext\": { \"ServiceName\": \"AccountManagementExt\", \"ReqRefTimeStamp\": \"2022-01-06T17:04:23\", \"ServiceVersionNo\": \"1.0\", \"ReqRefNum\": \"68839389219243319167\" }, \"ConsumerContext\": { \"RequesterID\": \"WRK\" } }, \"ResBody\": { \"CASADetails\": { \"AvailableClosingBalance\": \"292526.17\", \"AccountProductName\": \"SAVINGS ACCOUNT - STAFF\", \"AccountProductCode\": \"906\", \"AccountOpenDate\": \"2012-04-18\", \"AccountHomeBranch\": \"86\", \"AccountType\": \"INDIVIDUAL\", \"AccountNumber\": \"008690600000103\", \"AccountTitle\": \"AJAY SHARMA\", \"AvailableBalance\": \"292526.17\", \"AccountStatusCode\": \"8\", \"CASACustDetails\": [ { \"CustomerSegment\": null, \"AadhaarNumber\": null, \"CustomerFullName\": \"XXXXXXXXXXXXX\", \"RiskCategory\": null, \"CustomerRelationship\": \"SOW\", \"CustomerId\": \"729787\" } ], \"AccountStatusDescription\": \"ACCOUNT OPEN REGULAR\", \"BenefitCode\": null } } } }";
        ObjectMapper mapper = new ObjectMapper();
        try {
        	GetCASAdetailsResponseFinalDto accountsDto = mapper.readValue(request.toString(), GetCASAdetailsResponseFinalDto.class);
        	System.out.println(accountsDto);
        	String str = mapper.writeValueAsString(accountsDto);
        	System.out.println(str);
        	
        	if(accountsDto.getGetCASADetailsResponse().getResHdr().getServiceResponse().getEsbResStatus().equalsIgnoreCase("0")){
                System.out.println("Heloowwwwwwwwwwwww");
            }
        	
        	List<AccDetails> accDetails = new ArrayList();
        	for(int i = 0; i < 3; i++) {
        		AccDetails accDet = AccDetails.builder()
        				.custSegment(null)
        				.build();
        		accDetails.add(accDet);
        		
        	}
        	System.out.println(mapper.writeValueAsString(accDetails));
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
}
