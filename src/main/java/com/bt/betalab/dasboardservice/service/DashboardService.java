/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.service;

import com.bt.betalab.dasboardservice.api.CallData;
import com.bt.betalab.dasboardservice.api.SimulationData;
import com.bt.betalab.dasboardservice.api.SimulationStatus;
import com.bt.betalab.dasboardservice.api.SimulationSummary;
import com.bt.betalab.dasboardservice.config.DashboardServiceConfig;
import com.bt.betalab.dasboardservice.exceptions.DashboardServiceException;
import com.bt.betalab.dasboardservice.logging.LogLevel;
import com.bt.betalab.dasboardservice.logging.Logger;
import com.bt.betalab.dasboardservice.messaging.WebClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/report");
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
        WebClient webClient = clientFactory.generateWebClient(config.getAdminServiceUrl() + "/status");
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
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/simulation/" + id + (count.isPresent() ? "?count=" + count.get() : ""));
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
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/simulation/");
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
        WebClient webClient = clientFactory.generateWebClient(config.getDataServiceUrl() + "/simulation/" +id);
        ResponseEntity reply = webClient
                .get()
                .retrieve()
                .toBodilessEntity()
                .block();

        if (reply.getStatusCode().value() == 404) {
            return false;
        } else if (!reply.getStatusCode().is2xxSuccessful()) {
            return true;
        }
        Logger.log("Failed to communicate with data service backend. Error code: " + reply.getStatusCodeValue(), LogLevel.ERROR);
        throw new DashboardServiceException();
    }
}
