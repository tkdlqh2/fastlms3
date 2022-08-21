package com.zerobase.fastlms.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    String originalImageName;
    String imagePath;
    String toURL;

    boolean newWindowYn;
    Long sortValue;
    boolean usingYn;

    LocalDate regDt;
    LocalDate udtDt;

}
