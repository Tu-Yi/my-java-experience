!function() {
  var count = -1;
  var localArea = {}
  $(city).on(
    "keyup",
    _.debounce(function(e) {
      var eve = window.event || e;
      var code = eve.keyCode;
      var value = city.value;
      if (!value.trim()) {
    	cityData.classList.remove("active");
        return;
      }
      if (!storage.get("area") || !storage.get("area").pre) {
	  	cityData.classList.remove("active");
	    return;
	  }
      if ((code >= 65 && code <= 90) || code == 8 || code == 32) {
    	localArea = storage.get("area");
    	console.log("1 "+JSON.stringify(localArea))
        let area = new Area({areaname:value, parentid:localArea.pre});
        area.getSuggestion().then(datas => {
          console.log(datas);
          let listUl = $("#cityData");
          listUl.empty();
          if (datas.length > 0) {
            for (let i = 0; i < datas.length; i++) {
              listUl.append("<li id="+ datas[i].areaid +">" + datas[i].areaname + "</li>");
            }
            $("#cityData li").mouseover(function() {
              $("#cityData li").css("background", "");
              $(this).css("background", "#ccc");
              count = $(this).index();
            });
            $("#cityData li").click(function() {
              $("#city").val($(this).html());
              localArea.city = $(this).attr('id')
              storage.set('area',localArea)
              cityData.classList.remove("active");
              $("#county").val("")
            });
            cityData.classList.add("active");
          } else {
        	cityData.classList.remove("active");
          }
        });
      }
      $(document).one("click", function(e) {
    	  cityData.classList.remove("active");
      });
      // 判断用户点击的是否是键盘的下键
      if (code == 40) {
        // 判断是否有提示语
        if ($("#cityData li").length > 0) {
          // 判断
          count = count < $("#cityData li").length - 1 ? ++count : 0;
          // 清空所有提示语的div的背景颜色
          $("#cityData li").css("background-color", "");
          // 让提示语div中第一个提示语的背景色变成灰色
          $("#cityData li:eq(" + count + ")").css("background-color", "#ccc");
          // 将选择的提示语改变到搜索框中
          console.log("2 "+JSON.stringify(localArea))
          localArea.city = $("#cityData li:eq(" + count + ")").attr('id')
          storage.set('area',localArea)
          $("#city").val($("#cityData li:eq(" + count + ")").html());
          
          $("#county").val("")
        }
      }
      // 判断用户点击的是否是键盘的上键
      if (code == 38) {
        // 判断是否有提示语
        if ($("#cityData li").length > 0) {
          // 判断
          count = count > 0 ? --count : $("#cityData li").length - 1;
          // 清空所有提示语的div的背景颜色
          $("#cityData li").css("background-color", "");
          // 让提示语div中第一个提示语的背景色变成灰色
          $("#cityData li:eq(" + count + ")").css("background-color", "#ccc");
          // 将选择的提示语改变到搜索框中
          $("#city").val($("#cityData li:eq(" + count + ")").html());
          localArea.city = $("#cityData li:eq(" + count + ")").attr('id')
          storage.set('area',localArea)
          $("#county").val("")
        }
      }
    }, 200)
  );
}.call();
