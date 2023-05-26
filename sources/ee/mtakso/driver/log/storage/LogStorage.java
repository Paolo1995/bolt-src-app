package ee.mtakso.driver.log.storage;

import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogStorage.kt */
/* loaded from: classes3.dex */
public final class LogStorage {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f21117a;

    @Inject
    public LogStorage(DatabaseManager databaseManager) {
        Intrinsics.f(databaseManager, "databaseManager");
        this.f21117a = databaseManager;
    }

    public final void a(List<ApplogSync> list) {
        Intrinsics.f(list, "list");
        this.f21117a.d().G().b(list);
    }

    public final void b(List<BigQuerySync> list) {
        Intrinsics.f(list, "list");
        this.f21117a.d().G().c(list);
    }

    public final List<LogEntity> c(String message) {
        Intrinsics.f(message, "message");
        return this.f21117a.d().G().f(message);
    }

    public final List<LogEntity> d(String message, long j8) {
        Intrinsics.f(message, "message");
        return this.f21117a.d().G().i(message, j8);
    }

    public final List<LogEntity> e(String message) {
        Intrinsics.f(message, "message");
        return this.f21117a.d().G().h(message);
    }

    public final List<LogEntity> f(String tag) {
        Intrinsics.f(tag, "tag");
        return this.f21117a.d().G().d(tag);
    }

    public final List<LogEntity> g(String tag, long j8, int i8) {
        Intrinsics.f(tag, "tag");
        return this.f21117a.d().G().g(tag, j8, i8);
    }

    public final List<LogEntity> h(String tag) {
        Intrinsics.f(tag, "tag");
        return this.f21117a.d().G().l(tag);
    }
}
