document.addEventListener('DOMContentLoaded', function () {
    var dropbtn = document.querySelector('.dropbtn');

    // 문서에 클릭 이벤트 추가
    document.addEventListener('click', function (event) {
        var dropdown = document.getElementById('myDropdown');
        if (event.target !== dropbtn && !dropdown.contains(event.target)) {
            dropdown.classList.remove('show');
        }
    });
});

function toggleDropdown() {
    document.getElementById('myDropdown').classList.toggle('show');
}

function sortBy(type) {
    // 선택한 정렬 방식을 메뉴 버튼에 표시
    var dropbtn = document.querySelector('.dropbtn');
    dropbtn.textContent = type;

    // 여기서 선택한 정렬 방식에 따라 작업을 수행할 수 있습니다.
}

// 하트 아이콘 클릭에 대한 이벤트
function toggleHeart() {
    const heartContainer = event.currentTarget; // 하트를 감싸는 요소인 .heart
    const heartIcon = heartContainer.querySelector('i');
    heartIcon.classList.toggle('fa-regular');
    heartIcon.classList.toggle('fa-solid');

    // 부드러운 애니메이션을 위해 setTimeout을 이용하여 클래스 변경 후에 애니메이션 클래스 추가
    setTimeout(function () {
        heartIcon.classList.toggle('animate-heart');
    }, 50); // 적절한 시간을 설정하여 애니메이션 효과가 보이도록 함

    // 배경색 토글
    const container = event.currentTarget.closest('.board_container');
    container.classList.toggle('highlighted'); // 배경색을 토글하는 클래스 추가/제거
}
