package ee.mtakso.driver.log.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DatabaseManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DatabaseManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21089a;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: b  reason: collision with root package name */
    private final SimpleDateFormat f21090b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21091c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, LogsDatabase> f21092d;

    @Inject
    public DatabaseManager(Context context) {
        Intrinsics.f(context, "context");
        this.f21089a = context;
        this.f21090b = new SimpleDateFormat("yyyy-MM-dd");
        this.f21091c = "ee.mtakso.driver.logs-";
        this.f21092d = new LinkedHashMap();
    }

    private final LogsDatabase b(String str) {
        RoomDatabase d8 = Room.a(this.f21089a, LogsDatabase.class, str).d();
        Intrinsics.e(d8, "databaseBuilder(context,…:class.java, key).build()");
        return (LogsDatabase) d8;
    }

    private final String c(Long l8) {
        Date date;
        if (l8 != null) {
            date = new Date(l8.longValue());
        } else {
            date = new Date();
        }
        String str = this.f21091c;
        String format = this.f21090b.format(date);
        return str + format;
    }

    private final boolean e(String str, String str2) {
        boolean Q;
        Q = StringsKt__StringsKt.Q(str, this.f21091c, false, 2, null);
        if (!Q || str.compareTo(str2) >= 0) {
            return false;
        }
        return true;
    }

    public final void a() {
        String c8 = c(Long.valueOf(new Date().getTime() - 86400000));
        String[] dbs = this.f21089a.databaseList();
        Intrinsics.e(dbs, "dbs");
        for (String it : dbs) {
            Intrinsics.e(it, "it");
            if (e(it, c8)) {
                this.f21089a.deleteDatabase(it);
            }
        }
    }

    public final LogsDatabase d() {
        String c8 = c(null);
        Map<String, LogsDatabase> map = this.f21092d;
        LogsDatabase logsDatabase = map.get(c8);
        if (logsDatabase == null) {
            logsDatabase = b(c8);
            map.put(c8, logsDatabase);
        }
        return logsDatabase;
    }
}
