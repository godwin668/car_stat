# Spring MVC Hibernate Demo

----------

## Hibernate 配置
1. 数据库实体必须设置以下主键
@Entity
@Id

2. 自增主键必须设置以下注解，否则报错
@GeneratedValue(strategy = GenerationType.IDENTITY)

3. 在更新或删除数据时，必须调用getHibernateTemplate().flush();
	且在web.xml中添加
	```
	<filter>
		<filter-name>openSessionInViewFilter</filter-name>
		<filter-class>org.springframework.orm.hibernate4.support.OpenSessionInViewFilter</filter-class>
		<init-param>
			<param-name>flushMode</param-name>
			<param-value>AUTO</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>openSessionInViewFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	```

4. 配置checkWriteOperations为false，否则出现异常：Write operations are not allowed in read-only mode (FlushMode.MANUAL): Turn your Session into FlushMode.COMMIT/AUTO or remove 'readOnly' marker from transaction definition
	```
	<bean id="hibernateTemplate" class="org.springframework.orm.hibernate4.HibernateTemplate">
		<property name="sessionFactory" ref="sessionFactory" />
		<property name="checkWriteOperations" value="false" />
	</bean>
	```

Reference: http://www.mkyong.com/spring/maven-spring-hibernate-annotation-mysql-example/