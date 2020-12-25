
var config = {
    server_url: "http://127.0.0.1:8081/number",


	getInt: function (data) {
		 if (data && !isNaN(data)) {
			return data; 
		 } else {
			 return 0;
		 }
	},
	
	/**
     * 时间戳转日期格式
     * @param timestamp
     * @returns {*}
     */
    timestampToTime: function (timestamp) {
		if (!timestamp) return "";
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        var Y = date.getFullYear();
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
        var D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        var h = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
        var m = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
        var s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
        return Y + "-" + M + "-" + D + " " + h + ":" + m + ":" + s;
    },
	
	ajax: function (url, data, succ, err) {
		mui.ajax(url, {
			data:data,
			dataType:'json',
			timeout:5000,
            headers:{'Content-Type':'application/x-www-form-urlencoded; charset=utf-8'},
			success:function(data){
				console.log("data: "+JSON.stringify(data));
				if(data.status && data.status == 7){
					mui.openWindow({url:'login.html',id:'login'});
				} else if (succ) {
					succ(data);
				} 
			},
            error: err
		});
	},

    /**
	 * 获取url中参数
     * @param name
     * @returns {*}
     */
    getQueryString: function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURI(r[2]); return null;
    },

    /**
     *
     * @param brinellId
     */
    getBrinellPeriods: function (brinellId) {
        if (brinellId == 1) {
            return '痉挛期';
        } else {
            return '恢复期';
        }
    },



};






