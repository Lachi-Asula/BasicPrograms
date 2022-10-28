package com.practice.MavenCheck.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CASACustDetails {

    @JsonProperty("CustomerSegment")
    private String customerSegment;
    @JsonProperty("AadhaarNumber")
    private String aadhaarNumber;
    @JsonProperty("CustomerFullName")
    private String customerFullName;
    @JsonProperty("RiskCategory")
    private String riskCategory;
    @JsonProperty("CustomerRelationship")
    private String customerRelationship;
    @JsonProperty("CustomerId")
    private String customerId;
}
