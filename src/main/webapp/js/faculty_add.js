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
                "<input type=\"text\" class=\"form-control field-create field-create-m\" aria-label=\"Text input with checkbox\" value=\"" + item + "\" disabled>\n" +
                "</div>"
        });

        $("#faculty-subjects").html(subjects);
    });

$("#create-btn").click(function (event) {
    event.preventDefault();

    var name = $("input[name='facultyName']").val();
    var numberOfSeats = parseInt($("input[name='numberOfSeats']").val(), 10);

    var subjectsArray = [];
    $.each($("input[class='subject']:checked"), function () {
        String(subjectsArray.push($(this).attr("name")));
    });

    var subjects = subjectsArray.toString();

    var faculty = {
        name,
        numberOfSeats,
        subjects
    };

    $.ajax({
        url: "/faculty/api/add",
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        type: "POST",
        data: faculty,
        success: function () {
            location.href = "/faculty";
        }
    });
});