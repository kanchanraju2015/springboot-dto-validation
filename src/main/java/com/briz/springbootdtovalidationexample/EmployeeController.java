package com.briz.springbootdtovalidationexample;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class EmployeeController 
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return "this is dt-validation test";
}
@RequestMapping("/save")
public EmployeeDTO save(@Valid @RequestBody EmployeeDTO employeedto)
{
	Employee e=new Employee();
	EmployeeDTO dt=new EmployeeDTO();
	e.setAge(employeedto.getAge());
	e.setName(employeedto.getName());
	e.setCity(employeedto.getCity());
	BeanUtils.copyProperties(dt,e);// ModelMapper can be also Used Here fields must be same  
	erepo.save(e);
	return dt;
	
}
}
