package ee.mtakso.driver.ui.views.infoblock;

import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoBlockData.kt */
/* loaded from: classes5.dex */
public final class InfoBlockData {

    /* renamed from: a  reason: collision with root package name */
    private final InfoBlockType f34360a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f34361b;

    /* renamed from: c  reason: collision with root package name */
    private final Text f34362c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f34363d;

    public InfoBlockData(InfoBlockType type, Text text, Text text2, boolean z7) {
        Intrinsics.f(type, "type");
        this.f34360a = type;
        this.f34361b = text;
        this.f34362c = text2;
        this.f34363d = z7;
    }

    public final boolean a() {
        return this.f34363d;
    }

    public final Text b() {
        return this.f34362c;
    }

    public final Text c() {
        return this.f34361b;
    }

    public final InfoBlockType d() {
        return this.f34360a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InfoBlockData) {
            InfoBlockData infoBlockData = (InfoBlockData) obj;
            return this.f34360a == infoBlockData.f34360a && Intrinsics.a(this.f34361b, infoBlockData.f34361b) && Intrinsics.a(this.f34362c, infoBlockData.f34362c) && this.f34363d == infoBlockData.f34363d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f34360a.hashCode() * 31;
        Text text = this.f34361b;
        int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
        Text text2 = this.f34362c;
        int hashCode3 = (hashCode2 + (text2 != null ? text2.hashCode() : 0)) * 31;
        boolean z7 = this.f34363d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode3 + i8;
    }

    public String toString() {
        InfoBlockType infoBlockType = this.f34360a;
        Text text = this.f34361b;
        Text text2 = this.f34362c;
        boolean z7 = this.f34363d;
        return "InfoBlockData(type=" + infoBlockType + ", title=" + text + ", subtitle=" + text2 + ", showIcon=" + z7 + ")";
    }
}
