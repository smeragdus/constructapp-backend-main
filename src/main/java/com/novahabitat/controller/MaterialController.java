package com.novahabitat.controller;

import com.novahabitat.dto.MaterialDTO;
import com.novahabitat.model.Material;
import com.novahabitat.service.IMaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final IMaterialService service;
    private final ModelMapper modelMapper; // Asegúrate de que este bean esté configurado

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> findAll() throws Exception{
        // READ ALL
        List<MaterialDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> findById(@PathVariable("id") Integer id) throws Exception{
        // READ BY ID
        MaterialDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Material>  save(@Valid @RequestBody MaterialDTO dto) throws Exception{
        // CREATE
        Material obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMaterial()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MaterialDTO dto) throws Exception{
        // UPDATE
        Material obj = service.update(convertToEntity(dto), id);
        MaterialDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        // DELETE
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // --- Métodos de Conversión (Mapper) ---

    // DTO -> Entity (Para POST y PUT)
    private Material convertToEntity(MaterialDTO dto){
        return modelMapper.map(dto, Material.class);
    }

    // Entity -> DTO (Para GET)
    private MaterialDTO convertToDto(Material obj){
        return modelMapper.map(obj, MaterialDTO.class);
    }
}