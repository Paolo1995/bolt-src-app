package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* compiled from: PushObserver.kt */
/* loaded from: classes5.dex */
public interface PushObserver {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    /* compiled from: PushObserver.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: PushObserver.kt */
        /* loaded from: classes5.dex */
        private static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i8, BufferedSource source, int i9, boolean z7) throws IOException {
                Intrinsics.f(source, "source");
                source.skip(i9);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i8, List<Header> responseHeaders, boolean z7) {
                Intrinsics.f(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i8, List<Header> requestHeaders) {
                Intrinsics.f(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i8, ErrorCode errorCode) {
                Intrinsics.f(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i8, BufferedSource bufferedSource, int i9, boolean z7) throws IOException;

    boolean onHeaders(int i8, List<Header> list, boolean z7);

    boolean onRequest(int i8, List<Header> list);

    void onReset(int i8, ErrorCode errorCode);
}
