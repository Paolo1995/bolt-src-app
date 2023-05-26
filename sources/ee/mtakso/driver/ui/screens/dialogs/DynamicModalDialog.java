package ee.mtakso.driver.ui.screens.dialogs;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.network.client.generic.ButtonType;
import ee.mtakso.driver.network.client.modal.ModalDialogAction;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicModalDialog.kt */
/* loaded from: classes3.dex */
public final class DynamicModalDialog extends BaseDialogFragment {

    /* renamed from: o */
    public static final Companion f28274o = new Companion(null);

    /* renamed from: m */
    private final Lazy f28275m;

    /* renamed from: n */
    public Map<Integer, View> f28276n = new LinkedHashMap();

    /* compiled from: DynamicModalDialog.kt */
    /* loaded from: classes3.dex */
    public static final class ActionModel implements Parcelable {
        public static final Parcelable.Creator<ActionModel> CREATOR = new Creator();

        /* renamed from: f */
        private final String f28277f;

        /* renamed from: g */
        private final ButtonType f28278g;

        /* renamed from: h */
        private final String f28279h;

        /* renamed from: i */
        private final String f28280i;

        /* renamed from: j */
        private final ModalInfo f28281j;

        /* compiled from: DynamicModalDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<ActionModel> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final ActionModel createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new ActionModel(parcel.readString(), parcel.readInt() == 0 ? null : ButtonType.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? ModalInfo.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final ActionModel[] newArray(int i8) {
                return new ActionModel[i8];
            }
        }

        public ActionModel(String str, ButtonType buttonType, String text, String str2, ModalInfo modalInfo) {
            Intrinsics.f(text, "text");
            this.f28277f = str;
            this.f28278g = buttonType;
            this.f28279h = text;
            this.f28280i = str2;
            this.f28281j = modalInfo;
        }

        public final String a() {
            return this.f28277f;
        }

        public final String b() {
            return this.f28280i;
        }

        public final ModalInfo c() {
            return this.f28281j;
        }

        public final String d() {
            return this.f28279h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final ButtonType e() {
            return this.f28278g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActionModel) {
                ActionModel actionModel = (ActionModel) obj;
                return Intrinsics.a(this.f28277f, actionModel.f28277f) && this.f28278g == actionModel.f28278g && Intrinsics.a(this.f28279h, actionModel.f28279h) && Intrinsics.a(this.f28280i, actionModel.f28280i) && Intrinsics.a(this.f28281j, actionModel.f28281j);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f28277f;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            ButtonType buttonType = this.f28278g;
            int hashCode2 = (((hashCode + (buttonType == null ? 0 : buttonType.hashCode())) * 31) + this.f28279h.hashCode()) * 31;
            String str2 = this.f28280i;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            ModalInfo modalInfo = this.f28281j;
            return hashCode3 + (modalInfo != null ? modalInfo.hashCode() : 0);
        }

        public String toString() {
            String str = this.f28277f;
            ButtonType buttonType = this.f28278g;
            String str2 = this.f28279h;
            String str3 = this.f28280i;
            ModalInfo modalInfo = this.f28281j;
            return "ActionModel(id=" + str + ", type=" + buttonType + ", text=" + str2 + ", link=" + str3 + ", modalInfo=" + modalInfo + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f28277f);
            ButtonType buttonType = this.f28278g;
            if (buttonType == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                buttonType.writeToParcel(out, i8);
            }
            out.writeString(this.f28279h);
            out.writeString(this.f28280i);
            ModalInfo modalInfo = this.f28281j;
            if (modalInfo == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            modalInfo.writeToParcel(out, i8);
        }
    }

    /* compiled from: DynamicModalDialog.kt */
    /* loaded from: classes3.dex */
    public static final class CancelPayload {

        /* renamed from: a */
        private final String f28282a;

        public CancelPayload(String modalId) {
            Intrinsics.f(modalId, "modalId");
            this.f28282a = modalId;
        }

        public final String a() {
            return this.f28282a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CancelPayload) && Intrinsics.a(this.f28282a, ((CancelPayload) obj).f28282a);
        }

        public int hashCode() {
            return this.f28282a.hashCode();
        }

        public String toString() {
            String str = this.f28282a;
            return "CancelPayload(modalId=" + str + ")";
        }
    }

    /* compiled from: DynamicModalDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: DynamicModalDialog.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a */
            public static final /* synthetic */ int[] f28283a;

