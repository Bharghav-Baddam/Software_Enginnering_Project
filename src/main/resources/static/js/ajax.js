function requestActivity(id, reference){
	
	console.log(reference);
	id = id.toString();
	$.ajax({
	    url: "/search/requestActivity",
	    data: id,
	    contentType: "application/json",
	    type: "POST",
	    success: function(){
	      console.log("working");
	      $(reference).replaceWith($('<span>Requested</span>'));
	    }
	});
	
}



function confirmActivity(id, reference){
	
	console.log(reference);
	id = id.toString();
	$.ajax({
	    url: "/search/confirmActivity",
	    data: id,
	    contentType: "application/json",
	    type: "POST",
	    success: function(){
	      console.log("working");
	      $(reference).siblings().remove();
	      $(reference).replaceWith($('<span>Confirmed!</span>'));

	    }
	});
	
}


function declineActivity(id, reference){
	
	console.log(reference);
	id = id.toString();
	$.ajax({
	    url: "/search/declineActivity",
	    data: id,
	    contentType: "application/json",
	    type: "POST",
	    success: function(){
	      console.log("working");
	      $(reference).siblings().remove();
	      $(reference).replaceWith($('<span>Declined</span>'));
	    }
	});
	
}