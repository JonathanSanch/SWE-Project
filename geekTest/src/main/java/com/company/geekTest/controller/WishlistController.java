package com.company.geekTest.controller;

import com.company.geekTest.model.Wishlist;
import com.company.geekTest.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("wishlist")
public class WishlistController {

    @Autowired
    WishlistRepository repository;

    @GetMapping("/wishlists")
    public List<Wishlist> getAllWishlists() {
        return repository.findAll();
    }

    @PostMapping("/wishlists")
    @ResponseStatus(HttpStatus.CREATED)
    public Wishlist addWishlist(@RequestBody Wishlist newWishlist) {
        return repository.save(newWishlist);
    }

    @DeleteMapping("/wishlists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWishlistById(@PathVariable int id) {
        repository.deleteById(id);
    }
}