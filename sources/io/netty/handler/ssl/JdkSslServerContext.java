package io.netty.handler.ssl;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

@Deprecated
/* loaded from: classes5.dex */
public final class JdkSslServerContext extends JdkSslContext {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkSslServerContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j8, long j9, ClientAuth clientAuth, String[] strArr, boolean z7, String str2) throws SSLException {
        super(newSSLContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, j8, j9, str2), false, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, true), clientAuth, strArr, z7);
    }

    private static SSLContext newSSLContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, long j8, long j9, String str2) throws SSLException {
        SSLContext sSLContext;
        TrustManager[] trustManagers;
        if (privateKey == null && keyManagerFactory == null) {
            throw new NullPointerException("key, keyManagerFactory");
        }
        if (x509CertificateArr != null) {
            try {
                trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
            } catch (Exception e8) {
                if (e8 instanceof SSLException) {
                    throw ((SSLException) e8);
                }
                throw new SSLException("failed to initialize the server-side SSL context", e8);
            }
        }
        if (privateKey != null) {
            keyManagerFactory = SslContext.buildKeyManagerFactory(x509CertificateArr2, privateKey, str, keyManagerFactory, null);
        }
        if (provider == null) {
            sSLContext = SSLContext.getInstance("TLS");
        } else {
            sSLContext = SSLContext.getInstance("TLS", provider);
        }
        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        if (trustManagerFactory == null) {
            trustManagers = null;
        } else {
            trustManagers = trustManagerFactory.getTrustManagers();
        }
        sSLContext.init(keyManagers, trustManagers, null);
        SSLSessionContext serverSessionContext = sSLContext.getServerSessionContext();
        if (j8 > 0) {
            serverSessionContext.setSessionCacheSize((int) Math.min(j8, 2147483647L));
        }
        if (j9 > 0) {
            serverSessionContext.setSessionTimeout((int) Math.min(j9, 2147483647L));
        }
        return sSLContext;
    }
}
