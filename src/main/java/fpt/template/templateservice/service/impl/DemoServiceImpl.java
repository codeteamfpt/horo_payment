package fpt.template.templateservice.service.impl;

import fpt.template.templateservice.dto.response.DemoResponseDTO;
import fpt.template.templateservice.service.iclass.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public DemoResponseDTO demoMethod() {
        return DemoResponseDTO.builder().demo("Hello World").build();
    }
}
