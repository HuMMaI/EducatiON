$("#cover-file").change(function (){
    var fd = new FormData();
    var file = $('#cover-file')[0].files[0];

    if(file === undefined){
        return;
    }

    fd.append('coverFile', file);
    $.ajax({
        url: '/user-cover-files/upload?' + $("#sec-token").attr('name') + '=' + $("#sec-token").val(),
        type: 'post',
        data: fd,
        contentType: false,
        processData: false,
        success: function (coverId) {
            $("#user-cover")
                .attr("src", "/user-cover-files/download/" + coverId);
            $("#cover-id").val(coverId)
        },
    });
});