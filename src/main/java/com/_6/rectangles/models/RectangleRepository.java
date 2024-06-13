package com._6.rectangles.models;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<Rectangle,Integer>{
    Rectangle findByUid(int uid);
    


}
