/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.domains;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author thinh
 */
public class Database {
    private final List<Category> categories;
    private final List<Item> items;
    
    private Database() {
        categories = new ArrayList<Category>();
        items = new ArrayList<Item>();
        
        // Pre-defined categories
        String baseUrl = "http://localhost:8080/craftycle-backend/webresources/images/";
        Category category0 = new Category(0, "Old device", baseUrl + "animal.png");
        Category category1 = new Category(1, "Wood", baseUrl + "vehicle.png");
        Category category2 = new Category(2, "Paper", baseUrl + "girl.png");
        Category category3 = new Category(3, "Metal", baseUrl + "military.png");
        Category category4 = new Category(4, "Fabric", baseUrl + "anime.png");
        Category category5 = new Category(5, "Decoration", baseUrl + "love.png");
        Category category6 = new Category(6, "Everyday Waste", baseUrl + "celebrity.png");
        Category category7 = new Category(7, "Problematic Waste", baseUrl + "celebrity.png");
        
        categories.add(category0);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);
        categories.add(category7);   
    }
    
    // public static Database 
    public static Database getInstance() {
        return Singleton.object;
    }
    
    private static class Singleton {
        private static final Database object = new Database();
    }
    
    /**
     * Category
     */
    public List<Category> getAllCategories() {
        return categories;
    }
    
    public void addCategory(String categoryName) {
        Integer id = categories.size();
        Category newCategory = new Category(id, categoryName);
        categories.add(newCategory);
    }
    
    public Category categoryById(Integer id) {
        return Database.itemFromCollectionForId(categories, id);
    }
    
    /**
     * Generics Programming
     * 
     */
    public static <T extends IdentifiableElement, C extends Collection<T>> T itemFromCollectionForId(C collection, Integer id) {
        
        for (T element: collection) {
            if (element.getId() == id) {
                return element;
            }
        }
        
        return null;
    }
    
    /**
     * Item
     */
    
    public List<Item>getAllItems() {
        return items;
    }
    
    public void addItem(Integer catgoryId, String imageUrl) {
        Category category = Database.getInstance().categoryById(catgoryId);
        Integer itemId = items.size(); // Replicated auto-incremented id
        
        // Create new Item instance
        Item newItem = new Item(itemId, category, imageUrl);
        
        // Save item to database
        items.add(newItem);
    }
    
    public void addItem(Item item) {
        Integer itemId = items.size(); // Replicated auto-incremented id
        item.setId(itemId);
        
        // Save item to database
        items.add(item);
    }
    
    public Item itemById(Integer id) {
        return Database.itemFromCollectionForId(items, id);
    }
    
    
    
    
    
}
