package com.zerobase.fastlms.dto;

import com.zerobase.fastlms.entity.Banner;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BannerDto {

    Long id;
    String name;

    String originalImageName;
    String imagePath;
    String toURL;

    boolean newWindowYn;
    Long sortValue;
    boolean usingYn;

    LocalDate regDt;//등록일(추가날짜)
    LocalDate udtDt;//수정일(수정날짜)


    //추가컬럼
    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .name(banner.getName())
                .originalImageName(banner.getOriginalImageName())
                .imagePath(banner.getImagePath())
                .toURL(banner.getToURL())
                .newWindowYn(banner.isNewWindowYn())
                .sortValue(banner.getSortValue())
                .usingYn(banner.isUsingYn())
                .regDt(banner.getRegDt())
                .udtDt(banner.getUdtDt())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for(Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;

    }
}
