package com.mcg.takehome.constants;

public enum PrettifyMarkers {
    MILLION("M"),
    BILLION("B"),
    TRILLION("T");

    private String marker;

    PrettifyMarkers(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return this.marker;
    }
}
