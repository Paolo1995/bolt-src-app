package eu.bolt.driver.stories.ui.screen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import eu.bolt.android.stories.model.Story;
import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.util.SingleExtKt;
import eu.bolt.driver.stories.network.StoriesClient;
import eu.bolt.driver.stories.ui.screen.StorySetViewModel;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySetViewModel.kt */
/* loaded from: classes5.dex */
public final class StorySetViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final StoriesClient f41572f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<Story> f41573g;

    @Inject
    public StorySetViewModel(StoriesClient storiesClient) {
        Intrinsics.f(storiesClient, "storiesClient");
        this.f41572f = storiesClient;
        this.f41573g = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.core.ui.base.mvvm.BaseViewModel
    public void n() {
        Kalev.k("Story view model works");
    }

    public final LiveData<Story> s() {
        return this.f41573g;
    }

    public final void t(String storyId) {
        Intrinsics.f(storyId, "storyId");
        Single d8 = d(SingleExtKt.a(this.f41572f.c(storyId)));
        final Function1<Story, Unit> function1 = new Function1<Story, Unit>() { // from class: eu.bolt.driver.stories.ui.screen.StorySetViewModel$requestStory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Story story) {
                MutableLiveData mutableLiveData;
                mutableLiveData = StorySetViewModel.this.f41573g;
                mutableLiveData.o(story);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Story story) {
                b(story);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: i7.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StorySetViewModel.u(Function1.this, obj);
            }
        };
        final StorySetViewModel$requestStory$2 storySetViewModel$requestStory$2 = new StorySetViewModel$requestStory$2(this);
        Disposable I = d8.I(consumer, new Consumer() { // from class: i7.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StorySetViewModel.v(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun requestStory(storyId…     .autoDispose()\n    }");
        h(I);
    }
}
