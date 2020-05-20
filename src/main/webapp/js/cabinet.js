$.get("/cabinet/api/user-info")
    .done(function (user) {
        $("#user-first-name").html(user.firstName);
        $("#user-last-name").html(user.lastName);
        $("#user-email").html(user.email);
        var age = user.age === 0 ? "<i>Empty</i>" : user.age;
        $("#user-age").html(age);
        var gender = user.gender === null ? "<i>Empty</i>" : user.gender;
        $("#user-gender").html(gender);
        var country = user.country === null ? "<i>Empty</i>" : user.country;
        $("#user-country").html(country);
        var city = user.city === null ? "<i>Empty</i>" : user.city;
        $("#user-city").html(city);

        $.get("/cabinet/api/request-info?userId=" + user.id)
            .done(function (data) {
                var requestCards = "";

                jQuery.each(data, function (i, item) {
                    var statusClass = (item.status === "Not credited") ? "status-not-credited" : "status-" + item.status.toLowerCase();
                    var cardStatusClass = "";
                    var deleteBtn = "";

                    switch (item.status) {
                        case "Waiting":
                            cardStatusClass = "card-" + item.status.toLowerCase();
                            deleteBtn += "<button class=\"btn mosh-btn delete-btn\" request-id=\"" + item.id + "\" type=\"submit\">Delete</button>\n";
                            break;

                        case "Canceled":
                        case "Not credited":
                            cardStatusClass = "card-cancel";
                            break;

                        case "Accepted":
                        case "Credited":
                            cardStatusClass = "card-accept";
                            break;
                    }

                    requestCards += "<div class=\"card mb-3 w-50 mr-auto ml-auto " + cardStatusClass + "\" style=\"max-width: 540px;\">\n" +
                        "<div class=\"row no-gutters\">\n" +
                        "<div class=\"col-md-8\">\n" +
                        "<div class=\"card-body\">\n" +
                        "<h5 class=\"card-title\">Request No." + item.id + "</h5>\n" +
                        "<p class=\"card-text\">Faculty: " + item.faculty.name + "</p>\n" +
                        "<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"col-md-4 d-flex flex-column justify-content-around text-center\">\n" +
                        "<p class=\"card-text " + statusClass + "\">" + item.status + "</p>\n" +
                         deleteBtn +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>"
                });

                $("#user-requests").html(requestCards);
            })
    });

$.get("/user-cover-files/user-cover-id")
    .done(function (coverId) {
        var imgSrc;

        if (coverId === "") {
            var contextPath = $('#contextPathHolder').attr('data-contextPath');;
            imgSrc = contextPath + "/img/core-img/user_default.png";
        } else {
            imgSrc = "/user-cover-files/download/" + coverId;
        }

        $("#profile-img").attr("src", imgSrc);
    });

$(document).on("click", ".delete-btn", function (event) {
    event.preventDefault();

    $(".delete-btn").prop("disabled", true);
    var requestId = $(this).attr("request-id");

    $.ajax({
        url: "/requests/api/delete/" + requestId,
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "DELETE",
        success: function () {
            location.reload();
        }
    });
})
