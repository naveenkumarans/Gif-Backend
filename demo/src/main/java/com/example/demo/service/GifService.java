/*
 * Author : Naveen Kumar
 * Date : 17-08-2024
 * Created With : IntelliJ IDEA Community Edition
 */

package com.example.demo.service;

import com.example.demo.model.Gif;
import com.example.demo.repo.GifRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GifService {


    @Autowired
    private GifRepo gifRepository;


    public List<Gif> searchGifs(String tag) {
        return gifRepository.findByTagsContainingIgnoreCaseOrderByClicksDescSharesDesc(tag);
    }

    public void recordClick(String gifId) {
        Gif gif = gifRepository.findById(String.valueOf(gifId)).orElseThrow();
        gif.setClicks(gif.getClicks() + 1);
        gifRepository.save(gif);
    }

    public void recordShare(String gifId) {
        Gif gif = gifRepository.findById(String.valueOf(gifId)).orElseThrow();
        gif.setShares(gif.getShares() + 1);
        gifRepository.save(gif);
    }

}
