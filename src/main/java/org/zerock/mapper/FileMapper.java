package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.FileVO;

public interface FileMapper {

	void insertFile(FileVO file);

	List<FileVO> getFilesByPlaceName(String placeName);

	List<FileVO> getFilesByHashTag(String hashtag);

	FileVO getFile(Long id);

	boolean deleteFileByName(String filename);

	FileVO getFileById(Long id);

	
	void updateFile(FileVO file);//, String description, String address, int rating, String author , String phone_number, String sns_url, String otrher_info);
}