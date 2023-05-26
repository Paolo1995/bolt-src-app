package eu.bolt.verification.sdk.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class be extends ob {

    /* renamed from: f  reason: collision with root package name */
    private final String f42312f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42313g;

    /* renamed from: h  reason: collision with root package name */
    private final String f42314h;

    /* renamed from: i  reason: collision with root package name */
    private final fl f42315i;

    /* renamed from: j  reason: collision with root package name */
    private final List<cm> f42316j;

    /* renamed from: k  reason: collision with root package name */
    private final Integer f42317k;

    public be(String id, String textHtml, String str, fl textAlignment, List<cm> urlIntercepts, Integer num) {
        Intrinsics.f(id, "id");
        Intrinsics.f(textHtml, "textHtml");
        Intrinsics.f(textAlignment, "textAlignment");
        Intrinsics.f(urlIntercepts, "urlIntercepts");
        this.f42312f = id;
        this.f42313g = textHtml;
        this.f42314h = str;
        this.f42315i = textAlignment;
        this.f42316j = urlIntercepts;
        this.f42317k = num;
    }

    public static /* synthetic */ be b(be beVar, String str, String str2, String str3, fl flVar, List list, Integer num, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = beVar.a();
        }
        if ((i8 & 2) != 0) {
            str2 = beVar.f42313g;
        }
        String str4 = str2;
        if ((i8 & 4) != 0) {
            str3 = beVar.f42314h;
        }
        String str5 = str3;
        if ((i8 & 8) != 0) {
            flVar = beVar.f42315i;
        }
        fl flVar2 = flVar;
        List<cm> list2 = list;
        if ((i8 & 16) != 0) {
            list2 = beVar.f42316j;
        }
        List list3 = list2;
        if ((i8 & 32) != 0) {
            num = beVar.f42317k;
        }
        return beVar.c(str, str4, str5, flVar2, list3, num);
    }

    @Override // eu.bolt.verification.sdk.internal.ob
    public String a() {
        return this.f42312f;
    }

    public final be c(String id, String textHtml, String str, fl textAlignment, List<cm> urlIntercepts, Integer num) {
        Intrinsics.f(id, "id");
        Intrinsics.f(textHtml, "textHtml");
        Intrinsics.f(textAlignment, "textAlignment");
        Intrinsics.f(urlIntercepts, "urlIntercepts");
        return new be(id, textHtml, str, textAlignment, urlIntercepts, num);
    }

    public final Integer d() {
        return this.f42317k;
    }

    public final String e() {
        return this.f42314h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof be) {
            be beVar = (be) obj;
            return Intrinsics.a(a(), beVar.a()) && Intrinsics.a(this.f42313g, beVar.f42313g) && Intrinsics.a(this.f42314h, beVar.f42314h) && this.f42315i == beVar.f42315i && Intrinsics.a(this.f42316j, beVar.f42316j) && Intrinsics.a(this.f42317k, beVar.f42317k);
        }
        return false;
    }

    public final fl f() {
        return this.f42315i;
    }

    public final String g() {
        return this.f42313g;
    }

    public final List<cm> h() {
        return this.f42316j;
    }

    public int hashCode() {
        int hashCode = ((a().hashCode() * 31) + this.f42313g.hashCode()) * 31;
        String str = this.f42314h;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f42315i.hashCode()) * 31) + this.f42316j.hashCode()) * 31;
        Integer num = this.f42317k;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        String a8 = a();
        String str = this.f42313g;
        String str2 = this.f42314h;
        fl flVar = this.f42315i;
        List<cm> list = this.f42316j;
        Integer num = this.f42317k;
        return "Paragraph(id=" + a8 + ", textHtml=" + str + ", iconUrl=" + str2 + ", textAlignment=" + flVar + ", urlIntercepts=" + list + ", distanceToIconDp=" + num + ")";
    }
}
