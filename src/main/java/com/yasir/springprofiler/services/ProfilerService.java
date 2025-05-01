package com.yasir.springprofiler.services;


import org.springframework.stereotype.Service;

@Service
public class ProfilerService {

    private final ThreadService threadService;
    private final MemoryService memoryService;

    public ProfilerService(ThreadService threadService, MemoryService memoryService) {
        this.threadService = threadService;
        this.memoryService = memoryService;
    }

    public String getProfilerData() {
        // Combine thread and memory information into a single response
        String threadInfo = threadService.getThreadInfo();
        String memoryInfo = memoryService.getMemoryInfo();
        return "Profiler Data: \n" + threadInfo + "\n" + memoryInfo;
    }
}
