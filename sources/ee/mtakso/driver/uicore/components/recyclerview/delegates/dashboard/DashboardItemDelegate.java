package ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$drawable;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardItemDelegate.kt */
/* loaded from: classes5.dex */
public class DashboardItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> implements DashboardDelegate {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f35223b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<String, Unit> f35224c;

    /* renamed from: d  reason: collision with root package name */
    private final int f35225d;

    /* compiled from: DashboardItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Badge {

        /* renamed from: a  reason: collision with root package name */
        private final Text f35226a;

        /* renamed from: b  reason: collision with root package name */
        private final Image f35227b;

        public Badge(Text text, Image image) {
            Intrinsics.f(text, "text");
            this.f35226a = text;
            this.f35227b = image;
        }

        public final Image a() {
            return this.f35227b;
        }

        public final Text b() {
            return this.f35226a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Badge) {
                Badge badge = (Badge) obj;
                return Intrinsics.a(this.f35226a, badge.f35226a) && Intrinsics.a(this.f35227b, badge.f35227b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f35226a.hashCode() * 31;
            Image image = this.f35227b;
            return hashCode + (image == null ? 0 : image.hashCode());
        }

        public String toString() {
            Text text = this.f35226a;
            Image image = this.f35227b;
            return "Badge(text=" + text + ", icon=" + image + ")";
        }
    }

    /* compiled from: DashboardItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Chip {

        /* renamed from: a  reason: collision with root package name */
        private final Text f35228a;

        /* renamed from: b  reason: collision with root package name */
        private final Color f35229b;

        public Chip(Text text, Color background) {
            Intrinsics.f(text, "text");
            Intrinsics.f(background, "background");
            this.f35228a = text;
            this.f35229b = background;
        }

        public final Color a() {
            return this.f35229b;
        }

        public final Text b() {
            return this.f35228a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Chip) {
                Chip chip = (Chip) obj;
                return Intrinsics.a(this.f35228a, chip.f35228a) && Intrinsics.a(this.f35229b, chip.f35229b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f35228a.hashCode() * 31) + this.f35229b.hashCode();
        }

