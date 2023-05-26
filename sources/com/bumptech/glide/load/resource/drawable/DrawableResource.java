package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: f  reason: collision with root package name */
    protected final T f10516f;

    public DrawableResource(T t7) {
        this.f10516f = (T) Preconditions.d(t7);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void a() {
        T t7 = this.f10516f;
        if (t7 instanceof BitmapDrawable) {
            ((BitmapDrawable) t7).getBitmap().prepareToDraw();
        } else if (t7 instanceof GifDrawable) {
            ((GifDrawable) t7).e().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: e */
    public final T get() {
        Drawable.ConstantState constantState = this.f10516f.getConstantState();
        if (constantState == null) {
            return this.f10516f;
        }
        return (T) constantState.newDrawable();
    }
}
