package com.example.restclient.json;

import java.util.List;

public class GeocoderResponse {
    private String status;
    private List<GeocoderResults> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GeocoderResults> getResults() {
        return results;
    }

    public void setResults(List<GeocoderResults> results) {
        this.results = results;
    }

    public String getFormatedAddress() {
        return results.get(0).getFormattedAddress();
    }

    public double getLng() {
        return results.get(0).getGeometry().getLocation().getLng();
    }

    public double getLat() {
        return results.get(0).getGeometry().getLocation().getLat();
    }

    @Override
    public String toString() {
        return "GeocoderResponse{" +
                "status='" + status + '\'' +
                ", results=" + results +
                '}';
    }
}
