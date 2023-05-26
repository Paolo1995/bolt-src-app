package eu.bolt.verification.sdk.internal;

import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLException;

/* loaded from: classes5.dex */
public final class mc {

    /* renamed from: a  reason: collision with root package name */
    public static final mc f44173a = new mc();

    private mc() {
    }

    public final boolean a(Throwable th) {
        return InterruptedIOException.class.isInstance(th) || ProtocolException.class.isInstance(th) || SocketException.class.isInstance(th) || SSLException.class.isInstance(th) || UnknownHostException.class.isInstance(th) || UnknownServiceException.class.isInstance(th);
    }
}
