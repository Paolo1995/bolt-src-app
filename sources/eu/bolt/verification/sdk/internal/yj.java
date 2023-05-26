package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class yj {

    /* renamed from: a  reason: collision with root package name */
    private final String f45762a;

    /* renamed from: b  reason: collision with root package name */
    private final String f45763b;

    /* renamed from: c  reason: collision with root package name */
    private final String f45764c;

    /* renamed from: d  reason: collision with root package name */
    private final String f45765d;

    /* renamed from: e  reason: collision with root package name */
    private final ui f45766e;

    /* renamed from: f  reason: collision with root package name */
    private final ri f45767f;

    public yj(String text, String str, String str2, String str3, ui type, ri style) {
        Intrinsics.f(text, "text");
        Intrinsics.f(type, "type");
        Intrinsics.f(style, "style");
        this.f45762a = text;
        this.f45763b = str;
        this.f45764c = str2;
        this.f45765d = str3;
        this.f45766e = type;
        this.f45767f = style;
    }

    public final String a() {
        return this.f45763b;
    }

    public final String b() {
        return this.f45765d;
    }

    public final String c() {
        return this.f45764c;
    }

    public final ri d() {
        return this.f45767f;
    }

    public final String e() {
        return this.f45762a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof yj) {
            yj yjVar = (yj) obj;
            return Intrinsics.a(this.f45762a, yjVar.f45762a) && Intrinsics.a(this.f45763b, yjVar.f45763b) && Intrinsics.a(this.f45764c, yjVar.f45764c) && Intrinsics.a(this.f45765d, yjVar.f45765d) && this.f45766e == yjVar.f45766e && Intrinsics.a(this.f45767f, yjVar.f45767f);
        }
        return false;
    }

    public final ui f() {
        return this.f45766e;
    }

    public int hashCode() {
        int hashCode = this.f45762a.hashCode() * 31;
        String str = this.f45763b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f45764c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f45765d;
        return ((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f45766e.hashCode()) * 31) + this.f45767f.hashCode();
    }

    public String toString() {
        String str = this.f45762a;
        String str2 = this.f45763b;
        String str3 = this.f45764c;
        String str4 = this.f45765d;
        ui uiVar = this.f45766e;
        ri riVar = this.f45767f;
        return "StorySlideButton(text=" + str + ", link=" + str2 + ", shareText=" + str3 + ", shareFileName=" + str4 + ", type=" + uiVar + ", style=" + riVar + ")";
    }
}
