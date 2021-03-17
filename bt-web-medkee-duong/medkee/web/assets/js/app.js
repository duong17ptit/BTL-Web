

// toggle cua menu

let btnShow = document.getElementById('header-icon-btn'); //trỏ tới id :header-icon-btn
let menu1= document.getElementById('menu');// trỏ tới id :menu
let remove1 = document.getElementById('remove-list');// trỏ tới id : remove-list
let outclick = document.getElementById('outclick1');//trỏ tới id: outclick1
console.log(btnShow);
btnShow.onclick = function() { //khi click vào id mà biến này trỏ tới thì thực hiện function
    console.log(btnShow);
    menu1.classList.add('active');// add 1 class mới vào có tên là active
    outclick.classList.add('active-x');    // remove 1 class có tên active
};

remove1.onclick=function(){ // khi click vào class remove1 thì bỏ đi class active của menu1 và outclick
    menu1.classList.remove('active');
    outclick.classList.remove('active-x');
};
outclick.onclick=function(){
    menu1.classList.remove('active');
    outclick.classList.remove('active-x');
};

// end toggle menu

//end select2




var my_value = 2;
$('#my_select option').each(function(){
    var $this = $(this); // cache this jQuery object to avoid overhead

    if ($this.val() == my_value) { // if this option's value is equal to our value
        $this.prop('selected', true); // select this option
        return false; // break the loop, no need to look further
    }
});



