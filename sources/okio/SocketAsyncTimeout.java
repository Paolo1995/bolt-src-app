package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes5.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {

    /* renamed from: a  reason: collision with root package name */
    private final Socket f52645a;

    public SocketAsyncTimeout(Socket socket) {
        Intrinsics.f(socket, "socket");
        this.f52645a = socket;
    }

    @Override // okio.AsyncTimeout
    protected IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.f52645a.close();
        } catch (AssertionError e8) {
            if (Okio.e(e8)) {
                logger2 = Okio__JvmOkioKt.f52611a;
                logger2.log(Level.WARNING, Intrinsics.n("Failed to close timed out socket ", this.f52645a), (Throwable) e8);
                return;
            }
            throw e8;
        } catch (Exception e9) {
            logger = Okio__JvmOkioKt.f52611a;
            logger.log(Level.WARNING, Intrinsics.n("Failed to close timed out socket ", this.f52645a), (Throwable) e9);
        }
    }
}
