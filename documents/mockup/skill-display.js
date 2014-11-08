$(function() {
	$(document).ready(function(){
		$('.javascript-enabled').css('display', 'inline-block');
		$('#skill_form').children(':hidden').each(function() {
			id = $(this).attr('id');
			$('#' + id + "-colorbox").attr('skill-value', $(this).value);
		});
	});

	$(".colored").click(function() {
		formfield = $(this).attr('myformfield'); 
		v = parseInt($(this).attr('skill-value')) + 1;
		if (isNaN(v))
			v = 1;
		if (v > 3)
			v = 0;
		$(this).attr('skill-value',v);
		$("#"+formfield)[0].value = v;
	});
});