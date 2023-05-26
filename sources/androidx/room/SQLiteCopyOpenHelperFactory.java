package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final String f7622a;

    /* renamed from: b  reason: collision with root package name */
    private final File f7623b;

    /* renamed from: c  reason: collision with root package name */
    private final Callable<InputStream> f7624c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Factory f7625d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCopyOpenHelperFactory(String str, File file, Callable<InputStream> callable, @NonNull SupportSQLiteOpenHelper.Factory factory) {
        this.f7622a = str;
        this.f7623b = file;
        this.f7624c = callable;
        this.f7625d = factory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NonNull
    public SupportSQLiteOpenHelper a(SupportSQLiteOpenHelper.Configuration configuration) {
        return new SQLiteCopyOpenHelper(configuration.f7740a, this.f7622a, this.f7623b, this.f7624c, configuration.f7742c.f7739a, this.f7625d.a(configuration));
    }
}
