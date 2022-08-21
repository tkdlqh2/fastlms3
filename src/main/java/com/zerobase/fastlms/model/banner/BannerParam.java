package com.zerobase.fastlms.model.banner;

import com.zerobase.fastlms.model.CommonParam;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BannerParam extends CommonParam {
    Long id;
    String name;

    String originalImageName;
    String imagePath;
    String toURL;

    boolean newWindowYn;
    Long sortValue;
    boolean usingYn;

}
