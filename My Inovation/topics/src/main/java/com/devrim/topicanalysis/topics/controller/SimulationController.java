package com.devrim.topicanalysis.topics.controller;

import com.devrim.topicanalysis.topics.dtos.SimulationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SimulationController {
    ResponseEntity<List<SimulationDTO>> getAllSimulations();
    ResponseEntity<SimulationDTO> getSimulationById(Long id);
    ResponseEntity<SimulationDTO> createSimulation(SimulationDTO simulationDTO);
}
