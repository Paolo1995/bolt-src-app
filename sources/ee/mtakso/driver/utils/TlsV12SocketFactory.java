package ee.mtakso.driver.utils;

import android.os.Build;
import ee.mtakso.driver.di.Injector;
import eu.bolt.kalev.Kalev;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

/* compiled from: TlsV12SocketFactory.kt */
/* loaded from: classes5.dex */
public final class TlsV12SocketFactory extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f36329b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f36330a;

    /* compiled from: TlsV12SocketFactory.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SSLContext b() {
            try {
                return SSLContext.getInstance(TlsVersion.TLS_1_2.javaName());
            } catch (Exception e8) {
                Kalev.e(e8, "Error while setting TLS 1.2 compatibility");
                return null;
            }
        }

        private final X509TrustManager c() {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            Intrinsics.e(trustManagers, "trustManagerFactory.trustManagers");
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    Intrinsics.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                    return (X509TrustManager) trustManager;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public final OkHttpClient.Builder a(OkHttpClient.Builder builder) {
            Intrinsics.f(builder, "<this>");
            if (Build.VERSION.SDK_INT <= 22) {
                Companion companion = TlsV12SocketFactory.f36329b;
                SSLContext b8 = companion.b();
                if (b8 == null) {
                    Injector.f20166d.b().e2().B1().a();
                    b8 = companion.b();
                }
                if (b8 != null) {
                    b8.init(null, new X509TrustManager[]{companion.c()}, null);
                    SSLSocketFactory socketFactory = b8.getSocketFactory();
                    Intrinsics.e(socketFactory, "sslContext.socketFactory");
                    builder.sslSocketFactory(new TlsV12SocketFactory(socketFactory), companion.c());
                } else {
                    Kalev.b("Not able to initialize SSL Context for TLS version");
                }
            }
            return builder;
        }
    }

    public TlsV12SocketFactory(SSLSocketFactory delegate) {
        Intrinsics.f(delegate, "delegate");
        this.f36330a = delegate;
    }

    private final Socket a(Socket socket) {
        SSLSocket sSLSocket;
        if (socket instanceof SSLSocket) {
            sSLSocket = (SSLSocket) socket;
        } else {
            sSLSocket = null;
        }
        if (sSLSocket != null) {
            sSLSocket.setEnabledProtocols(new String[]{TlsVersion.TLS_1_2.javaName(), TlsVersion.TLS_1_1.javaName()});
            return sSLSocket;
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket s7, String host, int i8, boolean z7) throws IOException {
        Intrinsics.f(s7, "s");
        Intrinsics.f(host, "host");
        Socket createSocket = this.f36330a.createSocket(s7, host, i8, z7);
        Intrinsics.e(createSocket, "delegate.createSocket(s, host, port, autoClose)");
        return a(createSocket);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.f36330a.getDefaultCipherSuites();
        Intrinsics.e(defaultCipherSuites, "delegate.defaultCipherSuites");
        return defaultCipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.f36330a.getSupportedCipherSuites();
        Intrinsics.e(supportedCipherSuites, "delegate.supportedCipherSuites");
        return supportedCipherSuites;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int i8) throws IOException, UnknownHostException {
        Intrinsics.f(host, "host");
        Socket createSocket = this.f36330a.createSocket(host, i8);
        Intrinsics.e(createSocket, "delegate.createSocket(host, port)");
        return a(createSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int i8, InetAddress localHost, int i9) throws IOException, UnknownHostException {
        Intrinsics.f(host, "host");
        Intrinsics.f(localHost, "localHost");
        Socket createSocket = this.f36330a.createSocket(host, i8, localHost, i9);
        Intrinsics.e(createSocket, "delegate.createSocket(ho…rt, localHost, localPort)");
        return a(createSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int i8) throws IOException {
        Intrinsics.f(host, "host");
        Socket createSocket = this.f36330a.createSocket(host, i8);
        Intrinsics.e(createSocket, "delegate.createSocket(host, port)");
        return a(createSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int i8, InetAddress localAddress, int i9) throws IOException {
        Intrinsics.f(address, "address");
        Intrinsics.f(localAddress, "localAddress");
        Socket createSocket = this.f36330a.createSocket(address, i8, localAddress, i9);
        Intrinsics.e(createSocket, "delegate.createSocket(ad… localAddress, localPort)");
        return a(createSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        Socket createSocket = this.f36330a.createSocket();
        Intrinsics.e(createSocket, "delegate.createSocket()");
        return a(createSocket);
    }
}
