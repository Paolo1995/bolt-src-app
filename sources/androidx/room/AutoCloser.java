package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class AutoCloser {

    /* renamed from: e  reason: collision with root package name */
    final long f7414e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final Executor f7415f;

    /* renamed from: i  reason: collision with root package name */
    SupportSQLiteDatabase f7418i;

    /* renamed from: a  reason: collision with root package name */
    private SupportSQLiteOpenHelper f7410a = null;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f7411b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    Runnable f7412c = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final Object f7413d = new Object();

    /* renamed from: g  reason: collision with root package name */
    int f7416g = 0;

    /* renamed from: h  reason: collision with root package name */
    long f7417h = SystemClock.uptimeMillis();

    /* renamed from: j  reason: collision with root package name */
    private boolean f7419j = false;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f7420k = new Runnable() { // from class: androidx.room.AutoCloser.1
        @Override // java.lang.Runnable
        public void run() {
            AutoCloser autoCloser = AutoCloser.this;
            autoCloser.f7415f.execute(autoCloser.f7421l);
        }
    };
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    final Runnable f7421l = new Runnable() { // from class: androidx.room.AutoCloser.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (AutoCloser.this.f7413d) {
                long uptimeMillis = SystemClock.uptimeMillis();
                AutoCloser autoCloser = AutoCloser.this;
                if (uptimeMillis - autoCloser.f7417h < autoCloser.f7414e) {
                    return;
                }
                if (autoCloser.f7416g != 0) {
                    return;
                }
                Runnable runnable = autoCloser.f7412c;
                if (runnable != null) {
                    runnable.run();
                    SupportSQLiteDatabase supportSQLiteDatabase = AutoCloser.this.f7418i;
                    if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                        try {
                            AutoCloser.this.f7418i.close();
                        } catch (IOException e8) {
                            SneakyThrow.a(e8);
                        }
                        AutoCloser.this.f7418i = null;
                    }
                    return;
                }
                throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoCloser(long j8, @NonNull TimeUnit timeUnit, @NonNull Executor executor) {
        this.f7414e = timeUnit.toMillis(j8);
        this.f7415f = executor;
    }

    public void a() throws IOException {
        synchronized (this.f7413d) {
            this.f7419j = true;
            SupportSQLiteDatabase supportSQLiteDatabase = this.f7418i;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            this.f7418i = null;
        }
    }

    public void b() {
        synchronized (this.f7413d) {
            int i8 = this.f7416g;
            if (i8 > 0) {
                int i9 = i8 - 1;
                this.f7416g = i9;
                if (i9 == 0) {
                    if (this.f7418i == null) {
                        return;
                    }
                    this.f7411b.postDelayed(this.f7420k, this.f7414e);
                }
                return;
            }
            throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
        }
    }

    public <V> V c(@NonNull Function<SupportSQLiteDatabase, V> function) {
        try {
            return function.apply(e());
        } finally {
            b();
        }
    }

    public SupportSQLiteDatabase d() {
        SupportSQLiteDatabase supportSQLiteDatabase;
        synchronized (this.f7413d) {
            supportSQLiteDatabase = this.f7418i;
        }
        return supportSQLiteDatabase;
    }

    @NonNull
    public SupportSQLiteDatabase e() {
        synchronized (this.f7413d) {
            this.f7411b.removeCallbacks(this.f7420k);
            this.f7416g++;
            if (!this.f7419j) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.f7418i;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    return this.f7418i;
                }
                SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.f7410a;
                if (supportSQLiteOpenHelper != null) {
                    SupportSQLiteDatabase H0 = supportSQLiteOpenHelper.H0();
                    this.f7418i = H0;
                    return H0;
                }
                throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public void f(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (this.f7410a != null) {
            Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        } else {
            this.f7410a = supportSQLiteOpenHelper;
        }
    }

    public boolean g() {
        return !this.f7419j;
    }

    public void h(Runnable runnable) {
        this.f7412c = runnable;
    }
}
