package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b1 extends ob {

    /* renamed from: f  reason: collision with root package name */
    private final String f42247f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42248g;

    /* renamed from: h  reason: collision with root package name */
    private final b f42249h;

    /* renamed from: i  reason: collision with root package name */
    private final List<a> f42250i;

    /* loaded from: classes5.dex */
    public static final class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final d f42251f;

        /* renamed from: g  reason: collision with root package name */
        private final c2 f42252g;

        public a(d action, c2 c2Var) {
            Intrinsics.f(action, "action");
            this.f42251f = action;
            this.f42252g = c2Var;
        }

        public final d a() {
            return this.f42251f;
        }

        public final c2 b() {
            return this.f42252g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42251f, aVar.f42251f) && Intrinsics.a(this.f42252g, aVar.f42252g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f42251f.hashCode() * 31;
            c2 c2Var = this.f42252g;
            return hashCode + (c2Var == null ? 0 : c2Var.hashCode());
        }

        public String toString() {
            d dVar = this.f42251f;
            c2 c2Var = this.f42252g;
            return "ActionHolder(action=" + dVar + ", condition=" + c2Var + ")";
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        PRIMARY,
        SECONDARY,
        DANGER,
        TEXT
    }

    public b1(String id, String text, b uiType, List<a> actions) {
        Intrinsics.f(id, "id");
        Intrinsics.f(text, "text");
        Intrinsics.f(uiType, "uiType");
        Intrinsics.f(actions, "actions");
        this.f42247f = id;
        this.f42248g = text;
        this.f42249h = uiType;
        this.f42250i = actions;
    }

    @Override // eu.bolt.verification.sdk.internal.ob
    public String a() {
        return this.f42247f;
    }

    public final List<a> b() {
        return this.f42250i;
    }

    public final String c() {
        return this.f42248g;
    }

    public final b d() {
        return this.f42249h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b1) {
            b1 b1Var = (b1) obj;
            return Intrinsics.a(a(), b1Var.a()) && Intrinsics.a(this.f42248g, b1Var.f42248g) && this.f42249h == b1Var.f42249h && Intrinsics.a(this.f42250i, b1Var.f42250i);
        }
        return false;
    }

    public int hashCode() {
        return (((((a().hashCode() * 31) + this.f42248g.hashCode()) * 31) + this.f42249h.hashCode()) * 31) + this.f42250i.hashCode();
    }

    public String toString() {
        String a8 = a();
        String str = this.f42248g;
        b bVar = this.f42249h;
        List<a> list = this.f42250i;
        return "Button(id=" + a8 + ", text=" + str + ", uiType=" + bVar + ", actions=" + list + ")";
    }
}
