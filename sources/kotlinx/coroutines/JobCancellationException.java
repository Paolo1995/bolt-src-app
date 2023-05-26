package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
/* loaded from: classes5.dex */
public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {

    /* renamed from: f  reason: collision with root package name */
    public final transient Job f51298f;

    public JobCancellationException(String str, Throwable th, Job job) {
        super(str);
        this.f51298f = job;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* renamed from: b */
    public JobCancellationException a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!Intrinsics.a(jobCancellationException.getMessage(), getMessage()) || !Intrinsics.a(jobCancellationException.f51298f, this.f51298f) || !Intrinsics.a(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        int i8;
        String message = getMessage();
        Intrinsics.c(message);
        int hashCode = ((message.hashCode() * 31) + this.f51298f.hashCode()) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i8 = cause.hashCode();
        } else {
            i8 = 0;
        }
        return hashCode + i8;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f51298f;
    }
}
