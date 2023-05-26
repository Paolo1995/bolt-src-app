package eu.bolt.android.engine.html.span.timer;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimerValueFormatter.kt */
/* loaded from: classes5.dex */
public final class TimerValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    public static final TimerValueFormatter f36914a = new TimerValueFormatter();

    /* renamed from: b  reason: collision with root package name */
    private static final TimerValueFormatter$formatterCache$1 f36915b = new LruCache<String, TimeIntervalFormatter>() { // from class: eu.bolt.android.engine.html.span.timer.TimerValueFormatter$formatterCache$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public TimeIntervalFormatter create(String key) {
            Intrinsics.f(key, "key");
            return new TimeIntervalFormatter(key);
        }
    };

    private TimerValueFormatter() {
    }

    public final CharSequence a(TimerData data) {
        Intrinsics.f(data, "data");
        long f8 = data.f(System.currentTimeMillis());
        if (f8 == 0 && data.a() != null) {
            return data.a();
        }
        if (f8 < 60000 && data.e() != null) {
            return f36915b.get(data.e()).e(f8);
        }
        if (f8 < 3600000 && data.d() != null) {
            return f36915b.get(data.d()).e(f8);
        }
        if (f8 < 86400000 && data.c() != null) {
            return f36915b.get(data.c()).e(f8);
        }
        return f36915b.get(data.b()).e(f8);
    }
}
