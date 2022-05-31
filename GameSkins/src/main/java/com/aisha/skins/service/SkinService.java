package com.aisha.skins.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aisha.skins.entities.Type;
import com.aisha.skins.entities.Skins;
public interface SkinService {
Skins saveSkin(Skins s);
Skins updateSkin(Skins s);
void deleteSkin(Skins s);
 void deleteSkinById(Long id);
Skins getSkin(Long id);
List<Skins> getAllSkins();
Page<Skins> getAllSkinsParPage(int page, int size);
List<Skins> findByNomSkin(String nom);
List<Skins> findByNomSkinContains(String nom);
List<Skins> findByNomPrix (String nom, Double prix);
List<Skins> findByType (Type type);
List<Skins> findByTypeIdCat(Long id);

}