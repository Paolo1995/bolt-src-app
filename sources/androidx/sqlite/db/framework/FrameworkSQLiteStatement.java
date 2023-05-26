package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {

    /* renamed from: g  reason: collision with root package name */
    private final SQLiteStatement f7768g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f7768g = sQLiteStatement;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long m0() {
        return this.f7768g.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int x() {
        return this.f7768g.executeUpdateDelete();
    }
}
