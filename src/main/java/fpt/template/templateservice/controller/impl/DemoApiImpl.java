package fpt.template.templateservice.controller.impl;

import fpt.template.templateservice.controller.api.DemoApi;
import fpt.template.templateservice.dto.request.DemoRequestDTO;
import fpt.template.templateservice.dto.response.DemoResponseDTO;
import fpt.template.templateservice.service.iclass.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoApiImpl implements DemoApi {

    @Autowired
    DemoService demoService;

    @Override
    public DemoResponseDTO getDemo(String authentication, String msisdn, String requestId) {
        return demoService.demoMethod();
    }

    @Override
    public DemoResponseDTO postDemo(String authentication, DemoRequestDTO DemoRequestDTO) {
        return demoService.demoMethod();
    }
}
