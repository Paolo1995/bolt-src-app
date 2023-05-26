package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public interface CameraConfig extends ReadableConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final Config.Option<UseCaseConfigFactory> f3584a = Config.Option.a("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);

    /* renamed from: b  reason: collision with root package name */
    public static final Config.Option<Identifier> f3585b = Config.Option.a("camerax.core.camera.compatibilityId", Identifier.class);

    /* renamed from: c  reason: collision with root package name */
    public static final Config.Option<Integer> f3586c = Config.Option.a("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);

    /* renamed from: d  reason: collision with root package name */
    public static final Config.Option<SessionProcessor> f3587d = Config.Option.a("camerax.core.camera.SessionProcessor", SessionProcessor.class);

    /* renamed from: e  reason: collision with root package name */
    public static final Config.Option<Boolean> f3588e = Config.Option.a("camerax.core.camera.isZslDisabled", Boolean.class);

    @NonNull
    Identifier C();

    SessionProcessor G(SessionProcessor sessionProcessor);

    @NonNull
    UseCaseConfigFactory h();

    int s();
}
