package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes5.dex */
public final class Okio {
    public static final Sink a(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.b(file);
    }

    public static final Sink b() {
        return Okio__OkioKt.a();
    }

    public static final BufferedSink c(Sink sink) {
        return Okio__OkioKt.b(sink);
    }

    public static final BufferedSource d(Source source) {
        return Okio__OkioKt.c(source);
    }

    public static final boolean e(AssertionError assertionError) {
        return Okio__JvmOkioKt.c(assertionError);
    }

    public static final Sink f(File file, boolean z7) throws FileNotFoundException {
        return Okio__JvmOkioKt.d(file, z7);
    }

    public static final Sink g(OutputStream outputStream) {
        return Okio__JvmOkioKt.e(outputStream);
    }

    public static final Sink h(Socket socket) throws IOException {
        return Okio__JvmOkioKt.f(socket);
    }

    public static final Source j(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.h(file);
    }

    public static final Source k(InputStream inputStream) {
        return Okio__JvmOkioKt.i(inputStream);
    }

    public static final Source l(Socket socket) throws IOException {
        return Okio__JvmOkioKt.j(socket);
    }
}
