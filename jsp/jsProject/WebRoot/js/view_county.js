!function() {
  var count = -1;
  var localArea = {}
  $(county).on(
    "keyup",
    _.debounce(function(e) {
      var eve = window.event || e;
      var code = eve.keyCode;
      var value = county.value;
      if (!value.trim()) {
    	countyData.classList.remove("active");
        return;
      }
      if (!storage.get("area") || !storage.get("area").pre || !storage.get("area").city) {
    	countyData.classList.remove("active");
	    return;
	  }
      if ((code >= 65 && code <= 90) || code == 8 || code == 32) {
    	localArea = storage.get("area");
        let area = new Area({areaname:value, parentid:localArea.city});
        area.getSuggestion().then(datas => {
          console.log(datas);
          let listUl = $("#countyData");
          listUl.empty();
          if (datas.length > 0) {
            for (let i = 0; i < datas.length; i++) {
              listUl.append("<li id="+ datas[i].areaid +">" + datas[i].areaname + "</li>");
            }
            $("#countyData li").mouseover(function() {
              $("#countyData li").css("background", "");
              $(this).css("background", "#ccc");
              count = $(this).index();
            });
            $("#countyData li").click(function() {
              $("#county").val($(this).html());
              localArea.county = $(this).attr('id')
              storage.set('area',localArea)
              countyData.classList.remove("active");
            });
            countyData.classList.add("active");
          } else {
        	countyData.classList.remove("active");
          }
        });
      }
      $(document).one("click", function(e) {
    	  countyData.classList.remove("active");
      });
      // 判断用户点击的是否是键盘的下键
      if (code == 40) {
        // 判断是否有提示语
        if ($("#countyData li").length > 0) {
          // 判断
          count = count < $("#countyData li").length - 1 ? ++count : 0;
          // 清空所有提示语的div的背景颜色
          $("#countyData li").css("background-color", "");
          // 让提示语div中第一个提示语的背景色变成灰色
          $("#countyData li:eq(" + count + ")").css("background-color", "#ccc");
          // 将选择的提示语改变到搜索框中
          $("#county").val($("#countyData li:eq(" + count + ")").html());
          localArea.county = $("#countyData li:eq(" + count + ")").attr('id')
          storage.set('area',localArea)
        }
      }
      // 判断用户点击的是否是键盘的上键
      if (code == 38) {
        // 判断是否有提示语
        if ($("#countyData li").length > 0) {
          // 判断
          count = count > 0 ? --count : $("#countyData li").length - 1;
          // 清空所有提示语的div的背景颜色
          $("#countyData li").css("background-color", "");
          // 让提示语div中第一个提示语的背景色变成灰色
          $("#countyData li:eq(" + count + ")").css("background-color", "#ccc");
          // 将选择的提示语改变到搜索框中
          $("#county").val($("#countyData li:eq(" + count + ")").html());
          localArea.county = $("#countyData li:eq(" + count + ")").attr('id')
          storage.set('area',localArea)
        }
      }
    }, 200)
  );
}.call();
