package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f7882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupOverlayApi18(@NonNull ViewGroup viewGroup) {
        this.f7882a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void a(@NonNull Drawable drawable) {
        this.f7882a.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void b(@NonNull Drawable drawable) {
        this.f7882a.remove(drawable);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void c(@NonNull View view) {
        this.f7882a.add(view);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void d(@NonNull View view) {
        this.f7882a.remove(view);
    }
}
