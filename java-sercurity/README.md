# Security

应用安全相关。

## OIO SSL/TLS

使用Keytool生成密钥仓库以及数据证书。

```bash
# Generate the server and client certificate
# CN=liangshangfu, OU=swpu, O=swpu, L=chengdu, ST=sicuan, C=cn
keytool -genkey -alias server -keyalg RSA -keypass 123456 -storepass 123456 -keystore  D:\server.jks
keytool -genkey -alias client -keyalg RSA -keypass 123456 -storepass 123456 -keystore D:\client.jks

# Export the generated server and client certificate in keystore.jks into the file server.cer.
keytool -export -alias server -storepass 123456 -file server.cer -keystore  D:\server.jks
keytool -export -alias client -storepass 123456 -file client.cer -keystore  D:\client.jks

# add the server certificate to the client truststore file
keytool -import -v -trustcacerts -alias server -file D:\server.cer -keystore client.jks -keypass 123456 -storepass 123456
# add the client certificate to the server truststore file
keytool -import -v -trustcacerts -alias client -file D:\client.cer -keystore server.jks -keypass 123456 -storepass 123456
```

## Reference

+ [Creating a KeyStore in JKS Format](https://docs.oracle.com/cd/E19509-01/820-3503/ggfen/index.html)

+ [Wireshark does not capture HTTP on 8080](https://serverfault.com/questions/505840/wireshark-does-not-capture-http-on-8080)

