package androidx.camera.core.internal;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

/* loaded from: classes.dex */
public interface UseCaseEventConfig extends ReadableConfig {

    /* renamed from: z  reason: collision with root package name */
    public static final Config.Option<UseCase.EventCallback> f3913z = Config.Option.a("camerax.core.useCaseEventCallback", UseCase.EventCallback.class);

    UseCase.EventCallback E(UseCase.EventCallback eventCallback);
}
