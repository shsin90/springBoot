package com.syo.book.springboot.web;

import com.syo.book.springboot.domain.posts.Posts;
import com.syo.book.springboot.service.posts.PostsService;
import com.syo.book.springboot.web.dto.PostsResponseDto;
import com.syo.book.springboot.web.dto.PostsSaveRequestDto;
import com.syo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @PostMapping("/temp/setTemp")
    public HashMap<String, Object> setTemp(){
        HashMap<String, Object> tempMap = new HashMap<String, Object>();
        Object temp = postsService.findAllDesc();
        tempMap.put("posts", temp);
        return tempMap;
    }
//    public HashMap<String, Object> setTemp(){
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("id", "hello");
//        hashMap.put("password", "1234");
//        hashMap.put("email", "ssh@sygroup.kr");
//
//        return hashMap;
//    }
}
