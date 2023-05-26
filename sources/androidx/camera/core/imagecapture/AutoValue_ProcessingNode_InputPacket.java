package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.ProcessingNode;

/* loaded from: classes.dex */
final class AutoValue_ProcessingNode_InputPacket extends ProcessingNode.InputPacket {

    /* renamed from: a  reason: collision with root package name */
    private final ProcessingRequest f3439a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageProxy f3440b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ProcessingNode_InputPacket(ProcessingRequest processingRequest, ImageProxy imageProxy) {
        if (processingRequest != null) {
            this.f3439a = processingRequest;
            if (imageProxy != null) {
                this.f3440b = imageProxy;
                return;
            }
            throw new NullPointerException("Null imageProxy");
        }
        throw new NullPointerException("Null processingRequest");
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.InputPacket
    @NonNull
    ImageProxy a() {
        return this.f3440b;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.InputPacket
    @NonNull
    ProcessingRequest b() {
        return this.f3439a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingNode.InputPacket)) {
            return false;
        }
        ProcessingNode.InputPacket inputPacket = (ProcessingNode.InputPacket) obj;
        if (this.f3439a.equals(inputPacket.b()) && this.f3440b.equals(inputPacket.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3439a.hashCode() ^ 1000003) * 1000003) ^ this.f3440b.hashCode();
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.f3439a + ", imageProxy=" + this.f3440b + "}";
    }
}
