package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.FileVO;
import org.zerock.mapper.FileMapper;

@Service
public class FileService {

	@Autowired
	private FileMapper fileMapper;

	// 파일 정보 및 사용자 정보를 데이터베이스에 삽입하는 메소드
	public void insertFile(FileVO file) {
		fileMapper.insertFile(file);
	}

	public List<FileVO> getFilesByPlaceName(String placeName) {
		return fileMapper.getFilesByPlaceName(placeName);
	}

	public List<FileVO> getFilesByHashTag(String hashtag) {
		return fileMapper.getFilesByHashTag(hashtag);
	}

	public FileVO getFile(Long id) {
		return fileMapper.getFile(id);
	}

	public boolean deleteFileByName(String filename) {
		return fileMapper.deleteFileByName(filename);
	}

	public FileVO getFileById(Long id) {
		return fileMapper.getFileById(id);
	}

	

	public void updateFile(FileVO file) {
		fileMapper.updateFile(file);
	}

}