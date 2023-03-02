package fpt.horo.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Format of response returned to client
 *
 * @param <T>
 * @author thanhnd44
 */

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse<T> {

    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + "status=" + status +
                ", data=" + data.toString() +
                '}';
    }
}