package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
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
public final class JdkSslClientContext extends JdkSslContext {
    @Deprecated
    public JdkSslClientContext() throws SSLException {
        this(null, null);
    }

    private static SSLContext newSSLContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, long j8, long j9, String str2) throws SSLException {
        SSLContext sSLContext;
        KeyManager[] keyManagers;
        TrustManager[] trustManagers;
        if (x509CertificateArr != null) {
            try {
                trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
            } catch (Exception e8) {
                if (e8 instanceof SSLException) {
                    throw ((SSLException) e8);
                }
                throw new SSLException("failed to initialize the client-side SSL context", e8);
            }
        }
        if (x509CertificateArr2 != null) {
            keyManagerFactory = SslContext.buildKeyManagerFactory(x509CertificateArr2, privateKey, str, keyManagerFactory, str2);
        }
        if (provider == null) {
            sSLContext = SSLContext.getInstance("TLS");
        } else {
            sSLContext = SSLContext.getInstance("TLS", provider);
        }
        if (keyManagerFactory == null) {
            keyManagers = null;
        } else {
            keyManagers = keyManagerFactory.getKeyManagers();
        }
        if (trustManagerFactory == null) {
            trustManagers = null;
        } else {
            trustManagers = trustManagerFactory.getTrustManagers();
        }
        sSLContext.init(keyManagers, trustManagers, null);
        SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
        if (j8 > 0) {
            clientSessionContext.setSessionCacheSize((int) Math.min(j8, 2147483647L));
        }
        if (j9 > 0) {
            clientSessionContext.setSessionTimeout((int) Math.min(j9, 2147483647L));
        }
        return sSLContext;
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        this(file, trustManagerFactory, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j8, long j9) throws SSLException {
        this(null, file, trustManagerFactory, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, j8, j9);
    }

    JdkSslClientContext(Provider provider, File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j8, long j9) throws SSLException {
        super(newSSLContext(provider, SslContext.toX509CertificatesInternal(file), trustManagerFactory, null, null, null, null, j8, j9, KeyStore.getDefaultType()), true, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, ClientAuth.NONE, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkSslClientContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j8, long j9, String str2) throws SSLException {
        super(newSSLContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, j8, j9, str2), true, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), ClientAuth.NONE, strArr, false);
    }
}
