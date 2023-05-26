package eu.bolt.driver.stories.network;

import eu.bolt.android.stories.model.Story;
import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoriesClient.kt */
/* loaded from: classes5.dex */
public final class StoriesClient {

    /* renamed from: a  reason: collision with root package name */
    private final StoriesApi f41545a;

    @Inject
    public StoriesClient(StoriesApi api) {
        Intrinsics.f(api, "api");
        this.f41545a = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Story d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Story) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StoriesPreviewsResponse f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (StoriesPreviewsResponse) tmp0.invoke(obj);
    }

    public final Single<Story> c(String storyId) {
        Intrinsics.f(storyId, "storyId");
        Single<ServerResponse<Story>> b8 = this.f41545a.b(storyId);
        final StoriesClient$getStories$1 storiesClient$getStories$1 = new Function1<ServerResponse<Story>, Story>() { // from class: eu.bolt.driver.stories.network.StoriesClient$getStories$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Story invoke(ServerResponse<Story> it) {
                Intrinsics.f(it, "it");
                return (Story) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: eu.bolt.driver.stories.network.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Story d8;
                d8 = StoriesClient.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(x7, "api.getStories(storyId).map { it.exposeData() }");
        return x7;
    }

    public final Single<StoriesPreviewsResponse> e() {
        Single<ServerResponse<StoriesPreviewsResponse>> a8 = this.f41545a.a();
        final StoriesClient$getStoriesPreviews$1 storiesClient$getStoriesPreviews$1 = new Function1<ServerResponse<StoriesPreviewsResponse>, StoriesPreviewsResponse>() { // from class: eu.bolt.driver.stories.network.StoriesClient$getStoriesPreviews$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final StoriesPreviewsResponse invoke(ServerResponse<StoriesPreviewsResponse> it) {
                Intrinsics.f(it, "it");
                return (StoriesPreviewsResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: eu.bolt.driver.stories.network.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                StoriesPreviewsResponse f8;
                f8 = StoriesClient.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(x7, "api.getStoriesPreviews().map { it.exposeData() }");
        return x7;
    }
}
