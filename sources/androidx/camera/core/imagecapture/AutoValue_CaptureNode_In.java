package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;

/* loaded from: classes.dex */
final class AutoValue_CaptureNode_In extends CaptureNode.In {

    /* renamed from: c  reason: collision with root package name */
    private final Size f3427c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3428d;

    /* renamed from: e  reason: collision with root package name */
    private final Edge<ProcessingRequest> f3429e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CaptureNode_In(Size size, int i8, Edge<ProcessingRequest> edge) {
        if (size != null) {
            this.f3427c = size;
            this.f3428d = i8;
            if (edge != null) {
                this.f3429e = edge;
                return;
            }
            throw new NullPointerException("Null requestEdge");
        }
        throw new NullPointerException("Null size");
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    int c() {
        return this.f3428d;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    @NonNull
    Edge<ProcessingRequest> d() {
        return this.f3429e;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    Size e() {
        return this.f3427c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.In)) {
            return false;
        }
        CaptureNode.In in = (CaptureNode.In) obj;
        if (this.f3427c.equals(in.e()) && this.f3428d == in.c() && this.f3429e.equals(in.d())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3427c.hashCode() ^ 1000003) * 1000003) ^ this.f3428d) * 1000003) ^ this.f3429e.hashCode();
    }

    public String toString() {
        return "In{size=" + this.f3427c + ", format=" + this.f3428d + ", requestEdge=" + this.f3429e + "}";
    }
}
