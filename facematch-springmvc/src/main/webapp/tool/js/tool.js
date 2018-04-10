 function handleSave (snapData) {  
	 console.log(11);
    //导出base64格式的图片数据  
    //封装blob对象  
    var blob = dataURItoBlob(snapData);  
    //组装formdata  
    var fd = new FormData();  
    fd.append("img", blob);//fileData为自定义  
    
    jQuery.ajax({  
             type: "POST",  
             url:'http://localhost:8080/facematch-springmvc/img.do',  
            processData:false,
            contentType:false,
            async:false,
             data:fd,  
             success : function(data){
            	 console.log(111111);
            	 jQuery.ajax({  
                     type: "get",  
                     url:'http://localhost:8080/facematch-springmvc/loginUser.do?name=cover',  
                     dataType:'json',  
                     success : function(data){
                    	 console.log(data);
                    	 if(data.result[0].score>=90){
                    		 alert("登录成功！")
                    		 window.location.href='http://localhost:8080/facematch-springmvc/index.do';
                    	 }else{
                    		 alert("登录失败重新拍照")
                    	 }
                     }  
               });
            	 
            	 
             }  
   }); 
    
};  
	function dataURItoBlob (base64Data) {  
		var byteString;  
		if (base64Data.split(',')[0].indexOf('base64') >= 0)  
		    byteString = atob(base64Data.split(',')[1]);  
		else  
		    byteString = unescape(base64Data.split(',')[1]);  
		var mimeString = base64Data.split(',')[0].split(':')[1].split(';')[0];  
		var ia = new Uint8Array(byteString.length);  
		for (var i = 0; i < byteString.length; i++) {  
		    ia[i] = byteString.charCodeAt(i);  
		}  
		return new Blob([ia], {type: mimeString}); 
	
	}