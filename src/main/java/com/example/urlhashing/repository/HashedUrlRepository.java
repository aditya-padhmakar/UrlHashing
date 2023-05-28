package com.example.urlhashing.repository;

import com.example.urlhashing.model.HashedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashedUrlRepository extends JpaRepository<HashedUrl, Long> {
    HashedUrl findByHashedUrl(String hashedUrl);
}
