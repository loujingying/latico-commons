title jar install to native maven repository
@echo off
@rem 注意：必须使用CRLF换行符格式。因为mvn命令也是脚本,在BAT文件里面执行Maven的mvn命令后，mvn之后的命令不会被执行，
@rem 这是由于mvn本身也是BAT文件，并且其结束时执行了退出命令。要让mvn命令不使当前脚本自动退出，只需要在mvn之前加上“call”命令
@rem 如果运行报mvn命令找不到，就配置好maven环境变量，如果还是找不到，请使用管理员方式运行脚本

@rem 该脚本的使用，只需要修改jar的目录，必须使用绝对路径
@echo on
set jarAbsoluteDir=C:\project\latico\latico-commons\latico-commons-webservice-soap-wsdl\lib

@rem ====================
set jarFileName=analytics-core-5.1.0.Jar
set jarGroupId=com.smartbear.utils.analytics
set jarArtifactId=analytics-core
set jarVersion=5.1.0
call mvn install:install-file -Dfile=%jarAbsoluteDir%/%jarFileName% -DgroupId=%jarGroupId% -DartifactId=%jarArtifactId% -Dversion=%jarVersion% -Dpackaging=jar

@rem ====================
set jarFileName=out-app-analytics-provider-5.1.0.Jar
set jarGroupId=com.smartbear.utils.analytics
set jarArtifactId=out-app-analytics-provider
set jarVersion=5.1.0
call mvn install:install-file -Dfile=%jarAbsoluteDir%/%jarFileName% -DgroupId=%jarGroupId% -DartifactId=%jarArtifactId% -Dversion=%jarVersion% -Dpackaging=jar

@rem ====================
set jarFileName=soapui-5.1.2.jar
set jarGroupId=net.webservices
set jarArtifactId=soapui
set jarVersion=5.1.2
call mvn install:install-file -Dfile=%jarAbsoluteDir%/%jarFileName% -DgroupId=%jarGroupId% -DartifactId=%jarArtifactId% -Dversion=%jarVersion% -Dpackaging=jar

@rem ====================
set jarFileName=soapui-xmlbeans-1.7.jar
set jarGroupId=net.webservices.client
set jarArtifactId=soapui-xmlbeans
set jarVersion=1.7
call mvn install:install-file -Dfile=%jarAbsoluteDir%/%jarFileName% -DgroupId=%jarGroupId% -DartifactId=%jarArtifactId% -Dversion=%jarVersion% -Dpackaging=jar

pause
