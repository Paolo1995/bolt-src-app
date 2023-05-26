package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderedMarkerHolder.kt */
/* loaded from: classes3.dex */
public final class RenderedMarkerHolder {

    /* renamed from: a  reason: collision with root package name */
    private final String f30307a;

    /* renamed from: b  reason: collision with root package name */
    private final RenderedMarker f30308b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, RenderedMarker> f30309c;

    public RenderedMarkerHolder(String id, RenderedMarker renderedMarker, Map<Integer, RenderedMarker> variantByZoom) {
        Intrinsics.f(id, "id");
        Intrinsics.f(variantByZoom, "variantByZoom");
        this.f30307a = id;
        this.f30308b = renderedMarker;
        this.f30309c = variantByZoom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RenderedMarkerHolder b(RenderedMarkerHolder renderedMarkerHolder, String str, RenderedMarker renderedMarker, Map map, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = renderedMarkerHolder.f30307a;
        }
        if ((i8 & 2) != 0) {
            renderedMarker = renderedMarkerHolder.f30308b;
        }
        if ((i8 & 4) != 0) {
            map = renderedMarkerHolder.f30309c;
        }
        return renderedMarkerHolder.a(str, renderedMarker, map);
    }

    public final RenderedMarkerHolder a(String id, RenderedMarker renderedMarker, Map<Integer, RenderedMarker> variantByZoom) {
        Intrinsics.f(id, "id");
        Intrinsics.f(variantByZoom, "variantByZoom");
        return new RenderedMarkerHolder(id, renderedMarker, variantByZoom);
    }

    public final RenderedMarker c() {
        return this.f30308b;
    }

    public final String d() {
        return this.f30307a;
    }

    public final Map<Integer, RenderedMarker> e() {
        return this.f30309c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RenderedMarkerHolder) {
            RenderedMarkerHolder renderedMarkerHolder = (RenderedMarkerHolder) obj;
            return Intrinsics.a(this.f30307a, renderedMarkerHolder.f30307a) && Intrinsics.a(this.f30308b, renderedMarkerHolder.f30308b) && Intrinsics.a(this.f30309c, renderedMarkerHolder.f30309c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f30307a.hashCode() * 31;
        RenderedMarker renderedMarker = this.f30308b;
        return ((hashCode + (renderedMarker == null ? 0 : renderedMarker.hashCode())) * 31) + this.f30309c.hashCode();
    }

    public String toString() {
        String str = this.f30307a;
        RenderedMarker renderedMarker = this.f30308b;
        Map<Integer, RenderedMarker> map = this.f30309c;
        return "RenderedMarkerHolder(id=" + str + ", active=" + renderedMarker + ", variantByZoom=" + map + ")";
    }
}
