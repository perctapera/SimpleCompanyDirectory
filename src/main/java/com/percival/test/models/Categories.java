package com.percival.test.models;

import javax.persistence.*;

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
