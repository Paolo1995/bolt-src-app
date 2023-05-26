package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderedMarker.kt */
/* loaded from: classes3.dex */
public final class RenderedMarker {

    /* renamed from: a  reason: collision with root package name */
    private final String f30295a;

    /* renamed from: b  reason: collision with root package name */
    private final Locatable f30296b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f30297c;

    /* renamed from: d  reason: collision with root package name */
    private final MarkerParams f30298d;

    public RenderedMarker(String id, Locatable position, Object payload, MarkerParams markerParams) {
        Intrinsics.f(id, "id");
        Intrinsics.f(position, "position");
        Intrinsics.f(payload, "payload");
        this.f30295a = id;
        this.f30296b = position;
        this.f30297c = payload;
        this.f30298d = markerParams;
    }

    public final String a() {
        return this.f30295a;
    }

    public final MarkerParams b() {
        return this.f30298d;
    }

    public final Object c() {
        return this.f30297c;
    }

    public final Locatable d() {
        return this.f30296b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RenderedMarker) {
            RenderedMarker renderedMarker = (RenderedMarker) obj;
            return Intrinsics.a(this.f30295a, renderedMarker.f30295a) && Intrinsics.a(this.f30296b, renderedMarker.f30296b) && Intrinsics.a(this.f30297c, renderedMarker.f30297c) && Intrinsics.a(this.f30298d, renderedMarker.f30298d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f30295a.hashCode() * 31) + this.f30296b.hashCode()) * 31) + this.f30297c.hashCode()) * 31;
        MarkerParams markerParams = this.f30298d;
        return hashCode + (markerParams == null ? 0 : markerParams.hashCode());
    }

    public String toString() {
        String str = this.f30295a;
        Locatable locatable = this.f30296b;
        Object obj = this.f30297c;
        MarkerParams markerParams = this.f30298d;
        return "RenderedMarker(id=" + str + ", position=" + locatable + ", payload=" + obj + ", map=" + markerParams + ")";
    }
}