        public String toString() {
            Text text = this.f35228a;
            Color color = this.f35229b;
            return "Chip(text=" + text + ", background=" + color + ")";
        }
    }

    /* compiled from: DashboardItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Condition {

        /* renamed from: a  reason: collision with root package name */
        private final Text f35230a;

        /* renamed from: b  reason: collision with root package name */
        private final Color f35231b;

        /* renamed from: c  reason: collision with root package name */
        private final Image f35232c;

        public Condition(Text text, Color backColor, Image image) {
            Intrinsics.f(text, "text");
            Intrinsics.f(backColor, "backColor");
            this.f35230a = text;
            this.f35231b = backColor;
            this.f35232c = image;
        }

        public final Color a() {
            return this.f35231b;
        }

        public final Image b() {
            return this.f35232c;
        }

        public final Text c() {
            return this.f35230a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Condition) {
                Condition condition = (Condition) obj;
                return Intrinsics.a(this.f35230a, condition.f35230a) && Intrinsics.a(this.f35231b, condition.f35231b) && Intrinsics.a(this.f35232c, condition.f35232c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f35230a.hashCode() * 31) + this.f35231b.hashCode()) * 31;
            Image image = this.f35232c;
            return hashCode + (image == null ? 0 : image.hashCode());
        }

        public String toString() {
            Text text = this.f35230a;
            Color color = this.f35231b;
            Image image = this.f35232c;
            return "Condition(text=" + text + ", backColor=" + color + ", icon=" + image + ")";
        }
    }

    /* compiled from: DashboardItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static abstract class ContentItem {

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class BadgeGroup extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final List<Badge> f35233a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BadgeGroup(List<Badge> items) {
                super(null);
                Intrinsics.f(items, "items");
                this.f35233a = items;
            }

            public final List<Badge> a() {
                return this.f35233a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof BadgeGroup) && Intrinsics.a(this.f35233a, ((BadgeGroup) obj).f35233a);
            }

            public int hashCode() {
                return this.f35233a.hashCode();
            }

            public String toString() {
                List<Badge> list = this.f35233a;
                return "BadgeGroup(items=" + list + ")";
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Bonus extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final Text f35234a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Bonus(Text text) {
                super(null);
                Intrinsics.f(text, "text");
                this.f35234a = text;
            }

            public final Text a() {
                return this.f35234a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Bonus) && Intrinsics.a(this.f35234a, ((Bonus) obj).f35234a);
            }

            public int hashCode() {
                return this.f35234a.hashCode();
            }

            public String toString() {
                Text text = this.f35234a;
                return "Bonus(text=" + text + ")";
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Button extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final Text f35235a;

            /* renamed from: b  reason: collision with root package name */
            private final UiKitRoundButtonType f35236b;

            /* renamed from: c  reason: collision with root package name */
            private final String f35237c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Button(Text title, UiKitRoundButtonType type, String link) {
                super(null);
                Intrinsics.f(title, "title");
                Intrinsics.f(type, "type");
                Intrinsics.f(link, "link");
                this.f35235a = title;
                this.f35236b = type;
                this.f35237c = link;
            }

            public final String a() {
                return this.f35237c;
            }

            public final Text b() {
                return this.f35235a;
            }

            public final UiKitRoundButtonType c() {
                return this.f35236b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Button) {
                    Button button = (Button) obj;
                    return Intrinsics.a(this.f35235a, button.f35235a) && this.f35236b == button.f35236b && Intrinsics.a(this.f35237c, button.f35237c);
                }
                return false;
            }

            public int hashCode() {
                return (((this.f35235a.hashCode() * 31) + this.f35236b.hashCode()) * 31) + this.f35237c.hashCode();
            }

            public String toString() {
                Text text = this.f35235a;
                UiKitRoundButtonType uiKitRoundButtonType = this.f35236b;
                String str = this.f35237c;
                return "Button(title=" + text + ", type=" + uiKitRoundButtonType + ", link=" + str + ")";
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Conditions extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final List<Condition> f35238a;

            /* renamed from: b  reason: collision with root package name */
            private final Text f35239b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Conditions(List<Condition> items, Text text) {
                super(null);
                Intrinsics.f(items, "items");
                this.f35238a = items;
                this.f35239b = text;
            }

            public final List<Condition> a() {
                return this.f35238a;
            }

            public final Text b() {
                return this.f35239b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conditions) {
                    Conditions conditions = (Conditions) obj;
                    return Intrinsics.a(this.f35238a, conditions.f35238a) && Intrinsics.a(this.f35239b, conditions.f35239b);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f35238a.hashCode() * 31;
                Text text = this.f35239b;
                return hashCode + (text == null ? 0 : text.hashCode());
            }

            public String toString() {
                List<Condition> list = this.f35238a;
                Text text = this.f35239b;
                return "Conditions(items=" + list + ", label=" + text + ")";
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Icon extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final Image f35240a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Icon(Image icon) {
                super(null);
                Intrinsics.f(icon, "icon");
                this.f35240a = icon;
            }

            public final Image a() {
                return this.f35240a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Icon) && Intrinsics.a(this.f35240a, ((Icon) obj).f35240a);
            }

            public int hashCode() {
                return this.f35240a.hashCode();
            }

            public String toString() {
                Image image = this.f35240a;
                return "Icon(icon=" + image + ")";
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Link extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final Text f35241a;

            /* renamed from: b  reason: collision with root package name */
            private final String f35242b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Link(Text text, String link) {
                super(null);
                Intrinsics.f(text, "text");
                Intrinsics.f(link, "link");
                this.f35241a = text;
                this.f35242b = link;
            }

            public final String a() {
                return this.f35242b;
            }

            public final Text b() {
                return this.f35241a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Link) {
                    Link link = (Link) obj;
                    return Intrinsics.a(this.f35241a, link.f35241a) && Intrinsics.a(this.f35242b, link.f35242b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f35241a.hashCode() * 31) + this.f35242b.hashCode();
            }

            public String toString() {
                Text text = this.f35241a;
                String str = this.f35242b;
                return "Link(text=" + text + ", link=" + str + ")";
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Separator extends ContentItem {
            public Separator() {
                super(null);
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class SimpleText extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final Text f35243a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SimpleText(Text text) {
                super(null);
                Intrinsics.f(text, "text");
                this.f35243a = text;
            }

            public final Text a() {
                return this.f35243a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SimpleText) && Intrinsics.a(this.f35243a, ((SimpleText) obj).f35243a);
            }

            public int hashCode() {
                return this.f35243a.hashCode();
            }

            public String toString() {
                Text text = this.f35243a;
                return "SimpleText(text=" + text + ")";
            }
        }

        /* compiled from: DashboardItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Tags extends ContentItem {

            /* renamed from: a  reason: collision with root package name */
            private final List<DashboardTag> f35244a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Tags(List<DashboardTag> tags) {
                super(null);
                Intrinsics.f(tags, "tags");
                this.f35244a = tags;
            }

            public final List<DashboardTag> a() {
                return this.f35244a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Tags) && Intrinsics.a(this.f35244a, ((Tags) obj).f35244a);
            }

            public int hashCode() {
                return this.f35244a.hashCode();
            }

            public String toString() {
                List<DashboardTag> list = this.f35244a;
                return "Tags(tags=" + list + ")";
            }
        }

        private ContentItem() {
        }

        public /* synthetic */ ContentItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DashboardItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class DashboardTag {

        /* renamed from: a  reason: collision with root package name */
        private final Text f35245a;

        /* renamed from: b  reason: collision with root package name */
        private final Color f35246b;

        public DashboardTag(Text text, Color backColor) {
            Intrinsics.f(text, "text");
            Intrinsics.f(backColor, "backColor");
            this.f35245a = text;
            this.f35246b = backColor;
        }

        public final Color a() {
            return this.f35246b;
        }

        public final Text b() {
            return this.f35245a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DashboardTag) {
                DashboardTag dashboardTag = (DashboardTag) obj;
                return Intrinsics.a(this.f35245a, dashboardTag.f35245a) && Intrinsics.a(this.f35246b, dashboardTag.f35246b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f35245a.hashCode() * 31) + this.f35246b.hashCode();
        }

        public String toString() {
            Text text = this.f35245a;
            Color color = this.f35246b;
            return "DashboardTag(text=" + text + ", backColor=" + color + ")";
        }
    }

    /* compiled from: DashboardItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout A;
        private final ConstraintLayout B;
        private final View C;

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35260u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35261v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f35262w;

        /* renamed from: x  reason: collision with root package name */
        private final ImageView f35263x;

        /* renamed from: y  reason: collision with root package name */
        private final AppCompatImageView f35264y;

        /* renamed from: z  reason: collision with root package name */
        private final TextView f35265z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.F0);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35260u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.titleChip);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f35261v = appCompatTextView2;
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) itemView.findViewById(R$id.valueText);
            Intrinsics.d(appCompatTextView3, "null cannot be cast to non-null type android.widget.TextView");
            this.f35262w = appCompatTextView3;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.valueIcon);
            Intrinsics.d(appCompatImageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35263x = appCompatImageView;
            this.f35264y = (AppCompatImageView) itemView.findViewById(R$id.linkChevron);
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) itemView.findViewById(R$id.f34602q);
            Intrinsics.d(appCompatTextView4, "null cannot be cast to non-null type android.widget.TextView");
            this.f35265z = appCompatTextView4;
            LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R$id.bottomContent);
            Intrinsics.d(linearLayout, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.A = linearLayout;
            this.B = (ConstraintLayout) itemView.findViewById(R$id.viewRoot);
            this.C = itemView.findViewById(R$id.backgroundView);
        }

        public final View O() {
            return this.C;
        }

        public final LinearLayout P() {
            return this.A;
        }

        public final AppCompatImageView Q() {
            return this.f35264y;
        }

        public final TextView R() {
            return this.f35265z;
        }

        public final TextView S() {
            return this.f35261v;
        }

        public final TextView T() {
            return this.f35260u;
        }

        public final ImageView U() {
            return this.f35263x;
        }

        public final TextView V() {
            return this.f35262w;
        }

        public final ConstraintLayout W() {
            return this.B;
        }
    }

    public /* synthetic */ DashboardItemDelegate(Function1 function1, Function1 function12, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, (i9 & 4) != 0 ? R$layout.delegate_dashboard_item : i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 onLinkClick, ContentItem.Button item, View view) {
        Intrinsics.f(onLinkClick, "$onLinkClick");
        Intrinsics.f(item, "$item");
        onLinkClick.invoke(item.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 onLinkClick, ContentItem.Link link, View view) {
        Intrinsics.f(onLinkClick, "$onLinkClick");
        Intrinsics.f(link, "$link");
        onLinkClick.invoke(link.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(DashboardItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35223b.invoke(model);
    }

    private final View z(ViewGroup viewGroup, final ContentItem.Button button, final Function1<? super String, Unit> function1) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.dashboard_item_button, viewGroup, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type ee.mtakso.driver.uikit.widgets.RoundButton");
        RoundButton roundButton = (RoundButton) inflate;
        UiKitRoundButtonTypeKt.b(roundButton, button.c());
        roundButton.setOnClickListener(new View.OnClickListener() { // from class: s5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardItemDelegate.A(Function1.this, button, view);
            }
        });
        Text b8 = button.b();
        Context context = roundButton.getContext();
        Intrinsics.e(context, "button.context");
        roundButton.setText(TextKt.a(b8, context));
        viewGroup.addView(roundButton);
        return roundButton;
    }

    public final void B(ViewGroup parent, Condition condition) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(condition, "condition");
        Context context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R$layout.dashboard_item_condition, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        Text c8 = condition.c();
        Intrinsics.e(context, "context");
        textView.setText(TextKt.a(c8, context));
        parent.addView(inflate);
        Image b8 = condition.b();
        if (b8 != null) {
            ImageKt.c(b8, textView, Dimens.d(16), Dimens.d(16));
        }
        RippleProvider rippleProvider = RippleProvider.f35730a;
        int a8 = ColorKt.a(condition.a(), context);
        int a9 = ColorKt.a(condition.a(), context);
        float c9 = Dimens.c(4.0f);
        Paint.Style style = Paint.Style.FILL;
        inflate.setBackground(rippleProvider.d(a8, a9, new RippleProvider.CornerRadiuses(c9, c9, c9, c9), Dimens.c(2.0f), Paint.Style.FILL));
    }

    public final void C(ViewGroup parent, Text text) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        Context context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R$layout.dashboard_item_condition_label, parent, false);
        parent.addView(inflate);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        Intrinsics.e(context, "context");
        ((TextView) inflate).setText(TextKt.a(text, context));
    }

    public final void D(ViewGroup parent, ContentItem.Conditions conditions) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(conditions, "conditions");
        FlexboxLayout flexboxLayout = new FlexboxLayout(parent.getContext());
        flexboxLayout.setFlexWrap(1);
        flexboxLayout.setAlignItems(2);
        parent.addView(flexboxLayout);
        ViewExtKt.f(flexboxLayout, null, Integer.valueOf(Dimens.d(16)), null, null, 13, null);
        for (Condition condition : conditions.a()) {
            B(flexboxLayout, condition);
        }
        Text b8 = conditions.b();
        if (b8 != null) {
            C(flexboxLayout, b8);
        }
    }

    public final void E(ViewGroup parent, ContentItem item) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(item, "item");
        if (item instanceof ContentItem.Separator) {
            I(parent);
        } else if (item instanceof ContentItem.Link) {
            G(parent, (ContentItem.Link) item, this.f35224c);
        } else if (item instanceof ContentItem.Icon) {
            F(parent, (ContentItem.Icon) item);
        } else if (item instanceof ContentItem.Tags) {
            K(parent, (ContentItem.Tags) item);
        } else if (item instanceof ContentItem.Conditions) {
            D(parent, (ContentItem.Conditions) item);
        } else if (item instanceof ContentItem.Bonus) {
            y(parent, (ContentItem.Bonus) item);
        } else if (item instanceof ContentItem.SimpleText) {
            L(parent, (ContentItem.SimpleText) item);
        } else if (item instanceof ContentItem.BadgeGroup) {
            v(parent, (ContentItem.BadgeGroup) item);
        } else if (item instanceof ContentItem.Button) {
            z(parent, (ContentItem.Button) item, this.f35224c);
        }
    }

    public final View F(ViewGroup parent, ContentItem.Icon icon) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(icon, "icon");
        AppCompatImageView appCompatImageView = new AppCompatImageView(parent.getContext());
        appCompatImageView.setLayoutParams(new LinearLayout.LayoutParams(Dimens.d(24), Dimens.d(24)));
        ViewExtKt.f(appCompatImageView, null, Integer.valueOf(Dimens.d(12)), null, null, 13, null);
        parent.addView(appCompatImageView);
        ImageKt.b(icon.a(), appCompatImageView, null, 2, null);
        return appCompatImageView;
    }

    public final View G(ViewGroup parent, final ContentItem.Link link, final Function1<? super String, Unit> onLinkClick) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(link, "link");
        Intrinsics.f(onLinkClick, "onLinkClick");
        Context context = parent.getContext();
        View inflateLink$lambda$7 = LayoutInflater.from(context).inflate(R$layout.dashboard_item_link, parent, false);
        Intrinsics.e(inflateLink$lambda$7, "inflateLink$lambda$7");
        ViewExtKt.f(inflateLink$lambda$7, null, Integer.valueOf(Dimens.d(12)), null, null, 13, null);
        Text b8 = link.b();
        Intrinsics.e(context, "context");
        ((TextView) inflateLink$lambda$7).setText(TextKt.a(b8, context));
        inflateLink$lambda$7.setOnClickListener(new View.OnClickListener() { // from class: s5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardItemDelegate.H(Function1.this, link, view);
            }
        });
        RippleProvider.b(RippleProvider.f35730a, inflateLink$lambda$7, ColorKt.a(new Color.Res(R$color.f34586k), context), 0, 2, null);
        parent.addView(inflateLink$lambda$7);
        Intrinsics.e(inflateLink$lambda$7, "from(context)\n          …dView(this)\n            }");
        return inflateLink$lambda$7;
    }

    public final View I(ViewGroup parent) {
        Intrinsics.f(parent, "parent");
        Context context = parent.getContext();
        View view = new View(context);
        Color.Attr attr = new Color.Attr(R$attr.f34582m);
        Intrinsics.e(context, "context");
        view.setBackgroundColor(ColorKt.a(attr, context));
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, Dimens.d(1)));
        parent.addView(view);
        ViewExtKt.f(view, null, Integer.valueOf(Dimens.d(12)), null, null, 13, null);
        return view;
    }

    public final void J(ViewGroup parent, DashboardTag tag) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(tag, "tag");
        Context context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R$layout.dashboard_item_tag, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        Text b8 = tag.b();
        Intrinsics.e(context, "context");
        ((TextView) inflate).setText(TextKt.a(b8, context));
        RippleProvider rippleProvider = RippleProvider.f35730a;
        int a8 = ColorKt.a(tag.a(), context);
        int a9 = ColorKt.a(tag.a(), context);
        float c8 = Dimens.c(4.0f);
        Paint.Style style = Paint.Style.FILL;
        inflate.setBackground(rippleProvider.d(a8, a9, new RippleProvider.CornerRadiuses(c8, c8, c8, c8), Dimens.c(2.0f), Paint.Style.FILL));
        parent.addView(inflate);
    }

    public final void K(ViewGroup parent, ContentItem.Tags tags) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(tags, "tags");
        FlexboxLayout flexboxLayout = new FlexboxLayout(parent.getContext());
        flexboxLayout.setFlexWrap(1);
        parent.addView(flexboxLayout);
        ViewExtKt.f(flexboxLayout, null, Integer.valueOf(Dimens.d(4)), null, null, 13, null);
        for (DashboardTag dashboardTag : tags.a()) {
            J(flexboxLayout, dashboardTag);
        }
    }

    public final View L(ViewGroup parent, ContentItem.SimpleText link) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(link, "link");
        Context context = parent.getContext();
        View inflateText$lambda$8 = LayoutInflater.from(context).inflate(R$layout.dashboard_item_text, parent, false);
        Intrinsics.e(inflateText$lambda$8, "inflateText$lambda$8");
        ViewExtKt.f(inflateText$lambda$8, null, Integer.valueOf(Dimens.d(12)), null, null, 13, null);
        Text a8 = link.a();
        Intrinsics.e(context, "context");
        ((TextView) inflateText$lambda$8).setText(TextKt.a(a8, context));
        RippleProvider.b(RippleProvider.f35730a, inflateText$lambda$8, ColorKt.a(new Color.Res(R$color.f34586k), context), 0, 2, null);
        parent.addView(inflateText$lambda$8);
        Intrinsics.e(inflateText$lambda$8, "from(context)\n          …dView(this)\n            }");
        return inflateText$lambda$8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b7, code lost:
        if (r2 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r2 == null) goto L57;
     */
    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate.ViewHolder r11, final ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate.Model r12) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate.g(ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate$ViewHolder, ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate$Model):void");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: O */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardDelegate
    public void a(View view) {
        ViewGroup viewGroup;
        ConstraintLayout constraintLayout;
        Intrinsics.f(view, "view");
        ViewGroup.LayoutParams layoutParams = null;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null && (constraintLayout = (ConstraintLayout) viewGroup.findViewById(R$id.viewRoot)) != null) {
            layoutParams = constraintLayout.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        view.getLayoutParams().height = -2;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35225d;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View v7 = inflater.inflate(e(), parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    public final void v(ViewGroup parent, ContentItem.BadgeGroup badgeGroup) {
        int m8;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(badgeGroup, "badgeGroup");
        FlexboxLayout flexboxLayout = new FlexboxLayout(parent.getContext());
        flexboxLayout.setFlexWrap(1);
        flexboxLayout.setAlignItems(2);
        parent.addView(flexboxLayout);
        ViewExtKt.f(flexboxLayout, null, Integer.valueOf(Dimens.d(12)), null, null, 13, null);
        int i8 = 0;
        for (Object obj : badgeGroup.a()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            x(flexboxLayout, (Badge) obj);
            m8 = CollectionsKt__CollectionsKt.m(badgeGroup.a());
            if (m8 != i8) {
                w(flexboxLayout);
            }
            i8 = i9;
        }
    }

    public final View w(ViewGroup parent) {
        Intrinsics.f(parent, "parent");
        Context context = parent.getContext();
        View view = new View(context);
        Color.Attr attr = new Color.Attr(R$attr.dynamicNeutral03);
        Intrinsics.e(context, "context");
        view.setBackgroundColor(ColorKt.a(attr, context));
        view.setLayoutParams(new LinearLayout.LayoutParams(Dimens.d(1), Dimens.d(12)));
        parent.addView(view);
        ViewExtKt.f(view, Integer.valueOf(Dimens.d(8)), null, Integer.valueOf(Dimens.d(8)), null, 10, null);
        return view;
    }

    public final View x(ViewGroup parent, Badge badge) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(badge, "badge");
        Context context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R$layout.dashboard_item_badge, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        Text b8 = badge.b();
        Intrinsics.e(context, "context");
        textView.setText(TextKt.a(b8, context));
        Image a8 = badge.a();
        if (a8 != null) {
            ImageKt.d(a8, textView, Dimens.d(14), Dimens.d(14));
        }
        TextViewExtKt.a(textView, new Color.Attr(R$attr.f34580k));
        parent.addView(inflate);
        Intrinsics.e(inflate, "from(context)\n          …dView(this)\n            }");
        return inflate;
    }

    public final View y(ViewGroup parent, ContentItem.Bonus link) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(link, "link");
        Context context = parent.getContext();
        View inflateBonus$lambda$9 = LayoutInflater.from(context).inflate(R$layout.dashboard_item_bonus, parent, false);
        Intrinsics.e(inflateBonus$lambda$9, "inflateBonus$lambda$9");
        ViewExtKt.f(inflateBonus$lambda$9, null, Integer.valueOf(Dimens.d(12)), null, null, 13, null);
        TextView textView = (TextView) inflateBonus$lambda$9;
        Text a8 = link.a();
        Intrinsics.e(context, "context");
        textView.setText(TextKt.a(a8, context));
        ImageKt.d(new Image.Res(R$drawable.ic_small_check), textView, Dimens.d(16), Dimens.d(16));
        parent.addView(inflateBonus$lambda$9);
        Intrinsics.e(inflateBonus$lambda$9, "from(context)\n          …dView(this)\n            }");
        return inflateBonus$lambda$9;
    }

    /* compiled from: DashboardItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35247a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35248b;

        /* renamed from: c  reason: collision with root package name */
        private final Chip f35249c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f35250d;

        /* renamed from: e  reason: collision with root package name */
        private final int f35251e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f35252f;

        /* renamed from: g  reason: collision with root package name */
        private final List<ContentItem> f35253g;

        /* renamed from: h  reason: collision with root package name */
        private final Image f35254h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f35255i;

        /* renamed from: j  reason: collision with root package name */
        private final int f35256j;

        /* renamed from: k  reason: collision with root package name */
        private final int f35257k;

        /* renamed from: l  reason: collision with root package name */
        private final Color f35258l;

        /* renamed from: m  reason: collision with root package name */
        private final Object f35259m;

        public /* synthetic */ Model(String str, Text text, Chip chip, Text text2, int i8, Text text3, List list, Image image, boolean z7, int i9, int i10, Color color, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? null : text, (i11 & 4) != 0 ? null : chip, (i11 & 8) != 0 ? null : text2, (i11 & 16) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i8, (i11 & 32) != 0 ? null : text3, (i11 & 64) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i11 & 128) != 0 ? null : image, (i11 & Spliterator.NONNULL) != 0 ? false : z7, (i11 & 512) != 0 ? -1 : i9, (i11 & Spliterator.IMMUTABLE) != 0 ? -2 : i10, (i11 & 2048) != 0 ? new Color.Attr(R$attr.backPrimary) : color, (i11 & 4096) == 0 ? obj : null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35248b, model.f35248b) && Intrinsics.a(this.f35249c, model.f35249c) && Intrinsics.a(this.f35250d, model.f35250d) && this.f35251e == model.f35251e && Intrinsics.a(this.f35252f, model.f35252f) && Intrinsics.a(this.f35253g, model.f35253g) && Intrinsics.a(this.f35254h, model.f35254h) && this.f35255i == model.f35255i && this.f35256j == model.f35256j && this.f35257k == model.f35257k && Intrinsics.a(this.f35258l, model.f35258l) && Intrinsics.a(this.f35259m, model.f35259m);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f35248b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Chip chip = this.f35249c;
            int hashCode3 = (hashCode2 + (chip == null ? 0 : chip.hashCode())) * 31;
            Text text2 = this.f35250d;
            int hashCode4 = (((hashCode3 + (text2 == null ? 0 : text2.hashCode())) * 31) + this.f35251e) * 31;
            Text text3 = this.f35252f;
            int hashCode5 = (((hashCode4 + (text3 == null ? 0 : text3.hashCode())) * 31) + this.f35253g.hashCode()) * 31;
            Image image = this.f35254h;
            int hashCode6 = (hashCode5 + (image == null ? 0 : image.hashCode())) * 31;
            boolean z7 = this.f35255i;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int hashCode7 = (((((((hashCode6 + i8) * 31) + this.f35256j) * 31) + this.f35257k) * 31) + this.f35258l.hashCode()) * 31;
            Object obj = this.f35259m;
            return hashCode7 + (obj != null ? obj.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35247a;
        }

        public final Color n() {
            return this.f35258l;
        }

        public final boolean o() {
            return this.f35255i;
        }

        public final List<ContentItem> p() {
            return this.f35253g;
        }

        public final Text q() {
            return this.f35252f;
        }

        public final int r() {
            return this.f35257k;
        }

        public final Object s() {
            return this.f35259m;
        }

        public final Chip t() {
            return this.f35249c;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f35248b;
            Chip chip = this.f35249c;
            Text text2 = this.f35250d;
            int i8 = this.f35251e;
            Text text3 = this.f35252f;
            List<ContentItem> list = this.f35253g;
            Image image = this.f35254h;
            boolean z7 = this.f35255i;
            int i9 = this.f35256j;
            int i10 = this.f35257k;
            Color color = this.f35258l;
            Object obj = this.f35259m;
            return "Model(listId=" + m8 + ", titleText=" + text + ", titleChip=" + chip + ", valueText=" + text2 + ", titleTextMaxLines=" + i8 + ", descriptionText=" + text3 + ", content=" + list + ", valueIcon=" + image + ", chevronVisible=" + z7 + ", width=" + i9 + ", height=" + i10 + ", backgroundColor=" + color + ", payload=" + obj + ")";
        }

        public final Text u() {
            return this.f35248b;
        }

        public final int v() {
            return this.f35251e;
        }

        public final Image w() {
            return this.f35254h;
        }

        public final Text x() {
            return this.f35250d;
        }

        public final int y() {
            return this.f35256j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(String listId, Text text, Chip chip, Text text2, int i8, Text text3, List<? extends ContentItem> content, Image image, boolean z7, int i9, int i10, Color backgroundColor, Object obj) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(content, "content");
            Intrinsics.f(backgroundColor, "backgroundColor");
            this.f35247a = listId;
            this.f35248b = text;
            this.f35249c = chip;
            this.f35250d = text2;
            this.f35251e = i8;
            this.f35252f = text3;
            this.f35253g = content;
            this.f35254h = image;
            this.f35255i = z7;
            this.f35256j = i9;
            this.f35257k = i10;
            this.f35258l = backgroundColor;
            this.f35259m = obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DashboardItemDelegate(Function1<? super Model, Unit> onInfoClick, Function1<? super String, Unit> onLinkClick, int i8) {
        Intrinsics.f(onInfoClick, "onInfoClick");
        Intrinsics.f(onLinkClick, "onLinkClick");
        this.f35223b = onInfoClick;
        this.f35224c = onLinkClick;
        this.f35225d = i8;
    }
}
