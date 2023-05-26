package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_SurfaceEdge extends SurfaceEdge {

    /* renamed from: a  reason: collision with root package name */
    private final List<SettableSurface> f3971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SurfaceEdge(List<SettableSurface> list) {
        if (list != null) {
            this.f3971a = list;
            return;
        }
        throw new NullPointerException("Null surfaces");
    }

    @Override // androidx.camera.core.processing.SurfaceEdge
    @NonNull
    public List<SettableSurface> b() {
        return this.f3971a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceEdge) {
            return this.f3971a.equals(((SurfaceEdge) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f3971a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "SurfaceEdge{surfaces=" + this.f3971a + "}";
    }
}
