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
public class FinalGetAllAccountsReqDto {

	@JsonProperty("GetAllAccountsReq")
	private GetAllAccountsReqDto getAllaccountsReqDto;
}
