package fpt.horo.payment.exception;

import fpt.horo.payment.constant.ResponseStatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HandleException extends RuntimeException{
    private ResponseStatusCode statusCode;
    public HandleException(String message) {
        super(message);
    }
}
