package org.sammancoaching.dependencies;

public enum DeployStatus {
    SUCCESS,
    FAILURE;

    public boolean isSuccessful() {
        return this == SUCCESS;
    }
}