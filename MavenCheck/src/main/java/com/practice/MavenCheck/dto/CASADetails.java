package com.practice.MavenCheck.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CASADetails {

    @JsonProperty("AvailableClosingBalance")
    private String availableClosingBalance;
    @JsonProperty("AccountProductName")
    private String accountProductName;
    @JsonProperty("AccountProductCode")
    private String accountProductCode;
    @JsonProperty("AccountOpenDate")
    private String accountOpenDate;
    @JsonProperty("AccountHomeBranch")
    private String accountHomeBranch;
    @JsonProperty("AccountType")
    private String accountType;
    @JsonProperty("AccountNumber")
    private String accountNumber;
    @JsonProperty("AccountTitle")
    private String accountTitle;
    @JsonProperty("AvailableBalance")
    private String availableBalance;
    @JsonProperty("AccountStatusCode")
    private String accountStatusCode;
    @JsonProperty("CASACustDetails")
    private ArrayList<CASACustDetails> casaCustDetails;
    @JsonProperty("AccountStatusDescription")
    private String accountStatusDescription;
    @JsonProperty("BenefitCode")
    private String benefitCode;
}
