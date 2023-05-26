package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* compiled from: FaultHidingSink.kt */
/* loaded from: classes5.dex */
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;
    private final Function1<IOException, Unit> onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(Sink delegate, Function1<? super IOException, Unit> onException) {
        super(delegate);
        Intrinsics.f(delegate, "delegate");
        Intrinsics.f(onException, "onException");
        this.onException = onException;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e8) {
            this.hasErrors = true;
            this.onException.invoke(e8);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e8) {
            this.hasErrors = true;
            this.onException.invoke(e8);
        }
    }

    public final Function1<IOException, Unit> getOnException() {
        return this.onException;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer source, long j8) {
        Intrinsics.f(source, "source");
        if (this.hasErrors) {
            source.skip(j8);
            return;
        }
        try {
            super.write(source, j8);
        } catch (IOException e8) {
            this.hasErrors = true;
            this.onException.invoke(e8);
        }
    }
}
