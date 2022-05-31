package com.aisha.skins.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.skins.entities.Type;


@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{

}