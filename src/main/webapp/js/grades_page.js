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
                }
            });

            $("#add-btn").prop("disabled", false);
        });
});

$("#subject-name").keypress(function () {
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
