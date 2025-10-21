package com.novahabitat.controller;

import com.novahabitat.dto.CustomerDTO;
import com.novahabitat.model.Customer;
import com.novahabitat.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
//@AllArgsConstructor
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class CustomerController {
    //@Autowired
    private final ICustomerService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() throws Exception{

        List<CustomerDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id) throws Exception{

        CustomerDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Customer>  save(@Valid @RequestBody CustomerDTO dto) throws Exception{

        Customer obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdCustomer()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CustomerDTO dto) throws Exception{

        Customer obj = service.update(convertToEntity(dto), id);

        CustomerDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CustomerDTO convertToDto(Customer obj){
        return modelMapper.map(obj, CustomerDTO.class);
    }

    private Customer convertToEntity(CustomerDTO dto){
        return modelMapper.map(dto, Customer.class);
    }
    

}
