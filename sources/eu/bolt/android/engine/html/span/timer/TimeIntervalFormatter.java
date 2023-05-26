package eu.bolt.android.engine.html.span.timer;

import android.util.Log;
import eu.bolt.android.engine.html.util.Decoder;
import eu.bolt.android.engine.html.util.Token;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TimeIntervalFormatter.kt */
/* loaded from: classes5.dex */
public final class TimeIntervalFormatter {

    /* renamed from: c  reason: collision with root package name */
    private static final Companion f36902c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final List<Token> f36903a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f36904b;

    /* compiled from: TimeIntervalFormatter.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TimeIntervalFormatter(String format) {
        Object next;
        Intrinsics.f(format, "format");
        List<Token> b8 = new Decoder(format).b();
        this.f36903a = b8;
        Iterator<T> it = b8.iterator();
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                int a8 = ((Token) next).a();
                do {
                    Object next2 = it.next();
                    int a9 = ((Token) next2).a();
                    if (a8 < a9) {
                        next = next2;
                        a8 = a9;
                    }
                } while (it.hasNext());
            }
        }
        Token token = (Token) next;
        this.f36904b = token != null ? Integer.valueOf(token.a()) : null;
    }

    private final String a(long j8, String str) {
        return f(TimeUnit.MILLISECONDS.toDays(j8), str.length());
    }

    private final String b(long j8, String str, boolean z7) {
        long hours;
        if (z7) {
            hours = TimeUnit.MILLISECONDS.toHours(j8);
        } else {
            hours = TimeUnit.MILLISECONDS.toHours(j8) % 24;
        }
        return f(hours, str.length());
    }

    private final String c(long j8, String str, boolean z7) {
        long minutes;
        if (z7) {
            minutes = TimeUnit.MILLISECONDS.toMinutes(j8);
        } else {
            minutes = TimeUnit.MILLISECONDS.toMinutes(j8) % 60;
        }
        return f(minutes, str.length());
    }

    private final String d(long j8, String str, boolean z7) {
        long seconds;
        if (z7) {
            seconds = TimeUnit.MILLISECONDS.toSeconds(j8);
        } else {
            seconds = TimeUnit.MILLISECONDS.toSeconds(j8) % 60;
        }
        return f(seconds, str.length());
    }

    private final String f(long j8, int i8) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        Locale locale = Locale.getDefault();
        String format = String.format(locale, "%0" + i8 + "d", Arrays.copyOf(new Object[]{Long.valueOf(j8)}, 1));
        Intrinsics.e(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public final String e(long j8) {
        boolean z7;
        String str;
        StringBuilder sb = new StringBuilder();
        for (Token token : this.f36903a) {
            Integer num = this.f36904b;
            int a8 = token.a();
            if (num != null && num.intValue() == a8) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (token instanceof Token.Text) {
                str = ((Token.Text) token).b();
            } else if (token instanceof Token.Seconds) {
                str = d(j8, ((Token.Seconds) token).b(), z7);
            } else if (token instanceof Token.Minutes) {
                str = c(j8, ((Token.Minutes) token).b(), z7);
            } else if (token instanceof Token.Hours) {
                str = b(j8, ((Token.Hours) token).b(), z7);
            } else if (token instanceof Token.Days) {
                str = a(j8, ((Token.Days) token).b());
            } else if (token instanceof Token.HoursMarker) {
                Log.d("Design Html Engine", "timer doesn't support Hours marker");
                str = "";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            sb.append(str);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "result.toString()");
        return sb2;
    }
}
