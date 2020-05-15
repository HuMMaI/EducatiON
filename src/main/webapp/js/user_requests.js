$.get("/requests/api/")
    .done(function (userRequests) {
        var requestCards = "";

        jQuery.each(userRequests, function (key, item) {
            requestCards += "<div class=\"card w-100 mb-3\">\n" +
                "<h5 class=\"card-header\">Request No." + item.id + "</h5>\n" +
                "<div class=\"row no-gutters\">\n" +
                "<div class=\"col-md-5\">\n" +
                "<div class=\"card-body\">\n" +
                "<p class=\"card-text\">\n" +
                "<b>First name:</b> " + item.user.firstName + "<br>\n" +
                "<b>Last name:</b> " + item.user.lastName + "<br>\n" +
                "<b>Email:</b> " + item.user.email + "<br>\n" +
                "</p>\n" +
                "<small class=\"info-text user-all\" id=\"user-info " + item.user.id + "\">Show all</small>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"col-md-5\">\n" +
                "<div class=\"card-body\">\n" +
                "<p class=\"card-text\" id=\"user-" + item.user.id + "\">\n" +
                "<b>Faculty:</b> " + item.faculty.name + "<br>\n" +
                "</p>\n" +
                "<small class=\"info-text subject-all\" id=\"user-subject " + item.user.id + "\">Show all info</small>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"col-md-2 d-flex flex-column justify-content-around\">\n" +
                "<form action=\"\">\n" +
                "<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\"/>\n" +
                "<button class=\"btn mosh-btn accept-btn\" id=\"accept-btn " + item.id + "\" type=\"submit\">Accept</button>\n" +
                "</form>\n" +
                "<button class=\"btn mosh-btn cancel-btn\" request-id=\"" + item.id + "\" id=\"cancel-btn " + item.user.id + "\" type=\"submit\">Cancel</button>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"card-footer no-gutter error-hidden d-flex flex-row req-info\" id=\"req-info-" + item.user.id + "\">\n" +
                "</div>\n" +
                "</div>";

            $("#user-requests").append(requestCards);

            $.get("/grades/api/subjects-list?userId=" + item.user.id)
                .done(function (data) {
                    var subjects = "<b>Subjects: </b>"
                    jQuery.each(data, function (i, item) {
                        subjects += item.name;

                        if(i !== data.length - 1){
                            subjects += ", "
                        }
                    });
                    subjects += "<br>"

                    $("#user-" + item.user.id).append(subjects);
                });

            $.get("/grades/api/certificate-list?userId=" + item.user.id)
                .done(function (data) {
                    var certificate = "<b>Certificate: </b>"
                    jQuery.each(data, function (i, item) {
                        certificate += item.name;

                        if(i !== data.length - 1){
                            certificate += ", "
                        }
                    });

                    $("#user-" + item.user.id).append(certificate);
                });
        });
    });

$(document).on("click", ".user-all", function () {
    var idStr = $(this).attr("id");
    var idArray = idStr.split(/\s+/);

    $("#req-info-" + idArray[1]).html("");

    $.get("/user/api/find?id=" + idArray[1])
        .done(function (user) {
            var imgSrc;

            if (user.coverId === null) {
                var contextPath = $('#contextPathHolder').attr('data-contextPath');;
                imgSrc = contextPath + "/img/core-img/user_default.png";
            } else {
                imgSrc = "/user-cover-files/download/" + user.coverId;
            }

            var userInfo = "<div class=\"col-md-4\">\n" +
                "<img src=\"" + imgSrc + "\" alt=\"user photo\">\n" +
                "</div>\n" +
                "<div class=\"col-md-7\">\n" +
                "<p>\n" +
                "<b>First name:</b> " + user.firstName + "<br>\n" +
                "<b>Last name:</b> " + user.lastName + "<br>\n" +
                "<b>Email:</b> " + user.email + "\n" +
                "</p>\n" +
                "</div>\n" +
                "<div class=\"col-md-1 text-right\">\n" +
                "<span class=\"alert-link ml-auto info-close\"><i class=\"fas fa-times\"></i></span>\n" +
                "</div>";

            var divId = "#req-info-" + idArray[1];
            $(divId).removeClass("error-hidden");
            $(divId).html(userInfo);
        });
});

