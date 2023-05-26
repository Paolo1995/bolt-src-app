package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class Okio__JvmOkioKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f52611a = Logger.getLogger("okio.Okio");

    public static final Sink b(File file) throws FileNotFoundException {
        Intrinsics.f(file, "<this>");
        return Okio.g(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        boolean Q;
        Intrinsics.f(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        if (message == null) {
            Q = false;
        } else {
            Q = StringsKt__StringsKt.Q(message, "getsockname failed", false, 2, null);
        }
        if (!Q) {
            return false;
        }
        return true;
    }

    public static final Sink d(File file, boolean z7) throws FileNotFoundException {
        Intrinsics.f(file, "<this>");
        return Okio.g(new FileOutputStream(file, z7));
    }

    public static final Sink e(OutputStream outputStream) {
        Intrinsics.f(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Sink f(Socket socket) throws IOException {
        Intrinsics.f(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.e(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static /* synthetic */ Sink g(File file, boolean z7, int i8, Object obj) throws FileNotFoundException {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return Okio.f(file, z7);
    }

    public static final Source h(File file) throws FileNotFoundException {
        Intrinsics.f(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    public static final Source i(InputStream inputStream) {
        Intrinsics.f(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Source j(Socket socket) throws IOException {
        Intrinsics.f(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.e(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }
}
