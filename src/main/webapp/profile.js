$(document).ready(function () {
    $(".skill").each(function () {
        var label = $(this).children("label");
        var select = $(this).children("select");

        select.hide();

        label.addClass("button");
        label.prop('title', $.trim(select.children('option:selected').text()));

        label.click(function () {
            var next = select.children('option:selected').next();
            if (next.length == 0) {
                next = select.children('option:first');
            }
            next.prop('selected', 'true');
            label.prop('title', $.trim(next.text()));
        });
    })
});