var url = new URL(window.location.href);
var id = url.searchParams.get("id");

$.get("/statement/api/rating-list?id=" + id)
    .done(function (statement) {
        var ratingTable = "";

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