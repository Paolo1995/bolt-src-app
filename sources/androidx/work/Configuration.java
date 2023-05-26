package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.impl.DefaultRunnableScheduler;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class Configuration {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Executor f8214a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final Executor f8215b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final WorkerFactory f8216c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final InputMergerFactory f8217d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final RunnableScheduler f8218e;

    /* renamed from: f  reason: collision with root package name */
    final InitializationExceptionHandler f8219f;

    /* renamed from: g  reason: collision with root package name */
    final String f8220g;

    /* renamed from: h  reason: collision with root package name */
    final int f8221h;

    /* renamed from: i  reason: collision with root package name */
    final int f8222i;

    /* renamed from: j  reason: collision with root package name */
    final int f8223j;

    /* renamed from: k  reason: collision with root package name */
    final int f8224k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f8225l;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        Executor f8226a;

        /* renamed from: b  reason: collision with root package name */
        WorkerFactory f8227b;

        /* renamed from: c  reason: collision with root package name */
        InputMergerFactory f8228c;

        /* renamed from: d  reason: collision with root package name */
        Executor f8229d;

        /* renamed from: e  reason: collision with root package name */
        RunnableScheduler f8230e;

        /* renamed from: f  reason: collision with root package name */
        InitializationExceptionHandler f8231f;

        /* renamed from: g  reason: collision with root package name */
        String f8232g;

        /* renamed from: h  reason: collision with root package name */
        int f8233h = 4;

        /* renamed from: i  reason: collision with root package name */
        int f8234i = 0;

        /* renamed from: j  reason: collision with root package name */
        int f8235j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: k  reason: collision with root package name */
        int f8236k = 20;

        @NonNull
        public Configuration a() {
            return new Configuration(this);
        }

        @NonNull
        public Builder b(int i8) {
            this.f8233h = i8;
            return this;
        }

        @NonNull
        public Builder c(@NonNull WorkerFactory workerFactory) {
            this.f8227b = workerFactory;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        Configuration a();
    }

    Configuration(@NonNull Builder builder) {
        Executor executor = builder.f8226a;
        if (executor == null) {
            this.f8214a = a();
        } else {
            this.f8214a = executor;
        }
        Executor executor2 = builder.f8229d;
        if (executor2 == null) {
            this.f8225l = true;
            this.f8215b = a();
        } else {
            this.f8225l = false;
            this.f8215b = executor2;
        }
        WorkerFactory workerFactory = builder.f8227b;
        if (workerFactory == null) {
            this.f8216c = WorkerFactory.c();
        } else {
            this.f8216c = workerFactory;
        }
        InputMergerFactory inputMergerFactory = builder.f8228c;
        if (inputMergerFactory == null) {
            this.f8217d = InputMergerFactory.c();
        } else {
            this.f8217d = inputMergerFactory;
        }
        RunnableScheduler runnableScheduler = builder.f8230e;
        if (runnableScheduler == null) {
            this.f8218e = new DefaultRunnableScheduler();
        } else {
            this.f8218e = runnableScheduler;
        }
        this.f8221h = builder.f8233h;
        this.f8222i = builder.f8234i;
        this.f8223j = builder.f8235j;
        this.f8224k = builder.f8236k;
        this.f8219f = builder.f8231f;
        this.f8220g = builder.f8232g;
    }

    @NonNull
    private Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }

    public String b() {
        return this.f8220g;
    }

    public InitializationExceptionHandler c() {
        return this.f8219f;
    }

    @NonNull
    public Executor d() {
        return this.f8214a;
    }

    @NonNull
    public InputMergerFactory e() {
        return this.f8217d;
    }

    public int f() {
        return this.f8223j;
    }

    public int g() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f8224k / 2;
        }
        return this.f8224k;
    }

    public int h() {
        return this.f8222i;
    }

    public int i() {
        return this.f8221h;
    }

    @NonNull
    public RunnableScheduler j() {
        return this.f8218e;
    }

    @NonNull
    public Executor k() {
        return this.f8215b;
    }

    @NonNull
    public WorkerFactory l() {
        return this.f8216c;
    }
}
