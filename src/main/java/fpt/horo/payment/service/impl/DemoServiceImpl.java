package fpt.horo.payment.service.impl;

import fpt.horo.payment.dto.response.DemoResponseDTO;
import fpt.horo.payment.entity.User;
import fpt.horo.payment.repository.UserRepository;
import fpt.horo.payment.service.iclass.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    UserRepository userRepository;

    @Override
    public DemoResponseDTO demoMethod() {
        List<User> user = userRepository.findAll();
        System.out.println(user);
        return DemoResponseDTO.builder().demo("Hello World").build();
    }
}
