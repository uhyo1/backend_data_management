package com.uhyo.backend_data_management.Service;

import com.uhyo.backend_data_management.DbService;
import com.uhyo.common.dto.cond.*;
import com.uhyo.common.dto.ui.JobStartRequest;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {

    private final DbService db;
    private final PythonClient python;

    public JobService(DbService db, PythonClient python) {
        this.db = db;
        this.python = python;
    }

    public Object startJob(JobStartRequest req) {

        CustomerDto customer = db.findCustomer(req.getCustomerId());
        List<ItemCondDto> items = db.findItems(req.getItemIds());

        CondJson cond = new CondJson();
        cond.setJobId(1001);
        cond.setCustomer(customer);
        cond.setItems(items);
        cond.setRequestTime(LocalDateTime.now().toString());

        return python.call(cond);
    }
}
