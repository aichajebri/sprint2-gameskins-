package com.aisha.skins.service;

import java.util.List;

import com.aisha.skins.entities.Type;


public interface TypeService {

    List <Type> findAll();
    
    Type saveType(Type t);
    Type updateType(Type t);
    void deleteType(Type t);
     void deleteTypeById(Long id);
     Type getType (Long idType);

}