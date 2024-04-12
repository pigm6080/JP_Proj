document.addEventListener('DOMContentLoaded', function() {
  // 햄버거 메뉴 엘리먼트를 찾습니다.
  const hamburger = document.querySelector('.hamburger');
  // 메뉴 엘리먼트를 찾습니다.
  const menu = document.querySelector('.menu');

  hamburger.addEventListener('click', function() {
      menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
  });
});

document.addEventListener("DOMContentLoaded", function () {
  let progress = document.getElementById("progress"); // 프로그레스 바 엘리먼트
  let numElement = document.querySelector(".info_num"); // 숫자 표시 엘리먼트
  let currentSlide = 0; // 현재 슬라이드 인덱스, 0부터 시작
  const maxSlides = 5; // 총 슬라이드 수

  // 프로그레스 바와 숫자 업데이트
  function updateProgressAndNumber() {
      progress.value = (currentSlide + 1) * 20; // 프로그레스 바 값 업데이트
      numElement.textContent = (currentSlide + 1).toString().padStart(2, "0"); // 현재 슬라이드 번호로 숫자 업데이트
      slideToCurrent(); // 현재 슬라이드로 이동
  }

  // 현재 슬라이드로 이동
  function slideToCurrent() {
      const offset = currentSlide * -100; // 슬라이드 이동을 위한 오프셋 계산
      document.querySelector(".home_slide_container").style.transform = `translateX(${offset}vw)`; // 슬라이드 이동
  }

  // 화살표 클릭 이벤트
  document.getElementById("leftArrow").addEventListener("click", function (e) {
      e.preventDefault();
      currentSlide = (currentSlide - 1 + maxSlides) % maxSlides; // 순환
      updateProgressAndNumber();
  });

  document.getElementById("rightArrow").addEventListener("click", function (e) {
      e.preventDefault();
      currentSlide = (currentSlide + 1) % maxSlides; // 순환
      updateProgressAndNumber();
  });

  // 초기 프로그레스 바와 숫자 업데이트
  updateProgressAndNumber();
});



document.addEventListener('DOMContentLoaded', function() {
let intervalId = null; // 인터벌 ID를 저장할 변수

function setSlidePosition(currentIndex, slides) {
  const totalSlides = slides.length;
  for (let i = 0; i < totalSlides; i++) {
    slides[i].style.transform = `translateX(${(i - currentIndex) * 100}%)`;
    // 텍스트에 애니메이션 클래스 추가
    const textElement = slides[i].querySelector('.home_slide' + (i+1) + '_text');
    if (textElement) {
      textElement.classList.remove('slide-text-animation'); // 먼저 애니메이션 클래스를 제거합니다.
      // 브라우저가 동기적으로 클래스 변경을 처리하므로, 애니메이션을 재시작하기 위해 비동기적으로 클래스를 추가합니다.
      setTimeout(() => textElement.classList.add('slide-text-animation'), 10);
    }
  }
}

function updateProgress(progressValue) {
  document.getElementById("progress").value = progressValue;
}

function increaseNumber(numElement) {
  let num = parseInt(numElement.textContent);
  num = num >= 5 ? 1 : num + 1;
  numElement.textContent = num.toString().padStart(2, "0");
}

function startSlideShow() {
  const slides = document.querySelectorAll('.home_slide_container > div');
  if (slides.length === 0) return; // 슬라이드가 없으면 중단
  let currentIndex = 0;
  let progressValue = 1; 
  const numElement = document.querySelector(".info_num");

  setSlidePosition(currentIndex, slides);
  updateProgress(progressValue);

  intervalId = setInterval(function() {
    currentIndex = (currentIndex + 1) % slides.length;
    setSlidePosition(currentIndex, slides);
    progressValue = progressValue >= 5 ? 1 : progressValue + 1;
    updateProgress(progressValue);
    increaseNumber(numElement);
  }, 3000); // 3초마다 실행
}

function checkScreenSize() {
  if (window.matchMedia("(max-width: 600px)").matches) {
    if (intervalId === null) {
      startSlideShow();
    }
  } else {
    if (intervalId !== null) {
      clearInterval(intervalId);
      intervalId = null;
    }
  }
}

checkScreenSize(); // 초기 로드 시 실행
window.addEventListener('resize', checkScreenSize); // 창 크기 변경 시 실행
});