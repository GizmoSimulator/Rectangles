package com._6.rectangles.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<Rectangle,Integer>{
    Rectangle findByUid(Integer uid);
    
    void deleteByUid(Integer uid);
}
