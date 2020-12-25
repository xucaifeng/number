mui.init();
mui.ready(function(){
	mui('.mui-scroll-wrapper').scroll({
		indicators: false,
		deceleration: 0.0005 // flick 减速系数，系数越大，滚动速度越慢，滚动距离越小，默认值0.0006
	});

    mui('#center')[0].value = config.getQueryString('center');
    mui('#birnell')[0].value = config.getQueryString('brinellPeriods');
    mui('#randomNum')[0].value = config.getQueryString('randomNum');
    mui('#group')[0].value = config.getQueryString('interfereGroup');



    /**
     * 返回
     */
	mui('.mui-content-padded').on('tap', '.mui-btn-success', function(){
        mui.openWindow({url:'index.html', id:'index'});
    })


    /**
     * 退出
     */
    mui('.mui-content-padded').on('tap', '.mui-btn-danger', function(){
        config.ajax(config.server_url+"/user/logout", {
            },
            function(data){
                console.log("data= "+JSON.stringify(data));
                if (data.status == 0) {
                    mui.openWindow({
                        url:'login.html',
                        id:'login',
                    });
                } else {
                    mui.toast(data.message);
                }
            },
            function(){
                console.log("--------------error--------------");
            }
        )
    })

	
})




	