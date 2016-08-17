"use strict";
App.ModalShowNew=function(){
	
	var __currentId = 1;
	
	var __init=function(){
		
		$(document).on("ModalCreateNew_message", function (evt) {
			 console.info(evt);
		});
		__showNews();
        $("#submit-comment-btn").click(function(){
            __addComment();
        });
	}

  var __ajax = function(url, method, data){
		
	  if(data!=null){
		  data=JSON.stringify(data);
	  }else{
		  data=null;
	  }
      var dfd= new $.Deferred()
      $.ajax({
    	  url         : url,
          async       : true,
          type        : method,
          contentType : "application/json",
          data        : data,
          success     : dfd.resolve,
          error       : dfd.resolve
      });
      return dfd.promise();
  };
  
  var __showNews= function(){
	  var url = "api/read/" + __currentId;
	  var promise = __ajax(url,"GET", null);
	  promise.then(function(response){
		  $("#post-title-id").html(response.title);
		  $("#post-body-id").html(response.content);
		  $("#post-author-name").html(response.author.name);
		  $("#post-pubdate").html(response.date);
	  });
  }  

  var __addComment = function() {
	  
	  var comment = {
			  message: $("#comment-input").val(),
			  userName: $("#name-input").val(),
			  userEmail: $("#email-input").val()
	  }
	  
	  var url = "api/addComment/" + currentId;
	  
	  var promise = __ajax(url,"PUT", comment);
	  promise.then(function(response){	
		  console.info(response);
		  alert("Comment published succesfully");
	  });
  }
  
	 /**public**/
	  return{
		 
	    init:function(){
	    	__init();
	    }
	       
	  };
	
}