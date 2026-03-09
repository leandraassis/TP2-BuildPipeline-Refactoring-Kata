package org.sammancoaching;

import org.sammancoaching.dependencies.*;

public class Pipeline {
    private final TestRunner testRunner;
    private final Deployer deployer;
    private final Notifier notifier;

    public Pipeline(Config config, Emailer emailer, Logger log) {
        this.testRunner = new TestRunner(log);
        this.deployer = new Deployer(log);
        this.notifier = new Notifier(config, emailer, log);
    }

    public void run(Project project) {
        boolean testsPassed = testRunner.run(project);
        boolean deploySuccessful = testsPassed && deployer.deploy(project);
        notifier.notify(new PipelineResult(testsPassed, deploySuccessful));
    }
}
