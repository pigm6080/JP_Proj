package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.FilesVO;
import org.zerock.mapper.FilesMapper;

@Service
public class FilesService {

    @Autowired
    private FilesMapper filesMapper;

    // 모든 파일 가져오기
    public List<FilesVO> getAllFiles() {
        return filesMapper.getAllFiles();
    }

    // 여행 ID로 파일 가져오기
    public List<FilesVO> getFilesByTravelId(int travel_id) {
        return filesMapper.getFilesByTravelId(travel_id);
    }

    // 파일 추가
    public void insertFiles(FilesVO files) {
        filesMapper.insertFiles(files);
    }

    // 파일 수정
    public void updateFiles(FilesVO files) {
        filesMapper.updateFiles(files);
    }

    // 파일 삭제
    public void deleteFiles(int file_id) {
        filesMapper.deleteFiles(file_id);
    }
}
