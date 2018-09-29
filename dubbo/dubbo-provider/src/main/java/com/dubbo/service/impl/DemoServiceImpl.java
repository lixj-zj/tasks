package com.dubbo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dubbo.service.DemoService;


public class DemoServiceImpl implements DemoService{

	public List<String> getPermissions(Long id) {
		List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d", id));
        return demo;
	}
	
}
