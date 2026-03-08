package org.sammancoaching;

import org.sammancoaching.dependencies.*;

public class Pipeline {
    private final Config config;
    private final Emailer emailer;
    private final Logger log;

    public Pipeline(Config config, Emailer emailer, Logger log) {
        this.config = config;
        this.emailer = emailer;
        this.log = log;
    }

    private boolean testsPassed(Project project) {
        if (!project.hasTests()) {
            log.info("No tests");
            return true;
        }
        if (project.runTests() == TestStatus.PASSING_TESTS) {
            log.info("Tests passed");
            return true;
        }
        log.error("Tests failed");
        return false;
    }

    private boolean deploySuccessful(Project project) {
        if (project.deploy().isSuccessful()) {
            log.info("Deployment successful");
            return true;
        }
        log.error("Deployment failed");
        return false;
    }

    public void emailSummary(boolean testsPassed, boolean deploySuccessful) {
        log.info("Sending email");
        if (!testsPassed) {
            emailer.send("Tests failed");
        }else if (deploySuccessful) {
            emailer.send("Deployment completed successfully");
        } else {
            emailer.send("Deployment failed");
        }
    }

    public void run(Project project) {
        boolean testsPassed = testsPassed(project);
        boolean deploySuccessful = testsPassed && deploySuccessful(project);

        if (config.sendEmailSummary()) {
            emailSummary(testsPassed, deploySuccessful);
        } else {
            log.info("Email disabled");
        }
    }
}
