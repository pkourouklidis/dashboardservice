/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/

package com.bt.betalab.dasboardservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.bt.betalab.dasboardservice.api.CallData;
import com.bt.betalab.dasboardservice.api.DriftObservation;
import com.bt.betalab.dasboardservice.api.SimulationData;
import com.bt.betalab.dasboardservice.api.SimulationStatus;
import com.bt.betalab.dasboardservice.api.SimulationSummary;
import com.bt.betalab.dasboardservice.config.DashboardServiceConfig;
import com.bt.betalab.dasboardservice.exceptions.DashboardServiceException;
import com.bt.betalab.dasboardservice.logging.LogLevel;
import com.bt.betalab.dasboardservice.logging.Logger;
import com.bt.betalab.dasboardservice.messaging.WebClientFactory;

@Service
public class DashboardService {

    @Autowired
    WebClientFactory clientFactory;

    @Autowired
    DashboardServiceConfig config;

    public void reportCallData(CallData request) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/report");
        try{
            webClient
            .post()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .retrieve()
            .toBodilessEntity()
            .block();
        }
        catch (WebClientResponseException e) {
            Logger.log("Failed to report call result. Error code: " + e.getRawStatusCode(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }

    public SimulationStatus getCurrentSimulationStatus() throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getAdminServiceUrl() + "/api/v1/simulation/status");
        try{
            ResponseEntity<SimulationStatus> reply = webClient
            .get()
            .retrieve()
            .toEntity(SimulationStatus.class)
            .block();
            return reply.getBody();
        }
        catch (WebClientResponseException e) {
            Logger.log("Failed to retrieve simulation status. Error code: " + e.getRawStatusCode(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }

    public SimulationData getSimulationData(String id, Optional<Integer> count) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/simulation/" + id + (count.isPresent() ? "?count=" + count.get() : ""));
        try{
            ResponseEntity<SimulationData> reply = webClient
            .get()
            .retrieve()
            .toEntity(SimulationData.class)
            .block();
            return reply.getBody();
        }


        catch (WebClientResponseException e) {
            Logger.log("Failed to retrieve simulation data. Error code: " + e.getRawStatusCode(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }

    public List<SimulationSummary> getSimulations() throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/simulation/");
        try{
            ResponseEntity reply = webClient
            .get()
            .retrieve()
            .toEntity(List.class)
            .block();
            return (List<SimulationSummary>) reply.getBody();
        }
        catch (WebClientResponseException e) {
            Logger.log("Failed to retrieve simulation list. Error code: " + e.getRawStatusCode(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }

    public boolean simulationExists(String id) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/simulation/" + id);
        try {
            ResponseEntity<Void> reply = webClient
                    .get()
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            if (reply.getStatusCode().is2xxSuccessful()) {
                return true;
            }
            return false;
        } catch (WebClientResponseException e) {
            Logger.log("Failed to communicate with data service backend. Error code: " + e.getRawStatusCode(),
                    LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }

    public AIDeploymentStatus getAIDeploymentStatus() throws DashboardServiceException {
        WebClient webClient = clientFactory
                .generateWebClient(config.getPanoptesModelUrl() + "/api/v1/deployments/callcenter");
        try {
            ResponseEntity<AIDeploymentStatus> reply = webClient
                    .get()
                    .retrieve()
                    .toEntity(AIDeploymentStatus.class)
                    .block();
            AIDeploymentStatus resultStatus = reply.getBody();
            resultStatus.setData(getAIDeploymentDriftData(50));
            return resultStatus;
        } catch (WebClientResponseException e) {
            Logger.log("Failed to retrieve AI deployment status. Error code: " + e.getRawStatusCode(),
                    LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }

    public List<DriftObservation> getAIDeploymentDriftData(int count) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getPanoptesModelUrl() + "/api/v1/deployments/callcenter/baseAlgorithmExecutions?count=" + count);
        try {
            ResponseEntity<List<DriftObservation>> reply = webClient
                    .get()
                    .retrieve()
                    .toEntity(new ParameterizedTypeReference<List<DriftObservation>>() {})
                    .block();
            return reply.getBody();
        }

        catch (WebClientResponseException e) {
            Logger.log("Failed to retrieve data drift list for AI deployment. Error code: " + e.getRawStatusCode(),
                    LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }
}
