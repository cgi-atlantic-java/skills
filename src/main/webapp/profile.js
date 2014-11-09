$(document).ready(function () {

    $(".skill").each(function () {
        var label = $(this).children("label");
        var select = $(this).children("select");

        function selectedOption() {
            return select.children('option:selected');
        }                
        select.hide();

        label.addClass("button");
        label.prop('title', $.trim(selectedOption().text()));

        label.click(function () {
            var next = selectedOption().next();
            if (next.length == 0) {
                next = select.children('option:first');
            }
            next.prop('selected', 'true');
            label.prop('title', $.trim(next.text()));
        });
    })

});