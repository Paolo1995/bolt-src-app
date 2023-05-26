package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Factory f7433a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final AutoCloser f7434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoClosingRoomOpenHelperFactory(@NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull AutoCloser autoCloser) {
        this.f7433a = factory;
        this.f7434b = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NonNull
    /* renamed from: b */
    public AutoClosingRoomOpenHelper a(@NonNull SupportSQLiteOpenHelper.Configuration configuration) {
        return new AutoClosingRoomOpenHelper(this.f7433a.a(configuration), this.f7434b);
    }
}
