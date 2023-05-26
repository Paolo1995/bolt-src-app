package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class ListenableWorker {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private Context f8283f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private WorkerParameters f8284g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f8285h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8286i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8287j;

    /* loaded from: classes.dex */
    public static abstract class Result {

        /* loaded from: classes.dex */
        public static final class Failure extends Result {

            /* renamed from: a  reason: collision with root package name */
            private final Data f8288a;

            public Failure() {
                this(Data.f8268c);
            }

            @NonNull
            public Data e() {
                return this.f8288a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && Failure.class == obj.getClass()) {
                    return this.f8288a.equals(((Failure) obj).f8288a);
                }
                return false;
            }

            public int hashCode() {
                return (Failure.class.getName().hashCode() * 31) + this.f8288a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f8288a + '}';
            }

            public Failure(@NonNull Data data) {
                this.f8288a = data;
            }
        }

        /* loaded from: classes.dex */
        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && Retry.class == obj.getClass()) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return Retry.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        /* loaded from: classes.dex */
        public static final class Success extends Result {

            /* renamed from: a  reason: collision with root package name */
            private final Data f8289a;

            public Success() {
                this(Data.f8268c);
            }

            @NonNull
            public Data e() {
                return this.f8289a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && Success.class == obj.getClass()) {
                    return this.f8289a.equals(((Success) obj).f8289a);
                }
                return false;
            }

            public int hashCode() {
                return (Success.class.getName().hashCode() * 31) + this.f8289a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f8289a + '}';
            }

            public Success(@NonNull Data data) {
                this.f8289a = data;
            }
        }

        Result() {
        }

        @NonNull
        public static Result a() {
            return new Failure();
        }

        @NonNull
        public static Result b() {
            return new Retry();
        }

        @NonNull
        public static Result c() {
            return new Success();
        }

        @NonNull
        public static Result d(@NonNull Data data) {
            return new Success(data);
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        if (context != null) {
            if (workerParameters != null) {
                this.f8283f = context;
                this.f8284g = workerParameters;
                return;
            }
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        throw new IllegalArgumentException("Application Context is null");
    }

    @NonNull
    public final Context a() {
        return this.f8283f;
    }

    @NonNull
    public Executor c() {
        return this.f8284g.a();
    }

    @NonNull
    public ListenableFuture<ForegroundInfo> d() {
        SettableFuture t7 = SettableFuture.t();
        t7.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return t7;
    }

    @NonNull
    public final UUID f() {
        return this.f8284g.c();
    }

    @NonNull
    public final Data g() {
        return this.f8284g.d();
    }

    @NonNull
    public TaskExecutor h() {
        return this.f8284g.e();
    }

    @NonNull
    public WorkerFactory i() {
        return this.f8284g.f();
    }

    public boolean j() {
        return this.f8287j;
    }

    public final boolean k() {
        return this.f8285h;
    }

    public final boolean l() {
        return this.f8286i;
    }

    public void m() {
    }

    public void n(boolean z7) {
        this.f8287j = z7;
    }

    public final void o() {
        this.f8286i = true;
    }

    @NonNull
    public abstract ListenableFuture<Result> p();

    public final void q() {
        this.f8285h = true;
        m();
    }
}
