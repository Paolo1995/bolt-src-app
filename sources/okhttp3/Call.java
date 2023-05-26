package okhttp3;

import java.io.IOException;
import okio.Timeout;

/* compiled from: Call.kt */
/* loaded from: classes5.dex */
public interface Call extends Cloneable {

    /* compiled from: Call.kt */
    /* loaded from: classes5.dex */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
