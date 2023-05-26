package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderedMarkerDiff.kt */
/* loaded from: classes3.dex */
public final class RenderedMarkerDiff {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f30299d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final RenderedMarker f30300a;

    /* renamed from: b  reason: collision with root package name */
    private final long f30301b;

    /* renamed from: c  reason: collision with root package name */
    private final Change f30302c;

    /* compiled from: RenderedMarkerDiff.kt */
    /* loaded from: classes3.dex */
    public enum Change {
        ADDED,
        UPDATED,
        DELETED
    }

    /* compiled from: RenderedMarkerDiff.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RenderedMarkerDiff a(long j8, RenderedMarker renderedMarker, RenderedMarker renderedMarker2) {
            if (renderedMarker == null && renderedMarker2 != null) {
                return new RenderedMarkerDiff(renderedMarker2, j8, Change.ADDED);
            }
            if (renderedMarker != null && renderedMarker2 == null) {
                return new RenderedMarkerDiff(renderedMarker, j8, Change.DELETED);
            }
            if (renderedMarker != null && renderedMarker2 != null && !Intrinsics.a(renderedMarker2.c(), renderedMarker.c())) {
                return new RenderedMarkerDiff(renderedMarker2, j8, Change.UPDATED);
            }
            return null;
        }
    }

    public RenderedMarkerDiff(RenderedMarker marker, long j8, Change change) {
        Intrinsics.f(marker, "marker");
        Intrinsics.f(change, "change");
        this.f30300a = marker;
        this.f30301b = j8;
        this.f30302c = change;
    }

    public final Change a() {
        return this.f30302c;
    }

    public final RenderedMarker b() {
        return this.f30300a;
    }

    public final long c() {
        return this.f30301b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RenderedMarkerDiff) {
            RenderedMarkerDiff renderedMarkerDiff = (RenderedMarkerDiff) obj;
            return Intrinsics.a(this.f30300a, renderedMarkerDiff.f30300a) && this.f30301b == renderedMarkerDiff.f30301b && this.f30302c == renderedMarkerDiff.f30302c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f30300a.hashCode() * 31) + i0.a.a(this.f30301b)) * 31) + this.f30302c.hashCode();
    }

    public String toString() {
        RenderedMarker renderedMarker = this.f30300a;
        long j8 = this.f30301b;
        Change change = this.f30302c;
        return "RenderedMarkerDiff(marker=" + renderedMarker + ", version=" + j8 + ", change=" + change + ")";
    }
}
