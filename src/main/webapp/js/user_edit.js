var url = new URL(window.location.href);
var id = url.searchParams.get("id");

$.get("/user/api/edit?id=" + id)
    .done(function (user) {
        $("#first-name").val(user.firstName);
        $("#last-name").val(user.lastName);
        $("#email").val(user.email);

        $.get("/user/api/roles")
            .done(function (roles) {
                var rolesList = "";

                jQuery.each(roles, function (key, item) {
                    rolesList += "<div class=\"input-group mb-3\">\n" +
                        "<div class=\"input-group-prepend\">\n" +
                        "<div class=\"input-group-text\">\n" +
                        "<input type=\"checkbox\" class=\"role\" aria-label=\"Checkbox for following text input\" name=\"" + item + "\" " + (user.roles.includes(item) ? 'checked' : '') + " >\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<input type=\"text\" class=\"form-control field-create field-create-m role-name\" aria-label=\"Text input with checkbox\" value=\"" + item + "\" disabled>\n" +
                        "</div>"
                });

                rolesList += "<div class=\"invalid-feedback error-hidden\" id=\"roles-error\"></div>"

                $("#user-roles").html(rolesList);
            });
    });


$("#save-btn").click(function (event) {
    event.preventDefault();

    $("#save-btn").prop("disabled", true);

    var firstName = $("input[name='firstName']").val();
    var lastName = $("input[name='lastName']").val();
    var email = $("input[name='email']").val();

    var rolesArray = [];
    $.each($("input[class='role']:checked"), function () {
        String(rolesArray.push($(this).attr("name")));
    });

    var roles = rolesArray.toString();

    var user = {
        firstName,
        lastName,
        email,
        roles
    };

    $.ajax({
        url: "/user/api/edit?id=" + id,
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "PUT",
        data: user
    })
        .done(function (data, textStatus, xhr) {
            if (xhr.status === 200){
                location.href = "/user";
            }
        })
        .fail(function (response) {
            var result = response.responseJSON;

            jQuery.each(result, function (key, item) {
                switch (key) {
                    case "firstNameError":
                        $("#first-name").addClass("is-invalid");
                        $("#first-name").addClass("error-color");
                        $("#first-name-error").removeClass("error-hidden");
                        $("#first-name-error").html(item);
                        break;

                    case "lastNameError":
                        $("#last-name").addClass("is-invalid");
                        $("#last-name").addClass("error-color");
                        $("#last-name-error").removeClass("error-hidden");
                        $("#last-name-error").html(item);
                        break;

                    case "emailError":
                        $("#email").addClass("is-invalid");
                        $("#email").addClass("error-color");
                        $("#email-error").removeClass("error-hidden");
                        $("#email-error").html(item);
                        break;

                    case "rolesError":
                        $(".role-name").addClass("is-invalid");
                        $(".role-name").addClass("error-color");
                        $("#roles-error").removeClass("error-hidden");
                        $("#roles-error").css("display", "block");
                        $("#roles-error").html(item);
                        break;
                }
            });

            $("#save-btn").prop("disabled", false);
        });
});

$("#first-name").keypress(function () {
    $("#first-name").removeClass("is-invalid");
    $("#first-name").removeClass("error-color");
    $("#first-name-error").addClass("error-hidden");
    $("#first-name-error").html();
});

$("#last-name").keypress(function () {
    $("#last-name").removeClass("is-invalid");
    $("#last-name").removeClass("error-color");
    $("#last-name-error").addClass("error-hidden");
    $("#last-name-error").html();
});

$("#email").keypress(function () {
    $("#email").removeClass("is-invalid");
    $("#email").removeClass("error-color");
    $("#email-error").addClass("error-hidden");
    $("#email-error").html();
});

$(document).on("change", "input[type='checkbox']", function () {
    $(".role-name").removeClass("is-invalid");
    $(".role-name").removeClass("error-color");
    $("#roles-error").addClass("error-hidden");
    $("#roles-error").css("display", "none");
    $("#roles-error").html();
});
