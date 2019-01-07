package com.sda.project.groupsda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property")
@EntityListeners(AuditingEntityListener.class)

public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedAt;

    @Column(unique = true, nullable = false)
    private String propertyName;

    @Column(precision = 10, scale = 2)
    private BigDecimal startsFrom;

    @BatchSize(size = 10)
    @OneToMany(targetEntity = AddressEntity.class, mappedBy = "property", cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;
}