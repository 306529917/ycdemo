自定义SpringBoot风格的Redis启动器工程

只要在目标工程配置
jedis:
   enable: true
就可以注入Jedis对象，操作Redis数据库