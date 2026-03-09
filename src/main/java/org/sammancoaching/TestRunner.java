package org.sammancoaching;

import org.sammancoaching.dependencies.Logger;
import org.sammancoaching.dependencies.Project;
import org.sammancoaching.dependencies.TestStatus;

public class TestRunner {
    private final Logger log;

    public TestRunner(Logger logger) {
        this.log = logger;
    }

    public boolean run(Project project) {
        if(!project.hasTests()) {
            log.info("No tests");
            return true;
        }
        if(project.runTests() == TestStatus.PASSING_TESTS) {
            log.info("Tests passed");
            return true;
        }
        log.error("Tests failed");
        return false;
    }
}
