@echo off
::转到当前盘符
%~d0
::打开当前目录
cd %~dp0
::你做的主JAR包的路径
set MainJar=gfanpayane.jar
::第三方JAR包的路径
set jar1=gfansdk_pay.jar

::第三方JAR包顶级包名称
set packageName1=com
echo =========== start combin ==============
::解压第三方包
jar -xf %jar1%

::合并主JAR包
jar -uf %MainJar% %packageName1% 
echo =========== over ==============
echo 再点一下就结束了--小Q
pause