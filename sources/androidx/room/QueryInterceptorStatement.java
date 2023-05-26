package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {

    /* renamed from: f  reason: collision with root package name */
    private final SupportSQLiteStatement f7532f;

    /* renamed from: g  reason: collision with root package name */
    private final RoomDatabase.QueryCallback f7533g;

    /* renamed from: h  reason: collision with root package name */
    private final String f7534h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Object> f7535i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final Executor f7536j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorStatement(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RoomDatabase.QueryCallback queryCallback, String str, @NonNull Executor executor) {
        this.f7532f = supportSQLiteStatement;
        this.f7533g = queryCallback;
        this.f7534h = str;
        this.f7536j = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f7533g.a(this.f7534h, this.f7535i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f7533g.a(this.f7534h, this.f7535i);
    }

    private void h(int i8, Object obj) {
        int i9 = i8 - 1;
        if (i9 >= this.f7535i.size()) {
            for (int size = this.f7535i.size(); size <= i9; size++) {
                this.f7535i.add(null);
            }
        }
        this.f7535i.set(i9, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B0(int i8, long j8) {
        h(i8, Long.valueOf(j8));
        this.f7532f.B0(i8, j8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void F0(int i8, byte[] bArr) {
        h(i8, bArr);
        this.f7532f.F0(i8, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void Q0(int i8) {
        h(i8, this.f7535i.toArray());
        this.f7532f.Q0(i8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7532f.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long m0() {
        this.f7536j.execute(new Runnable() { // from class: androidx.room.w
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.e();
            }
        });
        return this.f7532f.m0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void q0(int i8, String str) {
        h(i8, str);
        this.f7532f.q0(i8, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int x() {
        this.f7536j.execute(new Runnable() { // from class: androidx.room.v
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.g();
            }
        });
        return this.f7532f.x();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void z(int i8, double d8) {
        h(i8, Double.valueOf(d8));
        this.f7532f.z(i8, d8);
    }
}
