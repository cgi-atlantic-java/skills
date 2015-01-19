$(document).ready(function () {

    function txt(element) {
        return $.trim(element.text());
    }

    $(".skill > select").each(function () {
        var select = $(this);
        var label = $("label[for='" + select.attr('id') + "']");

        function selectedOption() {
            return select.children('option:selected');
        }
        select.hide();

        label.addClass("button");
        label.prop('title', txt(selectedOption()));

        label.click(function () {
            var next = selectedOption().next();
            if (next.length === 0) {
                next = select.children('option:first');
            }
            next.prop('selected', 'true');
            label.prop('title', txt(next));
        });
    });

});