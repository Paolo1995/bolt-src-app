package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface ThreadConfig extends ReadableConfig {

    /* renamed from: y  reason: collision with root package name */
    public static final Config.Option<Executor> f3912y = Config.Option.a("camerax.core.thread.backgroundExecutor", Executor.class);
}
