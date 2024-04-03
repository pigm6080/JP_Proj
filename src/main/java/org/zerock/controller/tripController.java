package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//여행정보 카테고리 컨트롤러 아마.. 두번쨰로 기능구현될 컨트롤러.랄까..
@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/trip/*")
public class tripController {
	
	@GetMapping("/home")
	public String home() {
		
		return "trip";
	}
	
	/*
	 * @Autowired private TravelInfoService infoService;
	 * 
	 * @Autowired private FilesService filesService;
	 * 
	 * @GetMapping("/detil") public String detail() {
	 * 
	 * return "trip/trip_detail"; }
	 * 
	 * 
	 * @GetMapping("/insert") public String insert() {
	 * 
	 * return "trip/trip_insert"; }
	 * 
	 * @PostMapping("/addUserAndFile") public String
	 * addUserAndFile(@RequestParam("destination") String destination,
	 * 
	 * @RequestParam("description") String description,
	 * 
	 * @RequestParam("category_id") int categoryid,
	 * 
	 * @RequestParam("file") MultipartFile[] files) throws
	 * UnsupportedEncodingException { // 사용자 정보 삽입 TravelInfoVO trip = new
	 * TravelInfoVO(); trip.setDestination(destination);
	 * trip.setDescription(description); trip.setCategory_id(categoryid);
	 * 
	 * infoService.insertTravelInfo(trip);
	 * 
	 * 
	 * // 파일 정보 삽입 int fileCount = Math.min(files.length, 3); // 최대 3개의 파일 업로드 for
	 * (int i = 0; i < fileCount; i++) { MultipartFile file = files[i]; String
	 * originalFilename = file.getOriginalFilename(); try {
	 * insertAndSaveFile(destination, originalFilename, file); } catch (IOException
	 * e) { e.printStackTrace(); // 파일 저장 실패 처리 } }
	 * 
	 * return "redirect:/result?username=" + URLEncoder.encode(destination,
	 * "UTF-8"); }
	 * 
	 * // 파일 정보 삽입 및 저장 메서드 private void insertAndSaveFile(String destination,
	 * String originalFilename, MultipartFile file) throws IOException { String
	 * filename = saveFile(file); String webPath = generateWebPath(filename);
	 * FilesVO fileInfo = new FilesVO();
	 * 
	 * fileInfo.setTravel_id(1); fileInfo.setFile_name(originalFilename); // 원래 파일명
	 * 설정 fileInfo.setFile_name(webPath); // 웹 경로 설정
	 * filesService.insertFiles(fileInfo); }
	 * 
	 * private String saveFile(MultipartFile file) throws IOException { String
	 * originalFilename = file.getOriginalFilename(); String filename =
	 * generateFilenameWithExtension(originalFilename); // 파일명에 확장자 추가 String
	 * filepath =
	 * "/Users/myhome/Documents/프로그래밍/spring_kimjewog/JP_Proj/src/main/webapp/WEB-INF/upup"
	 * + filename; file.transferTo(new java.io.File(filepath)); return filename; }
	 * // 파일 확장자를 확인하고 지정하는 메서드 private String getFileExtension(String
	 * originalFilename) { if (originalFilename != null &&
	 * !originalFilename.isEmpty()) { int lastIndex =
	 * originalFilename.lastIndexOf('.'); if (lastIndex != -1 && lastIndex <
	 * originalFilename.length() - 1) { return
	 * originalFilename.substring(lastIndex); } } return ""; // 확장자가 없는 경우 빈 문자열 반환
	 * }
	 * 
	 * // 파일명을 시간 형식으로 생성하는 메서드 (확장자 포함) private String
	 * generateFilenameWithExtension(String originalFilename) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS"); String
	 * currentTimeStamp = dateFormat.format(new Date()); String extension =
	 * getFileExtension(originalFilename); return currentTimeStamp + extension; }
	 * 
	 * // 웹 경로 생성 메서드 private String generateWebPath(String filename) { return
	 * "/uploaded-images/" + filename; }
	 */


}
