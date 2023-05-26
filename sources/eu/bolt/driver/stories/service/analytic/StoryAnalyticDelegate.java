package eu.bolt.driver.stories.service.analytic;

import eu.bolt.android.stories.analytics.StoryAnalyticListener;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryAnalyticDelegate.kt */
/* loaded from: classes5.dex */
public final class StoryAnalyticDelegate implements StoryAnalyticListener {

    /* renamed from: a  reason: collision with root package name */
    private final StoryAnalytics f41552a;

    @Inject
    public StoryAnalyticDelegate(StoryAnalytics storyAnalytics) {
        Intrinsics.f(storyAnalytics, "storyAnalytics");
        this.f41552a = storyAnalytics;
    }

    @Override // eu.bolt.android.stories.analytics.StoryAnalyticListener
    public void a(StoryAnalyticListener.ActionType actionType, String storyId, String slideId) {
        Intrinsics.f(actionType, "actionType");
        Intrinsics.f(storyId, "storyId");
        Intrinsics.f(slideId, "slideId");
        this.f41552a.W3(actionType.c(), storyId, slideId);
    }

    @Override // eu.bolt.android.stories.analytics.StoryAnalyticListener
    public void b(StoryAnalyticListener.CloseReason closeType, boolean z7, String storyId, String lastSeenSlideId) {
        Intrinsics.f(closeType, "closeType");
        Intrinsics.f(storyId, "storyId");
        Intrinsics.f(lastSeenSlideId, "lastSeenSlideId");
        this.f41552a.k4(closeType.c(), z7, storyId, lastSeenSlideId);
    }

    @Override // eu.bolt.android.stories.analytics.StoryAnalyticListener
    public void c(String storyId, String slideId) {
        Intrinsics.f(storyId, "storyId");
        Intrinsics.f(slideId, "slideId");
        this.f41552a.d(storyId, slideId);
    }

    @Override // eu.bolt.android.stories.analytics.StoryAnalyticListener
    public void d(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f41552a.Z(storyId);
    }
}
