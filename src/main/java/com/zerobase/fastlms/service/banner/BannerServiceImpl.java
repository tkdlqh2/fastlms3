package com.zerobase.fastlms.service.banner;

import com.zerobase.fastlms.dto.BannerDto;
import com.zerobase.fastlms.entity.Banner;
import com.zerobase.fastlms.mapper.BannerMapper;
import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.model.banner.BannerInput;
import com.zerobase.fastlms.model.banner.BannerParam;
import com.zerobase.fastlms.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;
    @Override
    public List<BannerDto> listAll(BannerParam parameter) {

        long totalCount  = bannerMapper.totalCount();

        List<BannerDto> list = bannerMapper.allList(parameter);
        if(!CollectionUtils.isEmpty(list)){
            int i = 0;
            for (BannerDto x : list){
                x.setTotalCount(totalCount);
                x.setSeq((totalCount - parameter.getPageStart()-i));
                i++;
            }
        }

        return list;
    }

    @Override
    public ServiceResult add(BannerInput parameter) {

        Banner banner = Banner.builder()
                .id(parameter.getId())
                .name(parameter.getName())
                .imagePath(parameter.getImagePath())
                .toURL(parameter.getToURL())
                .newWindowYn(parameter.isNewWindowYn())
                .sortValue(parameter.getSortValue())
                .usingYn(parameter.isUsingYn())
                .regDt(LocalDate.now())
                .build();

        bannerRepository.save(banner);
        return new ServiceResult(true);
    }

    @Override
    public ServiceResult set(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());

        if(!optionalBanner.isPresent()){
            return new ServiceResult(false,"유효하지 않는 배너입니다.");
        }

        Banner banner = optionalBanner.get();
        banner.setId(parameter.getId());
        banner.setName(parameter.getName());
        banner.setOriginalImageName(parameter.getOriginalImageName());
        banner.setImagePath(parameter.getImagePath());
        banner.setToURL(parameter.getToURL());
        banner.setNewWindowYn(parameter.isNewWindowYn());
        banner.setSortValue(parameter.getSortValue());
        banner.setUsingYn(parameter.isUsingYn());
        banner.setUdtDt(LocalDate.now());

        bannerRepository.save(banner);
        return new ServiceResult(true);
    }

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        return null;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public ServiceResult del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                    return new ServiceResult(false,"유효하지 않은 배너가 입력되었습니다.");
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return new ServiceResult(true);
    }

    @Override
    public List<BannerDto> frontList() {

        return bannerMapper.selectList();
    }
}
