package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.TripInfoVO;
import org.zerock.mapper.TripInfoMapper;

@Service
public class TripInfoService {

	@Autowired
    private TripInfoMapper tripInfoMapper; // TripInfoMapper 인터페이스 변수 선언


    // TripInfo 데이터 삽입 메서드
    public void insertTripInfo(TripInfoVO tripInfo) {
        tripInfoMapper.insertTripInfo(tripInfo); // TripInfoMapper의 메서드 호출
        System.out.println(tripInfo);
    }


    public TripInfoVO getTripInfoByPlaceName(String place_name) {
        return tripInfoMapper.getTripInfoByPlaceName(place_name);
    }
    
    public TripInfoVO getTripInfoByHashTag(String hashtag) {
        return tripInfoMapper.getTripInfoByHashTag(hashtag);
    }
}
