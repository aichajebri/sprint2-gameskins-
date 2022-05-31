package com.aisha.skins.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aisha.skins.entities.Type;
import com.aisha.skins.entities.Skins;
@Repository
public interface SkinRepository extends JpaRepository<Skins, Long> {
	List<Skins> findByNomSkin(String nom);
	 List<Skins> findByNomSkinContains(String nom);
	 @Query("select s from Skins s where s.nomSkin like %:nom and s.prixSkin > :prix")
	 List<Skins> findByNomPrix(@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select s from Skins s where s.type = ?1")
	 List<Skins> findByType(Type type);
	 List<Skins> findByTypeIdType(Long id);

}