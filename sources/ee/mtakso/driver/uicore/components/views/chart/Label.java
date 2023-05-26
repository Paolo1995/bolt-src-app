package ee.mtakso.driver.uicore.components.views.chart;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bar.kt */
/* loaded from: classes5.dex */
public final class Label {

    /* renamed from: a  reason: collision with root package name */
    private final String f35544a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f35545b;

    public Label(String text, boolean z7) {
        Intrinsics.f(text, "text");
        this.f35544a = text;
        this.f35545b = z7;
    }

    public final boolean a() {
        return this.f35545b;
    }

    public final String b() {
        return this.f35544a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Label) {
            Label label = (Label) obj;
            return Intrinsics.a(this.f35544a, label.f35544a) && this.f35545b == label.f35545b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f35544a.hashCode() * 31;
        boolean z7 = this.f35545b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f35544a;
        boolean z7 = this.f35545b;
        return "Label(text=" + str + ", highlighted=" + z7 + ")";
    }
}
