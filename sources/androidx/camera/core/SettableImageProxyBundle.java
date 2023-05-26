package androidx.camera.core;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class SettableImageProxyBundle implements ImageProxyBundle {

    /* renamed from: e  reason: collision with root package name */
    private final List<Integer> f3293e;

    /* renamed from: f  reason: collision with root package name */
    private String f3294f;

    /* renamed from: a  reason: collision with root package name */
    final Object f3289a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final SparseArray<CallbackToFutureAdapter.Completer<ImageProxy>> f3290b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<ListenableFuture<ImageProxy>> f3291c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageProxy> f3292d = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f3295g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettableImageProxyBundle(List<Integer> list, String str) {
        this.f3293e = list;
        this.f3294f = str;
        f();
    }

    private void f() {
        synchronized (this.f3289a) {
            for (Integer num : this.f3293e) {
                final int intValue = num.intValue();
                this.f3291c.put(intValue, CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver<ImageProxy>() { // from class: androidx.camera.core.SettableImageProxyBundle.1
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public Object a(@NonNull CallbackToFutureAdapter.Completer<ImageProxy> completer) {
                        synchronized (SettableImageProxyBundle.this.f3289a) {
                            SettableImageProxyBundle.this.f3290b.put(intValue, completer);
                        }
                        return "getImageProxy(id: " + intValue + ")";
                    }
                }));
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public List<Integer> a() {
        return Collections.unmodifiableList(this.f3293e);
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public ListenableFuture<ImageProxy> b(int i8) {
        ListenableFuture<ImageProxy> listenableFuture;
        synchronized (this.f3289a) {
            if (!this.f3295g) {
                listenableFuture = this.f3291c.get(i8);
                if (listenableFuture == null) {
                    throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + i8);
                }
            } else {
                throw new IllegalStateException("ImageProxyBundle already closed.");
            }
        }
        return listenableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageProxy imageProxy) {
        synchronized (this.f3289a) {
            if (this.f3295g) {
                return;
            }
            Integer num = (Integer) imageProxy.O0().b().c(this.f3294f);
            if (num != null) {
                CallbackToFutureAdapter.Completer<ImageProxy> completer = this.f3290b.get(num.intValue());
                if (completer != null) {
                    this.f3292d.add(imageProxy);
                    completer.c(imageProxy);
                    return;
                }
                throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + num);
            }
            throw new IllegalArgumentException("CaptureId is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        synchronized (this.f3289a) {
            if (this.f3295g) {
                return;
            }
            for (ImageProxy imageProxy : this.f3292d) {
                imageProxy.close();
            }
            this.f3292d.clear();
            this.f3291c.clear();
            this.f3290b.clear();
            this.f3295g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        synchronized (this.f3289a) {
            if (this.f3295g) {
                return;
            }
            for (ImageProxy imageProxy : this.f3292d) {
                imageProxy.close();
            }
            this.f3292d.clear();
            this.f3291c.clear();
            this.f3290b.clear();
            f();
        }
    }
}
