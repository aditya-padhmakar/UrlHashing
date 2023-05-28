package com.example.urlhashing.service;

import com.example.urlhashing.model.HashedUrl;
import com.example.urlhashing.repository.HashedUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UrlHashingService {
    private static final String HASH_ALGORITHM = "SHA-256";

    private final HashedUrlRepository hashedUrlRepository;

    @Autowired
    public UrlHashingService(HashedUrlRepository hashedUrlRepository) {
        this.hashedUrlRepository = hashedUrlRepository;
    }

    @Transactional
    public String generateHashedUrl(String originalUrl) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashedBytes = digest.digest(originalUrl.getBytes());

            String hashedUrl = bytesToHexString(hashedBytes);
            HashedUrl entity = new HashedUrl();
            entity.setOriginalUrl(originalUrl);
            entity.setHashedUrl(hashedUrl);

            hashedUrlRepository.save(entity);

            return hashedUrl;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to generate hashed URL.", e);
        }
    }

    public String getOriginalUrl(String hashedUrl) {
        HashedUrl entity = hashedUrlRepository.findByHashedUrl(hashedUrl);
        if (entity != null) {
            return entity.getOriginalUrl();
        }
        return null;
    }

    private String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
