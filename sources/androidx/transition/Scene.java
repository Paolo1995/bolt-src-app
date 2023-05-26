package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Scene {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f7829a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f7830b;

    public static Scene b(@NonNull ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R$id.f7827c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(@NonNull ViewGroup viewGroup, Scene scene) {
        viewGroup.setTag(R$id.f7827c, scene);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f7829a) == this && (runnable = this.f7830b) != null) {
            runnable.run();
        }
    }
}
