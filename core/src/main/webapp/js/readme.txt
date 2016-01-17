相关内容和规则暂定如下，欢迎多多提改善意见（技术中心前端：孙德贵）

一、此文件夹存放网站的js脚本文件，文件结构同jsp文件夹一一对应（若页面无js则不建对应js文件）

二、js相关规范如下：
1、通用js（交互效果、各个组件、控件）写入common文件夹里common.js文件里面，按功能模块注释清楚
3、每个页面除去公用common.js外，若页面有独有js则建立单独js文件编写相应代码
4、函数和变量命名规则：
	必须采用驼峰式命名，如function pageManage *
	类名首字母大写，如Dialog *
	全局变量用纯大写字母，用”_“做连接符，如GO *
	禁止在业务页面使用全局变量。需要使用全局变量的地方可以放到GO2命名空间，如GO2.buyerId *
	jquery对象使用$做前缀，如$dom *
	“_“已经保留，不能作为变量的命名
	对象的key不能使用关键字或者保留字 *
	关键字
	“break”, “case”, “catch”, “const”, “continue”, “default”, “delete”, “do”, “else”, “finally”, “for”, “function”, “if”, “in”, “instanceof”, “new”, “return”, “switch”, “throw”, “try”, “typeof”, “var”, “void”, “while”, “with”, “false”, “true”, “null”, “undefined”
	保留字
	“abstract”, “boolean”, “byte”, “char”, “class”, “debugger”, “double”, “enum”, “export”, “extends”, “final”, “float”, “goto”, “implements”, “import”, “int”, “interface”, “long”, “native”, “package”, “private”, “protected”, “public”, “short”, “static”, “super”, “synchronized”, “throws”, “transient”, “volatile”, “_”
