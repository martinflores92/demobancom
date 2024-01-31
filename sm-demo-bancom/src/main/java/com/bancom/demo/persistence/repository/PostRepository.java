package com.bancom.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancom.demo.persistence.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	
	List<Post> findByUsuarioId(Long id);
}
