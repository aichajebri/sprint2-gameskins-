package com.aisha.skins.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.skins.entities.Type;
import com.aisha.skins.repos.TypeRepository;


@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List <Type> findAll() {
        return typeRepository.findAll();
    }

	@Override
	public Type saveType(Type t) {
		return typeRepository.save(t);
	}

	@Override
	public Type updateType(Type t) {
		return typeRepository.save(t);
	}

	@Override
	public void deleteType(Type t) {
		typeRepository.delete(t);
	}

	@Override
	public void deleteTypeById(Long idType) {
		typeRepository.deleteById(idType);
	}

	@Override
	public Type getType(Long idType) {
		return typeRepository.findById(idType).get();
	}

   
}