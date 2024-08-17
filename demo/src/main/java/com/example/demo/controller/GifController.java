/*
 * Author : Naveen Kumar
 * Date : 17-08-2024
 * Created With : IntelliJ IDEA Community Edition
 */

package com.example.demo.controller;

import com.example.demo.model.Gif;
import com.example.demo.repo.GifRepo;
import com.example.demo.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gifs")
@CrossOrigin(origins = "http://localhost:4200")
public class GifController {

    @Autowired
    private GifService gifService;

    @Autowired
    private GifRepo gifRepo;

    @GetMapping("/search")
    public List<Gif> searchGifs(@RequestParam String tag) {
        return gifService.searchGifs(tag);
    }

    @PostMapping("/{id}/click")
    public void recordClick(@PathVariable String id) {
        gifService.recordClick(id);
    }

    @PostMapping("/{id}/share")
    public void recordShare(@PathVariable String id) {
        gifService.recordShare(id);
    }

    @PostMapping("/save")
    public Gif saveGif(@RequestBody Gif gif) {
        return gifRepo.save(gif);
    }
    @GetMapping("/ranked")
    public List<Gif> getRankedGifs() {
        return gifRepo.findAll().stream()
                .sorted(Comparator.comparingDouble((Gif gif) -> (gif.getClicks() + gif.getShares()) / 2.0).reversed())
                .collect(Collectors.toList());
    }

}