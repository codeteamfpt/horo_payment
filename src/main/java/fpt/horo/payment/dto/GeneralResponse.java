package fpt.horo.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fpt.horo.payment.util.Utils;

public class GeneralResponse<T> {
    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("data")
    private T data;

    public GeneralResponse(T data) {
        this.data = data;
    }

    public GeneralResponse(T data, ResponseStatus status) {
        this.data = data;
        this.status = status;
    }

    public String toString() {
        return Utils.gson.toJson(this);
    }

    public ResponseStatus getStatus() {
        return this.status;
    }

    public T getData() {
        return this.data;
    }

    @JsonProperty("status")
    public void setStatus(final ResponseStatus status) {
        this.status = status;
    }

    @JsonProperty("data")
    public void setData(final T data) {
        this.data = data;
    }

    public GeneralResponse() {
    }
}