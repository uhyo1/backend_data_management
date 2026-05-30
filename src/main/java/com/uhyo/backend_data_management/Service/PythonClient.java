package com.uhyo.backend_data_management.Service;

import com.uhyo.common.dto.cond.CondJson;
import com.uhyo.common.dto.cond.JobResponse;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PythonClient {

    private final RestTemplate rest = new RestTemplate();

    public JobResponse call(CondJson cond) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CondJson> entity = new HttpEntity<>(cond, headers);

        return rest.postForObject(
            "http://localhost:5000/job/execute",
            entity,
            JobResponse.class
        );
    }
}
