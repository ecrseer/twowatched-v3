package br.gj.infnetat.twfilmes.exceptions;

public class HttpMessagePayload {
    private String message;

    public HttpMessagePayload(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
