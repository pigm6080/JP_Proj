package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.FilesVO;

public interface FilesMapper {
	
    List<FilesVO> getAllFiles();

    List<FilesVO> getFilesByTravelId(int travel_id);

    void insertFiles(FilesVO files);

    void updateFiles(FilesVO files);

    void deleteFiles(int file_id);

}
