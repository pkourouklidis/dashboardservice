/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.service;

import com.bt.betalab.dasboardservice.api.*;
import com.bt.betalab.dasboardservice.config.DashboardServiceConfig;
import com.bt.betalab.dasboardservice.exceptions.DashboardServiceException;
import com.bt.betalab.dasboardservice.logging.LogLevel;
import com.bt.betalab.dasboardservice.logging.Logger;
import com.bt.betalab.dasboardservice.messaging.WebClientFactory;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {

    @Autowired
    WebClientFactory clientFactory;

    @Autowired
    DashboardServiceConfig config;

    public void reportCallData(CallData request) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/report");
        ResponseEntity reply = webClient
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .toBodilessEntity()
                .block();

        if (!reply.getStatusCode().is2xxSuccessful()) {
            Logger.log("Failed to report call result. Error code: " + reply.getStatusCodeValue(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
    }

    public SimulationStatus getCurrentSimulationStatus() throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getAdminServiceUrl() + "/api/v1/simulation/status");
        ResponseEntity<SimulationStatus> reply = webClient
                .get()
                .retrieve()
                .toEntity(SimulationStatus.class)
                .block();

        if (!reply.getStatusCode().is2xxSuccessful()) {
            Logger.log("Failed to retrieve simulation status. Error code: " + reply.getStatusCodeValue(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
        return reply.getBody();
    }

    public SimulationData getSimulationData(String id, Optional<Integer> count) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/simulation/" + id + (count.isPresent() ? "?count=" + count.get() : ""));
        ResponseEntity<SimulationData> reply = webClient
                .get()
                .retrieve()
                .toEntity(SimulationData.class)
                .block();

        if (!reply.getStatusCode().is2xxSuccessful()) {
            Logger.log("Failed to retrieve simulation data. Error code: " + reply.getStatusCodeValue(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
        return reply.getBody();
    }

    public List<SimulationSummary> getSimulations() throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/simulation/");
        ResponseEntity reply = webClient
                .get()
                .retrieve()
                .toEntity(List.class)
                .block();

        if (!reply.getStatusCode().is2xxSuccessful()) {
            Logger.log("Failed to retrieve simulation list. Error code: " + reply.getStatusCodeValue(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
        return (List<SimulationSummary>) reply.getBody();
    }

    public boolean simulationExists(String id) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/api/v1/simulation/" +id);
        ResponseEntity reply = webClient
                .get()
                .retrieve()
                .toBodilessEntity()
                .block();

        if (reply.getStatusCode().value() == 404) {
            return false;
        } else if (reply.getStatusCode().is2xxSuccessful()) {
            return true;
        }
        Logger.log("Failed to communicate with data service backend. Error code: " + reply.getStatusCodeValue(), LogLevel.ERROR);
        throw new DashboardServiceException();
    }

    public AIDeploymentStatus getAIDeploymentStatus() throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getPanoptesModelUrl() + "/deployments/callcenter");
        ResponseEntity reply = webClient
                .get()
                .retrieve()
                .toEntity(AIDeploymentStatus.class)
                .onErrorResume(ex -> Mono.empty())
                .block();

        if (!reply.getStatusCode().is2xxSuccessful()) {
            Logger.log("Failed to retrieve AI deployment status. Error code: " + reply.getStatusCodeValue(),
                    LogLevel.ERROR);
            throw new DashboardServiceException();
        }

        AIDeploymentStatus resultStatus = (AIDeploymentStatus) reply.getBody();
        // resultStatus.setData(getAIDeploymentDriftData(50));
        return resultStatus;
    }

    public DriftData getAIDeploymentDriftData(int count) throws DashboardServiceException {
        WebClient webClient = clientFactory.generateWebClient(config.getPanoptesModelUrl() + "/drift?count=" + count);
        ResponseEntity reply = webClient
                .get()
                .retrieve()
                .toEntity(DriftData.class)
                .block();

        if (!reply.getStatusCode().is2xxSuccessful()) {
            Logger.log("Failed to retrieve data drift list for AI deployment. Error code: " + reply.getStatusCodeValue(), LogLevel.ERROR);
            throw new DashboardServiceException();
        }
        return (DriftData) reply.getBody();
    }
}
