package com.yasir.springprofiler.controller;


import com.yasir.springprofiler.services.ProfilerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

    private final ProfilerService profilerService;

    public MetricsController(ProfilerService profilerService) {
        this.profilerService = profilerService;
    }

    @GetMapping("/metrics/profiler")
    public String getProfilerData() {
        return profilerService.getProfilerData();
    }
}

