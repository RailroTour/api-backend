$(document).ready(function(){
    if($.urlParam('keyword') != null){
        $(".result_bar>div").text(decodeURI($.urlParam('keyword'))+'의 검색 결과입니다.');
        $(".result_bar").show();
        $.ajax({ //플래너 검색
            type:'GET',
            url: './api/searchPlanner/get',
            data:{
                keyword:decodeURI($.urlParam('keyword')),
				pageNo:decodeURI($.urlParam('pageNo'))
            },
            success:function(data){
                console.log("플래너 검색 : "+JSON.stringify(data));
				for (var i = 0; i < data.length; i++) {
					$(".plans_list_rows").append(planner_elements(
						data[i].planner_id,
						data[i].img_path,
						data[i].start_day,
						data[i].days,
						data[i].title,
						data[i].tema_name,
						data[i].view,
						data[i].trip_course,
						data[i].nickname
					));
				}
            },
            error:function(){
                console.log('ajax failed');
            }
        });

        $.ajax({ //플래너 개수 검색
            type:'GET',
            url: './api/searchPlannerCount/get',
            data:{
                keyword:decodeURI($.urlParam('keyword'))
            },
            success:function(data){
                console.log("플래너 개수 검색 : "+JSON.stringify(data));
				                //데이터 목록
                for(var i=0; i<Math.ceil(data/10); i++){
                    if((i+1)==$.urlParam('pageNo')){
                        $(".page_num_group").append('<a href=search_planner.jsp?keyword='+$.urlParam('keyword')+'&pageNo='+(i+1)+' class="selected">'+(i+1)+'</a>');
                    }
                    else{
                        $(".page_num_group").append('<a href=search_planner.jsp?keyword='+$.urlParam('keyword')+'&pageNo='+(i+1)+'>'+(i+1)+'</a>');
                    }
                }
            },
            error:function(){
                console.log('ajax failed');
            }
        });

        
        $(".itemlist>.itembox>a").eq(0).prop('href', 'search_integrated.jsp?keyword='+$.urlParam('keyword'));
        $(".itemlist>.itembox>a").eq(1).prop('href', 'search_tour.jsp?pageNo=1&keyword='+$.urlParam('keyword'));
        $(".itemlist>.itembox>a").eq(2).prop('href', 'search_foods.jsp?pageNo=1&keyword='+$.urlParam('keyword'));
        $(".itemlist>.itembox>a").eq(3).prop('href', 'search_planner.jsp?pageNo=1&keyword='+$.urlParam('keyword'));
        $(".itemlist>.itembox>a").eq(4).prop('href', 'search_rooms.jsp?pageNo=1&keyword='+$.urlParam('keyword'));
    }
    else{
        $(".result_bar").hide();
    }
    
    
    $(".search_btn").on('click', function(){
        $.ajax({ //플래너 검색
            type:'GET',
            url: './api/searchPlanner/get',
            data:{
                keyword:decodeURI($.urlParam('keyword'))
            },
            success:function(data){
                console.log("플래너 검색 : "+JSON.stringify(data));
				for (var i = 0; i < data.length; i++) {
					$(".plans_list_rows").append(planner_elements(
						data[i].planner_id,
						data[i].img_path,
						data[i].start_day,
						data[i].days,
						data[i].title,
						data[i].tema_name,
						data[i].view,
						data[i].trip_course,
						data[i].nickname
					));
				}
            },
            error:function(){
                console.log('ajax failed');
            }
        });
        location.href="search_planner.jsp?pageNo=1&keyword="+$(".search_input").val();
    });	
})

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return null;
    }
    else{
       return results[1] || 0;
    }
}


function planner_elements(planner_id, img_path, start_day, days, title, tema_name, view, trip_course, nickname){
	return '<a href=./planner.jsp?planner_id='+planner_id+' data-planner_id='+planner_id+' target="_blank"><ul class="list_item"><li><img src='+img_path+' alt="" width="346px" height="200px"><div class="note_info"><h1>'+start_day+' ('+days+'일)</h1><h1>'+title+'</h1></div></li><li><div class="like"><span class="tema">'+tema_name+'여행</span><span>'+view+'</span><img src="./note_plans_list_jpg/eye.png" alt="" width="20px"></div><div class="route">'+trip_course+'</div><div class="person"><img src="./note_plans_list_jpg/user.png" alt="" width="20px"><span>&nbsp;'+nickname+'</span></div></li></ul></a>'
}