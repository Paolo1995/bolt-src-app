package ee.mtakso.driver.ui.screens.operation_result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.operation_result.OperationResultFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OperationResultFragment.kt */
/* loaded from: classes3.dex */
public final class OperationResultFragment extends BazeFragment {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f30958p = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f30959m;

    /* renamed from: n  reason: collision with root package name */
    private final Lazy f30960n;

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f30961o;

    /* compiled from: OperationResultFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle b(Companion companion, Config config, Bundle bundle, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                bundle = new Bundle();
            }
            return companion.a(config, bundle);
        }

        public final Bundle a(Config config, Bundle bundle) {
            Intrinsics.f(config, "config");
            Intrinsics.f(bundle, "bundle");
            bundle.putParcelable("CONFIG", config);
            return bundle;
        }
    }

    /* compiled from: OperationResultFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f30964f;

        /* renamed from: g  reason: collision with root package name */
        private final CharSequence f30965g;

        /* renamed from: h  reason: collision with root package name */
        private final CharSequence f30966h;

        /* renamed from: i  reason: collision with root package name */
        private final ButtonModel f30967i;

        /* compiled from: OperationResultFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Config> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Config(parcel.readInt(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ButtonModel.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Config[] newArray(int i8) {
                return new Config[i8];
            }
        }

        public Config(int i8, CharSequence title, CharSequence text, ButtonModel buttonModel) {
            Intrinsics.f(title, "title");
            Intrinsics.f(text, "text");
            this.f30964f = i8;
            this.f30965g = title;
            this.f30966h = text;
            this.f30967i = buttonModel;
        }

        public final ButtonModel a() {
            return this.f30967i;
        }

        public final int b() {
            return this.f30964f;
        }

        public final CharSequence c() {
            return this.f30966h;
        }

        public final CharSequence d() {
            return this.f30965g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Config) {
                Config config = (Config) obj;
                return this.f30964f == config.f30964f && Intrinsics.a(this.f30965g, config.f30965g) && Intrinsics.a(this.f30966h, config.f30966h) && Intrinsics.a(this.f30967i, config.f30967i);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.f30964f * 31) + this.f30965g.hashCode()) * 31) + this.f30966h.hashCode()) * 31;
            ButtonModel buttonModel = this.f30967i;
            return hashCode + (buttonModel == null ? 0 : buttonModel.hashCode());
        }

        public String toString() {
            int i8 = this.f30964f;
            CharSequence charSequence = this.f30965g;
            CharSequence charSequence2 = this.f30966h;
            ButtonModel buttonModel = this.f30967i;
            return "Config(icon=" + i8 + ", title=" + ((Object) charSequence) + ", text=" + ((Object) charSequence2) + ", button=" + buttonModel + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f30964f);
            TextUtils.writeToParcel(this.f30965g, out, i8);
            TextUtils.writeToParcel(this.f30966h, out, i8);
            ButtonModel buttonModel = this.f30967i;
            if (buttonModel == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            buttonModel.writeToParcel(out, i8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OperationResultFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_operation_result, null, 4, null);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(deps, "deps");
        this.f30961o = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.operation_result.OperationResultFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = OperationResultFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f30959m = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<Config>() { // from class: ee.mtakso.driver.ui.screens.operation_result.OperationResultFragment$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OperationResultFragment.Config invoke() {
                return (OperationResultFragment.Config) OperationResultFragment.this.requireArguments().getParcelable("CONFIG");
            }
        });
        this.f30960n = b9;
    }

    private final Config L() {
        return (Config) this.f30960n.getValue();
    }

    private final Navigator M() {
        return (Navigator) this.f30959m.getValue();
    }

    private final void N() {
        Navigator M = M();
        if (M != null) {
            M.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(OperationResultFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.N();
    }

    private final void P(ButtonModel buttonModel) {
        boolean z7;
        int i8 = R.id.confirmButton;
        RoundButton confirmButton = (RoundButton) K(i8);
        Intrinsics.e(confirmButton, "confirmButton");
        if (buttonModel != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(confirmButton, z7, 0, 2, null);
        if (buttonModel != null) {
            RoundButton confirmButton2 = (RoundButton) K(i8);
            Intrinsics.e(confirmButton2, "confirmButton");
            UiKitRoundButtonTypeKt.b(confirmButton2, buttonModel.a());
            ((RoundButton) K(i8)).setText(buttonModel.b());
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30961o.clear();
    }

    public View K(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30961o;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Unit unit;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Config L = L();
        if (L != null) {
            ((AppCompatTextView) K(R.id.cc)).setText(L.d());
            ((AppCompatTextView) K(R.id.Hb)).setText(L.c());
            ((AppCompatImageView) K(R.id.Q5)).setImageResource(L.b());
            P(L.a());
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            N();
        }
        ((RoundButton) K(R.id.confirmButton)).setOnClickListener(new View.OnClickListener() { // from class: o4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OperationResultFragment.O(OperationResultFragment.this, view2);
            }
        });
        Navigator M = M();
        if (M != null) {
            M.n(new PopupToolbarAppearance(0, null, false, 6, null));
        }
    }

    /* compiled from: OperationResultFragment.kt */
    /* loaded from: classes3.dex */
    public static final class ButtonModel implements Parcelable {
        public static final Parcelable.Creator<ButtonModel> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final CharSequence f30962f;

        /* renamed from: g  reason: collision with root package name */
        private final UiKitRoundButtonType f30963g;

        /* compiled from: OperationResultFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<ButtonModel> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final ButtonModel createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new ButtonModel((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (UiKitRoundButtonType) parcel.readParcelable(ButtonModel.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final ButtonModel[] newArray(int i8) {
                return new ButtonModel[i8];
            }
        }

        public ButtonModel(CharSequence text, UiKitRoundButtonType roundButtonType) {
            Intrinsics.f(text, "text");
            Intrinsics.f(roundButtonType, "roundButtonType");
            this.f30962f = text;
            this.f30963g = roundButtonType;
        }

        public final UiKitRoundButtonType a() {
            return this.f30963g;
        }

        public final CharSequence b() {
            return this.f30962f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ButtonModel) {
                ButtonModel buttonModel = (ButtonModel) obj;
                return Intrinsics.a(this.f30962f, buttonModel.f30962f) && this.f30963g == buttonModel.f30963g;
            }
            return false;
        }

        public int hashCode() {
            return (this.f30962f.hashCode() * 31) + this.f30963g.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.f30962f;
            UiKitRoundButtonType uiKitRoundButtonType = this.f30963g;
            return "ButtonModel(text=" + ((Object) charSequence) + ", roundButtonType=" + uiKitRoundButtonType + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            TextUtils.writeToParcel(this.f30962f, out, i8);
            out.writeParcelable(this.f30963g, i8);
        }

        public /* synthetic */ ButtonModel(CharSequence charSequence, UiKitRoundButtonType uiKitRoundButtonType, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i8 & 2) != 0 ? UiKitRoundButtonType.f36164n : uiKitRoundButtonType);
        }
    }
}
