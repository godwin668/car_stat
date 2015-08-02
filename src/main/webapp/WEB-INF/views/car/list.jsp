<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="demo">
    <meta name="author" content="godwin">
    <link rel="icon" href="/favicon.ico">

    <title>Car list</title>

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
          <a class="navbar-brand" href="#">优信车源数据统计</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <!-- 标题栏
            <li class="active"><a href="#">日期</a></li>
            <li><a href="#about">城市</a></li>
            <li><a href="#contact">类型</a></li>
            -->
            <!-- 日期下拉 -->
            <li class="dropdown nav-dropdown-container nav-dropdown-container-date">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">日期 <span class="caret"></span></a>
              <ul class="dropdown-menu pre-scrollable">
                <li class="active"><a href="#">全部</a></li>
              </ul>
            </li>
            <!-- 城市下拉 -->
            <li class="dropdown nav-dropdown-container nav-dropdown-container-city">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">城市 <span class="caret"></span></a>
              <ul class="dropdown-menu pre-scrollable">
                <li class="active"><a href="#">全部</a></li>
              </ul>
            </li>
            <!-- 类型下拉 -->
            <li class="dropdown nav-dropdown-container nav-dropdown-container-type">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">类型 <span class="caret"></span></a>
              <ul class="dropdown-menu pre-scrollable">
                <li class="active"><a href="#">全部</a></li>
                <li><a href="#">买车</a></li>
                <li><a href="#">付半价</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
    
      <div class="container-fluid">
        <div class="row">
          <table id="table-large-columns" data-height="500" data-show-columns="true">
            <thead>
              <tr>
                <th data-field="ctime" data-align="center" >时间</th>
                <th data-field="cityName" data-align="center" >城市</th>
                <th data-field="pay_type" data-align="center" >类型</th>
                
                <th data-field="srcAll" data-align="center" >全部车源</th>
                <th data-field="srcNoAccident" data-align="center" >无事故承诺</th>
                <th data-field="srcOriginal" data-align="center" >原厂质保</th>
                <th data-field="srcBySeller" data-align="center" >商家质保</th>
                <th data-field="srcPersonal" data-align="center" >个人车源</th>
                
                <th data-field="age_1" data-align="center" data-visible="false">1年内</th>
                <th data-field="age_1_3" data-align="center" data-visible="false">1-3年</th>
                <th data-field="age_3_5" data-align="center" data-visible="false">3-5年</th>
                <th data-field="age_5_8" data-align="center" data-visible="false">5-8年</th>
                <th data-field="age_8" data-align="center" data-visible="false">8年以上</th>
                
                <th data-field="milage_1" data-align="center" data-visible="false">1万公里内</th>
                <th data-field="milage_1_3" data-align="center" data-visible="false">1-3万公里</th>
                <th data-field="milage_3_6" data-align="center" data-visible="false">3-6万公里</th>
                <th data-field="milage_6_10" data-align="center" data-visible="false">6-10万公里</th>
                <th data-field="milage_10_20" data-align="center" data-visible="false">10-20万公里</th>
                <th data-field="milage_20" data-align="center" data-visible="false">20万公里以上</th>
                
                <th data-field="price_5" data-align="center" data-visible="false">5万元以下</th>
                <th data-field="price_5_10" data-align="center" data-visible="false">5-10万元</th>
                <th data-field="price_10_15" data-align="center" data-visible="false">10-15万元</th>
                <th data-field="price_15_20" data-align="center" data-visible="false">15-20万元</th>
                <th data-field="price_20_30" data-align="center" data-visible="false">20-30万元</th>
                <th data-field="price_30_50" data-align="center" data-visible="false">30-50万元</th>
                <th data-field="price_50" data-align="center" data-visible="false">50万元以上</th>
              </tr>
            </thead>
          </table>
        </div>
      </div>

    </div><!-- /.container -->


    <!-- JavaScript
    ================================================== -->
    <script src="/static/jquery/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap3/js/bootstrap.min.js"></script>
    <script src="/static/bootstrap_table/js/bootstrap-table.min.js"></script>
    <script src="/static/car/js/list.js"></script>
  </body>
</html>
