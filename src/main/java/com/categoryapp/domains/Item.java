/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.domains;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thinh
 */
@XmlRootElement
public class Item implements IdentifiableElement {
    private Integer id;
    private Category category;
    private String imageUrl;
    private Boolean crafted;
    
    public Item() {}
    
    public Item(Integer id, Category category, String imageUrl) {
        this.id = id;
        this.category = category;
        this.imageUrl = imageUrl;
    }
    
    @XmlElement
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @XmlElement
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlElement
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    @XmlElement
    public Boolean getCrafted() {
        return crafted;
    }
    
    public void setCrafted(Boolean crafted) {
        this.crafted = crafted;
    }
}
