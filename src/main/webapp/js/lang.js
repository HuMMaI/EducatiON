var selItem = localStorage.getItem("lang");
$('#locales').val(selItem ? selItem : 'en');
$("#locales").change(function () {
    var selectedlang = $('#locales').val();
    if (selectedlang) {
        localStorage.setItem("lang", selectedlang);
        window.location.replace('?lang=' + selectedlang);
    }
});