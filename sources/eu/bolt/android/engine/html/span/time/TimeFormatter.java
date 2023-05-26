package eu.bolt.android.engine.html.span.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeFormatter.kt */
/* loaded from: classes5.dex */
public final class TimeFormatter {

    /* renamed from: a  reason: collision with root package name */
    private final String f36895a;

    public TimeFormatter(String format) {
        Intrinsics.f(format, "format");
        this.f36895a = format;
    }

    public final String a(Locale locale, long j8) {
        Intrinsics.f(locale, "locale");
        String format = new SimpleDateFormat(this.f36895a, locale).format(new Date(j8));
        Intrinsics.e(format, "formatter.format(date)");
        return format;
    }
}
