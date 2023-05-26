package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2198c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<TintContextWrapper>> f2199d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f2200a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f2201b;

    private TintContextWrapper(@NonNull Context context) {
        super(context);
        if (VectorEnabledTintResources.d()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.f2200a = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.f2201b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f2200a = new TintResources(this, context.getResources());
        this.f2201b = null;
    }

    private static boolean a(@NonNull Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources) || !VectorEnabledTintResources.d()) {
            return false;
        }
        return true;
    }

    public static Context b(@NonNull Context context) {
        TintContextWrapper tintContextWrapper;
        if (a(context)) {
            synchronized (f2198c) {
                ArrayList<WeakReference<TintContextWrapper>> arrayList = f2199d;
                if (arrayList == null) {
                    f2199d = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<TintContextWrapper> weakReference = f2199d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f2199d.remove(size);
                        }
                    }
                    for (int size2 = f2199d.size() - 1; size2 >= 0; size2--) {
                        WeakReference<TintContextWrapper> weakReference2 = f2199d.get(size2);
                        if (weakReference2 != null) {
                            tintContextWrapper = weakReference2.get();
                        } else {
                            tintContextWrapper = null;
                        }
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                    }
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                f2199d.add(new WeakReference<>(tintContextWrapper2));
                return tintContextWrapper2;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f2200a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f2200a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2201b;
        if (theme == null) {
            return super.getTheme();
        }
        return theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i8) {
        Resources.Theme theme = this.f2201b;
        if (theme == null) {
            super.setTheme(i8);
        } else {
            theme.applyStyle(i8, true);
        }
    }
}
