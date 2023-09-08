package com.project.Accommodator.controller;
import com.project.Accommodator.model.Favorite;
import com.project.Accommodator.model.Posting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.Accommodator.service.FavoriteService;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    FavoriteService FavoriteService;
    @CrossOrigin
    @GetMapping("/get/{id}")
    public Iterable<Posting> getFavoriteById(@PathVariable("id") int id) {
        return FavoriteService.getFavoriteById(id);
    }
    @CrossOrigin
    @PostMapping("/create")
    public Favorite createFavorite(@RequestBody Favorite Favorite) {
        return FavoriteService.createFavorite(Favorite);
    }
}
