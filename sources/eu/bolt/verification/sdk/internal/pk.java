package eu.bolt.verification.sdk.internal;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class pk implements MembersInjector<eu.bolt.client.stories.view.singlestory.a> {
    @InjectedFieldSignature("eu.bolt.client.stories.view.singlestory.StoryView.storiesRepository")
    public static void a(eu.bolt.client.stories.view.singlestory.a aVar, bi biVar) {
        aVar.f40268f = biVar;
    }

    @InjectedFieldSignature("eu.bolt.client.stories.view.singlestory.StoryView.storyShareHelper")
    public static void b(eu.bolt.client.stories.view.singlestory.a aVar, rj rjVar) {
        aVar.f40270h = rjVar;
    }

    @InjectedFieldSignature("eu.bolt.client.stories.view.singlestory.StoryView.analyticsManager")
    public static void c(eu.bolt.client.stories.view.singlestory.a aVar, s sVar) {
        aVar.f40271i = sVar;
    }

    @InjectedFieldSignature("eu.bolt.client.stories.view.singlestory.StoryView.rxSchedulers")
    public static void d(eu.bolt.client.stories.view.singlestory.a aVar, xg xgVar) {
        aVar.f40269g = xgVar;
    }
}
