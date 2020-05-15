// $("#user-img").click(function (event) {
//     event.preventDefault();
//     showDropdown();
// });
//
// function showDropdown(){
//     var value = $("#click-listener").val();
//
//     if (value === "0") {
//         $("#user-img-container").addClass("show");
//         $("#user-img").attr("aria-expanded", "true");
//         $("#user-panel").addClass("show");
//         $("#click-listener").val("1");
//     } else {
//         $("#user-img-container").removeClass("show");
//         $("#user-img").attr("aria-expanded", "false");
//         $("#user-panel").removeClass("show");
//         $("#click-listener").val("0");
//     }
// }

$.get("/user-cover-files/user-cover-id")
    .done(function (coverId) {
        var imgSrc;

        if (coverId === "") {
            var contextPath = $('#contextPathHolder').attr('data-contextPath');;
            imgSrc = contextPath + "/img/core-img/user_default.png";
        } else {
            imgSrc = "/user-cover-files/download/" + coverId;
        }

        $("#user-img-src").val(imgSrc);
        $("#user-img").attr("src", imgSrc);
    });
