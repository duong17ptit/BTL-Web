window.onload = function (){
    var qhurl = $('#get_quan_huyen_url').val();
    console.log(qhurl);
    $(function () {
        $('#tinhthanhpho').on('change', function (e) {
            var city_id = $(this).val();
            $.ajax({
                type: 'get',
                url: qhurl + city_id,
                data: city_id,
            }).done(function (res) {
                $('#quanhuyen').html(res);
            });
        });
    });


}
