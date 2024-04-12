package org.zerock.mapper;

import org.zerock.domain.TripInfoVO;

public interface TripInfoMapper {
    // TripInfo 데이터 삽입 메서드
    void insertTripInfo(TripInfoVO tripInfo);
    
    TripInfoVO getTripInfoByPlaceName(String place_name);

    TripInfoVO getTripInfoByHashTag(String hashtag);
}