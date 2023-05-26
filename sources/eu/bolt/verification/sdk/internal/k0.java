package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.b1;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class k0 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final List<b1.a> f43791f;

    public k0(List<b1.a> actions) {
        Intrinsics.f(actions, "actions");
        this.f43791f = actions;
    }

    public final List<b1.a> a() {
        return this.f43791f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k0) && Intrinsics.a(this.f43791f, ((k0) obj).f43791f);
    }

    public int hashCode() {
        return this.f43791f.hashCode();
    }

    public String toString() {
        List<b1.a> list = this.f43791f;
        return "BottomSheetButtonAction(actions=" + list + ")";
    }
}
