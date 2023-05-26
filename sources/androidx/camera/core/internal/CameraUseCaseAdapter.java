package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class CameraUseCaseAdapter implements Camera {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private CameraInternal f3893f;

    /* renamed from: g  reason: collision with root package name */
    private final LinkedHashSet<CameraInternal> f3894g;

    /* renamed from: h  reason: collision with root package name */
    private final CameraDeviceSurfaceManager f3895h;

    /* renamed from: i  reason: collision with root package name */
    private final UseCaseConfigFactory f3896i;

    /* renamed from: j  reason: collision with root package name */
    private final CameraId f3897j;

    /* renamed from: l  reason: collision with root package name */
    private ViewPort f3899l;

    /* renamed from: k  reason: collision with root package name */
    private final List<UseCase> f3898k = new ArrayList();
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private List<CameraEffect> f3900m = Collections.emptyList();
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    private CameraConfig f3901n = CameraConfigs.a();

    /* renamed from: o  reason: collision with root package name */
    private final Object f3902o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private boolean f3903p = true;

    /* renamed from: q  reason: collision with root package name */
    private Config f3904q = null;

    /* renamed from: r  reason: collision with root package name */
    private List<UseCase> f3905r = new ArrayList();

    /* loaded from: classes.dex */
    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class CameraId {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f3906a = new ArrayList();

        CameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator<CameraInternal> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.f3906a.add(it.next().j().a());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof CameraId) {
                return this.f3906a.equals(((CameraId) obj).f3906a);
            }
            return false;
        }

        public int hashCode() {
            return this.f3906a.hashCode() * 53;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ConfigPair {

        /* renamed from: a  reason: collision with root package name */
        UseCaseConfig<?> f3907a;

        /* renamed from: b  reason: collision with root package name */
        UseCaseConfig<?> f3908b;

        ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.f3907a = useCaseConfig;
            this.f3908b = useCaseConfig2;
        }
    }

    public CameraUseCaseAdapter(@NonNull LinkedHashSet<CameraInternal> linkedHashSet, @NonNull CameraDeviceSurfaceManager cameraDeviceSurfaceManager, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        this.f3893f = linkedHashSet.iterator().next();
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.f3894g = linkedHashSet2;
        this.f3897j = new CameraId(linkedHashSet2);
        this.f3895h = cameraDeviceSurfaceManager;
        this.f3896i = useCaseConfigFactory;
    }

    private boolean A() {
        boolean z7;
        synchronized (this.f3902o) {
            z7 = true;
            if (this.f3901n.s() != 1) {
                z7 = false;
            }
        }
        return z7;
    }

    private boolean B(@NonNull List<UseCase> list) {
        boolean z7 = false;
        boolean z8 = false;
        for (UseCase useCase : list) {
            if (E(useCase)) {
                z7 = true;
            } else if (D(useCase)) {
                z8 = true;
            }
        }
        if (!z7 || z8) {
            return false;
        }
        return true;
    }

    private boolean C(@NonNull List<UseCase> list) {
        boolean z7 = false;
        boolean z8 = false;
        for (UseCase useCase : list) {
            if (E(useCase)) {
                z8 = true;
            } else if (D(useCase)) {
                z7 = true;
            }
        }
        if (!z7 || z8) {
            return false;
        }
        return true;
    }

    private boolean D(UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    private boolean E(UseCase useCase) {
        return useCase instanceof Preview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.Result result) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(SurfaceRequest surfaceRequest) {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.l().getWidth(), surfaceRequest.l().getHeight());
        surfaceTexture.detachFromGLContext();
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.v(surface, CameraXExecutors.a(), new Consumer() { // from class: f.b
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CameraUseCaseAdapter.F(surface, surfaceTexture, (SurfaceRequest.Result) obj);
            }
        });
    }

    private void I() {
        synchronized (this.f3902o) {
            if (this.f3904q != null) {
                this.f3893f.d().g(this.f3904q);
            }
        }
    }

    static void L(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection) {
        HashMap hashMap = new HashMap();
        for (CameraEffect cameraEffect : list) {
            hashMap.put(Integer.valueOf(cameraEffect.c()), cameraEffect);
        }
        for (UseCase useCase : collection) {
            if (useCase instanceof Preview) {
                Preview preview = (Preview) useCase;
                CameraEffect cameraEffect2 = (CameraEffect) hashMap.get(1);
                if (cameraEffect2 == null) {
                    preview.W(null);
                } else {
                    SurfaceProcessor b8 = cameraEffect2.b();
                    Objects.requireNonNull(b8);
                    preview.W(new SurfaceProcessorWithExecutor(b8, cameraEffect2.a()));
                }
            }
        }
    }

    private void M(@NonNull Map<UseCase, Size> map, @NonNull Collection<UseCase> collection) {
        boolean z7;
        synchronized (this.f3902o) {
            if (this.f3899l != null) {
                Integer c8 = this.f3893f.j().c();
                boolean z8 = true;
                if (c8 == null) {
                    Logger.k("CameraUseCaseAdapter", "The lens facing is null, probably an external.");
                    z7 = true;
                } else {
                    if (c8.intValue() != 0) {
                        z8 = false;
                    }
                    z7 = z8;
                }
                Map<UseCase, Rect> a8 = ViewPorts.a(this.f3893f.d().c(), z7, this.f3899l.a(), this.f3893f.j().g(this.f3899l.c()), this.f3899l.d(), this.f3899l.b(), map);
                for (UseCase useCase : collection) {
                    useCase.I((Rect) Preconditions.g(a8.get(useCase)));
                    useCase.H(q(this.f3893f.d().c(), map.get(useCase)));
                }
            }
        }
    }

    private void o() {
        synchronized (this.f3902o) {
            CameraControlInternal d8 = this.f3893f.d();
            this.f3904q = d8.f();
            d8.h();
        }
    }

    @NonNull
    private List<UseCase> p(@NonNull List<UseCase> list, @NonNull List<UseCase> list2) {
        ArrayList arrayList = new ArrayList(list2);
        boolean C = C(list);
        boolean B = B(list);
        UseCase useCase = null;
        UseCase useCase2 = null;
        for (UseCase useCase3 : list2) {
            if (E(useCase3)) {
                useCase = useCase3;
            } else if (D(useCase3)) {
                useCase2 = useCase3;
            }
        }
        if (C && useCase == null) {
            arrayList.add(t());
        } else if (!C && useCase != null) {
            arrayList.remove(useCase);
        }
        if (B && useCase2 == null) {
            arrayList.add(s());
        } else if (!B && useCase2 != null) {
            arrayList.remove(useCase2);
        }
        return arrayList;
    }

    @NonNull
    private static Matrix q(@NonNull Rect rect, @NonNull Size size) {
        boolean z7;
        if (rect.width() > 0 && rect.height() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map<UseCase, Size> r(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull List<UseCase> list, @NonNull List<UseCase> list2, @NonNull Map<UseCase, ConfigPair> map) {
        ArrayList arrayList = new ArrayList();
        String a8 = cameraInfoInternal.a();
        HashMap hashMap = new HashMap();
        for (UseCase useCase : list2) {
            arrayList.add(AttachedSurfaceInfo.a(this.f3895h.a(a8, useCase.i(), useCase.c()), useCase.i(), useCase.c(), useCase.g().B(null)));
            hashMap.put(useCase, useCase.c());
        }
        if (!list.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            for (UseCase useCase2 : list) {
                ConfigPair configPair = map.get(useCase2);
                hashMap2.put(useCase2.r(cameraInfoInternal, configPair.f3907a, configPair.f3908b), useCase2);
            }
            Map<UseCaseConfig<?>, Size> b8 = this.f3895h.b(a8, arrayList, new ArrayList(hashMap2.keySet()));
            for (Map.Entry entry : hashMap2.entrySet()) {
                hashMap.put((UseCase) entry.getValue(), b8.get(entry.getKey()));
            }
        }
        return hashMap;
    }

    private ImageCapture s() {
        return new ImageCapture.Builder().j("ImageCapture-Extra").c();
    }

    private Preview t() {
        Preview c8 = new Preview.Builder().i("Preview-Extra").c();
        c8.X(new Preview.SurfaceProvider() { // from class: f.a
            @Override // androidx.camera.core.Preview.SurfaceProvider
            public final void a(SurfaceRequest surfaceRequest) {
                CameraUseCaseAdapter.G(surfaceRequest);
            }
        });
        return c8;
    }

    private void u(@NonNull List<UseCase> list) {
        synchronized (this.f3902o) {
            if (!list.isEmpty()) {
                this.f3893f.i(list);
                for (UseCase useCase : list) {
                    if (this.f3898k.contains(useCase)) {
                        useCase.A(this.f3893f);
                    } else {
                        Logger.c("CameraUseCaseAdapter", "Attempting to detach non-attached UseCase: " + useCase);
                    }
                }
                this.f3898k.removeAll(list);
            }
        }
    }

    @NonNull
    public static CameraId w(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    private Map<UseCase, ConfigPair> y(List<UseCase> list, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap hashMap = new HashMap();
        for (UseCase useCase : list) {
            hashMap.put(useCase, new ConfigPair(useCase.h(false, useCaseConfigFactory), useCase.h(true, useCaseConfigFactory2)));
        }
        return hashMap;
    }

    public void H(@NonNull Collection<UseCase> collection) {
        synchronized (this.f3902o) {
            u(new ArrayList(collection));
            if (A()) {
                this.f3905r.removeAll(collection);
                try {
                    k(Collections.emptyList());
                } catch (CameraException unused) {
                    throw new IllegalArgumentException("Failed to add extra fake Preview or ImageCapture use case!");
                }
            }
        }
    }

    public void J(List<CameraEffect> list) {
        synchronized (this.f3902o) {
            this.f3900m = list;
        }
    }

    public void K(ViewPort viewPort) {
        synchronized (this.f3902o) {
            this.f3899l = viewPort;
        }
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraControl b() {
        return this.f3893f.d();
    }

    public void f(boolean z7) {
        this.f3893f.f(z7);
    }

    @NonNull
    public CameraInfo g() {
        return this.f3893f.j();
    }

    public void k(@NonNull Collection<UseCase> collection) throws CameraException {
        synchronized (this.f3902o) {
            ArrayList<UseCase> arrayList = new ArrayList();
            for (UseCase useCase : collection) {
                if (this.f3898k.contains(useCase)) {
                    Logger.a("CameraUseCaseAdapter", "Attempting to attach already attached UseCase");
                } else {
                    arrayList.add(useCase);
                }
            }
            List<UseCase> arrayList2 = new ArrayList<>(this.f3898k);
            List<UseCase> emptyList = Collections.emptyList();
            List<UseCase> emptyList2 = Collections.emptyList();
            if (A()) {
                arrayList2.removeAll(this.f3905r);
                arrayList2.addAll(arrayList);
                emptyList = p(arrayList2, new ArrayList<>(this.f3905r));
                ArrayList arrayList3 = new ArrayList(emptyList);
                arrayList3.removeAll(this.f3905r);
                arrayList.addAll(arrayList3);
                emptyList2 = new ArrayList<>(this.f3905r);
                emptyList2.removeAll(emptyList);
            }
            Map<UseCase, ConfigPair> y7 = y(arrayList, this.f3901n.h(), this.f3896i);
            try {
                List<UseCase> arrayList4 = new ArrayList<>(this.f3898k);
                arrayList4.removeAll(emptyList2);
                Map<UseCase, Size> r7 = r(this.f3893f.j(), arrayList, arrayList4, y7);
                M(r7, collection);
                L(this.f3900m, collection);
                this.f3905r = emptyList;
                u(emptyList2);
                for (UseCase useCase2 : arrayList) {
                    ConfigPair configPair = y7.get(useCase2);
                    useCase2.x(this.f3893f, configPair.f3907a, configPair.f3908b);
                    useCase2.K((Size) Preconditions.g(r7.get(useCase2)));
                }
                this.f3898k.addAll(arrayList);
                if (this.f3903p) {
                    this.f3893f.h(arrayList);
                }
                for (UseCase useCase3 : arrayList) {
                    useCase3.v();
                }
            } catch (IllegalArgumentException e8) {
                throw new CameraException(e8.getMessage());
            }
        }
    }

    public void l(CameraConfig cameraConfig) {
        synchronized (this.f3902o) {
            if (cameraConfig == null) {
                cameraConfig = CameraConfigs.a();
            }
            if (!this.f3898k.isEmpty() && !this.f3901n.C().equals(cameraConfig.C())) {
                throw new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
            }
            this.f3901n = cameraConfig;
            this.f3893f.l(cameraConfig);
        }
    }

    public void n() {
        synchronized (this.f3902o) {
            if (!this.f3903p) {
                this.f3893f.h(this.f3898k);
                I();
                for (UseCase useCase : this.f3898k) {
                    useCase.v();
                }
                this.f3903p = true;
            }
        }
    }

    public void v() {
        synchronized (this.f3902o) {
            if (this.f3903p) {
                this.f3893f.i(new ArrayList(this.f3898k));
                o();
                this.f3903p = false;
            }
        }
    }

    @NonNull
    public CameraId x() {
        return this.f3897j;
    }

    @NonNull
    public List<UseCase> z() {
        ArrayList arrayList;
        synchronized (this.f3902o) {
            arrayList = new ArrayList(this.f3898k);
        }
        return arrayList;
    }
}
