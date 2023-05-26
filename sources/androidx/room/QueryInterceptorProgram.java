package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {

    /* renamed from: f  reason: collision with root package name */
    private List<Object> f7531f = new ArrayList();

    private void c(int i8, Object obj) {
        int i9 = i8 - 1;
        if (i9 >= this.f7531f.size()) {
            for (int size = this.f7531f.size(); size <= i9; size++) {
                this.f7531f.add(null);
            }
        }
        this.f7531f.set(i9, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B0(int i8, long j8) {
        c(i8, Long.valueOf(j8));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void F0(int i8, byte[] bArr) {
        c(i8, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void Q0(int i8) {
        c(i8, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> a() {
        return this.f7531f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void q0(int i8, String str) {
        c(i8, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void z(int i8, double d8) {
        c(i8, Double.valueOf(d8));
    }
}
