package ee.mtakso.driver.ui.screens.dialogs;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationDialog.kt */
/* loaded from: classes3.dex */
public final class NotificationDialog extends BaseDialogFragment {

    /* renamed from: n */
    public static final Companion f28313n = new Companion(null);

    /* renamed from: m */
    public Map<Integer, View> f28314m = new LinkedHashMap();

    /* compiled from: NotificationDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NotificationDialog c(Companion companion, Context context, Throwable th, Function3 function3, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                function3 = null;
            }
            return companion.a(context, th, function3);
        }

        public static /* synthetic */ NotificationDialog d(Companion companion, String str, String str2, String str3, Throwable th, Function3 function3, int i8, Object obj) {
            Throwable th2;
            Function3 function32;
            if ((i8 & 8) != 0) {
                th2 = null;
            } else {
                th2 = th;
            }
            if ((i8 & 16) != 0) {
                function32 = null;
            } else {
                function32 = function3;
            }
            return companion.b(str, str2, str3, th2, function32);
        }

        public static /* synthetic */ NotificationDialog f(Companion companion, String str, String str2, String str3, Integer num, Function3 function3, Throwable th, int i8, Object obj) {
            Function3 function32;
            Throwable th2;
            if ((i8 & 16) != 0) {
                function32 = null;
            } else {
                function32 = function3;
            }
            if ((i8 & 32) != 0) {
                th2 = null;
            } else {
                th2 = th;
            }
            return companion.e(str, str2, str3, num, function32, th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NotificationDialog i(Companion companion, String str, String str2, String str3, Function3 function3, int i8, Object obj) {
            if ((i8 & 8) != 0) {
                function3 = null;
            }
            return companion.h(str, str2, str3, function3);
        }

        public final NotificationDialog a(Context context, Throwable th, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
            String string;
            String str;
            int i8;
            Intrinsics.f(context, "context");
            if (th == null || (string = ApiExceptionUtils.l(th, context)) == null) {
                string = context.getString(R.string.error);
                Intrinsics.e(string, "context.getString(R.string.error)");
            }
            String str2 = string;
            if (th != null) {
                str = ApiExceptionUtils.k(th, context);
            } else {
                str = null;
            }
            String str3 = str;
            String string2 = context.getString(R.string.close);
            Intrinsics.e(string2, "context.getString(R.string.close)");
            if (th != null) {
                i8 = ApiExceptionUtils.h(th);
            } else {
                i8 = R.drawable.ic_error;
            }
            return e(str2, str3, string2, Integer.valueOf(i8), function3, th);
        }

        public final NotificationDialog b(String str, String str2, String dismissText, Throwable th, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
            Intrinsics.f(dismissText, "dismissText");
            return e(str, str2, dismissText, Integer.valueOf((int) R.drawable.ic_error), function3, th);
        }

        public final NotificationDialog e(String str, String str2, String dismissText, Integer num, Function3<? super DialogFragment, ? super View, Object, Unit> function3, Throwable th) {
            Intrinsics.f(dismissText, "dismissText");
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            bundle.putString("message", str2);
            bundle.putString("dismiss", dismissText);
            bundle.putSerializable("cause", th);
            if (num != null) {
                bundle.putInt("icon", num.intValue());
            }
            NotificationDialog notificationDialog = new NotificationDialog();
            notificationDialog.setArguments(bundle);
            notificationDialog.K(function3);
            return notificationDialog;
        }

        public final NotificationDialog g(String str, String str2, String dismissText, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
            Intrinsics.f(dismissText, "dismissText");
            return f(this, str, str2, dismissText, Integer.valueOf((int) R.drawable.ic_check_green_outline), function3, null, 32, null);
        }

        public final NotificationDialog h(String title, String message, String dismissText, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(dismissText, "dismissText");
            return f(this, title, message, dismissText, Integer.valueOf((int) R.drawable.ic_warning_yellow), function3, null, 32, null);
        }
    }

    public static final NotificationDialog Q(Context context, Throwable th, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
        return f28313n.a(context, th, function3);
    }

    public static final void R(NotificationDialog this$0, View view) {
        Unit unit;
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "dismiss");
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
        this.f28314m.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28314m;
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
        ItemViewFactory itemViewFactory = ItemViewFactory.f35921a;
        if (E("icon") != 0) {
            int E = E("icon");
            Rect rect = new Rect();
            rect.bottom = Dimens.c(16);
            Unit unit = Unit.f50853a;
            itemViewFactory.e(container, E, rect);
        }
        String H = H("title", "");
        Rect rect2 = new Rect();
        rect2.bottom = Dimens.c(16);
        Unit unit2 = Unit.f50853a;
        itemViewFactory.o(container, H, rect2);
        String H2 = H("message", "");
        Rect rect3 = new Rect();
        rect3.bottom = Dimens.c(16);
        itemViewFactory.h(container, H2, rect3);
        ItemViewFactory.l(itemViewFactory, container, H("dismiss", ""), null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: i3.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationDialog.R(NotificationDialog.this, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
