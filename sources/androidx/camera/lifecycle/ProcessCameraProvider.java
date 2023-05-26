package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessCameraProvider {

    /* renamed from: h  reason: collision with root package name */
    private static final ProcessCameraProvider f4065h = new ProcessCameraProvider();

    /* renamed from: c  reason: collision with root package name */
    private ListenableFuture<CameraX> f4068c;

    /* renamed from: f  reason: collision with root package name */
    private CameraX f4071f;

    /* renamed from: g  reason: collision with root package name */
    private Context f4072g;

    /* renamed from: a  reason: collision with root package name */
    private final Object f4066a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private CameraXConfig.Provider f4067b = null;

    /* renamed from: d  reason: collision with root package name */
    private ListenableFuture<Void> f4069d = Futures.h(null);

    /* renamed from: e  reason: collision with root package name */
    private final LifecycleCameraRepository f4070e = new LifecycleCameraRepository();

    private ProcessCameraProvider() {
    }

    @NonNull
    public static ListenableFuture<ProcessCameraProvider> f(@NonNull final Context context) {
        Preconditions.g(context);
        return Futures.o(f4065h.g(context), new Function() { // from class: androidx.camera.lifecycle.a
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                ProcessCameraProvider h8;
                h8 = ProcessCameraProvider.h(context, (CameraX) obj);
                return h8;
            }
        }, CameraXExecutors.a());
    }

    private ListenableFuture<CameraX> g(@NonNull Context context) {
        synchronized (this.f4066a) {
            ListenableFuture<CameraX> listenableFuture = this.f4068c;
            if (listenableFuture != null) {
                return listenableFuture;
            }
            final CameraX cameraX = new CameraX(context, this.f4067b);
            ListenableFuture<CameraX> a8 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.lifecycle.b
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object a(CallbackToFutureAdapter.Completer completer) {
                    Object j8;
                    j8 = ProcessCameraProvider.this.j(cameraX, completer);
                    return j8;
                }
            });
            this.f4068c = a8;
            return a8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ProcessCameraProvider h(Context context, CameraX cameraX) {
        ProcessCameraProvider processCameraProvider = f4065h;
        processCameraProvider.k(cameraX);
        processCameraProvider.l(ContextUtil.a(context));
        return processCameraProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object j(final CameraX cameraX, final CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.f4066a) {
            Futures.b(FutureChain.a(this.f4069d).e(new AsyncFunction() { // from class: androidx.camera.lifecycle.c
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    ListenableFuture h8;
                    Void r22 = (Void) obj;
                    h8 = CameraX.this.h();
                    return h8;
                }
            }, CameraXExecutors.a()), new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                /* renamed from: a */
                public void onSuccess(Void r22) {
                    completer.c(cameraX);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    completer.f(th);
                }
            }, CameraXExecutors.a());
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    private void k(CameraX cameraX) {
        this.f4071f = cameraX;
    }

    private void l(Context context) {
        this.f4072g = context;
    }

    @NonNull
    Camera d(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, ViewPort viewPort, @NonNull List<CameraEffect> list, @NonNull UseCase... useCaseArr) {
        CameraConfig cameraConfig;
        CameraConfig a8;
        Threads.a();
        CameraSelector.Builder c8 = CameraSelector.Builder.c(cameraSelector);
        int length = useCaseArr.length;
        int i8 = 0;
        while (true) {
            cameraConfig = null;
            if (i8 >= length) {
                break;
            }
            CameraSelector D = useCaseArr[i8].g().D(null);
            if (D != null) {
                Iterator<CameraFilter> it = D.c().iterator();
                while (it.hasNext()) {
                    c8.a(it.next());
                }
            }
            i8++;
        }
        LinkedHashSet<CameraInternal> a9 = c8.b().a(this.f4071f.e().a());
        if (!a9.isEmpty()) {
            LifecycleCamera c9 = this.f4070e.c(lifecycleOwner, CameraUseCaseAdapter.w(a9));
            Collection<LifecycleCamera> e8 = this.f4070e.e();
            for (UseCase useCase : useCaseArr) {
                for (LifecycleCamera lifecycleCamera : e8) {
                    if (lifecycleCamera.p(useCase) && lifecycleCamera != c9) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", useCase));
                    }
                }
            }
            if (c9 == null) {
                c9 = this.f4070e.b(lifecycleOwner, new CameraUseCaseAdapter(a9, this.f4071f.d(), this.f4071f.g()));
            }
            Iterator<CameraFilter> it2 = cameraSelector.c().iterator();
            while (it2.hasNext()) {
                CameraFilter next = it2.next();
                if (next.a() != CameraFilter.f3051a && (a8 = ExtendedCameraConfigProviderStore.a(next.a()).a(c9.g(), this.f4072g)) != null) {
                    if (cameraConfig == null) {
                        cameraConfig = a8;
                    } else {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                }
            }
            c9.l(cameraConfig);
            if (useCaseArr.length == 0) {
                return c9;
            }
            this.f4070e.a(c9, viewPort, list, Arrays.asList(useCaseArr));
            return c9;
        }
        throw new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
    }

    @NonNull
    public Camera e(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCase... useCaseArr) {
        return d(lifecycleOwner, cameraSelector, null, Collections.emptyList(), useCaseArr);
    }

    public void m() {
        Threads.a();
        this.f4070e.k();
    }
}
