@echo off
::ת����ǰ�̷�
%~d0
::�򿪵�ǰĿ¼
cd %~dp0
::��������JAR����·��
set MainJar=gfanpayane.jar
::������JAR����·��
set jar1=gfansdk_pay.jar

::������JAR������������
set packageName1=com
echo =========== start combin ==============
::��ѹ��������
jar -xf %jar1%

::�ϲ���JAR��
jar -uf %MainJar% %packageName1% 
echo =========== over ==============
echo �ٵ�һ�¾ͽ�����--СQ
pause