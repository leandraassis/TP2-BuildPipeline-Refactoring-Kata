package org.sammancoaching;

import org.sammancoaching.dependencies.Logger;
import org.sammancoaching.dependencies.Project;

public class Deployer {
    private final Logger log;

    public Deployer(Logger logger) {
        this.log = logger;
    }

    public boolean deploy(Project project) {
        if (project.deploy().isSuccessful()) {
            log.info("Deployment successful");
            return true;
        }
        log.error("Deployment failed");
        return false;
    }
}
