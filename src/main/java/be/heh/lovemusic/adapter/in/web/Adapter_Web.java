package be.heh.lovemusic.adapter.in.web;

import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Categories_For_Creation;
import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;
import be.heh.lovemusic.application.port.in.UseCase_In_Categories;
import be.heh.lovemusic.application.port.in.UseCase_In_Musics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Adapter_Web {
    private final UseCase_In_Categories useCase_in_categories;
    private final UseCase_In_Musics useCase_in_musics;
    public Adapter_Web(UseCase_In_Categories useCase_in_categories, UseCase_In_Musics useCase_in_musics) {
        this.useCase_in_categories = useCase_in_categories;
        this.useCase_in_musics = useCase_in_musics;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Categories>> getAllCategories() {
        return ResponseEntity.ok(useCase_in_categories.getAll());
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<Categories> getCategoriesById(@PathVariable int id) {
        Categories categories = useCase_in_categories.getById(id).stream().findFirst().orElse(null);
        return categories != null ? ResponseEntity.ok(categories) : ResponseEntity.notFound().build();
    }
    @PostMapping("/categories")
    public ResponseEntity<String> addCategories(@RequestBody Categories_For_Creation categories_for_creation) {
        useCase_in_categories.add(categories_for_creation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category added successfully");
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategories(@PathVariable int id) {
        useCase_in_categories.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category deleted successfully");
    }
    @GetMapping("/musics")
    public ResponseEntity<List<Musics>> getAllMusics() {
        return ResponseEntity.ok(useCase_in_musics.getAll());
    }
    @GetMapping("/musics/{id}")
    public ResponseEntity<Musics> getMusicById(@PathVariable int id) {
        Musics musics = useCase_in_musics.getById(id).stream().findFirst().orElse(null);
        return musics != null ?ResponseEntity.ok(musics) : ResponseEntity.notFound().build();
    }
    @GetMapping("/musics/{categoriesId}")
    public ResponseEntity<List<Musics>> getMusicsByCategoriesId(@PathVariable int categoriesId) {
        List<Musics> musics = (List<Musics>) useCase_in_musics.getByCategoryId(categoriesId).stream().findFirst().orElse(null);
        return musics != null ?ResponseEntity.ok(musics) : ResponseEntity.notFound().build();
    }
    @PostMapping("/musics")
    public ResponseEntity<String> addMusics(@Validated @RequestBody Musics_For_Creation musics_for_creation) {
        useCase_in_musics.add(musics_for_creation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Music added successfully");
    }
    @DeleteMapping("/musics")
    public ResponseEntity<String> deleteMusics(@Validated @RequestBody int id) {
        useCase_in_musics.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Music deleted successfully");
    }
}
