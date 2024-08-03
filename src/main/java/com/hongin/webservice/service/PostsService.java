package com.hongin.webservice.service;

import com.hongin.webservice.domain.Posts;
import com.hongin.webservice.domain.PostsRepository;
import com.hongin.webservice.dto.PostsMainResponseDto;
import com.hongin.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        Posts posts = postsRepository.save(dto.toEntity());
        return posts.getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
