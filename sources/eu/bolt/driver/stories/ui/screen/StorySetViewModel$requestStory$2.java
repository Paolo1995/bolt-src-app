package eu.bolt.driver.stories.ui.screen;

import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StorySetViewModel.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class StorySetViewModel$requestStory$2 extends AdaptedFunctionReference implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StorySetViewModel$requestStory$2(Object obj) {
        super(1, obj, StorySetViewModel.class, "handleError", "handleError(Ljava/lang/Throwable;Ljava/lang/String;)V", 0);
    }

    public final void c(Throwable p02) {
        Intrinsics.f(p02, "p0");
        BaseViewModel.m((StorySetViewModel) this.f50976f, p02, null, 2, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        c(th);
        return Unit.f50853a;
    }
}
