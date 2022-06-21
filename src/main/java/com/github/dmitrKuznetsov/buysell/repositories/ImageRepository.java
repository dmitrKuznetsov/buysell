package com.github.dmitrKuznetsov.buysell.repositories;

import com.github.dmitrKuznetsov.buysell.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
