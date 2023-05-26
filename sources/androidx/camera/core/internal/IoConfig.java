package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface IoConfig extends ReadableConfig {

    /* renamed from: v  reason: collision with root package name */
    public static final Config.Option<Executor> f3909v = Config.Option.a("camerax.core.io.ioExecutor", Executor.class);
}
