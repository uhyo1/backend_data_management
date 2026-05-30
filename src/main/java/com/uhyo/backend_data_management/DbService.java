package com.uhyo.backend_data_management;

import com.uhyo.common.dto.cond.*;
import com.uhyo.backend_data_management.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    private final CustomerRepository customerRepository;

    public DbService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto findCustomer(int id) {
        return customerRepository.findById(id);
    }

    public List<ItemCondDto> findItems(List<Integer> ids) {
        return ids.stream().map(i -> {
            ItemCondDto dto = new ItemCondDto();
            dto.setItemId(i);
            dto.setQty(1);
            return dto;
        }).toList();
    }
}

