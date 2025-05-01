package com.yasir.springprofiler.controller;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jvm")
public class JvmMetricsController {

    private final MeterRegistry meterRegistry;

    @Autowired
    public JvmMetricsController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/memory")
    public Map<String, Object> getJvmMemoryUsage() {
        Map<String, Object> memoryMetrics = new HashMap<>();
        meterRegistry.get("jvm.memory.used").gauges().forEach(gauge -> {
            String area = gauge.getId().getTag("area");
            String id = gauge.getId().getTag("id");
            memoryMetrics.put(area + "-" + id, gauge.value());
        });
        return memoryMetrics;
    }

    @GetMapping("/threads")
    public Map<String, Object> getThreadStats() {
        Map<String, Object> threadMetrics = new HashMap<>();

        // Live Threads
        Gauge liveGauge = meterRegistry.find("jvm.threads.live").gauge();
        if (liveGauge != null) {
            threadMetrics.put("threads.live", liveGauge.value());
        }

        // Peak Threads
        Gauge peakGauge = meterRegistry.find("jvm.threads.peak").gauge();
        if (peakGauge != null) {
            threadMetrics.put("threads.peak", peakGauge.value());
        }

        // Daemon Threads
        Gauge daemonGauge = meterRegistry.find("jvm.threads.daemon").gauge();
        if (daemonGauge != null) {
            threadMetrics.put("threads.daemon", daemonGauge.value());
        }

        return threadMetrics;
    }
}
