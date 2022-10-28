package com.practice.MavenCheck.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class ServiceContextDto {

	@JsonProperty("ServiceName")
	private String serviceName;
	
	@JsonProperty("ReqRefNum")
	private String reqRefNum;
	
	@JsonProperty("ReqRefTimeStamp")
	private String reqRefTimeStamp;
	
	@JsonProperty("ServiceVersionNo")
	private String ServiceVersionNo;
}
