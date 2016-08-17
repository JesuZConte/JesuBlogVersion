
"use strict";
App.Main=function(){

  var __newPostId, __modalSeePostId,__modalNewPostId;

  var __init=function(){

    console.info("starting...");
    $("#new_post_id").click(function(){
         $("#modal_create_post_id").modal('show');
    });

    $("#btn_see_post_1_id").click(function(){
         $("#modal_see_post_id").modal('show');
    });

  };
  
  
  var __ajax=function(url, method, data){
	
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
      return   dfd.promise();
	  
  };
  
  
  var __createNews= function(){
	  	  
	  var news={
		title:"the tittle",
		content: "the content",
		author:{name:"the name of the author",mail:"email"}			
	  };
	  
	  var promise=__ajax("api/create","POST",news);
	  promise.then(function(response){		  
		  console.info(response);	
		  __readNew();
	  });  
	  
  }
  
  
  var __readNew= function(){
  	  
	 
	  var promise=__ajax("api/read/0","GET",null);
	  promise.then(function(response){		  
		  console.info(response);		  
	  });  
	  
  }
  
  /** public**/
  return{
	 
    init:function(){
    	__init();
    },

  };

};
