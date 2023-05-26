package eu.bolt.verification.sdk.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class tb {

    /* renamed from: a  reason: collision with root package name */
    public static final tb f45154a = new tb();

    /* loaded from: classes5.dex */
    public enum a {
        YMD("ymd"),
        DMY("dmy"),
        MDY("mdy");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f45159f;

        a(String str) {
            this.f45159f = str;
        }

        public final String c() {
            return this.f45159f;
        }
    }

    private tb() {
    }

    public static /* synthetic */ a a(tb tbVar, Locale locale, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.e(locale, "getDefault()");
        }
        return tbVar.b(locale);
    }

    private final String c(Locale locale) {
        Set d8;
        try {
            DateFormat dateInstance = DateFormat.getDateInstance(3, locale);
            Intrinsics.d(dateInstance, "null cannot be cast to non-null type java.text.SimpleDateFormat");
            String pattern = ((SimpleDateFormat) dateInstance).toPattern();
            d8 = SetsKt__SetsKt.d('d', 'm', 'y');
            Intrinsics.e(pattern, "pattern");
            String lowerCase = pattern.toLowerCase(Locale.ROOT);
            Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            StringBuilder sb = new StringBuilder();
            int length = lowerCase.length();
            for (int i8 = 0; i8 < length; i8++) {
                char charAt = lowerCase.charAt(i8);
                if (d8.remove(Character.valueOf(charAt))) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "filterTo(StringBuilder(), predicate).toString()");
            return sb2;
        } catch (Exception unused) {
            return null;
        }
    }

    public final a b(Locale locale) {
        a[] values;
        Intrinsics.f(locale, "locale");
        String c8 = c(locale);
        for (a aVar : a.values()) {
            if (Intrinsics.a(aVar.c(), c8)) {
                return aVar;
            }
        }
        return null;
    }
}
