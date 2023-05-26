package eu.bolt.android.engine.html.span.time;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.LruCache;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeValueFormatter.kt */
/* loaded from: classes5.dex */
public final class TimeValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeValueFormatter f36896a = new TimeValueFormatter();

    /* renamed from: b  reason: collision with root package name */
    private static final TimeValueFormatter$formatterCache$1 f36897b = new LruCache<String, TimeFormatter>() { // from class: eu.bolt.android.engine.html.span.time.TimeValueFormatter$formatterCache$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public TimeFormatter create(String key) {
            Intrinsics.f(key, "key");
            return new TimeFormatter(key);
        }
    };

    private TimeValueFormatter() {
    }

    public final CharSequence a(TimeData data, Context context) {
        Intrinsics.f(data, "data");
        Intrinsics.f(context, "context");
        Locale locale = ConfigurationCompat.a(context.getResources().getConfiguration()).d(0);
        if (data.a() != null && !DateFormat.is24HourFormat(context)) {
            Intrinsics.e(locale, "locale");
            return f36897b.get(data.a()).a(locale, data.c());
        }
        Intrinsics.e(locale, "locale");
        return f36897b.get(data.b()).a(locale, data.c());
    }
}
