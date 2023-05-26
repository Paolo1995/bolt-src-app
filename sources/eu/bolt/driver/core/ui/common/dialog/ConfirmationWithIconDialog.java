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
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmationWithIconDialog.kt */
/* loaded from: classes5.dex */
public final class ConfirmationWithIconDialog extends LinearScrollableDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f41082m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41083l = new LinkedHashMap();

    /* compiled from: ConfirmationWithIconDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConfirmationWithIconDialog a(int i8, CharSequence title, CharSequence message, CharSequence confirmText, UiKitRoundButtonType confirmButtonType, CharSequence cancelText, DialogCallback callback, Bundle bundle) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(confirmButtonType, "confirmButtonType");
            Intrinsics.f(cancelText, "cancelText");
            Intrinsics.f(callback, "callback");
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("CONFIG_KEY", new Model(i8, title, message, confirmText, cancelText, new RoundButtonStyle(confirmButtonType, UiKitRoundButtonSize.f36155i)));
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            ConfirmationWithIconDialog confirmationWithIconDialog = new ConfirmationWithIconDialog();
            confirmationWithIconDialog.setArguments(bundle2);
            confirmationWithIconDialog.K(callback);
            return confirmationWithIconDialog;
        }
    }

    /* compiled from: ConfirmationWithIconDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Model implements Parcelable {
        public static final Parcelable.Creator<Model> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f41084f;

        /* renamed from: g  reason: collision with root package name */
        private final CharSequence f41085g;

        /* renamed from: h  reason: collision with root package name */
        private final CharSequence f41086h;

        /* renamed from: i  reason: collision with root package name */
        private final CharSequence f41087i;

        /* renamed from: j  reason: collision with root package name */
        private final CharSequence f41088j;

        /* renamed from: k  reason: collision with root package name */
        private final RoundButtonStyle f41089k;

        /* compiled from: ConfirmationWithIconDialog.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Model> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Model createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Model(parcel.readInt(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (RoundButtonStyle) parcel.readParcelable(Model.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Model[] newArray(int i8) {
                return new Model[i8];
            }
        }

        public Model(int i8, CharSequence title, CharSequence message, CharSequence confirmText, CharSequence cancelText, RoundButtonStyle confirmButtonStyle) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(cancelText, "cancelText");
            Intrinsics.f(confirmButtonStyle, "confirmButtonStyle");
            this.f41084f = i8;
            this.f41085g = title;
            this.f41086h = message;
            this.f41087i = confirmText;
            this.f41088j = cancelText;
            this.f41089k = confirmButtonStyle;
        }

        public final CharSequence a() {
            return this.f41088j;
        }

        public final RoundButtonStyle b() {
            return this.f41089k;
        }

        public final CharSequence c() {
            return this.f41087i;
        }

        public final int d() {
            return this.f41084f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final CharSequence e() {
            return this.f41086h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return this.f41084f == model.f41084f && Intrinsics.a(this.f41085g, model.f41085g) && Intrinsics.a(this.f41086h, model.f41086h) && Intrinsics.a(this.f41087i, model.f41087i) && Intrinsics.a(this.f41088j, model.f41088j) && Intrinsics.a(this.f41089k, model.f41089k);
            }
            return false;
        }

        public final CharSequence f() {
            return this.f41085g;
        }

        public int hashCode() {
            return (((((((((this.f41084f * 31) + this.f41085g.hashCode()) * 31) + this.f41086h.hashCode()) * 31) + this.f41087i.hashCode()) * 31) + this.f41088j.hashCode()) * 31) + this.f41089k.hashCode();
        }

        public String toString() {
            int i8 = this.f41084f;
            CharSequence charSequence = this.f41085g;
            CharSequence charSequence2 = this.f41086h;
            CharSequence charSequence3 = this.f41087i;
            CharSequence charSequence4 = this.f41088j;
            RoundButtonStyle roundButtonStyle = this.f41089k;
            return "Model(iconResId=" + i8 + ", title=" + ((Object) charSequence) + ", message=" + ((Object) charSequence2) + ", confirmText=" + ((Object) charSequence3) + ", cancelText=" + ((Object) charSequence4) + ", confirmButtonStyle=" + roundButtonStyle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f41084f);
            TextUtils.writeToParcel(this.f41085g, out, i8);
            TextUtils.writeToParcel(this.f41086h, out, i8);
            TextUtils.writeToParcel(this.f41087i, out, i8);
            TextUtils.writeToParcel(this.f41088j, out, i8);
            out.writeParcelable(this.f41089k, i8);
        }
    }

    public ConfirmationWithIconDialog() {
        super(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ConfirmationWithIconDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "ITEM_CONFIRM_TAG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ConfirmationWithIconDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "ITEM_CANCEL_TAG");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f41083l.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        Model model = (Model) requireArguments().getParcelable("CONFIG_KEY");
        if (model != null) {
            M().c(model.d(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
            M().g(model.f(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
            M().d(model.e(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
            M().h(model.c(), model.b(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationWithIconDialog.R(ConfirmationWithIconDialog.this, view);
                }
            });
            M().e(model.a(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationWithIconDialog.S(ConfirmationWithIconDialog.this, view);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Missing dialog cofig");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
