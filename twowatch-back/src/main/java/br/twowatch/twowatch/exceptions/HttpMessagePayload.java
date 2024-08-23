package br.twowatch.twowatch.exceptions;

public class HttpMessagePayload {
    private String message;

    public HttpMessagePayload(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
