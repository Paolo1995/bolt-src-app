package ee.mtakso.driver.ui.interactor.inbox;

import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.ui.interactor.inbox.InboxItem;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.stories.model.StoryPreview;
import eu.bolt.driver.core.util.Optional;
import eu.bolt.driver.stories.network.StoriesClient;
import eu.bolt.driver.stories.network.StoriesPreviewsResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InboxItemsInteractor.kt */
/* loaded from: classes3.dex */
public final class InboxItemsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final CampaignManager f26564a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverConfig f26565b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapManager f26566c;

    /* renamed from: d  reason: collision with root package name */
    private final StoriesClient f26567d;

    @Inject
    public InboxItemsInteractor(CampaignManager campaignManager, DriverConfig driverConfig, CleverTapManager cleverTapManager, StoriesClient storiesClient) {
        Intrinsics.f(campaignManager, "campaignManager");
        Intrinsics.f(driverConfig, "driverConfig");
        Intrinsics.f(cleverTapManager, "cleverTapManager");
        Intrinsics.f(storiesClient, "storiesClient");
        this.f26564a = campaignManager;
        this.f26565b = driverConfig;
        this.f26566c = cleverTapManager;
        this.f26567d = storiesClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<InboxItem> d(int i8, int i9, StoriesPreviewsResponse storiesPreviewsResponse) {
        List<InboxItem> q8;
        List<StoryPreview> list;
        InboxItem.Campaigns campaigns = new InboxItem.Campaigns(i9);
        boolean z7 = true;
        q8 = CollectionsKt__CollectionsKt.q(new InboxItem.News(i8), campaigns);
        if (storiesPreviewsResponse != null) {
            list = storiesPreviewsResponse.a();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            z7 = false;
        }
        if (!z7) {
            q8.add(0, new InboxItem.StoriesPreviews(list));
        }
        if (this.f26565b.x()) {
            q8.add(InboxItem.BoltClub.f26559a);
        }
        if (this.f26565b.H()) {
            q8.add(new InboxItem.ScheduledRides(0));
        }
        return q8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.l(obj, obj2, obj3);
    }

    public final Observable<List<InboxItem>> e() {
        Observable<Integer> startWith = this.f26566c.s().startWith((Observable<Integer>) 0);
        Observable<Integer> startWith2 = this.f26564a.u().R().startWith((Observable<Integer>) 0);
        Observable<StoriesPreviewsResponse> R = this.f26567d.e().R();
        Intrinsics.e(R, "storiesClient.getStories…          .toObservable()");
        Observable g8 = ObservableExtKt.g(R);
        final InboxItemsInteractor$observeInboxItems$1 inboxItemsInteractor$observeInboxItems$1 = new Function1<StoriesPreviewsResponse, Optional<StoriesPreviewsResponse>>() { // from class: ee.mtakso.driver.ui.interactor.inbox.InboxItemsInteractor$observeInboxItems$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<StoriesPreviewsResponse> invoke(StoriesPreviewsResponse it) {
                Intrinsics.f(it, "it");
                return Optional.f41306b.b(it);
            }
        };
        Observable startWith3 = g8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.inbox.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional f8;
                f8 = InboxItemsInteractor.f(Function1.this, obj);
                return f8;
            }
        }).startWith((Observable) Optional.f41306b.a());
        final Function3<Integer, Integer, Optional<StoriesPreviewsResponse>, List<? extends InboxItem>> function3 = new Function3<Integer, Integer, Optional<StoriesPreviewsResponse>, List<? extends InboxItem>>() { // from class: ee.mtakso.driver.ui.interactor.inbox.InboxItemsInteractor$observeInboxItems$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            /* renamed from: b */
            public final List<InboxItem> l(Integer inbox, Integer campaigns, Optional<StoriesPreviewsResponse> optionalStories) {
                List<InboxItem> d8;
                Intrinsics.f(inbox, "inbox");
                Intrinsics.f(campaigns, "campaigns");
                Intrinsics.f(optionalStories, "optionalStories");
                d8 = InboxItemsInteractor.this.d(inbox.intValue(), campaigns.intValue(), optionalStories.b());
                return d8;
            }
        };
        Observable<List<InboxItem>> combineLatest = Observable.combineLatest(startWith, startWith2, startWith3, new io.reactivex.functions.Function3() { // from class: ee.mtakso.driver.ui.interactor.inbox.b
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                List g9;
                g9 = InboxItemsInteractor.g(Function3.this, obj, obj2, obj3);
                return g9;
            }
        });
        Intrinsics.e(combineLatest, "fun observeInboxItems():…OrNull())\n        }\n    }");
        return combineLatest;
    }
}
