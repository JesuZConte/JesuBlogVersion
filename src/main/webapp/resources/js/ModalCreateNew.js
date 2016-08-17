"use strict";
App.ModalCreateNew=function(){
	
	var __cont=0;
	
	 var __init=function(){
		 
		 // to send a message to  other modules 
		 setInterval(function(){ 		
			 $.event.trigger({
			      type: "ModalCreateNew_message",
			      message: "the message"+ ++__cont,
			      time: new Date()
			    });
			 
		 }, 3000);
		 
		 
	 };
	
	
	 /**public**/
	  return{
		 
	    init:function(){
	    	__init();
	    }
	       
	  };
}