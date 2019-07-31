!function() {
  var count = -1;
  $(pre).on(
    "keyup",
    _.debounce(function(e) {
      var eve = window.event || e;
      var code = eve.keyCode;
      var value = pre.value;
      if (!value.trim()) {
        preData.classList.remove("active");
        return;
      }
      if ((code >= 65 && code <= 90) || code == 8 || code == 32) {
        let area = new Area({areaname:value, parentid:0});
        area.getSuggestion().then(datas => {
          console.log(datas);
          let listUl = $("#preData");
          listUl.empty();
          if (datas.length > 0) {
            for (let i = 0; i < datas.length; i++) {
              listUl.append("<li id="+ datas[i].areaid +">" + datas[i].areaname + "</li>");
            }
            $("#preData li").mouseover(function() {
              $("#preData li").css("background", "");
              $(this).css("background", "#ccc");
              count = $(this).index();
            });
            $("#preData li").click(function() {
              $("#pre").val($(this).html());
              storage.set('area',{pre:$(this).attr('id'),city:'',county:''})
              preData.classList.remove("active");
              $("#city").val("")
              $("#county").val("")
            });
            preData.classList.add("active");
          } else {
            preData.classList.remove("active");
          }
        });
      }
      $(document).one("click", function(e) {
        preData.classList.remove("active");
      });
      // 判断用户点击的是否是键盘的下键
      if (code == 40) {
        // 判断是否有提示语
        if ($("#preData li").length > 0) {
          // 判断
          count = count < $("#preData li").length - 1 ? ++count : 0;
          // 清空所有提示语的div的背景颜色
          $("#preData li").css("background-color", "");
          // 让提示语div中第一个提示语的背景色变成灰色
          $("#preData li:eq(" + count + ")").css("background-color", "#ccc");
          // 将选择的提示语改变到搜索框中
          $("#pre").val($("#preData li:eq(" + count + ")").html());
          storage.set('area',{pre:$("#preData li:eq(" + count + ")").attr('id'),city:'',county:''})
          $("#city").val("")
          $("#county").val("")
        }
      }
      // 判断用户点击的是否是键盘的上键
      if (code == 38) {
        // 判断是否有提示语
        if ($("#preData li").length > 0) {
          // 判断
          count = count > 0 ? --count : $("#preData li").length - 1;
          // 清空所有提示语的div的背景颜色
          $("#preData li").css("background-color", "");
          // 让提示语div中第一个提示语的背景色变成灰色
          $("#preData li:eq(" + count + ")").css("background-color", "#ccc");
          // 将选择的提示语改变到搜索框中
          $("#pre").val($("#preData li:eq(" + count + ")").html());
          storage.set('area',{pre:$("#preData li:eq(" + count + ")").attr('id'),city:'',county:''})
          $("#city").val("")
          $("#county").val("")
        }
      }
    }, 200)
  );
}.call();
