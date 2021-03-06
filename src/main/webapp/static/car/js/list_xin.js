$(document).ready(function(){
	// load data
	$('#table-large-columns').bootstrapTable({
	    url: '/car/2/list.json',
	    silent: true
	});
	
	// date
	$.get('/car/dateList.json', {}, function(data, status) {
		if ('success' === status) {
			for (var i = 0; i < data.length; i++) {
				$('.nav-dropdown-container-date ul').append('<li><a href="#" data-value="' + data[i] + '">' + data[i] + '</a></li>');
			}
			bindClickEvent();
		}
	});
	
	// city
	$.get('/city/list.json', {}, function(data, status) {
		if ('success' === status) {
			for (var i = 0; i < data.length; i++) {
				$('.nav-dropdown-container-city ul').append('<li><a href="#" data-value="' + data[i]['id'] + '" >' + data[i]['name'] + '</a></li>');
			}
			bindClickEvent();
		}
	});
	
	// action
	bindClickEvent();
});

function bindClickEvent() {
	$('.nav-dropdown-container ul li').click(function() {
		// active class
		$(this).parent().children().removeClass('active');
		$(this).addClass('active');
		
		// query
		var dateValue = $('.nav-dropdown-container-date ul li.active').children('a').attr('data-value');
		var cityValue = $('.nav-dropdown-container-city ul li.active').children('a').attr('data-value');
		var typeValue = $('.nav-dropdown-container-type ul li.active').children('a').attr('data-value');
		var newUrl = '/car/2/list.json?date=' + dateValue + '&city=' + cityValue + '&type=' + typeValue;
		$('#table-large-columns').bootstrapTable('refresh', {silent: true, url: newUrl});
	});
}