package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public interface ImageInputConfig extends ReadableConfig {

    /* renamed from: f  reason: collision with root package name */
    public static final Config.Option<Integer> f3652f = Config.Option.a("camerax.core.imageInput.inputFormat", Integer.TYPE);

    int getInputFormat();
}
