package com.FinAnalysis.Website.APIConnection;

public interface APIConnector {
    /**
     * Sends request to the api.
     *
     * @param apiParameters the api parameters (required/optional) to the api call.
     * @return the json response for the given call.
     */
    String getRequest(APIParameter... apiParameters);
}
