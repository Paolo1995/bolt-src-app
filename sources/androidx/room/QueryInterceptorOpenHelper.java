package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* renamed from: f  reason: collision with root package name */
    private final SupportSQLiteOpenHelper f7525f;

    /* renamed from: g  reason: collision with root package name */
    private final RoomDatabase.QueryCallback f7526g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f7527h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor executor) {
        this.f7525f = supportSQLiteOpenHelper;
        this.f7526g = queryCallback;
        this.f7527h = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase E0() {
        return new QueryInterceptorDatabase(this.f7525f.E0(), this.f7526g, this.f7527h);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase H0() {
        return new QueryInterceptorDatabase(this.f7525f.H0(), this.f7526g, this.f7527h);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7525f.close();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper e() {
        return this.f7525f;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f7525f.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z7) {
        this.f7525f.setWriteAheadLoggingEnabled(z7);
    }
}
