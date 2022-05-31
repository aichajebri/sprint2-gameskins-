package com.aisha.skins.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Type {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idType;
private String nomType;
private String descriptionType;
@JsonIgnore
@OneToMany(mappedBy = "type")
private List<Skins> Skins;
public Type() {}
public Type(String nomType, String descriptionType, List<Skins> Skins) 
{
super();
this.nomType = nomType;
this.descriptionType = descriptionType;
this.Skins = Skins;
}
public Long getIdType() {
return idType;
}
public void setIdType(Long idType) {
this.idType = idType;
}
public String getNomCat() {
return nomType;
}
public void setNomType(String nomType) {
this.nomType = nomType;
}
public String getDescriptionType() {
return descriptionType;
}
public void setDescriptionType(String descriptionType) {
this.descriptionType = descriptionType;
}
public List<Skins> getSkins() {
return Skins;
}
public void setProduits(List<Skins> Skins) {
this.Skins = Skins;
}
@Override
public String toString() {
	return "Type [idType=" + idType + ", nomType=" + nomType + ", descriptionType=" + descriptionType + "]";
}
}