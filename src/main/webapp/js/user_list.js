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

            userList += "<div class=\"card mb-3 w-50 mr-auto ml-auto\" style=\"max-width: 540px;\">\n" +
                "<div class=\"row no-gutters\">\n" +
                "<div class=\"col-md-4 d-flex flex-column justify-content-center\">\n" +
                "<img src=\"/user-cover-files/download/" + item.coverId + "\" class=\"card-img\" alt=\"user photo\">\n" +
                "</div>\n" +
                "<div class=\"col-md-8\">\n" +
                "<div class=\"card-body\">\n" +
                "<h5 class=\"card-title\">User No." + item.id + "</h5>\n" +
                "<p class=\"card-text\">\n" +
                "<b>First name:</b> " + item.firstName + "<br>\n" +
                "<b>Last name:</b> " + item.lastName + "<br>\n" +
                "<b>Email:</b> " + item.email + "<br>\n" +
                "<b>Roles:</b>\n" + roles +
                "</p>\n" +
                "<a class=\"btn mosh-btn\" href=\"/user/edit?id=" + item.id + "\">Edit</a>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>"
        });

        $("#user-list").html(userList);
    });
