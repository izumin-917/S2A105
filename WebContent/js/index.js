/**
 *
 */
$(function() {
	   //表にクラス追加と削除
            $("tr:nth-child(even)").addClass("even");
            $("tr:not(:first-child)").mouseover(function () {
                $(this).addClass("hober");
            }).mouseout(function () {
                $(this).removeClass("hover");
            });
});
	//マウスオーバーアクション
        $(function () {
            $(".btn-primary").addClass("even");
            $(".btn-primary").mouseover(function () {
                $(this).addClass("hover");
            }).mouseout(function () {
                $(this).removeClass("hover");
            });
});
        $(function() {
        	// 始めにjQueryで必須欄を加工する
        	$('form input:required').each(function() {
        		$(this).prev("label").addClass("required");
        	});
        	$('form select:required').each(function() {
        		$(this).prev("label").addClass("required");
        	});

        	// 入力欄の操作時
        	$('form:required').change(function() {
        		// 必須項目が空かどうかフラグ
        		let flag = true;
        		// 必須項目をひとつずつチェック
        		$('form:required').each(function(e) {
        			// もし必須項目が空なら
        			if ($('form input:required').eq(e).val() === "") {
        				flag = false;
        			}
        		});
        		// 全て埋まっていたら
        		if (flag) {
        			// 送信ボタンを復活
        			$('.send').prop("disabled", false);
        		} else {
        			// 送信ボタンを閉じる
        			$('.send').prop("disabled", true);
        		}
        	});
        });

        timerID = setInterval('clock()',500); //0.5秒毎にclock()を実行

        function clock() {
        	document.getElementById("view_clock").innerHTML = getNow();
        }

        function getNow() {
        	var now = new Date();
        	var year = now.getFullYear();
        	var mon = now.getMonth()+1; //１を足すこと
        	var day = now.getDate();
        	var hour = now.getHours();
        	var min = now.getMinutes();
        	var sec = now.getSeconds();

        	//出力用
        	var s = year + "年" + mon + "月" + day + "日" + hour + "時" + min + "分" + sec + "秒";
        	return s;
        }
