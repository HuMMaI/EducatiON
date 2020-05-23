$.get("/cabinet/api/user-edit")
    .done(function (user) {
        var imgSrc;

        if (user.coverId === null) {
            var contextPath = $('#contextPathHolder').attr('data-contextPath');;
            imgSrc = contextPath + "/img/core-img/user_default.png";
        } else {
            imgSrc = "/user-cover-files/download/" + user.coverId;
        }

        $("#user-cover").attr("src", imgSrc);
        $("#first-name").val(user.firstName);
        $("#last-name").val(user.lastName);
        $("#email").val(user.email);
        $("#user-id").val(user.id);
        var coverId = user.coverId === null ? "" : user.coverId;
        $("#cover-id").val(coverId);

        var age = user.age === 0 ? "" : user.age;
        $("#age").val(age);
        var gender = user.gender === null ? "" : user.gender;
        $("#gender").val(gender);
        var country = user.country === null ? "" : user.country;
        $("#country").val(country);
        var city = user.city === null ? "" : user.city;
        $("#city").val(city);
    });

$("#save-btn").click(function (event) {
    event.preventDefault();

    $("#save-btn").prop("disabled", true);

    var id = $("#user-id").val();
    var firstName = $("#first-name").val();
    var lastName = $("#last-name").val();
    var email = $("#email").val();
    var age = ($("#age").val() === "") ? null : parseInt($("#age").val(), 10);
    var gender = $("#gender").val();
    var country = $("#country").val();
    var city = $("#city").val();
    var coverId = $("#cover-id").val();

    var user = {
        id,
        firstName,
        lastName,
        email,
        age,
        gender,
        country,
        city,
        coverId
    };

    $.ajax({
        url: "/cabinet/api/user-edit",
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        method: "PUT",
        data: user
    })
        .done(function () {
            location.href = "/cabinet";
        })
        .fail(function (response) {
            var result = response.responseJSON;

            $("#save-btn").prop("disabled", false);

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

                    case "ageError":
                        $("#age").addClass("is-invalid");
                        $("#age").addClass("error-color");
                        $("#age-error").removeClass("error-hidden");
                        $("#age-error").html(item);
                        break;

                    case "genderError":
                        $("#gender").addClass("is-invalid");
                        $("#gender").addClass("error-color");
                        $("#gender-error").removeClass("error-hidden");
                        $("#gender-error").html(item);
                        break;

                    case "countryError":
                        $("#country").addClass("is-invalid");
                        $("#country").addClass("error-color");
                        $("#country-error").removeClass("error-hidden");
                        $("#country-error").html(item);
                        break;

                    case "cityError":
                        $("#city").addClass("is-invalid");
                        $("#city").addClass("error-color");
                        $("#city-error").removeClass("error-hidden");
                        $("#city-error").html(item);
                        break;

                    case "emailError":
                        $("#email").addClass("is-invalid");
                        $("#email").addClass("error-color");
                        $("#email-error").removeClass("error-hidden");
                        $("#email-error").html(item);
                        break;
                }
            });
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

$("#age").keypress(function () {
    $("#age").removeClass("is-invalid");
    $("#age").removeClass("error-color");
    $("#age-error").addClass("error-hidden");
    $("#age-error").html();
});

$("#city").keypress(function () {
    $("#city").removeClass("is-invalid");
    $("#city").removeClass("error-color");
    $("#city-error").addClass("error-hidden");
    $("#city-error").html();
});

$("#gender").change(function () {
    $("#gender").removeClass("is-invalid");
    $("#gender").removeClass("error-color");
    $("#gender-error").addClass("error-hidden");
    $("#gender-error").html();
});

$("#country").change(function () {
    $("#country").removeClass("is-invalid");
    $("#country").removeClass("error-color");
    $("#country-error").addClass("error-hidden");
    $("#country-error").html();
});
