package eu.bolt.android.rib;

import eu.bolt.android.rib.SerializableRouterNavigatorState;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttachInfo.kt */
/* loaded from: classes5.dex */
public final class AttachInfo<RouterState extends SerializableRouterNavigatorState> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final RouterState f37038f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f37039g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f37040h;

    public AttachInfo(RouterState state, boolean z7, boolean z8) {
        Intrinsics.f(state, "state");
        this.f37038f = state;
        this.f37039g = z7;
        this.f37040h = z8;
    }

    public final boolean a() {
        return this.f37039g;
    }

    public final RouterState b() {
        return this.f37038f;
    }

    public final boolean c() {
        return this.f37040h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AttachInfo) {
            AttachInfo attachInfo = (AttachInfo) obj;
            return Intrinsics.a(this.f37038f, attachInfo.f37038f) && this.f37039g == attachInfo.f37039g && this.f37040h == attachInfo.f37040h;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f37038f.hashCode() * 31;
        boolean z7 = this.f37039g;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f37040h;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        String name = this.f37038f.name();
        boolean z7 = this.f37039g;
        boolean z8 = this.f37040h;
        return "Attach(state=" + name + ", discardOnPush=" + z7 + ", immediate=" + z8 + ")";
    }
}
