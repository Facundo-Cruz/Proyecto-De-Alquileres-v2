const toggleBtn = document.querySelector('.toggle_btn');
const toggleBtnIcon = document.querySelector('.toggle_btn i');
const dropDownMenu = document.querySelector('.dropdown_menu');

const userBtn = document.querySelector('.user_btn');
const userBtnIcon = document.querySelector('.user_btn .arrow');
const dropDownUser = document.querySelector('.dropdown_user');

toggleBtn.onclick = function () {

    if (dropDownUser.classList.contains('open')) {
        dropDownUser.classList.remove('open');
        userBtnIcon.classList = 'arrow';
    }

    dropDownMenu.classList.toggle('open');
    const isOpen = dropDownMenu.classList.contains('open');

    toggleBtnIcon.classList = isOpen
        ? 'fa-solid fa-xmark'
        : 'fa-solid fa-bars';

}

if (userBtn) {
    userBtn.onclick = function () {

        if (dropDownMenu.classList.contains('open')) {
            dropDownMenu.classList.remove('open');
            toggleBtnIcon.classList = 'fa-solid fa-bars';
        }
    
        dropDownUser.classList.toggle('open');
        const isOpen = dropDownUser.classList.contains('open');
    
        userBtnIcon.classList = isOpen
            ? 'arrow down'
            : 'arrow';
    
    }
}