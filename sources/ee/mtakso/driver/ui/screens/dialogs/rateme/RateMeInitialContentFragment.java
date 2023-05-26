package ee.mtakso.driver.ui.screens.dialogs.rateme;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeInitialContentFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeInitialContentFragment.kt */
/* loaded from: classes3.dex */
public final class RateMeInitialContentFragment extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f28376h = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f28377f;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, View> f28378g = new LinkedHashMap();

    /* compiled from: RateMeInitialContentFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RateMeInitialContentFragment a(int i8, String title, String subtitle, String message) {
            Intrinsics.f(title, "title");
            Intrinsics.f(subtitle, "subtitle");
            Intrinsics.f(message, "message");
            RateMeInitialContentFragment rateMeInitialContentFragment = new RateMeInitialContentFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("CONFIG", new DialogConfig(i8, title, subtitle, message));
            rateMeInitialContentFragment.setArguments(bundle);
            return rateMeInitialContentFragment;
        }
    }

    /* compiled from: RateMeInitialContentFragment.kt */
    /* loaded from: classes3.dex */
    public static final class DialogConfig implements Parcelable {
        public static final Parcelable.Creator<DialogConfig> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f28379f;

        /* renamed from: g  reason: collision with root package name */
        private final String f28380g;

        /* renamed from: h  reason: collision with root package name */
        private final String f28381h;

        /* renamed from: i  reason: collision with root package name */
        private final String f28382i;

        /* compiled from: RateMeInitialContentFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<DialogConfig> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DialogConfig createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new DialogConfig(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DialogConfig[] newArray(int i8) {
                return new DialogConfig[i8];
            }
        }

        public DialogConfig(int i8, String title, String subtitle, String message) {
            Intrinsics.f(title, "title");
            Intrinsics.f(subtitle, "subtitle");
            Intrinsics.f(message, "message");
            this.f28379f = i8;
            this.f28380g = title;
            this.f28381h = subtitle;
            this.f28382i = message;
        }

        public final int a() {
            return this.f28379f;
        }

        public final String b() {
            return this.f28382i;
        }

        public final String c() {
            return this.f28381h;
        }

        public final String d() {
            return this.f28380g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DialogConfig) {
                DialogConfig dialogConfig = (DialogConfig) obj;
                return this.f28379f == dialogConfig.f28379f && Intrinsics.a(this.f28380g, dialogConfig.f28380g) && Intrinsics.a(this.f28381h, dialogConfig.f28381h) && Intrinsics.a(this.f28382i, dialogConfig.f28382i);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f28379f * 31) + this.f28380g.hashCode()) * 31) + this.f28381h.hashCode()) * 31) + this.f28382i.hashCode();
        }

        public String toString() {
            int i8 = this.f28379f;
            String str = this.f28380g;
            String str2 = this.f28381h;
            String str3 = this.f28382i;
            return "DialogConfig(iconResource=" + i8 + ", title=" + str + ", subtitle=" + str2 + ", message=" + str3 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f28379f);
            out.writeString(this.f28380g);
            out.writeString(this.f28381h);
            out.writeString(this.f28382i);
        }
    }

    public RateMeInitialContentFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DialogConfig>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeInitialContentFragment$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final RateMeInitialContentFragment.DialogConfig invoke() {
                Parcelable parcelable = RateMeInitialContentFragment.this.requireArguments().getParcelable("CONFIG");
                Intrinsics.d(parcelable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeInitialContentFragment.DialogConfig");
                return (RateMeInitialContentFragment.DialogConfig) parcelable;
            }
        });
        this.f28377f = b8;
    }

    private final RateMeDialog I() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.d(parentFragment, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog");
        return (RateMeDialog) parentFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(RateMeInitialContentFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.I().n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(RateMeInitialContentFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.I().S();
    }

    public void F() {
        this.f28378g.clear();
    }

    public View G(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28378g;
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

    public final DialogConfig H() {
        return (DialogConfig) this.f28377f.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_rate_content, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        F();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z7;
        boolean z8;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) G(R.id.Q5)).setImageResource(H().a());
        int i8 = R.id.cc;
        ((TextView) G(i8)).setText(H().d());
        int i9 = R.id.tb;
        ((TextView) G(i9)).setText(H().c());
        int i10 = R.id.f19830k7;
        ((TextView) G(i10)).setText(H().b());
        TextView title = (TextView) G(i8);
        Intrinsics.e(title, "title");
        boolean z9 = true;
        if (H().d().length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(title, z7, 0, 2, null);
        TextView subtitle = (TextView) G(i9);
        Intrinsics.e(subtitle, "subtitle");
        if (H().c().length() > 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(subtitle, z8, 0, 2, null);
        TextView message = (TextView) G(i10);
        Intrinsics.e(message, "message");
        if (H().b().length() <= 0) {
            z9 = false;
        }
        ViewExtKt.e(message, z9, 0, 2, null);
        ((ImageButton) G(R.id.like)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeInitialContentFragment.J(RateMeInitialContentFragment.this, view2);
            }
        });
        ((ImageButton) G(R.id.dislike)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeInitialContentFragment.K(RateMeInitialContentFragment.this, view2);
            }
        });
        final ScrollView scrollView = (ScrollView) G(R.id.contentScroll);
        if (scrollView != null) {
            ViewExtKt.c(scrollView, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeInitialContentFragment$onViewCreated$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void b() {
                    if (RateMeInitialContentFragment.this.G(R.id.rateContainer).getHeight() < scrollView.getHeight()) {
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
