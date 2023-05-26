package ee.mtakso.driver.service.analytics.timed.consumer.log;

import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.LogEntry;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogTrace.kt */
/* loaded from: classes3.dex */
public final class LogTrace {

    /* renamed from: a  reason: collision with root package name */
    private final String f23542a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f23543b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23544c;

    /* renamed from: d  reason: collision with root package name */
    private final List<TimeUnit> f23545d;

    public LogTrace(String key, Map<String, String> attrs) {
        List<TimeUnit> n8;
        Intrinsics.f(key, "key");
        Intrinsics.f(attrs, "attrs");
        this.f23542a = key;
        this.f23543b = attrs;
        this.f23544c = System.currentTimeMillis();
        n8 = CollectionsKt__CollectionsKt.n(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES, TimeUnit.SECONDS, TimeUnit.MILLISECONDS);
        this.f23545d = n8;
    }

    private final String c(long j8) {
        StringBuilder sb = new StringBuilder();
        for (TimeUnit timeUnit : this.f23545d) {
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            long convert = timeUnit.convert(j8, timeUnit2);
            if (convert > 0) {
                sb.append(convert);
                sb.append(' ');
                sb.append(timeUnit.name());
                j8 -= timeUnit2.convert(convert, timeUnit);
                if (timeUnit != timeUnit2 && j8 > 0) {
                    sb.append(' ');
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "builder.toString()");
        return sb2;
    }

    public final Map<String, String> a() {
        return this.f23543b;
    }

    public final void b() {
        LogEntry n8 = Kalev.j("TimedEvent").n("key", this.f23542a).n("duration", c(System.currentTimeMillis() - this.f23544c));
        for (Map.Entry<String, String> entry : this.f23543b.entrySet()) {
            n8.n(entry.getKey(), entry.getValue());
        }
        n8.a("Timed event");
    }
}
