package com.travelapp.entity;

public enum OrderStatus {
    PENDING("PENDING"),
    DONE("DONE"),
    CANCEL("CANCEL");

    private final String statusName;

    OrderStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}