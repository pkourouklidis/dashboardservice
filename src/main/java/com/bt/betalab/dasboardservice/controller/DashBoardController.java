/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 07/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.controller;

import com.bt.betalab.dasboardservice.api.CallData;
import com.bt.betalab.dasboardservice.api.SimulationData;
import com.bt.betalab.dasboardservice.api.SimulationStatus;
import com.bt.betalab.dasboardservice.api.SimulationSummary;
import com.bt.betalab.dasboardservice.exceptions.DashboardServiceException;
import com.bt.betalab.dasboardservice.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
public class DashBoardController {

    @Autowired
    DashboardService service;

    @PostMapping(produces = "application/json", value = "report")
    public ResponseEntity reportCallData(@RequestBody CallData request)  {
        try {
            service.reportCallData(request);
            return ResponseEntity.ok().build();
        } catch (DashboardServiceException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(produces = "application/json", value = "status")
    public ResponseEntity<SimulationStatus> getCurrentSimulationStatus()  {
        try {
            return ResponseEntity.ok(service.getCurrentSimulationStatus());
        } catch (DashboardServiceException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(produces = "application/json", value = "simulation/{id}")
    public ResponseEntity<SimulationData> getSimulationData(@PathVariable String id, @RequestParam Optional<Integer> count)  {
        try {
            if (service.simulationExists(id)) {
                return ResponseEntity.ok(service.getSimulationData(id, count));
            }
            return ResponseEntity.notFound().build();
        } catch (DashboardServiceException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(produces = "application/json", value = "simulation")
    public ResponseEntity<List<SimulationSummary>> getSimulations()  {
        try {
            return ResponseEntity.ok(service.getSimulations());
        } catch (DashboardServiceException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
