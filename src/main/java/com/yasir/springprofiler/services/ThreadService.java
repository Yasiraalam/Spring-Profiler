package com.yasir.springprofiler.services;

import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

@Service
public class ThreadService {
    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public String getThreadInfo() {
        // Fetch and return information about active threads
        long[] threadIds = threadMXBean.getAllThreadIds();
        StringBuilder threadInfo = new StringBuilder();

        for (long threadId : threadIds) {
            String threadName = threadMXBean.getThreadInfo(threadId).getThreadName();
            String threadState = threadMXBean.getThreadInfo(threadId).getThreadState().toString();
            threadInfo.append("Thread Name: ").append(threadName)
                    .append(", State: ").append(threadState).append("\n");
        }

        return threadInfo.toString();
    }
}
