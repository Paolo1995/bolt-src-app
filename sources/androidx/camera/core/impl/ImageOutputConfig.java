package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config;
import java.util.List;

/* loaded from: classes.dex */
public interface ImageOutputConfig extends ReadableConfig {

    /* renamed from: g  reason: collision with root package name */
    public static final Config.Option<Integer> f3653g = Config.Option.a("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);

    /* renamed from: h  reason: collision with root package name */
    public static final Config.Option<Integer> f3654h;

    /* renamed from: i  reason: collision with root package name */
    public static final Config.Option<Integer> f3655i;

    /* renamed from: j  reason: collision with root package name */
    public static final Config.Option<Size> f3656j;

    /* renamed from: k  reason: collision with root package name */
    public static final Config.Option<Size> f3657k;

    /* renamed from: l  reason: collision with root package name */
    public static final Config.Option<Size> f3658l;

    /* renamed from: m  reason: collision with root package name */
    public static final Config.Option<List<Pair<Integer, Size[]>>> f3659m;

    static {
        Class cls = Integer.TYPE;
        f3654h = Config.Option.a("camerax.core.imageOutput.targetRotation", cls);
        f3655i = Config.Option.a("camerax.core.imageOutput.appTargetRotation", cls);
        f3656j = Config.Option.a("camerax.core.imageOutput.targetResolution", Size.class);
        f3657k = Config.Option.a("camerax.core.imageOutput.defaultResolution", Size.class);
        f3658l = Config.Option.a("camerax.core.imageOutput.maxResolution", Size.class);
        f3659m = Config.Option.a("camerax.core.imageOutput.supportedResolutions", List.class);
    }

    Size A(Size size);

    Size g(Size size);

    List<Pair<Integer, Size[]>> i(List<Pair<Integer, Size[]>> list);

    int q(int i8);

    boolean u();

    int w();

    int x(int i8);

    Size y(Size size);
}
