package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class PreviewViewImplementation {

    /* renamed from: a  reason: collision with root package name */
    Size f4136a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    FrameLayout f4137b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final PreviewTransformation f4138c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4139d = false;

    /* loaded from: classes.dex */
    interface OnSurfaceNotInUseListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewViewImplementation(@NonNull FrameLayout frameLayout, @NonNull PreviewTransformation previewTransformation) {
        this.f4137b = frameLayout;
        this.f4138c = previewTransformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a() {
        Bitmap c8 = c();
        if (c8 == null) {
            return null;
        }
        return this.f4138c.a(c8, new Size(this.f4137b.getWidth(), this.f4137b.getHeight()), this.f4137b.getLayoutDirection());
    }

    abstract View b();

    abstract Bitmap c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f4139d = true;
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g(@NonNull SurfaceRequest surfaceRequest, OnSurfaceNotInUseListener onSurfaceNotInUseListener);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        View b8 = b();
        if (b8 != null && this.f4139d) {
            this.f4138c.q(new Size(this.f4137b.getWidth(), this.f4137b.getHeight()), this.f4137b.getLayoutDirection(), b8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(@NonNull Executor executor, @NonNull PreviewView.OnFrameUpdateListener onFrameUpdateListener);

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract ListenableFuture<Void> j();
}
