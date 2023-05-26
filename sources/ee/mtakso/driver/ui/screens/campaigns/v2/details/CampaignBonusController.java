package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockController;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignBonusController.kt */
/* loaded from: classes3.dex */
public final class CampaignBonusController {

    /* renamed from: a  reason: collision with root package name */
    private final View f27401a;

    /* renamed from: b  reason: collision with root package name */
    private final InfoBlockController f27402b;

    /* renamed from: c  reason: collision with root package name */
    private final InfoBlockController f27403c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f27404d;

    /* compiled from: CampaignBonusController.kt */
    /* loaded from: classes3.dex */
    public static final class Model {

        /* renamed from: a  reason: collision with root package name */
        private final Image f27405a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f27406b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f27407c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f27408d;

        /* renamed from: e  reason: collision with root package name */
        private final Text f27409e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f27410f;

        /* renamed from: g  reason: collision with root package name */
        private final Text f27411g;

        /* renamed from: h  reason: collision with root package name */
        private final InfoBlockData f27412h;

        public Model(Image icon, Text title, Text text, Integer num, Text text2, Text text3, Text text4, InfoBlockData infoBlockData) {
            Intrinsics.f(icon, "icon");
            Intrinsics.f(title, "title");
            this.f27405a = icon;
            this.f27406b = title;
            this.f27407c = text;
            this.f27408d = num;
            this.f27409e = text2;
            this.f27410f = text3;
            this.f27411g = text4;
            this.f27412h = infoBlockData;
        }

        public final InfoBlockData a() {
            return this.f27412h;
        }

        public final Image b() {
            return this.f27405a;
        }

        public final Text c() {
            return this.f27407c;
        }

        public final Integer d() {
            return this.f27408d;
        }

        public final Text e() {
            return this.f27410f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(this.f27405a, model.f27405a) && Intrinsics.a(this.f27406b, model.f27406b) && Intrinsics.a(this.f27407c, model.f27407c) && Intrinsics.a(this.f27408d, model.f27408d) && Intrinsics.a(this.f27409e, model.f27409e) && Intrinsics.a(this.f27410f, model.f27410f) && Intrinsics.a(this.f27411g, model.f27411g) && Intrinsics.a(this.f27412h, model.f27412h);
            }
            return false;
        }

        public final Text f() {
            return this.f27409e;
        }

        public final Text g() {
            return this.f27411g;
        }

        public final Text h() {
            return this.f27406b;
        }

        public int hashCode() {
            int hashCode = ((this.f27405a.hashCode() * 31) + this.f27406b.hashCode()) * 31;
            Text text = this.f27407c;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Integer num = this.f27408d;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Text text2 = this.f27409e;
            int hashCode4 = (hashCode3 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Text text3 = this.f27410f;
            int hashCode5 = (hashCode4 + (text3 == null ? 0 : text3.hashCode())) * 31;
            Text text4 = this.f27411g;
            int hashCode6 = (hashCode5 + (text4 == null ? 0 : text4.hashCode())) * 31;
            InfoBlockData infoBlockData = this.f27412h;
            return hashCode6 + (infoBlockData != null ? infoBlockData.hashCode() : 0);
        }

        public String toString() {
            Image image = this.f27405a;
            Text text = this.f27406b;
            Text text2 = this.f27407c;
            Integer num = this.f27408d;
            Text text3 = this.f27409e;
            Text text4 = this.f27410f;
            Text text5 = this.f27411g;
            InfoBlockData infoBlockData = this.f27412h;
            return "Model(icon=" + image + ", title=" + text + ", subtitle=" + text2 + ", threshold=" + num + ", thresholdBefore=" + text3 + ", thresholdAfter=" + text4 + ", thresholdBonus=" + text5 + ", description=" + infoBlockData + ")";
        }
    }

    public CampaignBonusController(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f27404d = new LinkedHashMap();
        this.f27401a = containerView;
        View infoBlock = a(R.id.infoBlock);
        Intrinsics.e(infoBlock, "infoBlock");
        this.f27402b = new InfoBlockController(infoBlock);
        View infoBlockFootnote = a(R.id.infoBlockFootnote);
        Intrinsics.e(infoBlockFootnote, "infoBlockFootnote");
        this.f27403c = new InfoBlockController(infoBlockFootnote);
    }

