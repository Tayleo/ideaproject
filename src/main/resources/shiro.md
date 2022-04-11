`shiro核心组件`
1.UsernamePasswordToken ,shiro用来封装用户登录信息，使用用户的登录信息来创建令牌token
2.SecurityManager,shiro的核心部分，负责安全认证和授权
3.subject:shiro的一个抽象概念，包含了用户信息
4.Realm：开发者自定义模块，根据项目的需求，验证和授权的逻辑都写在Realm中
5.Authenticationinfo:用户的角色信息集合，认证时使用
6.Authorzationifo:角色的权限信息集合，授权时使用
7.DefaultWebSecturityManager:安全管理器，开发者自定义的realm需要注入到DefaultWebSecturityManager进行管理才能生效
8.ShiroFilterfactoryBean:过滤器工厂，shiro的基本运行机制是开发者定制规则，shiro去执行，具体的执行操作就是ShiroFilterfactoryBean创建的一个个filter对象来完成

认证过滤器：
anon:无需认证
authc:必须认证
atchBasic:需要通过httpbasic认证
user:不一定通过认证，只要曾经被shiro记录即可

授权过滤器：
perms:必须拥有某个权限才能访问
role:必须拥有某个角色才能访问
port:请求的端口必须是指定值才可以
rest:请求必须基于Restful,post,get
ssl:必须是安全的url请求，协议https