package com.zerobase.fastlms.model.banner;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BannerInput {
    Long id;
    String name;

    String originalImageName;
    String imagePath;
    String toURL;

    boolean newWindowYn;
    Long sortValue;
    boolean usingYn;

    //삭제를 위한
    String idList;

}
