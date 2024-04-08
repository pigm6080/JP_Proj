package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.TravelInfoVO;
import org.zerock.mapper.TravelInfoMapper;

@Service
public class TravelInfoService {

    @Autowired
    private TravelInfoMapper travelInfoMapper;

    // 모든 여행 정보 가져오기
    public List<TravelInfoVO> getAllTravelInfo() {
        return travelInfoMapper.getAllTravelInfo();
    }

    // 여행 ID로 여행 정보 가져오기
    public TravelInfoVO getTravelInfoById(int travel_id) {
        return travelInfoMapper.getTravelInfoById(travel_id);
    }

    // 여행 정보 추가
    public void insertTravelInfo(TravelInfoVO travelInfo) {
        travelInfoMapper.insertTravelInfo(travelInfo);
    }

    // 여행 정보 수정
    public void updateTravelInfo(TravelInfoVO travelInfo) {
        travelInfoMapper.updateTravelInfo(travelInfo);
    }

    // 여행 정보 삭제
    public void deleteTravelInfo(int travel_id) {
        travelInfoMapper.deleteTravelInfo(travel_id);
    }
}
