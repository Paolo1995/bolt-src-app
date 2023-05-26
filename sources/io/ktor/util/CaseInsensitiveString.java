package io.ktor.util;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: Text.kt */
/* loaded from: classes5.dex */
public final class CaseInsensitiveString {

    /* renamed from: a  reason: collision with root package name */
    private final String f47034a;

    /* renamed from: b  reason: collision with root package name */
    private final int f47035b;

    public CaseInsensitiveString(String content) {
        Intrinsics.f(content, "content");
        this.f47034a = content;
        String lowerCase = content.toLowerCase(Locale.ROOT);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.f47035b = lowerCase.hashCode();
    }

    public final String a() {
        return this.f47034a;
    }

    public boolean equals(Object obj) {
        CaseInsensitiveString caseInsensitiveString;
        String str;
        boolean w7;
        if (obj instanceof CaseInsensitiveString) {
            caseInsensitiveString = (CaseInsensitiveString) obj;
        } else {
            caseInsensitiveString = null;
        }
        if (caseInsensitiveString == null || (str = caseInsensitiveString.f47034a) == null) {
            return false;
        }
        w7 = StringsKt__StringsJVMKt.w(str, this.f47034a, true);
        if (!w7) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f47035b;
    }

    public String toString() {
        return this.f47034a;
    }
}
