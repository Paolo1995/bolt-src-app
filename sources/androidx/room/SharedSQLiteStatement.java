package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f7626a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f7627b;

    /* renamed from: c  reason: collision with root package name */
    private volatile SupportSQLiteStatement f7628c;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.f7627b = roomDatabase;
    }

    private SupportSQLiteStatement c() {
        return this.f7627b.f(d());
    }

    private SupportSQLiteStatement e(boolean z7) {
        if (z7) {
            if (this.f7628c == null) {
                this.f7628c = c();
            }
            return this.f7628c;
        }
        return c();
    }

    public SupportSQLiteStatement a() {
        b();
        return e(this.f7626a.compareAndSet(false, true));
    }

    protected void b() {
        this.f7627b.c();
    }

    protected abstract String d();

    public void f(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.f7628c) {
            this.f7626a.set(false);
        }
    }
}
