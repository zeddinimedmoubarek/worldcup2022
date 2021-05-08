package tn.rnu.isi.worldcup.controller;

import java.io.IOException; 
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
import org.springframework.web.multipart.MultipartFile;

import tn.rnu.isi.worldcup.entities.ImageModel;
import tn.rnu.isi.worldcup.repository.ImageRepository; 
 @RestController 
 @CrossOrigin(origins = "http://localhost:4200") 
 @RequestMapping(path = "image") 
 public class ImageUploadController { 
	 @Autowired ImageRepository imageRepository; 
	 @PostMapping("/upload")
	 public ResponseEntity<ImageModel> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException 
		 { ImageModel img =null; 
		 System.out.println("Taille de l'image : " + file.getBytes().length); 
		 boolean exist = imageRepository.existsByName(file.getOriginalFilename()); 
		 System.out.println("file name = "+file.getOriginalFilename()); 
		 ResponseEntity response = null;
	 if (!exist) 
	 { img = new ImageModel(file.getOriginalFilename(), file.getContentType(), file.getBytes()); 
	 imageRepository.save(img);
	 System.out.println("image ajoutée avec succès "); 
	 response = ResponseEntity.ok().body(img); } 
	 else if (exist)
	 { System.out.println("le nom de l'image existe déja");
	 }
	 response = ResponseEntity.badRequest().body(img); 
	 return response; }
	 @GetMapping(path = { "/get/{imageName}" }) 
	 public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException { 
		 System.out.println("nom de l'image : "+imageName); 
		 final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName); 
		 ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(), retrievedImage.get().getPicByte()); 
		 return img; } 
 
}