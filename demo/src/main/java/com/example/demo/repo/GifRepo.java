/*
 * Author : Naveen Kumar
 * Date : 17-08-2024
 * Created With : IntelliJ IDEA Community Edition
 */

package com.example.demo.repo;

import com.example.demo.model.Gif;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GifRepo extends MongoRepository<Gif,String> {

    List<Gif> findByTagsContainingIgnoreCaseOrderByClicksDescSharesDesc(String tag);
    List<Gif> findAllByOrderByClicksDesc();

}

