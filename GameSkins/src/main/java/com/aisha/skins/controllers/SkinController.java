package com.aisha.skins.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aisha.skins.entities.Type;
import com.aisha.skins.entities.Skins;
import com.aisha.skins.service.TypeService;
import com.aisha.skins.service.UserService;
import com.aisha.skins.entities.User;
import com.aisha.skins.service.SkinService;
@Controller
public class SkinController {
@Autowired
SkinService skinService;
@Autowired
TypeService typeService;
@Autowired
UserService userService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Type> type = typeService.findAll();
modelMap.addAttribute("types", type);
modelMap.addAttribute("Skins", new Skins());
modelMap.addAttribute("mode", "new");
return "formSkin";
}
@RequestMapping("/saveSkin")
public String saveSkin(ModelMap modelMap,@Valid Skins Skins,
BindingResult bindingResult)
{
	List<Type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
System.out.println(Skins);
if (bindingResult.hasErrors()) return "formSkin";
skinService.saveSkin(Skins);
return "redirect:/ListeSkins";
}

@RequestMapping("/showCreateType")
public String showCreateCat(ModelMap modelMap)
{
modelMap.addAttribute("types", new Type());
modelMap.addAttribute("mode", "new");
return "formType";
}
@RequestMapping("/saveType")
public String saveType(@ModelAttribute("type") Type type,ModelMap modelMap) throws ParseException 
{
Type saveType = typeService.saveType(type);
return "redirect:/ListeType";
}

@RequestMapping("/ListeType")
public String listeProduits(ModelMap modelMap)
{
List <Type> type = typeService.findAll();
modelMap.addAttribute("types", type);
return "ListeType";
}

@RequestMapping("/ListeSkins")
public String listeSkins(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<Type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
Page<Skins> skins = skinService.getAllSkinsParPage(page, size);
modelMap.addAttribute("skins", skins);
 modelMap.addAttribute("pages", new int[skins.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "ListeSkins";
}


@RequestMapping("/supprimerSkin")
public String supprimerSkin(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
skinService.deleteSkinById(id);
Page<Skins> skins = skinService.getAllSkinsParPage(page, 
size);
modelMap.addAttribute("skins", skins);
modelMap.addAttribute("pages", new int[skins.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "redirect:/ListeSkins";
}
@RequestMapping("/supprimerType")
public String supprimerType(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
typeService.deleteTypeById(id);
List<Type> types = typeService.findAll();
modelMap.addAttribute("types", types);
return "redirect:/ListeType";
}

@RequestMapping("/modifierSkin")
public String editerSkin(@RequestParam("id") Long id,ModelMap modelMap)
{
Skins s= skinService.getSkin(id);
List<Type> types = typeService.findAll();
types.remove(s.getType());
modelMap.addAttribute("types", types);
modelMap.addAttribute("Skins", s);
modelMap.addAttribute("mode", "edit");
return "formSkin";
}
@RequestMapping("/updateSkin")
public String updateSkin(@ModelAttribute("Skins") Skins Skins,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 Skins.setDateCreation(dateCreation);
	 
	 skinService.updateSkin(Skins);
	 List<Skins> skins = skinService.getAllSkins();
	 modelMap.addAttribute("skins", skins);
	return "ListeSkins";
	}
@RequestMapping("/modifierType")
public String editerType(@RequestParam("id") Long id,ModelMap modelMap)
{
Type t= typeService.getType(id);
modelMap.addAttribute("types", t);
modelMap.addAttribute("mode", "edit");
return "formType";
}
@RequestMapping("/updateType")
public String updateType(@ModelAttribute("type") Type type,ModelMap modelMap) throws ParseException {
	typeService.updateType(type);
	 List<Type> types = typeService.findAll();
	 modelMap.addAttribute("types", types);
	return "ListeType";
	}

@RequestMapping("/searchType")
public String searchType(@RequestParam("type") Long type,ModelMap modelMap)
{
Type types = new Type();
types.setIdType(type);
List<Type> type2 = typeService.findAll();
modelMap.addAttribute("types", type2);
List<Skins> skins = skinService.findByType(types);
modelMap.addAttribute("skins",skins);
modelMap.addAttribute("mode", "SearchType");
return "ListeSkins";
}

@RequestMapping("/CreateUser")
public String showCreateUser(ModelMap modelMap)
{
modelMap.addAttribute("users", new User());
modelMap.addAttribute("mode", "new");
return "FormUtilisateurs";
}

@RequestMapping("/saveUser")
public String saveUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException 
{
User saveUser = userService.saveUser(user);
return "redirect:/ListeUtilisateurs";
}

@RequestMapping("/ListeUtilisateurs")
public String ListeUser(ModelMap modelMap)
{
List <User> users = userService.findAll();
modelMap.addAttribute("users", users);
return "ListeUtilisateurs";
}
@RequestMapping("/supprimerUtilisateurs")
public String supprimerUser(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
userService.deleteUserById(id);
List<User> roles = userService.findAll();
modelMap.addAttribute("users", roles);
return "ListeUtilisateurs";
}

@RequestMapping("/modifierUtilisateurs")
public String modifierUser(@RequestParam("id") Long id,ModelMap modelMap)
{
User user= userService.getUser(id);
modelMap.addAttribute("users", user);
modelMap.addAttribute("mode", "edit");
return "FormUtilisateurs";
}
@RequestMapping("/updateUtilisateurs")
public String updateUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException {
	userService.updateUser(user);
	 List<User> roles = userService.findAll();
	 modelMap.addAttribute("users", roles);
	return "ListeUtilisateurs";
	}
}