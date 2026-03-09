package org.sammancoaching;

public class PipelineResult {
    private final boolean testsPassed;
    private final boolean deploySuccesful;

    public PipelineResult(boolean testsPassed, boolean deploySuccesful) {
        this.testsPassed = testsPassed;
        this.deploySuccesful = deploySuccesful;
    }

    public boolean isTestsPassed() {
        return testsPassed;
    }

    public boolean isDeploySuccesful() {
        return deploySuccesful;
    }
}
