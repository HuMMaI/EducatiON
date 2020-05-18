var url = new URL(window.location.href);
var id = url.searchParams.get("id");

$.get("/statement/api/rating-list?id=" + id)
    .done(function (statement) {
        var ratingTable = "";

        $("#statement-id").val(statement[0].id);

        var number = 1;
        jQuery.each(statement, function (key, item) {
            ratingTable += "<tr>\n" +
                "<th scope=\"row\">" + number + "</th>\n" +
                "<td>" + item.user.firstName + "</td>\n" +
                "<td>" + item.user.lastName + "</td>\n" +
                "<td>" + item.user.id + "</td>\n" +
                "<td>" + item.averageGradeOfSubjects + "</td>\n" +
                "<td>" + item.averageGradeOfCertificate + "</td>\n" +
                "<td>" + item.grade + "</td>\n" +
                "</tr>";

            number++;
        });

        $("#rating-table-body").html(ratingTable);
    });

$("#close-set").click(function (event) {
    event.preventDefault();

    $("#close-set").prop("disabled", true);

    var facultyId = id;

    $.ajax({
        url: "/statement/api/result?facultyId=" + id,
        headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
        method: "POST"
    })
        .done(function () {
            location.reload();
        });
});
