package com.devrim.topicanalysis.topics.controller.impl;

import com.devrim.topicanalysis.topics.controller.SimulationController;
import com.devrim.topicanalysis.topics.dtos.SimulationDTO;
import com.devrim.topicanalysis.topics.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulations")
public class SimulationControllerImpl implements SimulationController {
    @Autowired
    private SimulationService simulationService;

    @GetMapping
    public ResponseEntity<List<SimulationDTO>> getAllSimulations() {
        List<SimulationDTO> simulations = simulationService.getAllSimulations();
        return ResponseEntity.ok(simulations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimulationDTO> getSimulationById(@PathVariable Long id) {
        SimulationDTO simulation = simulationService.getSimulationById(id);
        return ResponseEntity.ok(simulation);
    }

    @PostMapping
    public ResponseEntity<SimulationDTO> createSimulation(@RequestBody SimulationDTO simulationDTO) {
        SimulationDTO createdSimulation = simulationService.createSimulation(simulationDTO);
        return new ResponseEntity<>(createdSimulation, HttpStatus.CREATED);
    }
}
