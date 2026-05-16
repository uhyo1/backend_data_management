package com.uhyo.backend_data_management.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.uhyo.backend_data_management.entity.PswdExpired;
import com.uhyo.backend_data_management.repository.PswdExpiredRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expired")
public class PswdExpiredController {

    private final PswdExpiredRepository repository;

    @GetMapping("/all")
    public List<PswdExpired> getAll() {
        return repository.findAll();
    }
}
