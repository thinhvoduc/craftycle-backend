/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.domains;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thinh
 */
public class Database {
    private final List<Category> categories;
    
    private Database() {
        categories = new ArrayList<Category>();
        
        // Pre-defined categories
        String baseUrl = "http://localhost:8080/CategoryApp/webresources/images/";
        Category category0 = new Category(0, "Animal", baseUrl + "animal.png");
        Category category1 = new Category(1, "Vehicle", baseUrl + "vehicle.png");
        Category category2 = new Category(2, "Girl", baseUrl + "girl.png");
        Category category3 = new Category(3, "Military", baseUrl + "military.png");
        Category category4 = new Category(4, "Anime", baseUrl + "anime.png");
        Category category5 = new Category(5, "Love", baseUrl + "love.png");
        Category category6 = new Category(6, "Celebrity", baseUrl + "celebrity.png");
        
        categories.add(category0);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);
    }
    
    // public static Database 
    public static Database getInstance() {
        return Singleton.object;
    }
    
    private static class Singleton {
        private static final Database object = new Database();
    }
    
    public List<Category> getAllCategories() {
        return this.categories;
    }
    
    public void addCategory(String categoryName) {
        Integer id = categories.size();
        Category newCategory = new Category(id, categoryName);
        categories.add(newCategory);
    }
    
}
