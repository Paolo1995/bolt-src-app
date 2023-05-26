package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ud implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f45349f;

    /* renamed from: g  reason: collision with root package name */
    private final String f45350g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f45351h;

    public ud(String checkBoxGroupId, String selectedOptionId, boolean z7) {
        Intrinsics.f(checkBoxGroupId, "checkBoxGroupId");
        Intrinsics.f(selectedOptionId, "selectedOptionId");
        this.f45349f = checkBoxGroupId;
        this.f45350g = selectedOptionId;
        this.f45351h = z7;
    }

    public final String a() {
        return this.f45349f;
    }

    public final String b() {
        return this.f45350g;
    }

    public final boolean c() {
        return this.f45351h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ud) {
            ud udVar = (ud) obj;
            return Intrinsics.a(this.f45349f, udVar.f45349f) && Intrinsics.a(this.f45350g, udVar.f45350g) && this.f45351h == udVar.f45351h;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f45349f.hashCode() * 31) + this.f45350g.hashCode()) * 31;
        boolean z7 = this.f45351h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f45349f;
        String str2 = this.f45350g;
        boolean z7 = this.f45351h;
        return "OptionSelected(checkBoxGroupId=" + str + ", selectedOptionId=" + str2 + ", isMultiselection=" + z7 + ")";
    }
}
