package eu.bolt.verification.sdk.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class p8 {

    /* renamed from: a  reason: collision with root package name */
    private final String f44512a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, em> f44513b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f44514c;

    /* JADX WARN: Multi-variable type inference failed */
    public p8(String flowRunUUID, Map<String, ? extends em> map, boolean z7) {
        Intrinsics.f(flowRunUUID, "flowRunUUID");
        this.f44512a = flowRunUUID;
        this.f44513b = map;
        this.f44514c = z7;
    }

    public final String a() {
        return this.f44512a;
    }

    public final Map<String, em> b() {
        return this.f44513b;
    }

    public final boolean c() {
        return this.f44514c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p8) {
            p8 p8Var = (p8) obj;
            return Intrinsics.a(this.f44512a, p8Var.f44512a) && Intrinsics.a(this.f44513b, p8Var.f44513b) && this.f44514c == p8Var.f44514c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f44512a.hashCode() * 31;
        Map<String, em> map = this.f44513b;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        boolean z7 = this.f44514c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode2 + i8;
    }

    public String toString() {
        String str = this.f44512a;
        Map<String, em> map = this.f44513b;
        boolean z7 = this.f44514c;
        return "GetFlowDetailsData(flowRunUUID=" + str + ", userInput=" + map + ", isFirstRequest=" + z7 + ")";
    }
}
