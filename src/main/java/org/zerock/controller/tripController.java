package org.zerock.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.FileUserVO;
import org.zerock.domain.FileVO;
import org.zerock.domain.TripInfoVO;
import org.zerock.domain.UserVO;
import org.zerock.service.FileService;
import org.zerock.service.FileUserService;
import org.zerock.service.TripInfoService;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//여행정보 카테고리 컨트롤러 아마.. 두번쨰로 기능구현될 컨트롤러.랄까..
@Controller
@Log4j
@RequestMapping("/trip/*")
@AllArgsConstructor
public class tripController {
	

    @Autowired
    private TripInfoService tripInfoService;
    
    @Autowired
    private FileUserService fileUserService;
    
    @Autowired
    private FileService fileService;
	
	@Autowired
	UserService service; 
	
	@GetMapping("/home")
	public String handleHomeRequest(@RequestParam(value = "hashtag", required = false) String hashtag, Model model) {
	    if (hashtag != null) {
	        // hashtag가 존재하는 경우, showResult 메서드 호출
	        return showResult(hashtag, model);
	    } else {
	        // 리다이렉트로 매핑이 아닌 경우, trip 페이지로 바로 리턴
	        return "trip";
	    }
	}

	@GetMapping("/regMember")
	public String regMember() {
		
		System.out.println("회원가입 폼 왔음.");
		
		return "redirect:/regMember";
	}
	
	@PostMapping("/reg")
	public String regmember(@ModelAttribute UserVO vo) {
		
	    System.out.println("회원가입 정보: " + vo);
	    
	    service.register(vo);
	    
	    return "redirect:/";
	}
	@GetMapping("/detailInsert")
	public String tripInsertForm() {
	    System.out.println("디테일 인서트폼 왔음.");
	    return "/trip/trip_insert";
	}


    @GetMapping("/delete")
    public String deleteFiles(@RequestParam("filename") String filename) {
        // 파일 삭제 로직을 구현합니다.
        // 예를 들어, 파일 서비스를 사용하여 파일을 삭제할 수 있습니다.
        boolean isDeleted = fileService.deleteFileByName(filename);
        if (isDeleted) {
            System.out.println("File " + filename + " has been successfully deleted.");
        } else {
            System.out.println("Failed to delete file " + filename);
        }

        // 파일 삭제 후 리다이렉트할 페이지를 반환합니다. (예: 파일 삭제 후 목록 페이지 등)
        return "redirect:/trip/home"; // 파일 삭제 후 홈 페이지로 리다이렉트
    }
    
    @RequestMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        // 파일 ID를 사용하여 수정할 파일을 조회하는 로직을 구현합니다.
        // 파일 서비스를 사용하여 파일 정보를 가져옵니다.
        FileVO file = fileService.getFileById(id);
        
        // 수정할 파일 정보를 모델에 추가합니다.
        model.addAttribute("file", file);
        // 모든 필요한 정보를 모델에 추가합니다.
        model.addAttribute("id", id);
        model.addAttribute("placeName", file.getPlaceName());
        model.addAttribute("description", file.getDescription());
        model.addAttribute("address", file.getAddress());
        model.addAttribute("rating", file.getRating());
        model.addAttribute("author", file.getAuthor());
        model.addAttribute("phone_number", file.getPhone_number());
        model.addAttribute("sns_url", file.getSns_url());
        model.addAttribute("other_info", file.getOther_info());
        
