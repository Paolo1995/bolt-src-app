package eu.bolt.driver.core.ui.common.dialog;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment;
import eu.bolt.driver.core.ui.common.dialog.DynamicActionDialog;
import eu.bolt.driver.core.ui.common.dialog.helper.ItemViewInflater;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicActionDialog.kt */
/* loaded from: classes5.dex */
public final class DynamicActionDialog extends LinearScrollableDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f41090m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41091l = new LinkedHashMap();

    /* compiled from: DynamicActionDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Action implements Parcelable {
        public static final Parcelable.Creator<Action> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final CharSequence f41092f;

        /* renamed from: g  reason: collision with root package name */
        private final UiKitRoundButtonType f41093g;

        /* renamed from: h  reason: collision with root package name */
        private final Parcelable f41094h;

        /* compiled from: DynamicActionDialog.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Action> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Action createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Action((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (UiKitRoundButtonType) parcel.readParcelable(Action.class.getClassLoader()), parcel.readParcelable(Action.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Action[] newArray(int i8) {
                return new Action[i8];
            }
        }

        public Action(CharSequence title, UiKitRoundButtonType style, Parcelable parcelable) {
            Intrinsics.f(title, "title");
            Intrinsics.f(style, "style");
            this.f41092f = title;
            this.f41093g = style;
            this.f41094h = parcelable;
        }

        public final Parcelable a() {
            return this.f41094h;
        }

        public final UiKitRoundButtonType b() {
            return this.f41093g;
        }

        public final CharSequence c() {
            return this.f41092f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Action) {
                Action action = (Action) obj;
                return Intrinsics.a(this.f41092f, action.f41092f) && this.f41093g == action.f41093g && Intrinsics.a(this.f41094h, action.f41094h);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f41092f.hashCode() * 31) + this.f41093g.hashCode()) * 31;
            Parcelable parcelable = this.f41094h;
            return hashCode + (parcelable == null ? 0 : parcelable.hashCode());
        }

        public String toString() {
            CharSequence charSequence = this.f41092f;
            UiKitRoundButtonType uiKitRoundButtonType = this.f41093g;
            Parcelable parcelable = this.f41094h;
            return "Action(title=" + ((Object) charSequence) + ", style=" + uiKitRoundButtonType + ", payload=" + parcelable + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            TextUtils.writeToParcel(this.f41092f, out, i8);
            out.writeParcelable(this.f41093g, i8);
            out.writeParcelable(this.f41094h, i8);
        }
    }

    /* compiled from: DynamicActionDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DynamicActionDialog a(Model model, DialogCallback callback) {
            Intrinsics.f(model, "model");
            Intrinsics.f(callback, "callback");
            DynamicActionDialog dynamicActionDialog = new DynamicActionDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_MODEL", model);
            dynamicActionDialog.setArguments(bundle);
            dynamicActionDialog.K(callback);
            return dynamicActionDialog;
        }
    }

    /* compiled from: DynamicActionDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Model implements Parcelable {
        public static final Parcelable.Creator<Model> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final CharSequence f41095f;

        /* renamed from: g  reason: collision with root package name */
        private final CharSequence f41096g;

        /* renamed from: h  reason: collision with root package name */
        private final Action f41097h;

        /* renamed from: i  reason: collision with root package name */
        private final Action f41098i;

        /* compiled from: DynamicActionDialog.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Model> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Model createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                Parcelable.Creator<Action> creator = Action.CREATOR;
                return new Model((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), creator.createFromParcel(parcel), creator.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Model[] newArray(int i8) {
                return new Model[i8];
            }
        }

        public Model(CharSequence title, CharSequence message, Action primaryAction, Action secondaryAction) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(primaryAction, "primaryAction");
            Intrinsics.f(secondaryAction, "secondaryAction");
            this.f41095f = title;
            this.f41096g = message;
            this.f41097h = primaryAction;
            this.f41098i = secondaryAction;
        }

        public final CharSequence a() {
            return this.f41096g;
        }

        public final Action b() {
            return this.f41097h;
        }

        public final Action c() {
            return this.f41098i;
        }

        public final CharSequence d() {
            return this.f41095f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(this.f41095f, model.f41095f) && Intrinsics.a(this.f41096g, model.f41096g) && Intrinsics.a(this.f41097h, model.f41097h) && Intrinsics.a(this.f41098i, model.f41098i);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f41095f.hashCode() * 31) + this.f41096g.hashCode()) * 31) + this.f41097h.hashCode()) * 31) + this.f41098i.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.f41095f;
            CharSequence charSequence2 = this.f41096g;
            Action action = this.f41097h;
            Action action2 = this.f41098i;
            return "Model(title=" + ((Object) charSequence) + ", message=" + ((Object) charSequence2) + ", primaryAction=" + action + ", secondaryAction=" + action2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            TextUtils.writeToParcel(this.f41095f, out, i8);
            TextUtils.writeToParcel(this.f41096g, out, i8);
            this.f41097h.writeToParcel(out, i8);
            this.f41098i.writeToParcel(out, i8);
        }
    }

    public DynamicActionDialog() {
        super(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(DynamicActionDialog this$0, Model model, View it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.dismissAllowingStateLoss();
        Object a8 = model.b().a();
        if (a8 == null) {
            a8 = "TAG_ACTION_PRIMARY";
        }
        DialogCallback E = this$0.E();
        if (E != null) {
            Intrinsics.e(it, "it");
            E.a(this$0, it, a8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(DynamicActionDialog this$0, Model model, View it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.dismissAllowingStateLoss();
        Object a8 = model.c().a();
        if (a8 == null) {
            a8 = "TAG_ACTION_SECONDARY";
        }
        DialogCallback E = this$0.E();
        if (E != null) {
            Intrinsics.e(it, "it");
            E.a(this$0, it, a8);
        }
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f41091l.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        Parcelable parcelable = requireArguments().getParcelable("ARG_MODEL");
        if (parcelable != null) {
            Intrinsics.e(parcelable, "requireNotNull(requireAr…elable<Model>(ARG_MODEL))");
            final Model model = (Model) parcelable;
            M().g(model.d(), container, new Margins(0, 0, 0, Dimens.c(24), 7, null));
            M().d(model.a(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
            ItemViewInflater M = M();
            CharSequence c8 = model.b().c();
            UiKitRoundButtonType b8 = model.b().b();
            UiKitRoundButtonSize uiKitRoundButtonSize = UiKitRoundButtonSize.f36155i;
            M.h(c8, new RoundButtonStyle(b8, uiKitRoundButtonSize), container, new Margins(0, 0, 0, Dimens.c(16), 7, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DynamicActionDialog.R(DynamicActionDialog.this, model, view);
                }
            });
            M().h(model.c().c(), new RoundButtonStyle(model.c().b(), uiKitRoundButtonSize), container, new Margins(0, 0, 0, Dimens.c(16), 7, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DynamicActionDialog.S(DynamicActionDialog.this, model, view);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
