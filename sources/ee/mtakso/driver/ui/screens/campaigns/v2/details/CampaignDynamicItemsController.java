package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignConditionDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDynamicItemsController.kt */
/* loaded from: classes3.dex */
public final class CampaignDynamicItemsController {

    /* renamed from: a  reason: collision with root package name */
    private final View f27463a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<CampaignConditionDelegate.Model, Unit> f27464b;

    /* renamed from: c  reason: collision with root package name */
    private final DiffAdapter f27465c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f27466d;

    /* JADX WARN: Multi-variable type inference failed */
    public CampaignDynamicItemsController(View containerView, Function1<? super CampaignConditionDelegate.Model, Unit> onInfoClicked) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(onInfoClicked, "onInfoClicked");
        this.f27466d = new LinkedHashMap();
        this.f27463a = containerView;
        this.f27464b = onInfoClicked;
        DiffAdapter P = new DiffAdapter().P(new CampaignConditionDelegate(onInfoClicked)).P(new CampaignNoteDelegate()).P(new InfoBlockDelegate());
        this.f27465c = P;
        int i8 = R.id.H9;
        ((RecyclerView) a(i8)).setLayoutManager(new LinearLayoutManager(c().getContext()));
        ((RecyclerView) a(i8)).setAdapter(P);
        ((RecyclerView) a(i8)).h(new ListItemDividerDecoration(Dimens.b(24.0f)));
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27466d;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View c8 = c();
            if (c8 == null || (findViewById = c8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void b(CampaignDynamicItemsState state) {
        Intrinsics.f(state, "state");
        DiffAdapter.V(this.f27465c, state.a(), null, 2, null);
    }

    public View c() {
        return this.f27463a;
    }
}
