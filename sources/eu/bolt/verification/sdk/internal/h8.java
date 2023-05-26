package eu.bolt.verification.sdk.internal;

import eu.bolt.client.design.toolbar.DesignToolbarView;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h8 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final x6 f43345f;

    /* renamed from: g  reason: collision with root package name */
    private final DesignToolbarView.c f43346g;

    public h8(x6 errorContent, DesignToolbarView.c cVar) {
        Intrinsics.f(errorContent, "errorContent");
        this.f43345f = errorContent;
        this.f43346g = cVar;
    }

    public final x6 a() {
        return this.f43345f;
    }

    public final DesignToolbarView.c b() {
        return this.f43346g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h8) {
            h8 h8Var = (h8) obj;
            return Intrinsics.a(this.f43345f, h8Var.f43345f) && Intrinsics.a(this.f43346g, h8Var.f43346g);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f43345f.hashCode() * 31;
        DesignToolbarView.c cVar = this.f43346g;
        return hashCode + (cVar == null ? 0 : cVar.hashCode());
    }

    public String toString() {
        x6 x6Var = this.f43345f;
        DesignToolbarView.c cVar = this.f43346g;
        return "FullScreenErrorRibArgs(errorContent=" + x6Var + ", topCloseBtnMode=" + cVar + ")";
    }
}
