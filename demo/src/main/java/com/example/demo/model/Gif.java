/*
 * Author : Naveen Kumar
 * Date : 17-08-2024
 * Created With : IntelliJ IDEA Community Edition
 */

package com.example.demo.model;

import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "gifs")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Gif {
    @Id
    private String id;

    private String url;
    private String tags;
    private Long clicks;
    private Long shares;
}
