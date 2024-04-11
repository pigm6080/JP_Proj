document.addEventListener('DOMContentLoaded', function() {
    let startX, currentX, moving = false;
    let currentIndex = 0;
    const container = document.querySelector('.them_img_container');
    const totalBoxes = container.children.length;
    const slideWidth = 120;
    const gap = 10;
    let containerWidth = totalBoxes * (slideWidth + gap) - gap;
    container.style.width = `${containerWidth}px`;
    container.style.transition = 'transform 0.5s ease-out'; 

    function updateSlidePosition(final = false) {
        if (!final) {
            let moveX = startX - currentX;
            let newPos = -(currentIndex * (slideWidth + gap)) - moveX;
            container.style.transition = 'none'; 
            container.style.transform = `translateX(${newPos}px)`;
        } else {
            const newPosX = -(currentIndex * (slideWidth + gap));
            container.style.transition = 'transform 0.5s ease-out'; 
            container.style.transform = `translateX(${newPosX}px)`;
        }
    }

    const startHandler = function(e) {
        startX = e.type.includes('mouse') ? e.pageX : e.touches[0].clientX;
        moving = true;
        container.style.transition = 'none'; 
    };

    const moveHandler = function(e) {
        if (!moving) return;
        currentX = e.type.includes('mouse') ? e.pageX : e.touches[0].clientX;
        updateSlidePosition(); 
    };

    const endHandler = function() {
        if (!moving) return;
        let moveX = startX - currentX;
        if (moveX > 50 && currentIndex < totalBoxes - 1) { 
            currentIndex += 1;
        } else if (moveX < -50 && currentIndex > 0) { 
            currentIndex -= 1;
        }
        updateSlidePosition(true); 
        moving = false;
    };

    container.addEventListener('touchstart', startHandler);
    container.addEventListener('mousedown', startHandler);
    container.addEventListener('touchmove', moveHandler);
    container.addEventListener('mousemove', moveHandler);
    document.addEventListener('touchend', endHandler);
    document.addEventListener('mouseup', endHandler);
});
