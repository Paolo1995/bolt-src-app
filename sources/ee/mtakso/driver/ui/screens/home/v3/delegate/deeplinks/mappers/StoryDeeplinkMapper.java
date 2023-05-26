package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.stories.StoryManager;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class StoryDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final StoryManager f29997a;

    @Inject
    public StoryDeeplinkMapper(StoryManager storyManager) {
        Intrinsics.f(storyManager, "storyManager");
        this.f29997a = storyManager;
    }

    public RoutingCommand a(DeeplinkCall.Story deeplink) {
        List e8;
        Intrinsics.f(deeplink, "deeplink");
        StoryManager storyManager = this.f29997a;
        e8 = CollectionsKt__CollectionsJVMKt.e(deeplink.b());
        return StoryManager.b(storyManager, e8, false, 2, null);
    }
}
