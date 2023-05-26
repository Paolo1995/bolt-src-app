package io.ktor.http;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes5.dex */
public final class HeaderValueParam {

    /* renamed from: a  reason: collision with root package name */
    private final String f46770a;

    /* renamed from: b  reason: collision with root package name */
    private final String f46771b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f46772c;

    public HeaderValueParam(String name, String value, boolean z7) {
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        this.f46770a = name;
        this.f46771b = value;
        this.f46772c = z7;
    }

    public final String a() {
        return this.f46770a;
    }

    public final String b() {
        return this.f46771b;
    }

    public final String c() {
        return this.f46770a;
    }

    public final String d() {
        return this.f46771b;
    }

    public boolean equals(Object obj) {
        boolean w7;
        boolean w8;
        if (obj instanceof HeaderValueParam) {
            HeaderValueParam headerValueParam = (HeaderValueParam) obj;
            w7 = StringsKt__StringsJVMKt.w(headerValueParam.f46770a, this.f46770a, true);
            if (w7) {
                w8 = StringsKt__StringsJVMKt.w(headerValueParam.f46771b, this.f46771b, true);
                if (w8) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f46770a;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        String lowerCase2 = this.f46771b.toLowerCase(locale);
        Intrinsics.e(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return hashCode + (hashCode * 31) + lowerCase2.hashCode();
    }

    public String toString() {
        return "HeaderValueParam(name=" + this.f46770a + ", value=" + this.f46771b + ", escapeValue=" + this.f46772c + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeaderValueParam(String name, String value) {
        this(name, value, false);
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
    }
}
