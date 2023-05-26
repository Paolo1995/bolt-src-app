package androidx.room;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {

    /* renamed from: f  reason: collision with root package name */
    private final SupportSQLiteDatabase f7522f;

    /* renamed from: g  reason: collision with root package name */
    private final RoomDatabase.QueryCallback f7523g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f7524h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorDatabase(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor executor) {
        this.f7522f = supportSQLiteDatabase;
        this.f7523g = queryCallback;
        this.f7524h = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(String str, List list) {
        this.f7523g.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str) {
        this.f7523g.a(str, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f7523g.a(supportSQLiteQuery.a(), queryInterceptorProgram.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f7523g.a(supportSQLiteQuery.a(), queryInterceptorProgram.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        this.f7523g.a("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.f7523g.a("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f7523g.a("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        this.f7523g.a("END TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str) {
        this.f7523g.a(str, new ArrayList(0));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor C(@NonNull final SupportSQLiteQuery supportSQLiteQuery, @NonNull CancellationSignal cancellationSignal) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.c(queryInterceptorProgram);
        this.f7524h.execute(new Runnable() { // from class: androidx.room.m
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.O(supportSQLiteQuery, queryInterceptorProgram);
            }
        });
        return this.f7522f.a0(supportSQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor J0(@NonNull final String str) {
        this.f7524h.execute(new Runnable() { // from class: androidx.room.q
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.I(str);
            }
        });
        return this.f7522f.J0(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void K() {
        this.f7524h.execute(new Runnable() { // from class: androidx.room.n
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.X();
            }
        });
        this.f7522f.K();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void L(@NonNull final String str, @NonNull Object[] objArr) throws SQLException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.f7524h.execute(new Runnable() { // from class: androidx.room.s
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.F(str, arrayList);
            }
        });
        this.f7522f.L(str, arrayList.toArray());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void M() {
        this.f7524h.execute(new Runnable() { // from class: androidx.room.u
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.t();
            }
        });
        this.f7522f.M();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void S() {
        this.f7524h.execute(new Runnable() { // from class: androidx.room.r
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.w();
            }
        });
        this.f7522f.S();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean T0() {
        return this.f7522f.T0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor a0(@NonNull final SupportSQLiteQuery supportSQLiteQuery) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.c(queryInterceptorProgram);
        this.f7524h.execute(new Runnable() { // from class: androidx.room.o
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.N(supportSQLiteQuery, queryInterceptorProgram);
            }
        });
        return this.f7522f.a0(supportSQLiteQuery);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7522f.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean d1() {
        return this.f7522f.d1();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public String getPath() {
        return this.f7522f.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.f7522f.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void n() {
        this.f7524h.execute(new Runnable() { // from class: androidx.room.p
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.q();
            }
        });
        this.f7522f.n();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void p0(int i8) {
        this.f7522f.p0(i8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public List<Pair<String, String>> r() {
        return this.f7522f.r();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public SupportSQLiteStatement r0(@NonNull String str) {
        return new QueryInterceptorStatement(this.f7522f.r0(str), this.f7523g, str, this.f7524h);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void u(@NonNull final String str) throws SQLException {
        this.f7524h.execute(new Runnable() { // from class: androidx.room.t
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.y(str);
            }
        });
        this.f7522f.u(str);
    }
}
