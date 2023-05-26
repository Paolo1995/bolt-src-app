package ee.mtakso.driver.ui.interactor.rateme;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Text;
import io.reactivex.Single;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeFetchCategoriesInteractor.kt */
/* loaded from: classes3.dex */
public final class RateMeFetchCategoriesInteractor {
    private final List<RateMeCategory> a() {
        List n8;
        List n9;
        List n10;
        List n11;
        List n12;
        List n13;
        List<RateMeCategory> n14;
        Text.Resource resource = new Text.Resource(R.string.rateme_category_earnings, null, 2, null);
        n8 = CollectionsKt__CollectionsKt.n(new RateMeItem("Low earnings/High commission", new Text.Resource(R.string.rateme_item_price_earnings_price_lowearnings, null, 2, null)), new RateMeItem("Incorrect price estimations", new Text.Resource(R.string.rateme_item_price_earnings_incorrect_price, null, 2, null)), new RateMeItem("Balances/Earnings aren’t updated", new Text.Resource(R.string.rateme_item_price_earnings_noupdate, null, 2, null)), new RateMeItem("I’m not getting cash trips", new Text.Resource(R.string.rateme_item_price_earnings_no_cashtrips, null, 2, null)), new RateMeItem("Issues with ‘Pay to Bolt’", new Text.Resource(R.string.rateme_item_price_earnings_paytobolt, null, 2, null)), new RateMeItem("Price review takes too long", new Text.Resource(R.string.rateme_item_price_earnings_pricereview, null, 2, null)), new RateMeItem("Other earnings issues", new Text.Resource(R.string.rateme_item_price_earnings_other, null, 2, null)));
        Text.Resource resource2 = new Text.Resource(R.string.rateme_category_navigation, null, 2, null);
        n9 = CollectionsKt__CollectionsKt.n(new RateMeItem("Navigation/GPS issues", new Text.Resource(R.string.rateme_item_price_navigation_gps, null, 2, null)), new RateMeItem("Wrong estimated arrival times", new Text.Resource(R.string.rateme_item_price_navigation_eta, null, 2, null)), new RateMeItem("Incorrect pick-up locations", new Text.Resource(R.string.rateme_item_price_navigation_location, null, 2, null)), new RateMeItem("The route is not updating", new Text.Resource(R.string.rateme_item_price_navigation_noupdate, null, 2, null)), new RateMeItem("Other navigation issues", new Text.Resource(R.string.rateme_item_price_navigation_other, null, 2, null)));
        Text.Resource resource3 = new Text.Resource(R.string.rateme_category_safety, null, 2, null);
        n10 = CollectionsKt__CollectionsKt.n(new RateMeItem("I receive too many orders from dangerous areas", new Text.Resource(R.string.rateme_item_safety_drop, null, 2, null)), new RateMeItem("I encounter aggressive riders", new Text.Resource(R.string.rateme_item_safety_aggression, null, 2, null)), new RateMeItem("Other safety issues", new Text.Resource(R.string.rateme_item_safety_other, null, 2, null)));
        Text.Resource resource4 = new Text.Resource(R.string.rateme_category_account, null, 2, null);
        n11 = CollectionsKt__CollectionsKt.n(new RateMeItem("Drop in rating/activity", new Text.Resource(R.string.rateme_item_account_rating, null, 2, null)), new RateMeItem("Blocking of my account", new Text.Resource(R.string.rateme_item_account_blocking, null, 2, null)), new RateMeItem("Account activation process/updating documents takes too long", new Text.Resource(R.string.rateme_item_account_activation, null, 2, null)), new RateMeItem("Other account issues", new Text.Resource(R.string.rateme_item_account_other, null, 2, null)));
        Text.Resource resource5 = new Text.Resource(R.string.rateme_category_tech, null, 2, null);
        n12 = CollectionsKt__CollectionsKt.n(new RateMeItem("The app frequently crashes", new Text.Resource(R.string.rateme_item_tech_crash, null, 2, null)), new RateMeItem("I have a lot of missed orders", new Text.Resource(R.string.rateme_item_tech_miss, null, 2, null)), new RateMeItem("I can’t cancel orders", new Text.Resource(R.string.rateme_item_tech_ends_cantcancel, null, 2, null)), new RateMeItem("I’m not receiving orders", new Text.Resource(R.string.rateme_item_tech_no_orders, null, 2, null)), new RateMeItem("The application is slow", new Text.Resource(R.string.rateme_item_tech_slow, null, 2, null)), new RateMeItem("Issues with ‘Pay to Bolt’", new Text.Resource(R.string.rateme_item_tech_paytobolt, null, 2, null)), new RateMeItem("The app automatically takes me offline", new Text.Resource(R.string.rateme_item_tech_offline, null, 2, null)), new RateMeItem("Errors when uploading documents", new Text.Resource(R.string.rateme_item_tech_docs, null, 2, null)), new RateMeItem("No sound notification for incoming ride requests", new Text.Resource(R.string.rateme_item_tech_sound, null, 2, null)), new RateMeItem("Other technical issues", new Text.Resource(R.string.rateme_item_tech_other, null, 2, null)));
        Text.Resource resource6 = new Text.Resource(R.string.rateme_category_other, null, 2, null);
        n13 = CollectionsKt__CollectionsKt.n(new RateMeItem("Slow responses from Customer Support", new Text.Resource(R.string.rateme_item_other_slow_support, null, 2, null)), new RateMeItem("Unhelpful answers from Customer Support", new Text.Resource(R.string.rateme_item_other_unhelpfull_support, null, 2, null)), new RateMeItem("I’m not receiving requests", new Text.Resource(R.string.rateme_item_other_no_requests, null, 2, null)), new RateMeItem("Bad Rider behaviour", new Text.Resource(R.string.rateme_item_other_bad_rider, null, 2, null)), new RateMeItem("My issue is not in the list", new Text.Resource(R.string.rateme_item_other_other, null, 2, null)));
        n14 = CollectionsKt__CollectionsKt.n(new RateMeCategory("Pricing/Earnings issues", R.drawable.ic_wallet_fill, resource, n8), new RateMeCategory("Map/Navigation issues", R.drawable.ic_my_location_fill, resource2, n9), new RateMeCategory("Trip safety", R.drawable.ic_safety_fill, resource3, n10), new RateMeCategory("Account issues", R.drawable.ic_driver_fill, resource4, n11), new RateMeCategory("Technical issues", R.drawable.ic_settings_fill, resource5, n12), new RateMeCategory("Other", R.drawable.ic_more, resource6, n13));
        return n14;
    }

    public final Single<List<RateMeCategory>> b() {
        Single<List<RateMeCategory>> w7 = Single.w(a());
        Intrinsics.e(w7, "just(createCategories())");
        return w7;
    }
}
