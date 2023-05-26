package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class TintResources extends ResourcesWrapper {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f2206b;

    public TintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f2206b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i8) throws Resources.NotFoundException {
        Drawable a8 = a(i8);
        Context context = this.f2206b.get();
        if (a8 != null && context != null) {
            ResourceManagerInternal.h().x(context, i8, a8);
        }
        return a8;
    }
}
