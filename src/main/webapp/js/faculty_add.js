$.get("/faculty/api/add")
    .done(function (data) {
        var subjects = "";

        jQuery.each(data, function (key, item) {
            subjects += "<div class=\"input-group mb-3\">\n" +
                "<div class=\"input-group-prepend\">\n" +
                "<div class=\"input-group-text\">\n" +
                "<input type=\"checkbox\" class=\"subject\" aria-label=\"Checkbox for following text input\" name=\"" + key + "\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<input type=\"text\" class=\"form-control field-create field-create-m subject-name\" aria-label=\"Text input with checkbox\" value=\"" + item + "\" disabled>\n" +
                "</div>"
        });

        subjects += "<div class=\"invalid-feedback error-hidden\" id=\"subjects-error\"></div>"

        $("#faculty-subjects").html(subjects);
    });

$.get("/faculty/api/specializations")
    .done(function (specializations) {
        var specializationList = "";

        jQuery.each(specializations, function (i, item) {
            specializationList += "<option value=\"" + item + "\">" + item + "</option>";
        });

        $("#specialization-name").append(specializationList);
    });

$("#create-btn").click(function (event) {
    event.preventDefault();

    $("#create-btn").prop("disabled", true);

    var name = $("input[name='facultyName']").val();
    var numberOfSeatsStr = $("input[name='numberOfSeats']").val();
    var numberOfSeats = (numberOfSeatsStr === "") ? null : parseInt(numberOfSeatsStr, 10);
    var specialization = $("#specialization-name").val();

    var subjectsArray = [];
    $.each($("input[class='subject']:checked"), function () {
        String(subjectsArray.push($(this).attr("name")));
    });

    var subjects = subjectsArray.toString();

    var faculty = {
        name,
        numberOfSeats,
        subjects,
        specialization
    };

    $.ajax({
        url: "/faculty/api/add",
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "POST",
        data: faculty
    })
        .done(function (data, textStatus, xhr) {
            if (xhr.status === 200){
                location.href = "/faculty";
            }
        })
        .fail(function (response) {
            var result = response.responseJSON;

            jQuery.each(result, function (key, item) {
                switch (key) {
                    case "nameError":
                        $("#faculty-name").addClass("is-invalid");
                        $("#faculty-name").addClass("error-color");
                        $("#name-error").removeClass("error-hidden");
                        $("#name-error").html(item);
                        break;

                    case "numberOfSeatsError":
                        $("#number-of-seats").addClass("is-invalid");
                        $("#number-of-seats").addClass("error-color");
                        $("#number-of-seats-error").removeClass("error-hidden");
                        $("#number-of-seats-error").html(item);
                        break;

                    case "subjectsError":
                        $(".subject-name").addClass("is-invalid");
                        $(".subject-name").addClass("error-color");
                        $("#subjects-error").removeClass("error-hidden");
                        $("#subjects-error").css("display", "block");
                        $("#subjects-error").html(item);
                        break;

                    case "specializationError":
                        $("#specialization-name").addClass("is-invalid");
                        $("#specialization-name").addClass("error-color");
                        $("#specialization-error").removeClass("error-hidden");
                        $("#specialization-error").html(item);
                        break;
                }
            });

            $("#create-btn").prop("disabled", false);
        });
});

$("#faculty-name").keypress(function () {
    $("#faculty-name").removeClass("is-invalid");
    $("#faculty-name").removeClass("error-color");
    $("#name-error").addClass("error-hidden");
    $("#name-error").html();
});

$("#number-of-seats").keypress(function () {
    $("#number-of-seats").removeClass("is-invalid");
    $("#number-of-seats").removeClass("error-color");
    $("#number-of-seats-error").addClass("error-hidden");
    $("#number-of-seats-error").html();
});

$(document).on("change", "input[type='checkbox']", function () {
    $(".subject-name").removeClass("is-invalid");
    $(".subject-name").removeClass("error-color");
    $("#subjects-error").addClass("error-hidden");
    $("#subjects-error").css("display", "none");
    $("#subjects-error").html();
});

$(document).on("change", "#specialization-name", function () {
    $("#specialization-name").removeClass("is-invalid");
    $("#specialization-name").removeClass("error-color");
    $("#specialization-error").addClass("error-hidden");
    $("#specialization-error").html();
});
