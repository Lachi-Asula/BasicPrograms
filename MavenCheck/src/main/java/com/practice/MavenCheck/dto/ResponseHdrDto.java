package com.practice.MavenCheck.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHdrDto {

    @JsonProperty("ServiceResponse")
    private ServiceResponse serviceResponse;
    @JsonProperty("ServiceContext")
    private ServiceContextDto  serviceContext;
    @JsonProperty("ConsumerContext")
    private ConsumerContextDto consumerContext;
}
