package com.sandwich.model.service.impl;

import com.sandwich.model.service.ISpiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpiceServiceImpl implements ISpiceService {
    @Override
    public List<String> saveSpices(String[] spices) {
        return new ArrayList<>(Arrays.asList(spices));
    }
}
