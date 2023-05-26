package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Camera2RequestProcessor implements RequestProcessor {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CaptureSession f2527a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final List<SessionProcessorSurface> f2528b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f2529c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile SessionConfig f2530d;

    public Camera2RequestProcessor(@NonNull CaptureSession captureSession, @NonNull List<SessionProcessorSurface> list) {
        boolean z7 = captureSession.f2554l == CaptureSession.State.OPENED;
        Preconditions.b(z7, "CaptureSession state must be OPENED. Current state:" + captureSession.f2554l);
        this.f2527a = captureSession;
        this.f2528b = Collections.unmodifiableList(new ArrayList(list));
    }

    public void a() {
        this.f2529c = true;
    }

    public void b(SessionConfig sessionConfig) {
        this.f2530d = sessionConfig;
    }
}
