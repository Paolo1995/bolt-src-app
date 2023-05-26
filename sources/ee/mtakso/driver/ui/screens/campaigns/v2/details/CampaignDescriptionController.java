package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.BonusTrips;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDescriptionController.kt */
/* loaded from: classes3.dex */
public final class CampaignDescriptionController {

    /* renamed from: a  reason: collision with root package name */
    private final View f27425a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f27426b;

    /* compiled from: CampaignDescriptionController.kt */
    /* loaded from: classes3.dex */
    public static final class Model {

        /* renamed from: a  reason: collision with root package name */
        private final Text f27427a;

        /* renamed from: b  reason: collision with root package name */
        private final BonusTrips f27428b;

        public Model(Text description, BonusTrips bonusTrips) {
            Intrinsics.f(description, "description");
            this.f27427a = description;
            this.f27428b = bonusTrips;
        }

        public final BonusTrips a() {
            return this.f27428b;
        }

        public final Text b() {
            return this.f27427a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(this.f27427a, model.f27427a) && Intrinsics.a(this.f27428b, model.f27428b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f27427a.hashCode() * 31;
            BonusTrips bonusTrips = this.f27428b;
            return hashCode + (bonusTrips == null ? 0 : bonusTrips.hashCode());
        }

        public String toString() {
            Text text = this.f27427a;
            BonusTrips bonusTrips = this.f27428b;
            return "Model(description=" + text + ", bonusTrips=" + bonusTrips + ")";
        }
    }

    public CampaignDescriptionController(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f27426b = new LinkedHashMap();
        this.f27425a = containerView;
    }

    private final void c(BonusTrips bonusTrips) {
        if (bonusTrips == null) {
            Group bonusGroup = (Group) a(R.id.bonusGroup);
            Intrinsics.e(bonusGroup, "bonusGroup");
            ViewExtKt.d(bonusGroup, false, 0, 2, null);
            return;
        }
        Group bonusGroup2 = (Group) a(R.id.bonusGroup);
        Intrinsics.e(bonusGroup2, "bonusGroup");
        ViewExtKt.d(bonusGroup2, true, 0, 2, null);
        ((TextView) a(R.id.gc)).setText(bonusTrips.a());
        if (Intrinsics.a(bonusTrips.b(), "-")) {
            int i8 = R.id.statusNonText;
            TextView statusNonText = (TextView) a(i8);
            Intrinsics.e(statusNonText, "statusNonText");
            ViewExtKt.d(statusNonText, true, 0, 2, null);
            TextView statusText = (TextView) a(R.id.lb);
            Intrinsics.e(statusText, "statusText");
            ViewExtKt.d(statusText, false, 0, 2, null);
            ((TextView) a(i8)).setText(bonusTrips.b());
            return;
        }
        TextView statusNonText2 = (TextView) a(R.id.statusNonText);
        Intrinsics.e(statusNonText2, "statusNonText");
        ViewExtKt.d(statusNonText2, false, 0, 2, null);
        int i9 = R.id.lb;
        TextView statusText2 = (TextView) a(i9);
        Intrinsics.e(statusText2, "statusText");
        ViewExtKt.d(statusText2, true, 0, 2, null);
        ((TextView) a(i9)).setText(bonusTrips.b());
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27426b;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View d8 = d();
            if (d8 == null || (findViewById = d8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void b(Model model) {
        Intrinsics.f(model, "model");
        int i8 = R.id.f19834o3;
        Text b8 = model.b();
        Context context = ((TextView) a(i8)).getContext();
        Intrinsics.e(context, "descriptionText.context");
        ((TextView) a(i8)).setText(TextKt.a(b8, context));
        ((TextView) a(i8)).setMovementMethod(LinkMovementMethod.getInstance());
        c(model.a());
    }

    public View d() {
        return this.f27425a;
    }
}
