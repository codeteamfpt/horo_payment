package fpt.horo.payment.controller.api;

import fpt.horo.payment.dto.request.gateway_request.ConfirmTransRequest;
import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "${app.application-context}")
@Tag(name = "payment gateways vds", description = "định nghĩa request")
public interface PaymentGatewayApi {
    @PostMapping(value = "/verify-trans", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ConfirmTransResponse verifyTrans(
            @Parameter(name = "Authentication", in = ParameterIn.HEADER, required = true) String authentication,
            @RequestBody ConfirmTransRequest request);
}
