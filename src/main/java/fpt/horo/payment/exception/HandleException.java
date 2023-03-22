package fpt.horo.payment.exception;
import fpt.horo.payment.dto.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HandleException extends RuntimeException{
    private ResponseStatus statusCode;
    public HandleException(String message) {
        super(message);
    }
}
