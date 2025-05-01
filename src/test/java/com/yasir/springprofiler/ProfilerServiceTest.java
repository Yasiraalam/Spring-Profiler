package com.yasir.springprofiler;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.yasir.springprofiler.services.MemoryService;
import com.yasir.springprofiler.services.ProfilerService;
import com.yasir.springprofiler.services.ThreadService;
import org.junit.jupiter.api.Test;

public class ProfilerServiceTest {

    @Test
    public void testGetProfilerData() {
        ProfilerService profilerService = new ProfilerService(new ThreadService(), new MemoryService());
        String profilerData = profilerService.getProfilerData();
        assertNotNull(profilerData);
    }
}
