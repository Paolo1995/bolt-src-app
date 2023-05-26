package io.ktor.http;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes5.dex */
public final class HeaderValue {

    /* renamed from: a  reason: collision with root package name */
    private final String f46767a;

    /* renamed from: b  reason: collision with root package name */
    private final List<HeaderValueParam> f46768b;

    /* renamed from: c  reason: collision with root package name */
    private final double f46769c;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        r9 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.k(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HeaderValue(java.lang.String r9, java.util.List<io.ktor.http.HeaderValueParam> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            r8.<init>()
            r8.f46767a = r9
            r8.f46768b = r10
            java.util.Iterator r9 = r10.iterator()
        L15:
            boolean r10 = r9.hasNext()
            r0 = 0
            if (r10 == 0) goto L30
            java.lang.Object r10 = r9.next()
            r1 = r10
            io.ktor.http.HeaderValueParam r1 = (io.ktor.http.HeaderValueParam) r1
            java.lang.String r1 = r1.c()
            java.lang.String r2 = "q"
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r2)
            if (r1 == 0) goto L15
            goto L31
        L30:
            r10 = r0
        L31:
            io.ktor.http.HeaderValueParam r10 = (io.ktor.http.HeaderValueParam) r10
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r10 == 0) goto L5c
            java.lang.String r9 = r10.d()
            if (r9 == 0) goto L5c
            java.lang.Double r9 = kotlin.text.StringsKt.k(r9)
            if (r9 == 0) goto L5c
            double r3 = r9.doubleValue()
            r5 = 0
            r10 = 0
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 > 0) goto L53
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L53
            r10 = 1
        L53:
            if (r10 == 0) goto L56
            r0 = r9
        L56:
            if (r0 == 0) goto L5c
            double r1 = r0.doubleValue()
        L5c:
            r8.f46769c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HeaderValue.<init>(java.lang.String, java.util.List):void");
    }

    public final String a() {
        return this.f46767a;
    }

    public final List<HeaderValueParam> b() {
        return this.f46768b;
    }

    public final double c() {
        return this.f46769c;
    }

    public final String d() {
        return this.f46767a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeaderValue) {
            HeaderValue headerValue = (HeaderValue) obj;
            return Intrinsics.a(this.f46767a, headerValue.f46767a) && Intrinsics.a(this.f46768b, headerValue.f46768b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f46767a.hashCode() * 31) + this.f46768b.hashCode();
    }

    public String toString() {
        return "HeaderValue(value=" + this.f46767a + ", params=" + this.f46768b + ')';
    }

    public /* synthetic */ HeaderValue(String str, List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
