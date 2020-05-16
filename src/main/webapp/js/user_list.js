$.get("/user/api")
    .done(function (users) {
        var userList = "";

        jQuery.each(users, function (i, item) {
            var roles = "";
            jQuery.each(item.roles, function (j, role) {
                roles += role;
                if (j !== item.roles.length - 1){
                    roles += ", ";
                }
            });

            var imgSrc;

            if (item.coverId === null) {
                var contextPath = $('#contextPathHolder').attr('data-contextPath');;
                imgSrc = contextPath + "/img/core-img/user_default.png";
            } else {
                imgSrc = "/user-cover-files/download/" + item.coverId;
            }

            userList += "<div class=\"card mb-3 w-50 mr-auto ml-auto\" style=\"max-width: 540px;\" id=\"full-info-" + item.id + "\">\n" +
                "<div class=\"row no-gutters\">\n" +
                "<div class=\"col-md-4 d-flex flex-column justify-content-center\">\n" +
                "<img src=\"" + imgSrc + "\" class=\"card-img\" alt=\"user photo\">\n" +
                "</div>\n" +
                "<div class=\"col-md-8\" id=\"first-block-" + item.id + "\">\n" +
                "<div class=\"card-body\">\n" +
                "<h5 class=\"card-title\">User No." + item.id + "</h5>\n" +
                "<p class=\"card-text\">\n" +
                "<b>First name:</b> " + item.firstName + "<br>\n" +
                "<b>Last name:</b> " + item.lastName + "<br>\n" +
                "<b>Email:</b> " + item.email + "<br>\n" +
                "<b>Roles:</b>\n" + roles +
                "</p>\n" +
                "<div class=\"d-flex flex-row\" id=\"buttons-" + item.id + "\">\n" +
                "<button class=\"btn mosh-btn full-info\" id=\"" + item.id + "\">Full info</button>\n" +
                "<a class=\"btn mosh-btn ml-4\" href=\"/user/edit?id=" + item.id + "\">Edit</a>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>" +
                "<div class=\"col-md-4 error-hidden\" id=\"second-block-" + item.id + "\"></div>" +
                "</div>\n" +
                "</div>"
        });

        $("#user-list").html(userList);
    });

function getSubjects(userId){
    var subjects = $.parseJSON($.ajax({
        url: "/grades/api/subjects-list?userId=" + userId,
        method: "GET",
        dataType: "json",
        async: false
    }).responseText);

    var subjectNames = "<h5 class=\"card-title\">Subjects: </h5>\n<p>";

    jQuery.each(subjects, function (i, item) {
        subjectNames += "&nbsp;" + item.name;

        if(i !== subjects.length - 1){
            subjectNames += "<br>";
        }
    });

    subjectNames += "\n</p>";

    return subjectNames;
}

function getCertificate(userId){
    var certificate = $.parseJSON($.ajax({
        url: "/grades/api/certificate-list?userId=" + userId,
        method: "GET",
        dataType: "json",
        async: false
    }).responseText);

    var certificateNames = "<h5 class=\"card-title\">Certificate: </h5>\n<p>";

    jQuery.each(certificate, function (i, item) {
        certificateNames += "&nbsp;" + item.name;

        if(i !== certificate.length - 1){
            certificateNames += "<br>";
        }
    });

    certificateNames += "\n</p>";

    return certificateNames;
}

$(document).on("click", ".full-info", function (event) {
    event.preventDefault();

    var id = $(this).attr("id");

    $("#full-info-" + id).addClass("w-100");
    $("#full-info-" + id).addClass("full-info-collapse");
    $("#first-block-" + id).removeClass("col-md-8");
    $("#first-block-" + id).addClass("col-md-4");
    $("#buttons-" + id).addClass("position-absolute");
    $("#buttons-" + id).addClass("fixed-bottom");
    $("#second-block-" + id).removeClass("error-hidden");
    $("#" + id).addClass("info-collapse");
    $("#" + id).removeClass("full-info");
    $("#" + id).html("Collapse");

    $("#second-block-" + id).append(getSubjects(id));
    $("#second-block-" + id).append(getCertificate(id));
});

$(document).on("click", ".info-collapse", function (event) {
    event.preventDefault();

    var id = $(this).attr("id");

    $("#full-info-" + id).removeClass("w-100");
    $("#first-block-" + id).removeClass("col-md-4");
    $("#first-block-" + id).addClass("col-md-8");
    $("#buttons-" + id).removeClass("position-absolute");
    $("#buttons-" + id).removeClass("fixed-bottom");
    $("#second-block-" + id).addClass("error-hidden");
    $("#full-info-" + id).removeClass("full-info-collapse");
    $("#" + id).removeClass("info-collapse");
    $("#" + id).addClass("full-info");
    $("#" + id).html("Full info");

    $("#second-block-" + id).html("");
});