$(document).on("click", ".subject-all", function () {
    var idStr = $(this).attr("id");
    var idArray = idStr.split(/\s+/);

    $("#req-info-" + idArray[1]).html("");

    $.get("/grades/api/subjects-list?userId=" + idArray[1])
        .done(function (subjects) {
            var subjectsInfo = "<div class=\"col-md-6\">\n" +
                "<p><b>Subjects:</b><br>\n";

            jQuery.each(subjects, function (i, item) {
                subjectsInfo += "<span class=\"d-flex flex-row\">" + "<span> &nbsp;" + item.name + "</span>" + "<span class=\"ml-auto\">" + item.grade + "</span>";
            });

            subjectsInfo += "\n</p>\n</div>\n";

            $("#req-info-" + idArray[1]).append(subjectsInfo);
        });

    $.get("/grades/api/certificate-list?userId=" + idArray[1])
        .done(function (certificate) {
            var certificateInfo = "<div class=\"col-md-5\">\n" +
                "<p><b>Certificate:</b><br>\n";

            jQuery.each(certificate, function (i, item) {
                certificateInfo += "<span class=\"d-flex flex-row\">" + "<span> &nbsp;" + item.name + "</span>" + "<span class=\"ml-auto\">" + item.grade + "</span>" + "</span>";
            });

            var closeInfo = "<div class=\"col-md-1 text-right\">\n" +
                "<span class=\"alert-link ml-auto info-close\"><i class=\"fas fa-times\"></i></span>\n" +
                "</div>";

            certificateInfo += "\n</p>\n</div>\n" + closeInfo;

            $("#req-info-" + idArray[1]).append(certificateInfo);
        });

    $("#req-info-" + idArray[1]).removeClass("error-hidden");
});

$(document).on("click", ".info-close", function () {
    $(".req-info").addClass("error-hidden");
    $(".req-info").html();
});

$(document).on("click", ".cancel-btn", function (event) {
    event.preventDefault();

    var idStr = $(this).attr("id");
    var idArray = idStr.split(/\s+/);
    var requestId = $(this).attr("request-id");

    $("#req-info-" + idArray[1]).html("");

    var reasonInfo = "<div class=\"col-12\">\n" +
        "<div class=\"d-flex flex-row\">\n" +
        "<h5 class=\"card-title\">Reason</h5>\n" +
        "<div class=\"col-md-1 text-right ml-auto\">\n" +
        "<span class=\"alert-link info-close\"><i class=\"fas fa-times\"></i></span>\n" +
        "</div>\n" +
        "</div>" +
        "<form action=\"\">\n" +
        "<div class=\"input-group mb-3\">\n" +
        "<input type=\"text\" class=\"form-control request-cancel\" placeholder=\"Write cancel reason\" aria-label=\"Cancel reason\" aria-describedby=\"button-addon2\">\n" +
        "<div class=\"input-group-append\">\n" +
        "<button class=\"btn btn-outline-secondary request-cancel\" type=\"button\" id=\"button-addon2 request-cancel " + requestId + "\">Send</button>\n" +
        "</div>\n" +
        "</div>" +
        "</form>\n" +
        "</div>";

    $("#req-info-" + idArray[1]).html(reasonInfo);
    $("#req-info-" + idArray[1]).removeClass("error-hidden");
});

$(document).on("click", ".accept-btn", function (event) {
    event.preventDefault();

    var idStr = $(this).attr("id");
    var idArray = idStr.split(/\s+/);

    $("#accept-btn-" + idArray[1]).prop("disabled", true);

    $.ajax({
        url: "/statement/api/add?id=" + idArray[1],
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "POST"
    })
        .done(function () {
            location.reload();
        });
});

$(document).on("click", ".request-cancel", function (event) {
    event.preventDefault();

    var idStr = $(this).attr("id");
    var idArray = idStr.split(/\s+/);

    $(".request-cancel").prop("disabled", true);

    $.ajax({
        url: "/statement/api/cancel?id=" + idArray[2],
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "POST"
    })
        .done(function () {
            location.reload();
        });
});
