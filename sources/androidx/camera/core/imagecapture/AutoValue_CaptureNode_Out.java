package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;

/* loaded from: classes.dex */
final class AutoValue_CaptureNode_Out extends CaptureNode.Out {

    /* renamed from: a  reason: collision with root package name */
    private final Edge<ImageProxy> f3430a;

    /* renamed from: b  reason: collision with root package name */
    private final Edge<ProcessingRequest> f3431b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3432c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CaptureNode_Out(Edge<ImageProxy> edge, Edge<ProcessingRequest> edge2, int i8) {
        if (edge != null) {
            this.f3430a = edge;
            if (edge2 != null) {
                this.f3431b = edge2;
                this.f3432c = i8;
                return;
            }
            throw new NullPointerException("Null requestEdge");
        }
        throw new NullPointerException("Null imageEdge");
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    int a() {
        return this.f3432c;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    Edge<ImageProxy> b() {
        return this.f3430a;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    Edge<ProcessingRequest> c() {
        return this.f3431b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.Out)) {
            return false;
        }
        CaptureNode.Out out = (CaptureNode.Out) obj;
        if (this.f3430a.equals(out.b()) && this.f3431b.equals(out.c()) && this.f3432c == out.a()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3430a.hashCode() ^ 1000003) * 1000003) ^ this.f3431b.hashCode()) * 1000003) ^ this.f3432c;
    }

    public String toString() {
        return "Out{imageEdge=" + this.f3430a + ", requestEdge=" + this.f3431b + ", format=" + this.f3432c + "}";
    }
}
