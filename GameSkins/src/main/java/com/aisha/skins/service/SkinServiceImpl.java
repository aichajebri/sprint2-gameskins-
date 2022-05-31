package com.aisha.skins.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aisha.skins.entities.Type;
import com.aisha.skins.entities.Skins;
import com.aisha.skins.repos.SkinRepository;
@Service
public class SkinServiceImpl implements SkinService {
@Autowired
SkinRepository skinRepository;
@Override
public Skins saveSkin(Skins s) {
	return skinRepository.save(s);
	}
	@Override
	public Skins updateSkin(Skins s) {
	return skinRepository.save(s);
	}
	@Override
	public void deleteSkin(Skins s) {
	skinRepository.delete(s);
	}
	 @Override
	public void deleteSkinById(Long id) {
	skinRepository.deleteById(id);
	}
	@Override
	public Skins getSkin(Long id) {
	return skinRepository.findById(id).get();
	}
	@Override
	public List<Skins> getAllSkins() {
	return skinRepository.findAll();
	}
	@Override
	public Page<Skins> getAllSkinsParPage(int page, int size) {
		return skinRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<Skins> findByNomSkin(String nom) {
	return skinRepository.findByNomSkin(nom);
	}
	@Override
	public List<Skins> findByNomSkinContains(String nom) {
	return skinRepository.findByNomSkinContains(nom);
	}
	@Override
	public List<Skins> findByNomPrix(String nom, Double prix) {
		return skinRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Skins> findByType(Type type) {
	return skinRepository.findByType(type);
	}
	@Override
	public List<Skins> findByTypeIdCat(Long id) {
	return skinRepository.findByTypeIdType(id);
	}
	
}