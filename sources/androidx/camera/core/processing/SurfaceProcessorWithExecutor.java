package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class SurfaceProcessorWithExecutor implements SurfaceProcessorInternal {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceProcessor f4012a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f4013b;

    public SurfaceProcessorWithExecutor(@NonNull SurfaceProcessor surfaceProcessor, @NonNull Executor executor) {
        Preconditions.j(!(surfaceProcessor instanceof SurfaceProcessorInternal), "SurfaceProcessorInternal should always be thread safe. Do not wrap.");
        this.f4012a = surfaceProcessor;
        this.f4013b = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceRequest surfaceRequest) {
        this.f4012a.a(surfaceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceOutput surfaceOutput) {
        this.f4012a.b(surfaceOutput);
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void a(@NonNull final SurfaceRequest surfaceRequest) {
        this.f4013b.execute(new Runnable() { // from class: i.h
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceProcessorWithExecutor.this.e(surfaceRequest);
            }
        });
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void b(@NonNull final SurfaceOutput surfaceOutput) {
        this.f4013b.execute(new Runnable() { // from class: i.i
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceProcessorWithExecutor.this.f(surfaceOutput);
            }
        });
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
    }
}
