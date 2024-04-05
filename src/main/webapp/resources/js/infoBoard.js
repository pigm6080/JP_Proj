// 해시태그 클릭 시 해당 게시물 목록을 표시하도록 이벤트 추가
document.querySelectorAll('.hashtag_circle1').forEach(function (hashtag) {
    hashtag.addEventListener('click', changeBoardCategory);
});

// 해시태그 클릭 시 카테고리 변경 함수
function changeBoardCategory(event) {
    const clickedHashtag = event.currentTarget;
    const boardCategory = clickedHashtag.querySelector('.hashtag_title_text').textContent;
    const boardCategoryElement = document.querySelector('.board_category');
    if (boardCategoryElement) {
        boardCategoryElement.textContent = boardCategory;
    }

    // 클릭된 해시태그에 따라 해당하는 게시물 목록 표시
    if (boardCategory === '#카페') {
        showCafeBoard();
    } else if (boardCategory === '#맛집') {
        showRestaurantBoard();
    } else if (boardCategory === '#체험') {
        showExpBoard();
    } else if (boardCategory === '#공원') {
        showParkBoard();
    } else if (boardCategory === '#테마') {
        showThemBoard();
    } else if (boardCategory === '#공방') {
        showMakeBoard();
    } else if (boardCategory === '#축제') {
        showFestBoard();
    } else if (boardCategory === '#전시') {
        showShowBoard();
    } else if (boardCategory === '#야경') {
        showNightBoard();
    }
}

// JavaScript
// 카페 게시물 목록 표시
function showCafeBoard() {
    const cafeBoard = document.getElementById('cafe_board');
    if (cafeBoard) {
        cafeBoard.style.display = 'block';
        cafeBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'cafe_board') {
            board.style.display = 'none';
        }
    });
}

// 맛집 게시물 목록 표시
function showRestaurantBoard() {
    const restaurantBoard = document.getElementById('restaurant_board');
    if (restaurantBoard) {
        restaurantBoard.style.display = 'block';
        restaurantBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'restaurant_board') {
            board.style.display = 'none';
        }
    });
}

// 체험 게시물 목록 표시
function showExpBoard() {
    const expBoard = document.getElementById('exp_board');
    if (expBoard) {
        expBoard.style.display = 'block';
        expBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'exp_board') {
            board.style.display = 'none';
        }
    });
}

// 공원 게시물 목록 표시
function showParkBoard() {
    const parkBoard = document.getElementById('park_board');
    if (parkBoard) {
        parkBoard.style.display = 'block';
        parkBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'park_board') {
            board.style.display = 'none';
        }
    });
}

// 테마 게시물 목록 표시
function showThemBoard() {
    const themBoard = document.getElementById('them_board');
    if (themBoard) {
        themBoard.style.display = 'block';
        themBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'them_board') {
            board.style.display = 'none';
        }
    });
}

// 공방 게시물 목록 표시
function showMakeBoard() {
    const makeBoard = document.getElementById('make_board');
    if (makeBoard) {
        makeBoard.style.display = 'block';
        makeBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'make_board') {
            board.style.display = 'none';
        }
    });
}

// 축제 게시물 목록 표시
function showFestBoard() {
    const festBoard = document.getElementById('fest_board');
    if (festBoard) {
        festBoard.style.display = 'block';
        festBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'fest_board') {
            board.style.display = 'none';
        }
    });
}

// 전시 게시물 목록 표시
function showShowBoard() {
    const showBoard = document.getElementById('show_board');
    if (showBoard) {
        showBoard.style.display = 'block';
        showBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'show_board') {
            board.style.display = 'none';
        }
    });
}

// 야경 게시물 목록 표시
function showNightBoard() {
    const nightBoard = document.getElementById('night_board');
    if (nightBoard) {
        nightBoard.style.display = 'block';
        nightBoard.classList.add('fade-in'); // 애니메이션 클래스 추가
    }
    // 나머지 게시물 숨기기
    const boards = document.querySelectorAll('.board_list');
    boards.forEach(function (board) {
        if (board.id !== 'night_board') {
            board.style.display = 'none';
        }
    });
}
