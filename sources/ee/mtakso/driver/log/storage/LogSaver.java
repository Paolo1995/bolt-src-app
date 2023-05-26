package ee.mtakso.driver.log.storage;

import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.strategy.CompositeWatcher;
import eu.bolt.kalev.LogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LogSaver.kt */
/* loaded from: classes3.dex */
public final class LogSaver {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f21111a;

    /* renamed from: b  reason: collision with root package name */
    private final InternalLog f21112b;

    /* renamed from: c  reason: collision with root package name */
    private final CompositeWatcher f21113c;

    @Inject
    public LogSaver(DatabaseManager databaseManager, InternalLog internalLog, CompositeWatcher insertWatcher) {
        Intrinsics.f(databaseManager, "databaseManager");
        Intrinsics.f(internalLog, "internalLog");
        Intrinsics.f(insertWatcher, "insertWatcher");
        this.f21111a = databaseManager;
        this.f21112b = internalLog;
        this.f21113c = insertWatcher;
    }

    private final String b(LogEntry logEntry) {
        JSONObject jSONObject = new JSONObject();
        Iterator<T> it = logEntry.c().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.e(jSONObject2, "oobj.toString()");
        return jSONObject2;
    }

    private final LogEntity c(LogEntry logEntry) {
        String f8 = logEntry.f();
        String d8 = logEntry.d();
        Long h8 = logEntry.h();
        if (h8 != null) {
            return new LogEntity(0L, f8, d8, logEntry.e(), h8.longValue(), b(logEntry), 1, null);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void a(List<? extends LogEntry> logs) {
        int v7;
        Intrinsics.f(logs, "logs");
        InternalLog internalLog = this.f21112b;
        int size = logs.size();
        internalLog.b("Saving logs to storage. " + size + " ");
        LogDao G = this.f21111a.d().G();
        v7 = CollectionsKt__IterablesKt.v(logs, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LogEntry logEntry : logs) {
            arrayList.add(c(logEntry));
        }
        G.a(arrayList);
        for (LogEntry logEntry2 : logs) {
            this.f21113c.a(logEntry2);
        }
    }
}
