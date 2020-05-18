$(document).on("click", ".apply-btn", function (event) {
    event.preventDefault();

    $(".apply-btn").prop("disabled", true);

    var userId = $("input[name='userId']").val();
    var facultyId = $(this).attr("id");

    var request = {
        user: userId,
        faculty: facultyId
    };

    $.ajax({
        url: "/faculty/api/apply",
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "POST",
        data: request
    })
        .done(function () {
            location.reload();
        })
        .fail(function (response) {
            var result = response.responseJSON;

            var message = "";
            if (result.applyError !== undefined) {
                message += result.applyError;
            } else {
                message += result.subjectsEmptyError + "<a href=\"/grades\" class=\"alert-link\"> on the grades page!</a>";
            }

            var alertId = "#card-" + facultyId;
            var alertMessageId = "#alertMessage-" + facultyId;
            $(alertId).removeClass("error-hidden");
            $(alertMessageId).html(message);

            $(".apply-btn").prop("disabled", false);
        });
});

$(".alert-close").click(function () {
    $(".alert").addClass("error-hidden");
    $(".message").html();
});
