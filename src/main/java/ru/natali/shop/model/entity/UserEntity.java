package ru.natali.shop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity {
    @ToString.Exclude

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ToString.Exclude

    @OneToOne
    @JoinColumn(name = "bucket_id")
    private BucketEntity bucket;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @ToString.Exclude
    private List<OrderEntity> orderEntityList;
}
