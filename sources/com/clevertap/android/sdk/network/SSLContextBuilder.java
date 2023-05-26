package com.clevertap.android.sdk.network;

import com.clevertap.android.sdk.Logger;
import java.io.BufferedInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes.dex */
final class SSLContextBuilder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SSLContext a() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("DigiCertGlobalRootCA", (X509Certificate) certificateFactory.generateCertificate(new BufferedInputStream(SSLContextBuilder.class.getClassLoader().getResourceAsStream("com/clevertap/android/sdk/certificates/DigiCertGlobalRootCA.crt"))));
            keyStore.setCertificateEntry("DigiCertSHA2SecureServerCA", (X509Certificate) certificateFactory.generateCertificate(new BufferedInputStream(SSLContextBuilder.class.getClassLoader().getResourceAsStream("com/clevertap/android/sdk/certificates/DigiCertSHA2SecureServerCA.crt"))));
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            Logger.a("SSL Context built");
            return sSLContext;
        } catch (Throwable th) {
            Logger.k("Error building SSL Context", th);
            return null;
        }
    }
}
