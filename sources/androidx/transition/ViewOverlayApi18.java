package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f7884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOverlayApi18(@NonNull View view) {
        this.f7884a = view.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void a(@NonNull Drawable drawable) {
        this.f7884a.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void b(@NonNull Drawable drawable) {
        this.f7884a.remove(drawable);
    }
}
