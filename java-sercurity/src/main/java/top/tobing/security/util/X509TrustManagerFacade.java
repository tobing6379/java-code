package top.tobing.security.util;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * $ X509TrustManagerFacade 自定义信任管理器
 *
 * @author tobing
 * @date 2022/3/16 20:00
 */
@Slf4j
public class X509TrustManagerFacade implements X509TrustManager {

    private X509TrustManager x509TrustManager;

    /**
     * 使用密钥仓库初始化信任管理器
     *
     * @param keyStore 密钥仓库
     */
    public void init(KeyStore keyStore) throws Exception {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init(keyStore);
        TrustManager[] trustManagers = factory.getTrustManagers();
        for (int i = 0; i < trustManagers.length; i++) {
            TrustManager trustManager = trustManagers[i];
            if (trustManager instanceof X509TrustManager) {
                this.x509TrustManager = (X509TrustManager) trustManager;
            }
        }
        if (this.x509TrustManager == null) {
            throw new Exception("Can't find X509TrustManager");
        }
    }

    /**
     * 客户端证书检验
     * 检查客户端的证书，若不信任该证书则抛出异常。
     * 如果不需要对客户端进行认证，只需要执行默认的信任管理器的这个方法。
     * JSSE中，默认的信任管理器类为TrustManager。
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        log.info("checkClient {}, type is {}", chain, authType);
        if (this.x509TrustManager != null) {
            this.x509TrustManager.checkClientTrusted(chain, authType);
        }
    }

    /**
     * 服务端证书校验
     * 客户端通过该方法检查服务器证书，不信任的整数抛出异常。
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        log.info("checkServer {}, type is {}", chain, authType);
        if (this.x509TrustManager != null) {
            this.x509TrustManager.checkServerTrusted(chain, authType);
        }
    }

    /**
     * 返回信任的X509证书数组
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        if (this.x509TrustManager == null) {
            return null;
        }
        X509Certificate[] ret = x509TrustManager.getAcceptedIssuers();
        if (ret == null) {
            log.error("信任的X509整数数组为空");
        }
        return ret;
    }
}
