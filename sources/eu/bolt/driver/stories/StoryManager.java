package eu.bolt.driver.stories;

import eu.bolt.driver.core.ui.common.activity.SimpleAuthorisedActivity;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.impl.AnimationResources;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryManager.kt */
/* loaded from: classes5.dex */
public final class StoryManager {
    public static /* synthetic */ RoutingCommand b(StoryManager storyManager, List list, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = true;
        }
        return storyManager.a(list, z7);
    }

    public final RoutingCommand a(List<String> storyIds, boolean z7) {
        Intrinsics.f(storyIds, "storyIds");
        return SimpleAuthorisedActivity.Companion.c(SimpleAuthorisedActivity.f41067q, StorySetFragment.class, StorySetFragment.f41557p.a(storyIds, z7), 0, new AnimationResources(R$anim.story_enter, R$anim.story_exit), 4, null);
    }
}
