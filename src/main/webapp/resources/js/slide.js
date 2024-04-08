// 네비게이션 바 제어
const navButtons = document.querySelectorAll(".nav-buttons > .button");

function scrollToSection(sectionName) {
  const section = document.getElementById(sectionName);

  if (section) {
    const sectionTop = section.offsetTop;
    const scrollOffset = 100;
    window.scrollTo({
      top: sectionTop - scrollOffset,
      behavior: "smooth",
    });
  }
}

navButtons.forEach((button) => {
  button.addEventListener("click", function () {
    const sectionName = this.textContent.trim();
    scrollToSection(sectionName);
    const sectionName2 = this.dataset.section;
    scrollToSection(sectionName2);
    navButtons.forEach((btn) => btn.classList.remove("on"));
    this.classList.add("on");
  });
});

// 슬라이드쇼 제어
/*
document.addEventListener("DOMContentLoaded", function () {
  const slides = document.querySelectorAll(".inner");
  const prevBtn = document.querySelector(".them_prevBtn");
  const nextBtn = document.querySelector(".them_nextBtn");
  let currentSlide = 0;
  let slideInterval = setInterval(nextSlide, 3000);

  function showSlide(n) {
    slides.forEach((slide) => {
      slide.style.display = "none";
    });
    slides[n].style.display = "flex";
  }

  function prevSlide() {
    currentSlide = (currentSlide - 1 + slides.length) % slides.length;
    showSlide(currentSlide);
  }

  function nextSlide() {
    currentSlide = (currentSlide + 1) % slides.length;
    showSlide(currentSlide);
  }

  function stopSlideInterval() {
    clearInterval(slideInterval);
  }

  function startSlideInterval() {
    slideInterval = setInterval(nextSlide, 5000);
  }

  prevBtn.addEventListener("click", function () {
    stopSlideInterval();
    prevSlide();
  });

  nextBtn.addEventListener("click", function () {
    stopSlideInterval();
    nextSlide();
  });

  slides.forEach((slide) => {
    slide.addEventListener("mouseover", stopSlideInterval);
    slide.addEventListener("mouseleave", startSlideInterval);
  });

  showSlide(currentSlide);
});

*/
