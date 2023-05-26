package androidx.camera.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraX {

    /* renamed from: o  reason: collision with root package name */
    private static final Object f3063o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private static final SparseArray<Integer> f3064p = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final CameraXConfig f3067c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f3068d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f3069e;

    /* renamed from: f  reason: collision with root package name */
    private final HandlerThread f3070f;

    /* renamed from: g  reason: collision with root package name */
    private CameraFactory f3071g;

    /* renamed from: h  reason: collision with root package name */
    private CameraDeviceSurfaceManager f3072h;

    /* renamed from: i  reason: collision with root package name */
    private UseCaseConfigFactory f3073i;

    /* renamed from: j  reason: collision with root package name */
    private Context f3074j;

    /* renamed from: k  reason: collision with root package name */
    private final ListenableFuture<Void> f3075k;

    /* renamed from: n  reason: collision with root package name */
    private final Integer f3078n;

    /* renamed from: a  reason: collision with root package name */
    final CameraRepository f3065a = new CameraRepository();

    /* renamed from: b  reason: collision with root package name */
    private final Object f3066b = new Object();

    /* renamed from: l  reason: collision with root package name */
    private InternalInitState f3076l = InternalInitState.UNINITIALIZED;

    /* renamed from: m  reason: collision with root package name */
    private ListenableFuture<Void> f3077m = Futures.h(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    public CameraX(@NonNull Context context, CameraXConfig.Provider provider) {
        if (provider != null) {
            this.f3067c = provider.getCameraXConfig();
        } else {
            CameraXConfig.Provider f8 = f(context);
            if (f8 != null) {
                this.f3067c = f8.getCameraXConfig();
            } else {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
        }
        Executor I = this.f3067c.I(null);
        Handler L = this.f3067c.L(null);
        this.f3068d = I == null ? new CameraExecutor() : I;
        if (L == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.f3070f = handlerThread;
            handlerThread.start();
            this.f3069e = HandlerCompat.a(handlerThread.getLooper());
        } else {
            this.f3070f = null;
            this.f3069e = L;
        }
        Integer num = (Integer) this.f3067c.e(CameraXConfig.G, null);
        this.f3078n = num;
        i(num);
        this.f3075k = k(context);
    }

    private static CameraXConfig.Provider f(@NonNull Context context) {
        String str;
        Application b8 = ContextUtil.b(context);
        if (b8 instanceof CameraXConfig.Provider) {
            return (CameraXConfig.Provider) b8;
        }
        try {
            Context a8 = ContextUtil.a(context);
            Bundle bundle = a8.getPackageManager().getServiceInfo(new ComponentName(a8, MetadataHolderService.class), 640).metaData;
            if (bundle != null) {
                str = bundle.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER");
            } else {
                str = null;
            }
            if (str == null) {
                Logger.c("CameraX", "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
                return null;
            }
            return (CameraXConfig.Provider) Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e8) {
            Logger.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e8);
            return null;
        }
    }

    private static void i(Integer num) {
        synchronized (f3063o) {
            if (num == null) {
                return;
            }
            Preconditions.c(num.intValue(), 3, 6, "minLogLevel");
            SparseArray<Integer> sparseArray = f3064p;
            int i8 = 1;
            if (sparseArray.get(num.intValue()) != null) {
                i8 = 1 + sparseArray.get(num.intValue()).intValue();
            }
            sparseArray.put(num.intValue(), Integer.valueOf(i8));
            p();
        }
    }

    private void j(@NonNull final Executor executor, final long j8, @NonNull final Context context, @NonNull final CallbackToFutureAdapter.Completer<Void> completer) {
        executor.execute(new Runnable() { // from class: androidx.camera.core.f
            @Override // java.lang.Runnable
            public final void run() {
                CameraX.this.m(context, executor, completer, j8);
            }
        });
    }

    private ListenableFuture<Void> k(@NonNull final Context context) {
        boolean z7;
        ListenableFuture<Void> a8;
        synchronized (this.f3066b) {
            if (this.f3076l == InternalInitState.UNINITIALIZED) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "CameraX.initInternal() should only be called once per instance");
            this.f3076l = InternalInitState.INITIALIZING;
            a8 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.e
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object a(CallbackToFutureAdapter.Completer completer) {
                    Object n8;
                    n8 = CameraX.this.n(context, completer);
                    return n8;
                }
            });
        }
        return a8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Executor executor, long j8, CallbackToFutureAdapter.Completer completer) {
        j(executor, j8, this.f3074j, completer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Context context, final Executor executor, final CallbackToFutureAdapter.Completer completer, final long j8) {
        try {
            Application b8 = ContextUtil.b(context);
            this.f3074j = b8;
            if (b8 == null) {
                this.f3074j = ContextUtil.a(context);
            }
            CameraFactory.Provider J = this.f3067c.J(null);
            if (J != null) {
                CameraThreadConfig a8 = CameraThreadConfig.a(this.f3068d, this.f3069e);
                CameraSelector H = this.f3067c.H(null);
                this.f3071g = J.a(this.f3074j, a8, H);
                CameraDeviceSurfaceManager.Provider K = this.f3067c.K(null);
                if (K != null) {
                    this.f3072h = K.a(this.f3074j, this.f3071g.c(), this.f3071g.b());
                    UseCaseConfigFactory.Provider M = this.f3067c.M(null);
                    if (M != null) {
                        this.f3073i = M.a(this.f3074j);
                        if (executor instanceof CameraExecutor) {
                            ((CameraExecutor) executor).c(this.f3071g);
                        }
                        this.f3065a.b(this.f3071g);
                        CameraValidator.a(this.f3074j, this.f3065a, H);
                        o();
                        completer.c(null);
                        return;
                    }
                    throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
                }
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
            }
            throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
        } catch (InitializationException | CameraValidator.CameraIdListIncorrectException | RuntimeException e8) {
            if (SystemClock.elapsedRealtime() - j8 < 2500) {
                Logger.l("CameraX", "Retry init. Start time " + j8 + " current time " + SystemClock.elapsedRealtime(), e8);
                HandlerCompat.b(this.f3069e, new Runnable() { // from class: androidx.camera.core.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraX.this.l(executor, j8, completer);
                    }
                }, "retry_token", 500L);
                return;
            }
            synchronized (this.f3066b) {
                this.f3076l = InternalInitState.INITIALIZING_ERROR;
            }
            if (e8 instanceof CameraValidator.CameraIdListIncorrectException) {
                Logger.c("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                completer.c(null);
            } else if (e8 instanceof InitializationException) {
                completer.f(e8);
            } else {
                completer.f(new InitializationException(e8));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Context context, CallbackToFutureAdapter.Completer completer) throws Exception {
        j(this.f3068d, SystemClock.elapsedRealtime(), context, completer);
        return "CameraX initInternal";
    }

    private void o() {
        synchronized (this.f3066b) {
            this.f3076l = InternalInitState.INITIALIZED;
        }
    }

    private static void p() {
        SparseArray<Integer> sparseArray = f3064p;
        if (sparseArray.size() == 0) {
            Logger.h();
        } else if (sparseArray.get(3) != null) {
            Logger.i(3);
        } else if (sparseArray.get(4) != null) {
            Logger.i(4);
        } else if (sparseArray.get(5) != null) {
            Logger.i(5);
        } else if (sparseArray.get(6) != null) {
            Logger.i(6);
        }
    }

    @NonNull
    public CameraDeviceSurfaceManager d() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.f3072h;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    public CameraRepository e() {
        return this.f3065a;
    }

    @NonNull
    public UseCaseConfigFactory g() {
        UseCaseConfigFactory useCaseConfigFactory = this.f3073i;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    public ListenableFuture<Void> h() {
        return this.f3075k;
    }
}
