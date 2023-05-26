package eu.bolt.chat.tools.network;

import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUtils.kt */
/* loaded from: classes5.dex */
public final class NetworkUtilsKt {
    public static final boolean a(Throwable th) {
        Intrinsics.f(th, "<this>");
        if (!(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SocketException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
            return false;
        }
        return true;
    }
}
