package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* loaded from: classes.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void a() {
        ((GifDrawable) this.f10516f).e().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return ((GifDrawable) this.f10516f).i();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        ((GifDrawable) this.f10516f).stop();
        ((GifDrawable) this.f10516f).k();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<GifDrawable> d() {
        return GifDrawable.class;
    }
}
