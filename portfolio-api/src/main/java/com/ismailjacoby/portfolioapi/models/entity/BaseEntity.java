package com.ismailjacoby.portfolioapi.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private  LocalDateTime createdAt;
}
