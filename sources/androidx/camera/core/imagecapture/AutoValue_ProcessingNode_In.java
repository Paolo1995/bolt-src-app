package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.processing.Edge;

/* loaded from: classes.dex */
final class AutoValue_ProcessingNode_In extends ProcessingNode.In {

    /* renamed from: a  reason: collision with root package name */
    private final Edge<ProcessingNode.InputPacket> f3437a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3438b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ProcessingNode_In(Edge<ProcessingNode.InputPacket> edge, int i8) {
        if (edge != null) {
            this.f3437a = edge;
            this.f3438b = i8;
            return;
        }
        throw new NullPointerException("Null edge");
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    Edge<ProcessingNode.InputPacket> a() {
        return this.f3437a;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    int b() {
        return this.f3438b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingNode.In)) {
            return false;
        }
        ProcessingNode.In in = (ProcessingNode.In) obj;
        if (this.f3437a.equals(in.a()) && this.f3438b == in.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3437a.hashCode() ^ 1000003) * 1000003) ^ this.f3438b;
    }

    public String toString() {
        return "In{edge=" + this.f3437a + ", format=" + this.f3438b + "}";
    }
}
