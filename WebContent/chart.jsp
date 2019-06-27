<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script src="js/jquery-3.2.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/index.js"></script>
	<link rel=stylesheet href="css/bootstrap.min.css">
	<link rel=stylesheet type="text/css" href="css/style.css" />
	<link rel="shortcut icon" href="images/favicon.ico">
	<title>S2A105</title>
</head>
<body>
<header>
<h1>OTODO</h1>
<nav>
	<ul class="nav nav-tabs nav-justified" style="background-color:#ff8c00" style="color:#000000">
		<li><a href="index.jsp">タスク登録</a>
		<li><a href="ResponseServlet2">タスク</a>
		<li><a href="chart.jsp">チャート</a>
	</ul>
</nav>
</header>
<h1>株価表示画面</h1>
<!-- TradingView Widget BEGIN -->
<div class="tradingview-widget-container">
  <div id="tradingview_0d03d"></div>
  <div class="tradingview-widget-copyright">TradingView提供の<a href="https://jp.tradingview.com/symbols/NASDAQ-AAPL/" rel="noopener" target="_blank"><span class="blue-text">AAPLチャート</span></a></div>
  <script type="text/javascript" src="https://s3.tradingview.com/tv.js"></script>
  <script type="text/javascript">
  new TradingView.widget(
  {
  "width": 980,
  "height": 610,
  "symbol": "BTCUSD+XRPUSD",
  "interval": "1",
  "timezone": "Etc/UTC",
  "theme": "Dark",
  "style": "1",
  "locale": "ja",
  "toolbar_bg": "#f1f3f6",
  "enable_publishing": false,
  "allow_symbol_change": true,
  "container_id": "tradingview_0d03d"
}
  );
  </script>
</div>
<!-- TradingView Widget END -->
</body>
</html>