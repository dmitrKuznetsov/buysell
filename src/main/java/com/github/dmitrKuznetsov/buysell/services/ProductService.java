package com.github.dmitrKuznetsov.buysell.services;

import com.github.dmitrKuznetsov.buysell.models.Image;
import com.github.dmitrKuznetsov.buysell.models.Product;
import com.github.dmitrKuznetsov.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        if (title != null && !title.isBlank()) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        if (file1.getSize() != 0) {
            Image image = toImageEntity(file1);
            image.setPreviewImage(true);
            product.addImageToProject(image);

            product.setPreviewImageId(image.getId());
        }
        if (file2.getSize() != 0) {
            Image image = toImageEntity(file2);
            product.addImageToProject(image);
        }
        if (file3.getSize() != 0) {
            Image image = toImageEntity(file3);
            product.addImageToProject(image);
        }

        log.info("Saving new Product. Title {}, Author {}", product.getTitle(), product.getAuthor());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
