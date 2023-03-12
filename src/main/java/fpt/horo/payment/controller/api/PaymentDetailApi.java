package fpt.horo.payment.controller.api;

import fpt.horo.payment.dto.GeneralResponse;
import fpt.horo.payment.dto.request.CreateTransRequest;
import fpt.horo.payment.dto.response.CreateTransResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "${app.application-context}")
@Tag(name = "payment detail", description = "định nghĩa request")
public interface PaymentDetailApi {

    @PostMapping(value = "/create_trans", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    GeneralResponse<CreateTransResponse> createTrans(
            @RequestBody CreateTransRequest request);

}