    public static /* synthetic */ void c(CampaignBonusController campaignBonusController, Model model, InfoBlockData infoBlockData, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            infoBlockData = null;
        }
        campaignBonusController.b(model, infoBlockData);
    }

    private final void e(int i8) {
        boolean z7 = true;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        ((ImageView) a(R.id.ridesBeforeImage)).setImageResource(R.drawable.ic_dots_5_descending);
                        ((ImageView) a(R.id.ridesAfterImage)).setImageResource(R.drawable.ic_dots_10_descending);
                    } else {
                        ((ImageView) a(R.id.ridesBeforeImage)).setImageResource(R.drawable.ic_dots_4);
                        ((ImageView) a(R.id.ridesAfterImage)).setImageResource(R.drawable.ic_dots_11_descending);
                    }
                } else {
                    ((ImageView) a(R.id.ridesBeforeImage)).setImageResource(R.drawable.ic_dots_3);
                    ((ImageView) a(R.id.ridesAfterImage)).setImageResource(R.drawable.ic_dots_12_descending);
                }
            } else {
                ((ImageView) a(R.id.ridesBeforeImage)).setImageResource(R.drawable.ic_dots_2);
                ((ImageView) a(R.id.ridesAfterImage)).setImageResource(R.drawable.ic_dots_12_descending);
            }
        } else {
            ((ImageView) a(R.id.ridesBeforeImage)).setImageResource(R.drawable.ic_dot_1);
            ((ImageView) a(R.id.ridesAfterImage)).setImageResource(R.drawable.ic_dots_12_descending);
        }
        Group bonusGroup = (Group) a(R.id.bonusGroup);
        Intrinsics.e(bonusGroup, "bonusGroup");
        if (i8 <= 0) {
            z7 = false;
        }
        ViewExtKt.d(bonusGroup, z7, 0, 2, null);
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27404d;
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

    public final void b(Model model, InfoBlockData infoBlockData) {
        int i8;
        boolean z7;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        Intrinsics.f(model, "model");
        Context context = d().getContext();
        Integer d8 = model.d();
        if (d8 != null) {
            i8 = d8.intValue();
        } else {
            i8 = 0;
        }
        Image b8 = model.b();
        ImageView bonusImage = (ImageView) a(R.id.bonusImage);
        Intrinsics.e(bonusImage, "bonusImage");
        ImageKt.b(b8, bonusImage, null, 2, null);
        Text h8 = model.h();
        Intrinsics.e(context, "context");
        ((TextView) a(R.id.bonusTitleText)).setText(TextKt.a(h8, context));
        int i9 = R.id.bonusSubtitleText;
        TextView bonusSubtitleText = (TextView) a(i9);
        Intrinsics.e(bonusSubtitleText, "bonusSubtitleText");
        if (model.c() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(bonusSubtitleText, z7, 0, 2, null);
        TextView textView = (TextView) a(i9);
        Text c8 = model.c();
        if (c8 != null) {
            charSequence = TextKt.a(c8, context);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        TextView textView2 = (TextView) a(R.id.ridesBeforeText);
        Text f8 = model.f();
        if (f8 != null) {
            charSequence2 = TextKt.a(f8, context);
        } else {
            charSequence2 = null;
        }
        textView2.setText(charSequence2);
        TextView textView3 = (TextView) a(R.id.ridesAfterText);
        Text e8 = model.e();
        if (e8 != null) {
            charSequence3 = TextKt.a(e8, context);
        } else {
            charSequence3 = null;
        }
        textView3.setText(charSequence3);
        Chip chip = (Chip) a(R.id.ridesAfterChip);
        Text g8 = model.g();
        if (g8 != null) {
            charSequence4 = TextKt.a(g8, context);
        } else {
            charSequence4 = null;
        }
        chip.setText(charSequence4);
        e(i8);
        this.f27402b.b(model.a());
        if (infoBlockData != null) {
            View infoBlockFootnote = a(R.id.infoBlockFootnote);
            Intrinsics.e(infoBlockFootnote, "infoBlockFootnote");
            ViewExtKt.d(infoBlockFootnote, false, 0, 3, null);
            this.f27403c.b(infoBlockData);
        }
    }

    public View d() {
        return this.f27401a;
    }
}
