console.log("Reply Module..");

var replyService = (function(){ //익명함수 정의 및 즉시 실행

	function add(reply, callback, error){ // add 함수 정의 이함수는 AJAX에 요청을 보내는 역할을 한다. 
		console.log("add reply................");
		// reply: AJAX에 요청에 포함할 데이터를 담는다. callback, errror :각각 성공 실패
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		
		$.ajax({ //jquery의 AJAX메서드를 사용하여 서버에 HTTP 요청을 보낸다. 이부분이 실제 서버에 요청을 보낸다.
		type: 'post', // http post로 보내겠다.
		url: '/replies/new', //여기로.
		data: JSON.stringify(reply), // 이데이터를  JSON형식으로
		contentType: "application/json; charset=utf-8", //타입지정
				beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		success: function(result, status, xhr){ //성공시
			if(callback){
				callback(result);
			}
		},
		error: function(xhr, status, er) { //실패시
			if(error){
				error(er);
			}
		}
	});
    

    }; //add
	
	function getList(param, callback, error){
		var bno = param.bno;
		
		var page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json", 
			function(data){
				if (callback) {
					callback(data);
				}
			}).fail(function(xhr, status, err){
			if (error) {
				error();
			}		
		});
	};
	
	function remove(rno, callback, error) {
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			type: 'delete',
			url: '/replies/' + rno,
			beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
			success: function(deleteResult, status, xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	};
	
	function update(reply, callback, error){
		console.log("RNO : " + reply.rno);
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			type: 'put',
			url: '/replies/' + reply.rno,
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
			success: function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	};
	
	function get(rno, callback, error){
		$.get("/replies/" + rno + ".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		})
	};
	
	function displayTime(timeValue){
		var today = new Date();
		
		var gap = today.getTime() - timeValue;
		
		var dateObj = new Date(timeValue);
		var str = "";
		
		if( gap < (1000 * 60 * 60 *24 )) {
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0' ) + mi, ':', (ss>9 ? '': '0' ) + ss].join(''); 
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;	// getMonth() is zero-based
			var dd = dateObj.getDate();
			
			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd ].join('');
		}
	};
	
	return {
		add: add,
		getList: getList,
		remove: remove,
		update: update,
		get: get,
		displayTime: displayTime
	};
})();