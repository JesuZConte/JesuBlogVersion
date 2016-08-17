
"use strict";
App.LoadData=function(){

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


    var __createNews= function(data){

        var promise=__ajax("api/create","POST",data);
        promise.then(function(response){
            console.info(response);
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

        createNews:function(){
            var new1 = {
                title:"Pokemon Go es el juego movil mas popular",
                content: "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, " +
                "totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. " +
                "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui " +
                "ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci " +
                "velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. " +
                "Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea " +
                "commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil " +
                "molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                author:{name:"Juanito Perez",mail:"juanito_perez@gmail.com"}
            };
            var new2 = {
                title:"conoce mas sobre swift, el lenguaje de apple",
                content: "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain " +
                "was born and I will give you a complete account of the system, and expound the actual teachings of the " +
                "great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids " +
                "pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally " +
                "encounter consequences that are extremely painful.",
                author:{name:"Diego Montaña",mail:"diegomontana@nisum.com"}
            };
            var new3 = {
                title:"los programadores java son mas felices",
                content: "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum " +
                "deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, " +
                "similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem " +
                "rerum facilis est et expedita distinctio.",
                author:{name:"perico Los Palotes",mail:"perico@gmail.com"}
            };
            __createNews(new1);
            __createNews(new2);
            __createNews(new3);
        },

    };

};
