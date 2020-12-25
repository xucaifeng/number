mui.init();
mui.ready(function(){
    mui('#login')[0].addEventListener('tap',function(){
        var account = mui('#account')[0].value;
        var password = mui('#password')[0].value;
        mui.ajax(config.server_url+"/user/login", {
            data:{
                userName: account,
                password: password
            },
            dataType:'json',
            type: 'post',
            timeout:5000,
            headers:{'Content-Type':'application/x-www-form-urlencoded; charset=utf-8'},
            success:function(data){
                console.log("data: "+JSON.stringify(data));
                if (data.status == 0) {
                    localStorage.setItem("user", JSON.stringify(data.data));
                    mui.openWindow({url:'index.html', id:'index'});
                } else {
                    mui.toast(data.message);
                }
            },
            error:function(){
                console.log("--------------error--------------");
            }
        });
    })

})