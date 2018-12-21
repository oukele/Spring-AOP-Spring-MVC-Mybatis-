### 前言：
   除了mybatis 不是零配置，有些还是有xml的配置文件在里面的。

### 注解是Spring的一个构建的一个重要手段，减少写配置文件，下面解释一下一些要用到的注解：
~~~
@Configuration 作用于类上面，声明当前类是一个配置类（相当于一个Spring的xml文件）
@ComponentScan(“xxx”) 作用于类上面，自动扫描xxx包名下所有使用@Service、@Component、@Repository和@Controller的类，并注册为Bean
@Bean 作用与类和方法上，相当于Spring配置文件bean节点
@EnableWebMvc 作用于类，开启一些默认配置，如一些ViewResolver或者MessageConverter
@RequestMapping 作用于类、方法，配置URL和方法之间的映射
@RequestBody 作用于参数前，允许request的参数在request体中，而不是在直接链接在地址后面
@ResponseBody 作用于返回值、方法上，支持将返回值放在response体中，而不是返回一个页面。
@RequestParam 作用于参数前，将form的对应name值映射到当前参数中。

~~~
### AspectJ 
 #### 前言
###### AOP并不是Spring框架特有的。Spring只是支持AOP编程 (面向切面编程) 的框架之一。
~~~
1、切面(Aspect)
　　一系列Advice + Pointcut 的集合。

2、通知(Advice)
　　通知是切面开启后，切面的方法。

前置通知 ( before )：在动态代理反射原有对象方法 或者 执行环绕通知 前 执行的通知功能
后置通知（after）：在动态代理反射原有对象方法 或者 执行环绕通知 后 执行的通知功能
返回通知 （afterReturning）：在动态代理反射原有对象方法 或者 执行环绕通知 后 正常返回（无异常）执行的通知功能
异常通知（afterTherowing）：在动态代理反射原有对象方法 或者 执行环绕通知 产生异常后执行的通知功能
环绕通知（around）：在动态代理中，它可以取代当前被拦截对象的方法，提供回调原有被拦截对象的方法
3、引入(Introduction)
　　引入允许我们在现有的类里添加自定义的类和方法

4、切点(Pointcut)
　　这是一个告诉Spring AOP 在什么时候启动拦截并织入对应的流程，因为并不是所有的开发都是需要启动AOP的，它往往通过正则表达进行限定

5、连接点( join point)
　　Pointcut 中的某个具体位置。
~~~