            static {
                int[] iArr = new int[ButtonType.values().length];
                try {
                    iArr[ButtonType.ACTION.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ButtonType.PRIMARY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ButtonType.CRITICAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ButtonType.SECONDARY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ButtonType.TEXT_PRIMARY.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ButtonType.TEXT_SECONDARY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f28283a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ActionModel b(ModalDialogAction modalDialogAction, ModalInfo modalInfo) {
            if (modalDialogAction != null) {
                return new ActionModel(modalDialogAction.a(), modalDialogAction.d(), modalDialogAction.c(), modalDialogAction.b(), modalInfo);
            }
            return null;
        }

        public static /* synthetic */ Model f(Companion companion, String str, ModalDialogResponse.Dialog.DialogPayload dialogPayload, ModalInfo modalInfo, Integer num, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                modalInfo = null;
            }
            if ((i8 & 8) != 0) {
                num = null;
            }
            return companion.e(str, dialogPayload, modalInfo, num);
        }

        public final DynamicModalDialog a(Model model, Function3<? super DialogFragment, ? super View, Object, Unit> onAction) {
            Intrinsics.f(model, "model");
            Intrinsics.f(onAction, "onAction");
            Bundle bundle = new Bundle();
            bundle.putParcelable("MODEL_KEY", model);
            DynamicModalDialog dynamicModalDialog = new DynamicModalDialog();
            dynamicModalDialog.setArguments(bundle);
            dynamicModalDialog.J(onAction);
            return dynamicModalDialog;
        }

        public final RoundButtonStyle c(ButtonType buttonType) {
            int i8;
            UiKitRoundButtonType uiKitRoundButtonType;
            UiKitRoundButtonSize uiKitRoundButtonSize = UiKitRoundButtonSize.f36155i;
            if (buttonType == null) {
                i8 = -1;
            } else {
                i8 = WhenMappings.f28283a[buttonType.ordinal()];
            }
            switch (i8) {
                case 1:
                    uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
                    break;
                case 2:
                    uiKitRoundButtonType = UiKitRoundButtonType.f36162l;
                    break;
                case 3:
                    uiKitRoundButtonType = UiKitRoundButtonType.f36163m;
                    break;
                case 4:
                    uiKitRoundButtonType = UiKitRoundButtonType.f36164n;
                    break;
                case 5:
                    uiKitRoundButtonType = UiKitRoundButtonType.f36164n;
                    break;
                case 6:
                    uiKitRoundButtonType = UiKitRoundButtonType.f36164n;
                    break;
                default:
                    uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
                    break;
            }
            return new RoundButtonStyle(uiKitRoundButtonType, uiKitRoundButtonSize);
        }

        public final Model d(ModalDialogResponse.Dialog response, Integer num) {
            Intrinsics.f(response, "response");
            return e(response.a(), response.b(), new ModalInfo(response.a(), response.d(), response.c()), num);
        }

        public final Model e(String dialogId, ModalDialogResponse.Dialog.DialogPayload params, ModalInfo modalInfo, Integer num) {
            boolean z7;
            Intrinsics.f(dialogId, "dialogId");
            Intrinsics.f(params, "params");
            String f8 = params.f();
            Message message = new Message(params.a(), num);
            String b8 = params.b();
            ActionModel b9 = b(params.d(), modalInfo);
            ActionModel b10 = b(params.e(), modalInfo);
            if (params.c() == ModalDialogResponse.Dialog.DialogPayload.LayoutType.RESIZABLE_IMAGE) {
                z7 = true;
            } else {
                z7 = false;
            }
            return new Model(dialogId, f8, message, b8, modalInfo, b9, b10, z7);
        }
    }

    /* compiled from: DynamicModalDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Message implements Parcelable {
        public static final Parcelable.Creator<Message> CREATOR = new Creator();

        /* renamed from: f */
        private final String f28284f;

        /* renamed from: g */
        private final Integer f28285g;

        /* compiled from: DynamicModalDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Message> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Message createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Message(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Message[] newArray(int i8) {
                return new Message[i8];
            }
        }

        public Message(String str, Integer num) {
            this.f28284f = str;
            this.f28285g = num;
        }

        public final Integer a() {
            return this.f28285g;
        }

        public final String b() {
            return this.f28284f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Message) {
                Message message = (Message) obj;
                return Intrinsics.a(this.f28284f, message.f28284f) && Intrinsics.a(this.f28285g, message.f28285g);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f28284f;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.f28285g;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            String str = this.f28284f;
            Integer num = this.f28285g;
            return "Message(text=" + str + ", placeholder=" + num + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            int intValue;
            Intrinsics.f(out, "out");
            out.writeString(this.f28284f);
            Integer num = this.f28285g;
            if (num == null) {
                intValue = 0;
            } else {
                out.writeInt(1);
                intValue = num.intValue();
            }
            out.writeInt(intValue);
        }
    }

    /* compiled from: DynamicModalDialog.kt */
    /* loaded from: classes3.dex */
    public static final class ModalInfo implements Parcelable {
        public static final Parcelable.Creator<ModalInfo> CREATOR = new Creator();

        /* renamed from: f */
        private final String f28286f;

        /* renamed from: g */
        private final String f28287g;

        /* renamed from: h */
        private final String f28288h;

        /* compiled from: DynamicModalDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<ModalInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final ModalInfo createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new ModalInfo(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final ModalInfo[] newArray(int i8) {
                return new ModalInfo[i8];
            }
        }

        public ModalInfo(String modalId, String pollEntryId, String pollCampaignId) {
            Intrinsics.f(modalId, "modalId");
            Intrinsics.f(pollEntryId, "pollEntryId");
            Intrinsics.f(pollCampaignId, "pollCampaignId");
            this.f28286f = modalId;
            this.f28287g = pollEntryId;
            this.f28288h = pollCampaignId;
        }

        public final String a() {
            return this.f28286f;
        }

        public final String b() {
            return this.f28288h;
        }

        public final String c() {
            return this.f28287g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ModalInfo) {
                ModalInfo modalInfo = (ModalInfo) obj;
                return Intrinsics.a(this.f28286f, modalInfo.f28286f) && Intrinsics.a(this.f28287g, modalInfo.f28287g) && Intrinsics.a(this.f28288h, modalInfo.f28288h);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f28286f.hashCode() * 31) + this.f28287g.hashCode()) * 31) + this.f28288h.hashCode();
        }

        public String toString() {
            String str = this.f28286f;
            String str2 = this.f28287g;
            String str3 = this.f28288h;
            return "ModalInfo(modalId=" + str + ", pollEntryId=" + str2 + ", pollCampaignId=" + str3 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f28286f);
            out.writeString(this.f28287g);
            out.writeString(this.f28288h);
        }
    }

    /* compiled from: DynamicModalDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Model implements Parcelable {
        public static final Parcelable.Creator<Model> CREATOR = new Creator();

        /* renamed from: f */
        private final String f28289f;

        /* renamed from: g */
        private final String f28290g;

        /* renamed from: h */
        private final Message f28291h;

        /* renamed from: i */
        private final String f28292i;

        /* renamed from: j */
        private final ModalInfo f28293j;

        /* renamed from: k */
        private final ActionModel f28294k;

        /* renamed from: l */
        private final ActionModel f28295l;

        /* renamed from: m */
        private final boolean f28296m;

        /* compiled from: DynamicModalDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Model> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Model createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Model(parcel.readString(), parcel.readString(), Message.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : ModalInfo.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ActionModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ActionModel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Model[] newArray(int i8) {
                return new Model[i8];
            }
        }

        public Model(String str, String title, Message message, String str2, ModalInfo modalInfo, ActionModel actionModel, ActionModel actionModel2, boolean z7) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            this.f28289f = str;
            this.f28290g = title;
            this.f28291h = message;
            this.f28292i = str2;
            this.f28293j = modalInfo;
            this.f28294k = actionModel;
            this.f28295l = actionModel2;
            this.f28296m = z7;
        }

        public final String a() {
            return this.f28289f;
        }

        public final String b() {
            return this.f28292i;
        }

        public final Message c() {
            return this.f28291h;
        }

        public final ActionModel d() {
            return this.f28294k;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final ActionModel e() {
            return this.f28295l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(this.f28289f, model.f28289f) && Intrinsics.a(this.f28290g, model.f28290g) && Intrinsics.a(this.f28291h, model.f28291h) && Intrinsics.a(this.f28292i, model.f28292i) && Intrinsics.a(this.f28293j, model.f28293j) && Intrinsics.a(this.f28294k, model.f28294k) && Intrinsics.a(this.f28295l, model.f28295l) && this.f28296m == model.f28296m;
            }
            return false;
        }

        public final String f() {
            return this.f28290g;
        }

        public final boolean g() {
            return this.f28296m;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.f28289f;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.f28290g.hashCode()) * 31) + this.f28291h.hashCode()) * 31;
            String str2 = this.f28292i;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            ModalInfo modalInfo = this.f28293j;
            int hashCode3 = (hashCode2 + (modalInfo == null ? 0 : modalInfo.hashCode())) * 31;
            ActionModel actionModel = this.f28294k;
            int hashCode4 = (hashCode3 + (actionModel == null ? 0 : actionModel.hashCode())) * 31;
            ActionModel actionModel2 = this.f28295l;
            int hashCode5 = (hashCode4 + (actionModel2 != null ? actionModel2.hashCode() : 0)) * 31;
            boolean z7 = this.f28296m;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode5 + i8;
        }

        public String toString() {
            String str = this.f28289f;
            String str2 = this.f28290g;
            Message message = this.f28291h;
            String str3 = this.f28292i;
            ModalInfo modalInfo = this.f28293j;
            ActionModel actionModel = this.f28294k;
            ActionModel actionModel2 = this.f28295l;
            boolean z7 = this.f28296m;
            return "Model(id=" + str + ", title=" + str2 + ", message=" + message + ", imageUrl=" + str3 + ", modalInfo=" + modalInfo + ", primaryAction=" + actionModel + ", secondaryAction=" + actionModel2 + ", isResizable=" + z7 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f28289f);
            out.writeString(this.f28290g);
            this.f28291h.writeToParcel(out, i8);
            out.writeString(this.f28292i);
            ModalInfo modalInfo = this.f28293j;
            if (modalInfo == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                modalInfo.writeToParcel(out, i8);
            }
            ActionModel actionModel = this.f28294k;
            if (actionModel == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                actionModel.writeToParcel(out, i8);
            }
            ActionModel actionModel2 = this.f28295l;
            if (actionModel2 == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                actionModel2.writeToParcel(out, i8);
            }
            out.writeInt(this.f28296m ? 1 : 0);
        }
    }

    public DynamicModalDialog() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Model>() { // from class: ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog$optionalModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DynamicModalDialog.Model invoke() {
                Bundle arguments = DynamicModalDialog.this.getArguments();
                if (arguments != null) {
                    return (DynamicModalDialog.Model) arguments.getParcelable("MODEL_KEY");
                }
                return null;
            }
        });
        this.f28275m = b8;
    }

    private final void Q(ViewGroup viewGroup, final ActionModel actionModel) {
        ItemViewFactory itemViewFactory = ItemViewFactory.f35921a;
        String d8 = actionModel.d();
        RoundButtonStyle c8 = f28274o.c(actionModel.e());
        Rect rect = new Rect();
        rect.top = Dimens.c(16);
        itemViewFactory.q(viewGroup, d8, rect, c8).setOnClickListener(new View.OnClickListener() { // from class: i3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DynamicModalDialog.R(DynamicModalDialog.this, actionModel, view);
            }
        });
    }

    public static final void R(DynamicModalDialog this$0, ActionModel action, View view) {
        Unit unit;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(action, "$action");
        this$0.dismissAllowingStateLoss();
        Function3<DialogFragment, View, Object, Unit> F = this$0.F();
        if (F != null) {
            F.l(this$0, view, action);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            Kalev.d("on item click");
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28276n.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28276n;
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

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public void O(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        Model S = S();
        if (S == null) {
            dismiss();
            return;
        }
        container.setPadding(Dimens.c(24), Dimens.c(24), Dimens.c(24), Dimens.c(24));
        ItemViewFactory itemViewFactory = ItemViewFactory.f35921a;
        String b8 = S.b();
        if (b8 != null) {
            Rect rect = new Rect();
            rect.bottom = Dimens.c(16);
            Unit unit = Unit.f50853a;
            itemViewFactory.f(container, b8, rect, S.g());
        }
        String f8 = S.f();
        Rect rect2 = new Rect();
        rect2.bottom = Dimens.c(16);
        Unit unit2 = Unit.f50853a;
        itemViewFactory.o(container, f8, rect2);
        String b9 = S.c().b();
        if (b9 != null) {
            Rect rect3 = new Rect();
            rect3.bottom = Dimens.c(16);
            itemViewFactory.j(container, b9, rect3, S.c().a());
        }
        ActionModel d8 = S.d();
        if (d8 != null) {
            Q(container, d8);
        }
        ActionModel e8 = S.e();
        if (e8 != null) {
            Q(container, e8);
        }
    }

    public final Model S() {
        return (Model) this.f28275m.getValue();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        String a8;
        Function3<DialogFragment, View, Object, Unit> F;
        Intrinsics.f(dialog, "dialog");
        Model S = S();
        if (S != null && (a8 = S.a()) != null && (F = F()) != null) {
            F.l(this, null, new CancelPayload(a8));
        }
        super.onCancel(dialog);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
