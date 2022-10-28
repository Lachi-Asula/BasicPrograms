package com.practice.MavenCheck.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown =  true)
@AllArgsConstructor
@NoArgsConstructor
public class ReqBodyDto {

	@JsonProperty("CustomerId")
	private String customerId;
	
	@JsonProperty("GetSavingsAcc")
	private String getSavingsAcc;
	
	@JsonProperty("GetCurAcc")
	private boolean getCurAcc;
	
	@JsonProperty("GetFDAcc")
	private boolean getFDAcc;
	
	@JsonProperty("GetRDAcc")
	private boolean getRDAcc;
}
