package io.ktor.util.date;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GMTDateParser.kt */
/* loaded from: classes5.dex */
public final class GMTDateParser {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f47082b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f47083a;

    /* compiled from: GMTDateParser.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GMTDateParser(String pattern) {
        boolean z7;
        Intrinsics.f(pattern, "pattern");
        this.f47083a = pattern;
        if (pattern.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalStateException("Date parser pattern shouldn't be empty.".toString());
    }

    private final void a(GMTDateBuilder gMTDateBuilder, char c8, String str) {
        if (c8 == 's') {
            gMTDateBuilder.g(Integer.valueOf(Integer.parseInt(str)));
        } else if (c8 == 'm') {
            gMTDateBuilder.e(Integer.valueOf(Integer.parseInt(str)));
        } else if (c8 == 'h') {
            gMTDateBuilder.d(Integer.valueOf(Integer.parseInt(str)));
        } else if (c8 == 'd') {
            gMTDateBuilder.c(Integer.valueOf(Integer.parseInt(str)));
        } else if (c8 == 'M') {
            gMTDateBuilder.f(Month.f47084g.b(str));
        } else if (c8 == 'Y') {
            gMTDateBuilder.h(Integer.valueOf(Integer.parseInt(str)));
        } else if (c8 == 'z') {
            if (!Intrinsics.a(str, "GMT")) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else if (c8 != '*') {
            boolean z7 = false;
            int i8 = 0;
            while (true) {
                boolean z8 = true;
                if (i8 < str.length()) {
                    if (str.charAt(i8) != c8) {
                        z8 = false;
                    }
                    if (!z8) {
                        break;
                    }
                    i8++;
                } else {
                    z7 = true;
                    break;
                }
            }
            if (!z7) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    public final GMTDate b(String dateString) {
        Intrinsics.f(dateString, "dateString");
        GMTDateBuilder gMTDateBuilder = new GMTDateBuilder();
        char charAt = this.f47083a.charAt(0);
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i8 < this.f47083a.length()) {
            try {
                if (this.f47083a.charAt(i8) == charAt) {
                    i8++;
                } else {
                    int i11 = (i9 + i8) - i10;
                    String substring = dateString.substring(i9, i11);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    a(gMTDateBuilder, charAt, substring);
                    try {
                        charAt = this.f47083a.charAt(i8);
                        i10 = i8;
                        i8++;
                        i9 = i11;
                    } catch (Throwable unused) {
                        i9 = i11;
                        throw new InvalidDateStringException(dateString, i9, this.f47083a);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (i9 < dateString.length()) {
            String substring2 = dateString.substring(i9);
            Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
            a(gMTDateBuilder, charAt, substring2);
        }
        return gMTDateBuilder.a();
    }
}
