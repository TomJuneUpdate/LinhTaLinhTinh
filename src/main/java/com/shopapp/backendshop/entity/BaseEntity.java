package com.shopapp.backendshop.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

//    @CreatedBy
    private String createdBy;

//    @LastModifiedBy
    private String updatedBy;

}