        // 수정 폼 페이지로 이동합니다.
        return "trip/trip_update";
    }

    @PostMapping(value = "/updateFile")
    public String updateFile(@ModelAttribute("file") FileVO file){
    	
    	System.out.println("컨트롤러 단 리퀘스트 파라미터 확인!!!!!"+ file +"file.toString() !!!!!"+ file.toString());

    	fileService.updateFile(file);
    	

        return "redirect:/";
    }

    
    
    @GetMapping("/showdetail")
    public String showDetailPage(@RequestParam("placeName") String placeName, 
                                 @RequestParam("hashtag") String hashtag, 
                                 Model model) {
        // 여기에 해당 placeName에 대한 상세 정보를 가져와서 모델에 추가하는 로직을 구현합니다.
        // 예를 들어, 서비스나 DAO를 사용하여 데이터베이스에서 해당 placeName에 대한 정보를 가져와 모델에 추가합니다.
        // 이후 trip/trip_detail.jsp 등의 뷰 페이지에서 모델에 담긴 정보를 사용하여 상세 정보를 보여줍니다.
        List<FileVO> files = fileService.getFilesByHashTag(hashtag);
        // 예시로 모델에 placeName을 추가하는 코드를 작성하겠습니다.
        model.addAttribute("placeName", placeName); // 여기서 place_name을 placeName으로 수정
        model.addAttribute("files", files);
        System.out.println(placeName);
        System.out.println(files);
        return "trip/trip_detail";
    }


    
    @PostMapping("/addUserAndFile")
    public String addUserAndFile(@RequestParam("username") String username,
                                  @RequestParam("placeName") String placeName,
                                  @RequestParam("hashtag") String hashtag,
                                  @RequestParam("description") String description,
                                  @RequestParam("address") String address,
                                  @RequestParam("rating") int rating,
                                  @RequestParam("author") String author,
                                  @RequestParam("phone_number") String phone_number,
                                  @RequestParam("sns_url") String sns_url,
                                  @RequestParam("other_info") String other_info,
                                  @RequestParam("file") MultipartFile[] files,
            Model model                      
    		) throws UnsupportedEncodingException {
        
    	System.out.println("여기까지옴.");
        // 사용자 정보 삽입
        FileUserVO user = new FileUserVO();
        user.setUsername(username);
        
		fileUserService.insertUser(user);
        System.out.println(user);
        
        // 여행 정보 삽입
        TripInfoVO tripInfo = new TripInfoVO();
        tripInfo.setPlaceName(placeName); 
        tripInfo.setHashtag(hashtag);
        tripInfoService.insertTripInfo(tripInfo);
        System.out.println("tripInfo = "+tripInfo);
        
        // 파일 정보 삽입
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String originalFilename = file.getOriginalFilename();
            try {
                insertAndSaveFile(username, originalFilename, placeName, file, hashtag, description, address, rating, author, phone_number, sns_url, other_info, model);
            } catch (IOException e) {
                e.printStackTrace();
                // 파일 저장 실패 처리
            }
            
        }

        return "redirect:/trip/home?hashtag=" + URLEncoder.encode(hashtag, "UTF-8");





    }



 // 파일 확장자를 확인하고 지정하는 메서드
    private String getFileExtension(String originalFilename) {
        if (originalFilename != null && !originalFilename.isEmpty()) {
            int lastIndex = originalFilename.lastIndexOf('.');
            if (lastIndex != -1 && lastIndex < originalFilename.length() - 1) {
                return originalFilename.substring(lastIndex);
            }
        }
        return ""; // 확장자가 없는 경우 빈 문자열 반환
    }

    // 파일명을 시간 형식으로 생성하는 메서드 (확장자 포함)
    private String generateFilenameWithExtension(String originalFilename) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String currentTimeStamp = dateFormat.format(new Date());
        String extension = getFileExtension(originalFilename);
        return currentTimeStamp + extension;
    }

    // 웹 경로 생성 메서드
    private String generateWebPath(String filename) {
        return "/uploaded-images/" + filename;
    }

    // 파일을 저장하고 파일명을 반환하는 메서드
    private String saveFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String filename = generateFilenameWithExtension(originalFilename); // 파일명에 확장자 추가
        String filepath = "C:/uploaded-images/" + filename;
        file.transferTo(new java.io.File(filepath));
        return filename;
    }

    // 파일 정보 삽입 및 저장 메서드
 // 파일 정보 삽입 및 저장 메서드
    private String insertAndSaveFile(String username, String originalFilename, String placeName, MultipartFile file,
    		String hashtag,String description, String address, int rating, String author, String phone_number, String sns_url, String other_info, Model model) throws IOException {
        String filename = saveFile(file);
        String webPath = generateWebPath(filename);
        FileVO fileInfo = new FileVO();
        fileInfo.setUsername(username);
        fileInfo.setPlaceName(placeName); // 여행지명 설정
        fileInfo.setFilename(originalFilename); // 원래 파일명 설정
        fileInfo.setFilepath(webPath); // 웹 경로 설정
        fileInfo.setHashtag(hashtag); // 해시태그 설정
        fileInfo.setDescription(description);//한줄소개설정
        fileInfo.setAddress(address);//주소설정
        fileInfo.setRating(rating);//별점
        fileInfo.setAuthor(author);//작성자
        fileInfo.setPhone_number(phone_number);//연락처
        fileInfo.setSns_url(sns_url);//sns주소
        fileInfo.setOther_info(other_info);//기타정보
        fileService.insertFile(fileInfo);
        System.out.println(fileInfo);

        Map<String, String> tripInfoMap = new HashMap<>();
        tripInfoMap.put("placeName", placeName);
        tripInfoMap.put("hashtag", hashtag);
        // 이러한 형식으로 다른 필요한 정보도 추가할 수 있음

        // 맵을 모델에 추가하여 리다이렉트할 때 함께 전달
        model.addAttribute("tripInfoPost", tripInfoMap);

        return hashtag; // 해시태그를 리턴
    }

    @GetMapping("/uploaded-images/{filename:.+}")
    @ResponseBody
    public byte[] getImage(@PathVariable String filename) throws IOException {
    	System.out.println("getImage실행됨");
        return Files.readAllBytes(Paths.get("C:/uploaded-images/" + filename));
    }


   
    

    @RequestMapping("/home")
    public String showResult(@RequestParam("hashtag") String hashtag,Model model)  {
        // 여행 정보 및 파일 정보 조회
        System.out.println("showResult실행됨");
        TripInfoVO tripInfo = tripInfoService.getTripInfoByHashTag(hashtag);
        if (tripInfo == null) {
            System.out.println("No trip info found for place: " + hashtag);
        }
        List<FileVO> fileList = fileService.getFilesByHashTag(hashtag);

        // 모델에 데이터 추가
        model.addAttribute("tripInfo", tripInfo);
        System.out.println("tripInfo: " + tripInfo);
        model.addAttribute("files", fileList);
        System.out.println("files: " + fileList);
        
        
        return "trip";
    }

    
 
	
}
