package com.devrim.topicanalysis.topics.service.impl;

import com.devrim.topicanalysis.topics.dtos.SimulationDTO;
import com.devrim.topicanalysis.topics.service.SimulationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationServiceImpl implements SimulationService {
    @Override
    public List<SimulationDTO> getAllSimulations() {
        return List.of();
    }

    @Override
    public SimulationDTO getSimulationById(Long id) {
        return null;
    }

    @Override
    public SimulationDTO createSimulation(SimulationDTO simulationDTO) {
        return null;
    }
}
