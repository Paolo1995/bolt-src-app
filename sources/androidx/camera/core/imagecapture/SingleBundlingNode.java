package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.utils.Threads;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleBundlingNode {

    /* renamed from: a  reason: collision with root package name */
    private ProcessingRequest f3489a;

    /* renamed from: b  reason: collision with root package name */
    private ProcessingNode.In f3490b;

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull ImageProxy imageProxy) {
        boolean z7;
        Threads.a();
        boolean z8 = true;
        if (this.f3489a != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.i(z7);
        Object c8 = imageProxy.O0().b().c(this.f3489a.g());
        Objects.requireNonNull(c8);
        if (((Integer) c8).intValue() != this.f3489a.f().get(0).intValue()) {
            z8 = false;
        }
        Preconditions.i(z8);
        this.f3490b.a().accept(ProcessingNode.InputPacket.c(this.f3489a, imageProxy));
        this.f3489a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(@NonNull ProcessingRequest processingRequest) {
        boolean z7;
        Threads.a();
        boolean z8 = false;
        if (processingRequest.f().size() == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.j(z7, "Cannot handle multi-image capture.");
        if (this.f3489a == null) {
            z8 = true;
        }
        Preconditions.j(z8, "Already has an existing request.");
        this.f3489a = processingRequest;
    }

    public void d() {
    }

    @NonNull
    public ProcessingNode.In f(@NonNull CaptureNode.Out out) {
        out.b().a(new Consumer() { // from class: androidx.camera.core.imagecapture.i
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                SingleBundlingNode.this.c((ImageProxy) obj);
            }
        });
        out.c().a(new Consumer() { // from class: androidx.camera.core.imagecapture.j
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                SingleBundlingNode.this.e((ProcessingRequest) obj);
            }
        });
        ProcessingNode.In c8 = ProcessingNode.In.c(out.a());
        this.f3490b = c8;
        return c8;
    }
}
