# 二手车源数据统计系统

车源数据统计系统

网址：www.chenum.com

## 部署步骤

* 根据conf.properties配置文件，在MySQL中创建对应数据库和设置权限
* 导入城市数据city.sql
* mvn clean package打包项目
* 打包后，将target下项目文件夹复制到tomcat服务下
* 重启tomcat

## 注意事项

* conf.properties配置文件中可配置自动获取数据的时间
* ...

## 技术框架

* 后台使用SpringMVC 4.1 + Hibernate 5.0
* 数据使用MySQL
* 前端Bootstrap 3
* 表格bootstrap-table

## 后期优化

* 添加其他数据源：58二手车、赶集二手车、优信拍、车易拍、好车无忧、人人车等
* 图标展示数据
* 抓取策略
* 数据细分（如在售、已售）
* 首页汇总，多网站趋势图对比，动态1小时变化曲线
* 翻页

## 数据来源

* 优信www.xin.com
* ...

## 分类

### 优信分类
* 类型：买车、付半价
* 车源：全部车源、无事故承诺、原厂质保、商家质保、个人车源
* 车龄：1年内、1-3年、3-5年、5-8年、8年以上
* 里程：1万公里内、1-3万公里、3-6万公里、6-10万公里、10-20万公里、20万公里以上
* 价格：5万元以下、5-10万元、10-15万元、15-20万元、20-30万元、30-50万元、50万元以上

## 参考

* Spring: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/
* Bootstrap(en): http://getbootstrap.com
* Bootstrap(中): http://www.bootcss.com/
* bootstrap-table: http://bootstrap-table.wenzhixin.net.cn

## 版权

* Open Source & Free
* Powered by godwin668@gmail.com

