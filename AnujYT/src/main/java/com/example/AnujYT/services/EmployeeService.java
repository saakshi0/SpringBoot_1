package com.example.AnujYT.services;

import com.example.AnujYT.dto.EmployeeDTO;
import com.example.AnujYT.entities.EmployeeEntity;
import com.example.AnujYT.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {



    @Autowired
    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity=employeeRepository.getById(id); //returns entity
//        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.isActive());
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map( employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());

        /*
        List<EmployeeDTO> list = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            EmployeeDTO map = modelMapper.map(employeeEntity, EmployeeDTO.class);
            list.add(map);
        }
        return list;
        */
    }

    public boolean deleteEmployeeById(Long id){
        boolean isPresent=employeeRepository.existsById(id);
        if(!isPresent) return false;

        employeeRepository.deleteById(id);
        return true;
    }

}
