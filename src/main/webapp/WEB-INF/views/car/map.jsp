<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="全国二手车数据统计分析">
    <meta name="keywords" content="二手车 数据统计 对比分析 58二手车 优信二手车" />
    <meta name="author" content="godwin668@gmail.com">
    <link rel="icon" href="/favicon.ico">

    <title>全国二手车数据统计分析系统</title>

    <!-- CSS -->
    <link href="/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/bootstrap_table/css/bootstrap-table.min.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 70px;
      }
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">全国二手车数据统计分析系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/car/58">58二手车数据统计</a></li>
            <li><a href="/car/xin">优信二手车数据统计</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
    
      <div class="container-fluid">
        <div class="row" style="text-align: center;">
          <div class="col-md-6">
            <div id="chart-container-58" style="height: 400px;"></div>
          </div>
          <div class="col-md-6">
            <div id="chart-container-xin" style="height: 400px;"></div>
          </div>
        </div>
        <br />
        <hr />
        <br />
        <div class="row" style="text-align: center;">
          <div class="col-md-12">
            <div id="chart-container-trend" style="width: 100%; height: 400px;"></div>
          </div>
        </div>
      </div>

    </div><!-- /.container -->

    <!-- JavaScript
    ================================================== -->
    <script src="/static/jquery/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap3/js/bootstrap.min.js"></script>
    <script src="/static/bootstrap_table/js/bootstrap-table.min.js"></script>
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script src="/static/dateFormat/js/jquery-dateFormat.min.js"></script>
    <script src="/static/car/js/map.js?v=${version}"></script>
    <script src="/static/car/js/stat.js?v=${version}"></script>
  </body>
</html>
