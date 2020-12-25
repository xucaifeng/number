mui.init();
mui.ready(function(){
	mui('.mui-scroll-wrapper').scroll({
		indicators: false,
		deceleration: 0.0005 //flick 减速系数，系数越大，滚动速度越慢，滚动距离越小，默认值0.0006
	});

    config.ajax(config.server_url+"/number/numberInfo", {},
		function(data){
			console.log("data= "+JSON.stringify(data));
			if (data.status == 0) {

                var user = localStorage.getItem("user");
                var name = document.getElementById("center");
                name.value = JSON.parse(user).center;

                var briData = data.data;
                var num;
                var flag = false;
                for (var id in briData) {
                    num = briData[id];
                    if (num > 0) {
                        flag = true;
                        mui('#brinell-'+id+' > d')[0].innerText = ' (剩余'+num+')';
                        mui('#brinell-'+id)[0].nextElementSibling.removeAttribute("disabled");
                    }
                }
                if (!flag) {
                    mui('.mui-btn-success')[0].disabled = 'disabled';
                }

			} else {
				mui.toast(data.message);
			}
        },
		function(){
            console.log("--------------error--------------");
        }
	);

    /**
     * 选号并分组
     */
    mui('.mui-btn-success')[0].addEventListener('tap',function(){

        var brinellId = 0;
        var ra=mui('.mui-card > div > input');
        for(var i = 0; i < ra.length; i++) {
            console.log(ra[i].value)
            if (ra[i].checked) {
                brinellId = ra[i].getAttribute('brinellId');
            }
        }
        if (!brinellId) {
            mui.toast('请选择布氏分期');
            return false;
        }

	    var caseName = mui('#name')[0].value;
        if (!caseName) {
            mui.toast('请输入姓名缩写');
            return false;
        }
        var caseIdCard = mui('#idCard')[0].value;
        if (!caseIdCard) {
            mui.toast('请输入身份证号');
            return false;
        }

        var btnArray = ['确认','返回'];
        var confirmHtml = '<br/><label style="float: left;">姓名缩写：</label>'+caseName+'<br/>' +
            '<label style="float: left">身份证号：</label>'+caseIdCard+'<br/>' +
            '<label style="float: left">布氏分期：</label>'+config.getBrinellPeriods(brinellId)+'';
        mui.confirm(confirmHtml,'请确认信息',btnArray,function(e){
            if(e.index==0){
                pickNumber(caseName, caseIdCard, brinellId);
            }else{

            }
        })
    })

    /**
     * 选号
     * @param caseName
     * @param caseIdCard
     * @param brinellId
     */
    function pickNumber(caseName, caseIdCard, brinellId) {
        config.ajax(config.server_url+"/number/pickNumber", {
                'centerId': JSON.parse(user).centerId,
                'caseName': caseName,
                'caseIdCard': caseIdCard,
                'brinellId': brinellId
            },
            function(data){
                console.log("data= "+JSON.stringify(data));
                if (data.status == 0) {
                    var center = data.data.center;
                    var brinellPeriods = data.data.brinellPeriods;
                    var randomNum = data.data.randomNum;
                    var interfereGroup = data.data.interfereGroup;
                    var param = 'center='+center+'&brinellPeriods='+brinellPeriods+'&randomNum='+randomNum+'&interfereGroup='+interfereGroup;
                    mui.openWindow({
                        url:'result.html?'+param,
                        id:'result'
                    });
                } else {
                    mui.alert(data.message, ' ', function() {
                    });
                }
            },
            function(){
                console.log("--------------error--------------");
            }
        )
    }


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




	