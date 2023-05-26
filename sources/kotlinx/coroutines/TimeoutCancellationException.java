package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* compiled from: Timeout.kt */
/* loaded from: classes5.dex */
public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable<TimeoutCancellationException> {

    /* renamed from: f  reason: collision with root package name */
    public final transient Job f51338f;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.f51338f = job;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* renamed from: b */
    public TimeoutCancellationException a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.f51338f);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
