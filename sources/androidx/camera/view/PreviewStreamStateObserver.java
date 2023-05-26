package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PreviewStreamStateObserver implements Observable.Observer<CameraInternal.State> {

    /* renamed from: a  reason: collision with root package name */
    private final CameraInfoInternal f4080a;

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<PreviewView.StreamState> f4081b;

    /* renamed from: c  reason: collision with root package name */
    private PreviewView.StreamState f4082c;

    /* renamed from: d  reason: collision with root package name */
    private final PreviewViewImplementation f4083d;

    /* renamed from: e  reason: collision with root package name */
    ListenableFuture<Void> f4084e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4085f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewStreamStateObserver(CameraInfoInternal cameraInfoInternal, MutableLiveData<PreviewView.StreamState> mutableLiveData, PreviewViewImplementation previewViewImplementation) {
        this.f4080a = cameraInfoInternal;
        this.f4081b = mutableLiveData;
        this.f4083d = previewViewImplementation;
        synchronized (this) {
            this.f4082c = mutableLiveData.f();
        }
    }

    private void e() {
        ListenableFuture<Void> listenableFuture = this.f4084e;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.f4084e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture g(Void r12) throws Exception {
        return this.f4083d.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void h(Void r12) {
        l(PreviewView.StreamState.STREAMING);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object i(final CameraInfo cameraInfo, List list, final CallbackToFutureAdapter.Completer completer) throws Exception {
        CameraCaptureCallback cameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.view.PreviewStreamStateObserver.2
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void b(@NonNull CameraCaptureResult cameraCaptureResult) {
                completer.c(null);
                ((CameraInfoInternal) cameraInfo).e(this);
            }
        };
        list.add(cameraCaptureCallback);
        ((CameraInfoInternal) cameraInfo).b(CameraXExecutors.a(), cameraCaptureCallback);
        return "waitForCaptureResult";
    }

    private void k(final CameraInfo cameraInfo) {
        l(PreviewView.StreamState.IDLE);
        final ArrayList arrayList = new ArrayList();
        FutureChain d8 = FutureChain.a(m(cameraInfo, arrayList)).e(new AsyncFunction() { // from class: androidx.camera.view.a
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture g8;
                g8 = PreviewStreamStateObserver.this.g((Void) obj);
                return g8;
            }
        }, CameraXExecutors.a()).d(new Function() { // from class: androidx.camera.view.b
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Void h8;
                h8 = PreviewStreamStateObserver.this.h((Void) obj);
                return h8;
            }
        }, CameraXExecutors.a());
        this.f4084e = d8;
        Futures.b(d8, new FutureCallback<Void>() { // from class: androidx.camera.view.PreviewStreamStateObserver.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r22) {
                PreviewStreamStateObserver.this.f4084e = null;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                PreviewStreamStateObserver.this.f4084e = null;
                if (!arrayList.isEmpty()) {
                    for (CameraCaptureCallback cameraCaptureCallback : arrayList) {
                        ((CameraInfoInternal) cameraInfo).e(cameraCaptureCallback);
                    }
                    arrayList.clear();
                }
            }
        }, CameraXExecutors.a());
    }

    private ListenableFuture<Void> m(final CameraInfo cameraInfo, final List<CameraCaptureCallback> list) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.c
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object i8;
                i8 = PreviewStreamStateObserver.this.i(cameraInfo, list, completer);
                return i8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        e();
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    /* renamed from: j */
    public void a(CameraInternal.State state) {
        if (state != CameraInternal.State.CLOSING && state != CameraInternal.State.CLOSED && state != CameraInternal.State.RELEASING && state != CameraInternal.State.RELEASED) {
            if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.f4085f) {
                k(this.f4080a);
                this.f4085f = true;
                return;
            }
            return;
        }
        l(PreviewView.StreamState.IDLE);
        if (this.f4085f) {
            this.f4085f = false;
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(PreviewView.StreamState streamState) {
        synchronized (this) {
            if (this.f4082c.equals(streamState)) {
                return;
            }
            this.f4082c = streamState;
            Logger.a("StreamStateObserver", "Update Preview stream state to " + streamState);
            this.f4081b.m(streamState);
        }
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    public void onError(@NonNull Throwable th) {
        f();
        l(PreviewView.StreamState.IDLE);
    }
}
