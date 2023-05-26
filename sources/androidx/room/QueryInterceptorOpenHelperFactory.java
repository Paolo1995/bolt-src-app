package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Factory f7528a;

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase.QueryCallback f7529b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f7530c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorOpenHelperFactory(@NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor executor) {
        this.f7528a = factory;
        this.f7529b = queryCallback;
        this.f7530c = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NonNull
    public SupportSQLiteOpenHelper a(@NonNull SupportSQLiteOpenHelper.Configuration configuration) {
        return new QueryInterceptorOpenHelper(this.f7528a.a(configuration), this.f7529b, this.f7530c);
    }
}
