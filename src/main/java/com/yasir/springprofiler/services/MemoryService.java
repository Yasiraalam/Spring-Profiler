package com.yasir.springprofiler.services;


import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Service
public class MemoryService {

    private final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

    public String getMemoryInfo() {
        // Fetch and return memory information (heap usage, GC stats, etc.)
        return "Memory Info: " + memoryMXBean.getHeapMemoryUsage().toString();
    }
}
