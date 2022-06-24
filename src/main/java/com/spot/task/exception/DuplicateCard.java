package com.spot.task.exception;

public class DuplicateCard extends RuntimeException {
    public DuplicateCard(String message) {
        super(message);
    }
}
