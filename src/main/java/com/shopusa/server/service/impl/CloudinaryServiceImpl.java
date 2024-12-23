package com.shopusa.server.service.impl;

import com.cloudinary.Cloudinary;
import com.shopusa.server.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public List<String> uploadImages(List<MultipartFile> files) throws IOException {
        List<String> uploadedUrls = new ArrayList<>();

        for (MultipartFile file : files) {
            // Extrae el nombre del archivo sin la extensión
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("Una de las imágenes no tiene un nombre válido.");
            }
            String imageName = originalFilename.substring(0, originalFilename.lastIndexOf('.')); // Elimina la extensión

            // Especifica la carpeta y asigna el public_id al nombre del archivo
            Map<String, Object> options = new HashMap<>();
            options.put("folder", "shop-usa");
            options.put("public_id", imageName); // Usa el nombre del archivo como public_id

            // Sube la imagen con las opciones
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), options);

            // Agrega la URL de la imagen subida a la lista
            uploadedUrls.add(uploadResult.get("url").toString());
        }
        return uploadedUrls;
    }
}