package eu.bolt.driver.chat.ui;

import android.app.Activity;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatForegroundTracker.kt */
@Singleton
/* loaded from: classes5.dex */
public final class ChatForegroundTracker extends DefaultActivityLifecycleCallback {

    /* renamed from: f  reason: collision with root package name */
    private final ChatForegroundProvider f40507f;

    @Inject
    public ChatForegroundTracker(ChatForegroundProvider foregroundProvider) {
        Intrinsics.f(foregroundProvider, "foregroundProvider");
        this.f40507f = foregroundProvider;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.f(activity, "activity");
        this.f40507f.b(true);
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.f(activity, "activity");
        this.f40507f.b(false);
    }
}
