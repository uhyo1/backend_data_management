package com.uhyo.backend_data_management.controller;

import com.uhyo.common.dto.cond.*;
import com.uhyo.backend_data_management.Service.JobService;
import com.uhyo.common.dto.ui.JobStartRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping("/start")
    public ResponseEntity<?> start(@RequestBody JobStartRequest req) {
        return ResponseEntity.ok(service.startJob(req));
    }
}
