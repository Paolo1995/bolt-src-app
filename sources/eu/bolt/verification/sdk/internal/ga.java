package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ga implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f43133f;

    /* renamed from: g  reason: collision with root package name */
    private final ha f43134g;

    /* renamed from: h  reason: collision with root package name */
    private final f7 f43135h;

    public ga(boolean z7, ha informationUiModel, f7 fadeBackgroundState) {
        Intrinsics.f(informationUiModel, "informationUiModel");
        Intrinsics.f(fadeBackgroundState, "fadeBackgroundState");
        this.f43133f = z7;
        this.f43134g = informationUiModel;
        this.f43135h = fadeBackgroundState;
    }

    public final boolean a() {
        return this.f43133f;
    }

    public final f7 b() {
        return this.f43135h;
    }

    public final ha c() {
        return this.f43134g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ga) {
            ga gaVar = (ga) obj;
            return this.f43133f == gaVar.f43133f && Intrinsics.a(this.f43134g, gaVar.f43134g) && this.f43135h == gaVar.f43135h;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z7 = this.f43133f;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        return (((r02 * 31) + this.f43134g.hashCode()) * 31) + this.f43135h.hashCode();
    }

    public String toString() {
        boolean z7 = this.f43133f;
        ha haVar = this.f43134g;
        f7 f7Var = this.f43135h;
        return "InformationRibArgs(closeOnOutsideClick=" + z7 + ", informationUiModel=" + haVar + ", fadeBackgroundState=" + f7Var + ")";
    }
}
