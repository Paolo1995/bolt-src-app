package ee.mtakso.driver.platform.push;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Push.kt */
/* loaded from: classes3.dex */
public final class Push {

    /* renamed from: a  reason: collision with root package name */
    private final String f23343a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23344b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f23345c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f23346d;

    public Push(String str, String str2, Map<String, String> data, Object obj) {
        Intrinsics.f(data, "data");
        this.f23343a = str;
        this.f23344b = str2;
        this.f23345c = data;
        this.f23346d = obj;
    }

    public final String a() {
        return this.f23344b;
    }

    public final Map<String, String> b() {
        return this.f23345c;
    }

    public final String c() {
        return this.f23343a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Push) {
            Push push = (Push) obj;
            return Intrinsics.a(this.f23343a, push.f23343a) && Intrinsics.a(this.f23344b, push.f23344b) && Intrinsics.a(this.f23345c, push.f23345c) && Intrinsics.a(this.f23346d, push.f23346d);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f23343a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f23344b;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f23345c.hashCode()) * 31;
        Object obj = this.f23346d;
        return hashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        String str = this.f23343a;
        String str2 = this.f23344b;
        Map<String, String> map = this.f23345c;
        Object obj = this.f23346d;
        return "Push(title=" + str + ", body=" + str2 + ", data=" + map + ", origin=" + obj + ")";
    }
}
