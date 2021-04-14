package com.example.demo.service;

import java.util.List;

public interface IService<B>{
    List<B> findAll();
    B findById(Long id);
    B save(B b);
    void delete(Long id);

}
