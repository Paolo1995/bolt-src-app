package eu.bolt.android.rib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import eu.bolt.android.rib.xray.XRay;

/* loaded from: classes5.dex */
public abstract class ViewBuilder<ViewType extends View, DependencyT> extends Builder<DependencyT> {
    public ViewBuilder(DependencyT dependencyt) {
        super(dependencyt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public final ViewType b(@NonNull ViewGroup viewGroup) {
        ViewType c8 = c(LayoutInflater.from(d(viewGroup.getContext())), viewGroup);
        XRay xRay = XRay.f37400a;
        if (xRay.c()) {
            xRay.a(this, c8);
        }
        return c8;
    }

    protected abstract ViewType c(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    protected Context d(Context context) {
        return context;
    }
}
