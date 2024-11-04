package com.devrim.topicanalysis.topics.service;

import com.devrim.topicanalysis.topics.dtos.SimulationDTO;

import java.util.List;

public interface SimulationService {
    List<SimulationDTO> getAllSimulations();

    SimulationDTO getSimulationById(Long id);

    SimulationDTO createSimulation(SimulationDTO simulationDTO);
}
