package fpt.horo.payment.controller.impl;

import fpt.horo.payment.controller.api.DemoApi;
import fpt.horo.payment.dto.request.DemoRequestDTO;
import fpt.horo.payment.dto.response.DemoResponseDTO;
import fpt.horo.payment.service.iclass.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApiImpl implements DemoApi {

    @Override
    public DemoResponseDTO getDemo(String authentication, String msisdn, String requestId) {
        return null;
    }

    @Override
    public DemoResponseDTO postDemo(String authentication, DemoRequestDTO demoRequestDTO) {
        return null;
    }

    @Override
    public String homeAdmin(Model model) {
        return null;
    }
}
