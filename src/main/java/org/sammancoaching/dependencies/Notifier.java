package org.sammancoaching.dependencies;

import org.sammancoaching.PipelineResult;

public class Notifier {
    private final Config config;
    private final Emailer emailer;
    private final Logger log;

    public Notifier(Config config, Emailer emailer, Logger log) {
        this.config = config;
        this.emailer = emailer;
        this.log = log;
    }

    private void sendEmail(PipelineResult result) {
        log.info("Sending email");
        if (!result.isTestsPassed()) {
            emailer.send("Tests failed");
        }else if (result.isDeploySuccesful()) {
            emailer.send("Deployment completed successfully");
        } else {
            emailer.send("Deployment failed");
        }
    }

    public void notify(PipelineResult result) {
        if (config.sendEmailSummary()) {
            sendEmail(result);
        } else {
            log.info("Email disabled");
        }
    }
}
