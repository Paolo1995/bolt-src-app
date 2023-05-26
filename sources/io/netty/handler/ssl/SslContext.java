package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.util.AttributeMap;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.internal.EmptyArrays;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes5.dex */
public abstract class SslContext {
    static final CertificateFactory X509_CERT_FACTORY;
    private final AttributeMap attributes;
    private final boolean startTls;

    /* renamed from: io.netty.handler.ssl.SslContext$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        static {
            int[] iArr = new int[SslProvider.values().length];
            $SwitchMap$io$netty$handler$ssl$SslProvider = iArr;
            try {
                iArr[SslProvider.JDK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL_REFCNT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        try {
            X509_CERT_FACTORY = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e8) {
            throw new IllegalStateException("unable to instance X.509 CertificateFactory", e8);
        }
    }

    protected SslContext() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, String str2) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        return buildKeyManagerFactory(x509CertificateArr, KeyManagerFactory.getDefaultAlgorithm(), privateKey, str, keyManagerFactory, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyStore buildKeyStore(X509Certificate[] x509CertificateArr, PrivateKey privateKey, char[] cArr, String str) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        if (str == null) {
            str = KeyStore.getDefaultType();
        }
        KeyStore keyStore = KeyStore.getInstance(str);
        keyStore.load(null, null);
        keyStore.setKeyEntry("key", privateKey, cArr, x509CertificateArr);
        return keyStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrustManagerFactory buildTrustManagerFactory(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, String str) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {
        if (str == null) {
            str = KeyStore.getDefaultType();
        }
        KeyStore keyStore = KeyStore.getInstance(str);
        keyStore.load(null, null);
        int i8 = 1;
        for (X509Certificate x509Certificate : x509CertificateArr) {
            keyStore.setCertificateEntry(Integer.toString(i8), x509Certificate);
            i8++;
        }
        if (trustManagerFactory == null) {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        }
        trustManagerFactory.init(keyStore);
        return trustManagerFactory;
    }

    public static SslProvider defaultClientProvider() {
        return defaultProvider();
    }

    private static SslProvider defaultProvider() {
        if (OpenSsl.isAvailable()) {
            return SslProvider.OPENSSL;
        }
        return SslProvider.JDK;
    }

    public static SslProvider defaultServerProvider() {
        return defaultProvider();
    }

    protected static PKCS8EncodedKeySpec generateKeySpec(char[] cArr, byte[] bArr) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (cArr == null) {
            return new PKCS8EncodedKeySpec(bArr);
        }
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(bArr);
        SecretKey generateSecret = SecretKeyFactory.getInstance(encryptedPrivateKeyInfo.getAlgName()).generateSecret(new PBEKeySpec(cArr));
        Cipher cipher = Cipher.getInstance(encryptedPrivateKeyInfo.getAlgName());
        cipher.init(2, generateSecret, encryptedPrivateKeyInfo.getAlgParameters());
        return encryptedPrivateKeyInfo.getKeySpec(cipher);
    }

    private static X509Certificate[] getCertificatesFromBuffers(ByteBuf[] byteBufArr) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate[] x509CertificateArr = new X509Certificate[byteBufArr.length];
        int i8 = 0;
        for (int i9 = 0; i9 < byteBufArr.length; i9++) {
            try {
                ByteBufInputStream byteBufInputStream = new ByteBufInputStream(byteBufArr[i9], false);
                x509CertificateArr[i9] = (X509Certificate) certificateFactory.generateCertificate(byteBufInputStream);
                try {
                    byteBufInputStream.close();
                } catch (IOException e8) {
                    throw new RuntimeException(e8);
                }
            } finally {
                int length = byteBufArr.length;
                while (i8 < length) {
                    byteBufArr[i8].release();
                    i8++;
                }
            }
        }
        return x509CertificateArr;
    }

    private static PrivateKey getPrivateKeyFromByteBuffer(ByteBuf byteBuf, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        char[] charArray;
        byte[] bArr = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bArr).release();
        if (str == null) {
            charArray = null;
        } else {
            charArray = str.toCharArray();
        }
        PKCS8EncodedKeySpec generateKeySpec = generateKeySpec(charArray, bArr);
        try {
            try {
                try {
                    return KeyFactory.getInstance("RSA").generatePrivate(generateKeySpec);
                } catch (InvalidKeySpecException unused) {
                    return KeyFactory.getInstance("EC").generatePrivate(generateKeySpec);
                }
            } catch (InvalidKeySpecException e8) {
                throw new InvalidKeySpecException("Neither RSA, DSA nor EC worked", e8);
            }
        } catch (InvalidKeySpecException unused2) {
            return KeyFactory.getInstance("DSA").generatePrivate(generateKeySpec);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] keyStorePassword(String str) {
        if (str == null) {
            return EmptyArrays.EMPTY_CHARS;
        }
        return str.toCharArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SslContext newClientContextInternal(SslProvider sslProvider, Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j8, long j9, boolean z7, String str2) throws SSLException {
        SslProvider sslProvider2;
        if (sslProvider == null) {
            sslProvider2 = defaultClientProvider();
        } else {
            sslProvider2 = sslProvider;
        }
        int i8 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider2.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    verifyNullSslContextProvider(sslProvider2, provider);
                    return new ReferenceCountedOpenSslClientContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j8, j9, z7, str2);
                }
                throw new Error(sslProvider2.toString());
            }
            verifyNullSslContextProvider(sslProvider2, provider);
            return new OpenSslClientContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j8, j9, z7, str2);
        } else if (!z7) {
            return new JdkSslClientContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j8, j9, str2);
        } else {
            throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + sslProvider2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SslContext newServerContextInternal(SslProvider sslProvider, Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j8, long j9, ClientAuth clientAuth, String[] strArr, boolean z7, boolean z8, String str2) throws SSLException {
        SslProvider defaultServerProvider = sslProvider == null ? defaultServerProvider() : sslProvider;
        int i8 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[defaultServerProvider.ordinal()];
        if (i8 == 1) {
            if (!z8) {
                return new JdkSslServerContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j8, j9, clientAuth, strArr, z7, str2);
            }
            throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + defaultServerProvider);
        } else if (i8 == 2) {
            verifyNullSslContextProvider(defaultServerProvider, provider);
            return new OpenSslServerContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j8, j9, clientAuth, strArr, z7, z8, str2);
        } else if (i8 == 3) {
            verifyNullSslContextProvider(defaultServerProvider, provider);
            return new ReferenceCountedOpenSslServerContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j8, j9, clientAuth, strArr, z7, z8, str2);
        } else {
            throw new Error(defaultServerProvider.toString());
        }
    }

    static PrivateKey toPrivateKey(File file, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        if (file == null) {
            return null;
        }
        return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(file), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PrivateKey toPrivateKeyInternal(File file, String str) throws SSLException {
        try {
            return toPrivateKey(file, str);
        } catch (Exception e8) {
            throw new SSLException(e8);
        }
    }

    static X509Certificate[] toX509Certificates(File file) throws CertificateException {
        if (file == null) {
            return null;
        }
        return getCertificatesFromBuffers(PemReader.readCertificates(file));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static X509Certificate[] toX509CertificatesInternal(File file) throws SSLException {
        try {
            return toX509Certificates(file);
        } catch (CertificateException e8) {
            throw new SSLException(e8);
        }
    }

    private static void verifyNullSslContextProvider(SslProvider sslProvider, Provider provider) {
        if (provider == null) {
            return;
        }
        throw new IllegalArgumentException("Java Security Provider unsupported for SslProvider: " + sslProvider);
    }

    public abstract boolean isClient();

    public final boolean isServer() {
        return !isClient();
    }

    public abstract SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i8);

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i8) {
        return newHandler(byteBufAllocator, str, i8, this.startTls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SslContext(boolean z7) {
        this.attributes = new DefaultAttributeMap();
        this.startTls = z7;
    }

    static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] x509CertificateArr, String str, PrivateKey privateKey, String str2, KeyManagerFactory keyManagerFactory, String str3) throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, UnrecoverableKeyException {
        char[] keyStorePassword = keyStorePassword(str2);
        return buildKeyManagerFactory(buildKeyStore(x509CertificateArr, privateKey, keyStorePassword, str3), str, keyStorePassword, keyManagerFactory);
    }

    protected SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i8, boolean z7) {
        return new SslHandler(newEngine(byteBufAllocator, str, i8), z7);
    }

    static KeyManagerFactory buildKeyManagerFactory(KeyStore keyStore, String str, char[] cArr, KeyManagerFactory keyManagerFactory) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (keyManagerFactory == null) {
            keyManagerFactory = KeyManagerFactory.getInstance(str);
        }
        keyManagerFactory.init(keyStore, cArr);
        return keyManagerFactory;
    }
}
