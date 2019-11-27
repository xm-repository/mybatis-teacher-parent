# 简介

此项目主要是用来学习mybatis的源码以及教学使用，去掉一些我不喜欢以及复杂的内容。便于学生理解mybatis源代码。

对于mybatis，我个人倾向于Mapper接口+mapper文件的开发模式，利用这种方式完成crud操作即可，不需要注解、事务等功能。

# v0

v0版本是直接从mybatis官网下载的mybatis的源代码，与实际使用的mybatis源代码不是完全匹配的，因为实际使用的mybatis源代码是把其它的依赖都整合进来了，而官网却没有。

# v1



## Environment

此类在mapper包下，核心作用是获取DataSource以及事务工厂以及支持多环境下的开发。