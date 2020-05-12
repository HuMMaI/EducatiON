$.get("/grades/api/subjects")
    .done(function (subjects) {
        var subjectList = "";

        jQuery.each(subjects, function (key, item) {
            subjectList += "<option value=\"" + item + "\">" + item + "</option>";
        });

        $("#subject-name").append(subjectList);
    });

$.get("/grades/api/current-user-subjects")
    .done(function (subjects) {
        var subjectCards = "";

        jQuery.each(subjects, function (key, item) {
            subjectCards += "<div class=\"card mb-3 w-50 mr-auto ml-auto\" style=\"max-width: 540px;\">\n" +
                "<div class=\"row no-gutters\">\n" +
                "<div class=\"col-md-8\">\n" +
                "<div class=\"card-body\">\n" +
                "<h5 class=\"card-title\">" + item.name + "</h5>\n" +
                "<p class=\"card-text\">Grade: " + item.grade + "</p>\n" +
                "<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"col-md-4 d-flex flex-column justify-content-around\">\n" +
                "<input type=\"hidden\" value=\"" + item.id + "\" name=\"subjectId\">\n" +
                "<button class=\"btn mosh-btn\" type=\"submit\">Edit</button>\n" +
                "<button class=\"btn mosh-btn delete-btn\" id=\"" + item.id + " subject\" type=\"submit\">Delete</button>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>"
        });

        $("#subject-cards").html(subjectCards);
    });

$.get("/grades/api/current-user-certificate")
    .done(function (certificate) {
        var certificateCards = "";

        jQuery.each(certificate, function (key, item) {
            certificateCards += "<div class=\"card mb-3 w-50 mr-auto ml-auto\" style=\"max-width: 540px;\">\n" +
                "<div class=\"row no-gutters\">\n" +
                "<div class=\"col-md-8\">\n" +
                "<div class=\"card-body\">\n" +
                "<h5 class=\"card-title\">" + item.name + "</h5>\n" +
                "<p class=\"card-text\">Grade: " + item.grade + "</p>\n" +
                "<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"col-md-4 d-flex flex-column justify-content-around\">\n" +
                "<input type=\"hidden\" value=\"" + item.id + "\" name=\"certificateId\">\n" +
                "<button class=\"btn mosh-btn\" type=\"submit\">Edit</button>\n" +
                "<button class=\"btn mosh-btn\" type=\"submit\">Delete</button>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>"
        });

        $("#certificate-cards").html(certificateCards);
    });

$("#add-btn").click(function (event) {
    event.preventDefault();

    $("#add-btn").prop("disabled", true);

    var subjectName = $("#subject-name").val();
    var subjectGradeStr = $("#subject-grade").val();
    var subjectGrade = (subjectGradeStr === "") ? null : parseInt(subjectGradeStr, 10);
    var type = $("input[name='subject']").val();

    var subject = {
        name: subjectName,
        grade: subjectGrade,
        gradeType: type
    }

    $.ajax({
        url: "/grades/api/add",
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "POST",
        data: subject
    })
        .done(function (data, textStatus, xhr) {
            if (xhr.status === 200) {
                location.reload();
            }
        })
        .fail(function (response) {
            var result = response.responseJSON;

            jQuery.each(result, function (key, item) {
                switch (key) {
                    case "nameError":
                        $("#subject-name").addClass("is-invalid");
                        $("#subject-name").addClass("error-color");
                        $("#subject-name-error").removeClass("error-hidden");
                        $("#subject-name-error").html(item);
                        break;

                    case "gradeError":
                        $("#subject-grade").addClass("is-invalid");
                        $("#subject-grade").addClass("error-color");
                        $("#grade-error").removeClass("error-hidden");
                        $("#grade-error").html(item);
                        break;

                    case "existError":
                        $("#existError").removeClass("error-hidden");
                        $("#message").html(item);
                        break;
                }
            });

            $("#add-btn").prop("disabled", false);
        });
});

$("#subject-name").change(function () {
    $("#subject-name").removeClass("is-invalid");
    $("#subject-name").removeClass("error-color");
    $("#subject-name-error").addClass("error-hidden");
    $("#subject-name-error").html();
});

$("#subject-grade").keypress(function () {
    $("#subject-grade").removeClass("is-invalid");
    $("#subject-grade").removeClass("error-color");
    $("#grade-error").addClass("error-hidden");
    $("#grade-error").html();
});

$("#subject-alert-close").click(function () {
    $("#existError").addClass("error-hidden");
    $("#message").html();
});

$("#certificate-add-btn").click(function (event) {
    event.preventDefault();

    $("#certificate-add-btn").prop("disabled", true);

    var subjectName = $("#certificate-name").val();
    var subjectGradeStr = $("#certificate-grade").val();
    var subjectGrade = (subjectGradeStr === "") ? null : parseInt(subjectGradeStr, 10);
    var type = $("input[name='certificate']").val();

    var certificate = {
        name: subjectName,
        grade: subjectGrade,
        gradeType: type
    }

    $.ajax({
        url: "/grades/api/add",
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "POST",
        data: certificate
    })
        .done(function (data, textStatus, xhr) {
            if (xhr.status === 200) {
                location.reload();
            }
        })
        .fail(function (response) {
            var result = response.responseJSON;

            jQuery.each(result, function (key, item) {
                switch (key) {
                    case "nameError":
                        $("#certificate-name").addClass("is-invalid");
                        $("#certificate-name").addClass("error-color");
                        $("#certificate-name-error").removeClass("error-hidden");
                        $("#certificate-name-error").html(item);
                        break;

                    case "gradeError":
                        $("#certificate-grade").addClass("is-invalid");
                        $("#certificate-grade").addClass("error-color");
                        $("#certificate-grade-error").removeClass("error-hidden");
                        $("#certificate-grade-error").html(item);
                        break;
                }
            });

            $("#certificate-add-btn").prop("disabled", false);
        });
});

$("#certificate-name").keypress(function () {
    $("#certificate-name").removeClass("is-invalid");
    $("#certificate-name").removeClass("error-color");
    $("#certificate-name-error").addClass("error-hidden");
    $("#certificate-name-error").html();
});

$("#certificate-grade").keypress(function () {
    $("#certificate-grade").removeClass("is-invalid");
    $("#certificate-grade").removeClass("error-color");
    $("#certificate-grade-error").addClass("error-hidden");
    $("#certificate-grade-error").html();
});

$(document).on("click", ".delete-btn", function (event) {
    event.preventDefault();

    var idStr = $(".delete-btn").attr("id");
    var idArray = idStr.split(/\s+/);
    $(".delete-btn").prop("disabled", true);

    $.ajax({
        url: "/grades/api/subject-delete/" + idArray[0],
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "DELETE",
        success: function () {
            location.reload();
        }
    });
});
