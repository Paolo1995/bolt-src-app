package io.ktor.http;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HeaderValueWithParameters.kt */
/* loaded from: classes5.dex */
public abstract class HeaderValueWithParameters {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f46773c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f46774a;

    /* renamed from: b  reason: collision with root package name */
    private final List<HeaderValueParam> f46775b;

    /* compiled from: HeaderValueWithParameters.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HeaderValueWithParameters(String content, List<HeaderValueParam> parameters) {
        Intrinsics.f(content, "content");
        Intrinsics.f(parameters, "parameters");
        this.f46774a = content;
        this.f46775b = parameters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a() {
        return this.f46774a;
    }

    public final List<HeaderValueParam> b() {
        return this.f46775b;
    }

    public final String c(String name) {
        int m8;
        boolean w7;
        Intrinsics.f(name, "name");
        m8 = CollectionsKt__CollectionsKt.m(this.f46775b);
        if (m8 >= 0) {
            int i8 = 0;
            while (true) {
                HeaderValueParam headerValueParam = this.f46775b.get(i8);
                w7 = StringsKt__StringsJVMKt.w(headerValueParam.c(), name, true);
                if (w7) {
                    return headerValueParam.d();
                }
                if (i8 != m8) {
                    i8++;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    public String toString() {
        int m8;
        if (this.f46775b.isEmpty()) {
            return this.f46774a;
        }
        int length = this.f46774a.length();
        int i8 = 0;
        int i9 = 0;
        for (HeaderValueParam headerValueParam : this.f46775b) {
            i9 += headerValueParam.c().length() + headerValueParam.d().length() + 3;
        }
        StringBuilder sb = new StringBuilder(length + i9);
        sb.append(this.f46774a);
        m8 = CollectionsKt__CollectionsKt.m(this.f46775b);
        if (m8 >= 0) {
            while (true) {
                HeaderValueParam headerValueParam2 = this.f46775b.get(i8);
                sb.append("; ");
                sb.append(headerValueParam2.c());
                sb.append("=");
                String d8 = headerValueParam2.d();
                if (HeaderValueWithParametersKt.a(d8)) {
                    sb.append(HeaderValueWithParametersKt.d(d8));
                } else {
                    sb.append(d8);
                }
                if (i8 == m8) {
                    break;
                }
                i8++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "{\n            val size =…   }.toString()\n        }");
        return sb2;
    }
}
