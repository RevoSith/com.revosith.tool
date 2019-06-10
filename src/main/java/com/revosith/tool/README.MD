常用工具包封装.懒得引各种杂七八的包,轻量级包. cglib还是需要的(scope=provided).
1.0.0

CopyUtils 
BeanCopier封装. 提供简单的单一复制与List复制. 不支持自定义构造函数的类的复制.
example:
  Abc abc = CopyUtil.copySigle(Abc.class,other);
  List<Abc> temp = CopyUtil.copyMulti(Abc.class,otherList);
  
CollectionUtils
isEmpty 方法.

ConvertUtils(带工具缓存功能,工具初始化存在耗时.)
使用@CopyConvert注解的同名属性复制功能.
ConvertTool 接口. 可以自定义实现方式

值转换:
DefaultConvertTool:默认字符赋值
DateConvertTool: date->Str
深拷贝:
ListConvertTool:   列表拷贝
SimpleConvertTool: 对象拷贝

example:
   @CopyConvert(convertClass = "com.revosith.tool.impl.DateConvertTool", param = "yyyy-MM-dd")
   private Date tempDate; 
DateConvertTool 实现了ConvertTool 接口. 可以自定义实现方式
   public class DateConvertTool implements ConvertTool<String, Date> {
   
       @Override
       public String convert(Class<String> target, Date souceData, String param) {
           return DateUtils.format(souceData, param);
       }
   }

DateUtils
提供 date<->str .
批量使用 线程优化版parse,format
简单使用 常规版   getDate,formateDate

StringUtils
isBlank 方法.      