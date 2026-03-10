package com.foro.forohub.controller;

import com.foro.forohub.model.Topico;
import com.foro.forohub.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

 @Autowired
 private TopicoRepository repository;

 @PostMapping
 public Topico crear(@RequestBody Topico topico){
  return repository.save(topico);
 }

 @GetMapping
 public List<Topico> listar(){
  return repository.findAll();
 }

 @GetMapping("/{id}")
 public Topico obtener(@PathVariable Long id){
  return repository.findById(id).orElse(null);
 }

 @PutMapping("/{id}")
 public Topico actualizar(@PathVariable Long id, @RequestBody Topico datos){

  Topico topico = repository.findById(id).orElse(null);

  if(topico != null){
   topico.setTitulo(datos.getTitulo());
   topico.setMensaje(datos.getMensaje());
   topico.setAutor(datos.getAutor());
   topico.setCurso(datos.getCurso());

   return repository.save(topico);
  }

  return null;
 }

 @DeleteMapping("/{id}")
 public void eliminar(@PathVariable Long id){
  repository.deleteById(id);
 }

}