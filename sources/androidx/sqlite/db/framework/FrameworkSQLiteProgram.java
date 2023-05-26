package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* loaded from: classes.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {

    /* renamed from: f  reason: collision with root package name */
    private final SQLiteProgram f7767f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.f7767f = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B0(int i8, long j8) {
        this.f7767f.bindLong(i8, j8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void F0(int i8, byte[] bArr) {
        this.f7767f.bindBlob(i8, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void Q0(int i8) {
        this.f7767f.bindNull(i8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7767f.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void q0(int i8, String str) {
        this.f7767f.bindString(i8, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void z(int i8, double d8) {
        this.f7767f.bindDouble(i8, d8);
    }
}
