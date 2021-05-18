const url = 'http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword';
const api_key = 'JXL40bCK2WGOu/E1WOGjuALpADt64Wb2mQVwNpxiA0bre/V8GozZggM2O01/PaTTyNm0A2JahebDf/PGwW8jbg==';

$(document).ready(function(){
    if($.urlParam('keyword') != null){
        $(".result_bar>div").text(decodeURI($.urlParam('keyword'))+'의 검색 결과입니다.');
        $(".result_bar").show();
        $.ajax({ //관광지 검색
            type:'GET',
            url: url,
            data:{
                numOfRows:4,
                pageNo:1,
                MobileOS:'ETC',
                MobileApp:'Railro',
                ServiceKey:api_key,
                _type:'json',
                listYN:'Y',
                arrange:'O',
                contentTypeId:12,
                keyword:decodeURI($.urlParam('keyword'))
            },
            success:function(data){
                console.log(data);
                data = data.response.body.items.item;
                for(var i=0; i<data.length; i++){
                    $(".Tour").append(search_elements(data[i].contenttypeid, data[i].contentid, data[i].firstimage, data[i].title, data[i].addr1));
                }
            },
            error:function(){
                console.log('ajax failed');
            }
        });
        
        $.ajax({ //음식점 검색
            type:'GET',
            url: url,
            data:{
                numOfRows:4,
                pageNo:1,
                MobileOS:'ETC',
                MobileApp:'Railro',
                ServiceKey:api_key,
                _type:'json',
                listYN:'Y',
                arrange:'O',
                contentTypeId:39,
                keyword:decodeURI($.urlParam('keyword'))
            },
            success:function(data){
                console.log(data);
                data = data.response.body.items.item;
                for(var i=0; i<data.length; i++){
                    $(".Restaurant").append(search_elements(data[i].contenttypeid, data[i].contentid, data[i].firstimage, data[i].title, data[i].addr1));
                }
            },
            error:function(){
                console.log('ajax failed');
            }
        });
        
        $.ajax({ //숙소 검색
            type:'GET',
            url: url,
            data:{
                numOfRows:4,
                pageNo:1,
                MobileOS:'ETC',
                MobileApp:'Railro',
                ServiceKey:api_key,
                _type:'json',
                listYN:'Y',
                arrange:'O',
                contentTypeId:32,
                keyword:decodeURI($.urlParam('keyword'))
            },
            success:function(data){
                console.log(data);
                data = data.response.body.items.item;
                for(var i=0; i<data.length; i++){
                    $(".Rooms").append(search_elements(data[i].contenttypeid, data[i].contentid, data[i].firstimage, data[i].title, data[i].addr1));
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
	        
       $.ajax({ //인기검색어
            type:'POST',
            url: './trending/keyword',
            data:{
                keyword:$(".search_input").val()
            },
            success:function(data){
                console.log(data);
            },
            error:function(){
                console.log('ajax failed');
            }
        });
        location.href="search_integrated.jsp?keyword="+$(".search_input").val();

    });
});

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return null;
    }
    else{
       return results[1] || 0;
    }
}

function search_elements(contenttypeid, contentid, img, title, addr){
    return '<ul class="Tour_group"><a href=detail_info.jsp?contenttypeid='+contenttypeid+'&contentid='+contentid+' target=_blank><li class="TourImage"><img src='+img+' alt="" width="148px"></li><div class="TourInfo"><li class="TourTitle">'+title+'</li><li class="shopping_add"><img src="./jpg/plus.png" alt=""></li><li class="TourContent">'+addr+'</li></div><div class="like_review"><span>321321</span><img src="./mynote_jpg/review.png" alt=""></div></a></ul>'
}