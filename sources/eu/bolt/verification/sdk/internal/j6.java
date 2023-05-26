package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j6 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final ll f43661f;

    /* renamed from: g  reason: collision with root package name */
    private final l6 f43662g;

    /* renamed from: h  reason: collision with root package name */
    private final m6 f43663h;

    public j6(ll text, l6 action, m6 uiType) {
        Intrinsics.f(text, "text");
        Intrinsics.f(action, "action");
        Intrinsics.f(uiType, "uiType");
        this.f43661f = text;
        this.f43662g = action;
        this.f43663h = uiType;
    }

    public final l6 a() {
        return this.f43662g;
    }

    public final ll b() {
        return this.f43661f;
    }

    public final m6 c() {
        return this.f43663h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j6) {
            j6 j6Var = (j6) obj;
            return Intrinsics.a(this.f43661f, j6Var.f43661f) && Intrinsics.a(this.f43662g, j6Var.f43662g) && Intrinsics.a(this.f43663h, j6Var.f43663h);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f43661f.hashCode() * 31) + this.f43662g.hashCode()) * 31) + this.f43663h.hashCode();
    }

    public String toString() {
        ll llVar = this.f43661f;
        l6 l6Var = this.f43662g;
        m6 m6Var = this.f43663h;
        return "ErrorActionButtonModel(text=" + llVar + ", action=" + l6Var + ", uiType=" + m6Var + ")";
    }
}
