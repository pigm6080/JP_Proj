package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.TravelInfoVO;

public interface TravelInfoMapper {

    List<TravelInfoVO> getAllTravelInfo();

    TravelInfoVO getTravelInfoById(int travel_id);

    void insertTravelInfo(TravelInfoVO travelInfo);

    void updateTravelInfo(TravelInfoVO travelInfo);

    void deleteTravelInfo(int travel_id);
}
