### 顺丰同城开放平台服务端SDK FOR JAVA <br>
1、使用说明 <br><br>
    将项目拉到本地后，导入src/main/resources/lib目录下的jar包，或者重新打包均可；然后上传到远程仓库，pom增加依赖文件即可使用。<br><br>
```
       <dependency>
            <groupId>com.sfjswl</groupId>
            <artifactId>sftc-open-sdk-java</artifactId>
            <version>1.0.0</version>
        </dependency>
```

  （1）SftcwlSignature.sign()：签名生成，适用于开发者请求顺丰开放平台接口时生成签名。<br><br>
  （2）SftcwlSignature.checkSign()：签名校验，适用于开发者接收到顺丰同城回调请求时进行签名校验。<br><br>
2、注意事项 <br><br>
  （1）当前sdk只适配于version>=17的版本，请各位开发者使用时注意。<br><br>
  （2）使用过程中如有任何问题，可以联系相关对接人员。<br>
