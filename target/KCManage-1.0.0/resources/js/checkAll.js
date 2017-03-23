


function mainOpen(url) {
	var iWidth = 1000; // 寮瑰嚭绐楀彛鐨勫搴�
	var iHeight = 600; // 寮瑰嚭绐楀彛鐨勯珮搴�
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
	// 鑾峰緱绐楀彛鐨勬按骞充綅缃�
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
	window
			.open(
					url,
					"child",
					'height='
							+ iHeight
							+ ',,innerHeight='
							+ iHeight
							+ ',width='
							+ iWidth
							+ ',innerWidth='
							+ iWidth
							+ ',top='
							+ iTop
							+ ',left='
							+ iLeft
							+ ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
}


