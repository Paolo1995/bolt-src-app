package ee.mtakso.driver.ui.screens.dialogs.rateme;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeActionContentFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeActionContentFragment.kt */
/* loaded from: classes3.dex */
public final class RateMeActionContentFragment extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f28319h = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f28320f;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, View> f28321g = new LinkedHashMap();

    /* compiled from: RateMeActionContentFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RateMeActionContentFragment a(int i8, String title, String message, String buttonText, String actionTag) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(buttonText, "buttonText");
            Intrinsics.f(actionTag, "actionTag");
            RateMeActionContentFragment rateMeActionContentFragment = new RateMeActionContentFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("CONFIG", new DialogConfig(i8, title, message, buttonText, actionTag));
            rateMeActionContentFragment.setArguments(bundle);
            return rateMeActionContentFragment;
        }
    }

    /* compiled from: RateMeActionContentFragment.kt */
    /* loaded from: classes3.dex */
    public static final class DialogConfig implements Parcelable {
        public static final Parcelable.Creator<DialogConfig> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f28322f;

        /* renamed from: g  reason: collision with root package name */
        private final String f28323g;

        /* renamed from: h  reason: collision with root package name */
        private final String f28324h;

        /* renamed from: i  reason: collision with root package name */
        private final String f28325i;

        /* renamed from: j  reason: collision with root package name */
        private final String f28326j;

        /* compiled from: RateMeActionContentFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<DialogConfig> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DialogConfig createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new DialogConfig(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DialogConfig[] newArray(int i8) {
                return new DialogConfig[i8];
            }
        }

        public DialogConfig(int i8, String title, String message, String buttonText, String actionTag) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(buttonText, "buttonText");
            Intrinsics.f(actionTag, "actionTag");
            this.f28322f = i8;
            this.f28323g = title;
            this.f28324h = message;
            this.f28325i = buttonText;
            this.f28326j = actionTag;
        }

        public final String a() {
            return this.f28326j;
        }

        public final String b() {
            return this.f28325i;
        }

        public final int c() {
            return this.f28322f;
        }

        public final String d() {
            return this.f28324h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f28323g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DialogConfig) {
                DialogConfig dialogConfig = (DialogConfig) obj;
                return this.f28322f == dialogConfig.f28322f && Intrinsics.a(this.f28323g, dialogConfig.f28323g) && Intrinsics.a(this.f28324h, dialogConfig.f28324h) && Intrinsics.a(this.f28325i, dialogConfig.f28325i) && Intrinsics.a(this.f28326j, dialogConfig.f28326j);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f28322f * 31) + this.f28323g.hashCode()) * 31) + this.f28324h.hashCode()) * 31) + this.f28325i.hashCode()) * 31) + this.f28326j.hashCode();
        }

        public String toString() {
            int i8 = this.f28322f;
            String str = this.f28323g;
            String str2 = this.f28324h;
            String str3 = this.f28325i;
            String str4 = this.f28326j;
            return "DialogConfig(iconResource=" + i8 + ", title=" + str + ", message=" + str2 + ", buttonText=" + str3 + ", actionTag=" + str4 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f28322f);
            out.writeString(this.f28323g);
            out.writeString(this.f28324h);
            out.writeString(this.f28325i);
            out.writeString(this.f28326j);
        }
    }

    public RateMeActionContentFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DialogConfig>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeActionContentFragment$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final RateMeActionContentFragment.DialogConfig invoke() {
                Parcelable parcelable = RateMeActionContentFragment.this.requireArguments().getParcelable("CONFIG");
                Intrinsics.d(parcelable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeActionContentFragment.DialogConfig");
                return (RateMeActionContentFragment.DialogConfig) parcelable;
            }
        });
        this.f28320f = b8;
    }

    private final DialogConfig G() {
        return (DialogConfig) this.f28320f.getValue();
    }

    private final RateMeDialog H() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.d(parentFragment, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog");
        return (RateMeDialog) parentFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(RateMeActionContentFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.H().Z(this$0.G().a());
    }

    public void E() {
        this.f28321g.clear();
    }

    public View F(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28321g;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_rate_action_content, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        E();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) F(R.id.Q5)).setImageResource(G().c());
        ((TextView) F(R.id.cc)).setText(G().e());
        ((TextView) F(R.id.f19830k7)).setText(G().d());
        RoundButton roundButton = (RoundButton) F(R.id.actionButton);
        roundButton.setText(G().b());
        roundButton.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeActionContentFragment.I(RateMeActionContentFragment.this, view2);
            }
        });
        final ScrollView scrollView = (ScrollView) F(R.id.contentScroll);
        if (scrollView != null) {
            ViewExtKt.c(scrollView, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeActionContentFragment$onViewCreated$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void b() {
                    if (RateMeActionContentFragment.this.getView() != null && RateMeActionContentFragment.this.F(R.id.rateContainer).getHeight() < scrollView.getHeight()) {
                        ScrollView scrollView2 = scrollView;
                        ViewGroup.LayoutParams layoutParams = scrollView2.getLayoutParams();
                        Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.height = -2;
                        layoutParams2.weight = 0.0f;
                        scrollView2.setLayoutParams(layoutParams2);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
        }
    }
}
