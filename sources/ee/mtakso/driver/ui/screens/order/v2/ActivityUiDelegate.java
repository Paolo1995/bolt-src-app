package ee.mtakso.driver.ui.screens.order.v2;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.ui.screens.order.dialog.RiderMessageDialog;
import ee.mtakso.driver.ui.screens.order.v2.map.NavigationMode;
import ee.mtakso.driver.ui.screens.order.v2.order.ExtraInfo;
import ee.mtakso.driver.ui.screens.order.v2.order.ScreenState;
import ee.mtakso.driver.ui.utils.ClipboardUtil;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.utils.TranslationUtils;
import ee.mtakso.driver.utils.UrlLauncher;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityUiDelegate.kt */
/* loaded from: classes3.dex */
public final class ActivityUiDelegate {

    /* renamed from: l  reason: collision with root package name */
    private static final Companion f31898l = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final View f31899a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f31900b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderViewModel f31901c;

    /* renamed from: d  reason: collision with root package name */
    private final UrlLauncher f31902d;

    /* renamed from: e  reason: collision with root package name */
    private final LanguageManager f31903e;

    /* renamed from: f  reason: collision with root package name */
    private final UiNotificationManager f31904f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f31905g;

    /* renamed from: h  reason: collision with root package name */
    private String f31906h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31907i;

    /* renamed from: j  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f31908j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f31909k;

    /* compiled from: ActivityUiDelegate.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ActivityUiDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31910a;

        static {
            int[] iArr = new int[NavigationMode.values().length];
            try {
                iArr[NavigationMode.FOLLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f31910a = iArr;
        }
    }

    public ActivityUiDelegate(View containerView, FragmentManager fragmentManager, OrderViewModel viewModel, UrlLauncher urlLauncher, LanguageManager languageManager, UiNotificationManager uiNotificationManager, boolean z7) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(fragmentManager, "fragmentManager");
        Intrinsics.f(viewModel, "viewModel");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(uiNotificationManager, "uiNotificationManager");
        this.f31909k = new LinkedHashMap();
        this.f31899a = containerView;
        this.f31900b = fragmentManager;
        this.f31901c = viewModel;
        this.f31902d = urlLauncher;
        this.f31903e = languageManager;
        this.f31904f = uiNotificationManager;
        this.f31905g = z7;
        Function3<DialogFragment, View, Object, Unit> function3 = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActivityUiDelegate$onMessageViewClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                OrderViewModel orderViewModel;
                LanguageManager languageManager2;
                UrlLauncher urlLauncher2;
                Intrinsics.f(dialogFragment, "dialogFragment");
                if (Intrinsics.a(obj, "link")) {
                    String message = dialogFragment.requireArguments().getString("message", "");
                    TranslationUtils translationUtils = TranslationUtils.f36331a;
                    languageManager2 = ActivityUiDelegate.this.f31903e;
                    String b8 = languageManager2.f().b();
                    Intrinsics.e(message, "message");
                    String a8 = translationUtils.a(b8, message);
                    urlLauncher2 = ActivityUiDelegate.this.f31902d;
                    if (!urlLauncher2.a(a8)) {
                        Context context = ActivityUiDelegate.this.f().getContext();
                        Intrinsics.e(context, "containerView.context");
                        new ClipboardUtil(context).a(message);
                        Toast.makeText(ActivityUiDelegate.this.f().getContext(), (int) R.string.translate_message_copied_clipboard, 0).show();
                    }
                } else if (Intrinsics.a(obj, "ok")) {
                    orderViewModel = ActivityUiDelegate.this.f31901c;
                    orderViewModel.r1();
                    dialogFragment.dismissAllowingStateLoss();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.f31908j = function3;
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, fragmentManager, "extra_info_dialog", function3, null, 8, null);
    }

    private final void g(String str, String str2) {
        Image url;
        if (str2 != null) {
            url = new Image.DarkLight(new Image.Url(str2), new Image.Url(str));
        } else {
            url = new Image.Url(str);
        }
        ImageView externalNavigationButton = (ImageView) a(R.id.externalNavigationButton);
        Intrinsics.e(externalNavigationButton, "externalNavigationButton");
        ImageKt.a(url, externalNavigationButton, ResourcesCompat.f(f().getResources(), R.drawable.ic_active_order_default_nav, null));
    }

    private final void j() {
        Ringtone ringtone = RingtoneManager.getRingtone(f().getContext(), RingtoneManager.getDefaultUri(2));
        if (ringtone != null) {
            ringtone.play();
        }
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31909k;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View f8 = f();
            if (f8 == null || (findViewById = f8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void e(ExtraInfo extraInfo) {
        if (extraInfo == null) {
            ((ImageView) a(R.id.extraInfoButton)).setVisibility(4);
            return;
        }
        ((ImageView) a(R.id.extraInfoButton)).setVisibility(0);
        if (!extraInfo.b() && !Intrinsics.a(this.f31906h, extraInfo.a()) && this.f31907i) {
            this.f31906h = extraInfo.a();
            k(extraInfo, true);
        }
    }

    public View f() {
        return this.f31899a;
    }

    public final void h() {
        this.f31907i = false;
    }

    public final void i() {
        this.f31907i = true;
        this.f31904f.p();
    }

    public final void k(ExtraInfo extraInfo, boolean z7) {
        DialogFragment dialogFragment;
        Intrinsics.f(extraInfo, "extraInfo");
        Fragment findFragmentByTag = this.f31900b.findFragmentByTag("extra_info_dialog");
        if (findFragmentByTag instanceof DialogFragment) {
            dialogFragment = (DialogFragment) findFragmentByTag;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
        RiderMessageDialog a8 = RiderMessageDialog.f31286n.a(extraInfo.a(), this.f31908j);
        if (z7) {
            j();
        }
        a8.showNow(this.f31900b, "extra_info_dialog");
    }

    public final void l(ScreenState data) {
        Intrinsics.f(data, "data");
        if (data.d() == NavigationMode.FOLLOW) {
            ((ImageView) a(R.id.externalNavigationButton)).setVisibility(8);
        } else if (this.f31905g && data.f() != null) {
            String darkIconUrl = data.f().getDarkIconUrl();
            String lightIconUrl = data.f().getLightIconUrl();
            if (lightIconUrl != null) {
                g(lightIconUrl, darkIconUrl);
            }
            ((ImageView) a(R.id.externalNavigationButton)).setVisibility(0);
        } else if (!this.f31905g && data.g().getType() != Navigator.Type.NO_NAVIGATION_SELECTED && data.g().getType() != Navigator.Type.TAXIFY_NAVIGATION) {
            int i8 = R.id.externalNavigationButton;
            ((ImageView) a(i8)).setImageResource(data.g().c());
            ((ImageView) a(i8)).setVisibility(0);
        } else {
            ((ImageView) a(R.id.externalNavigationButton)).setVisibility(8);
        }
    }

    public final void m(NavigationMode navMode) {
        Intrinsics.f(navMode, "navMode");
        if (WhenMappings.f31910a[navMode.ordinal()] == 1) {
            ((ImageView) a(R.id.internalNavigationButton)).setImageResource(R.drawable.ic_active_order_show_route);
        } else {
            ((ImageView) a(R.id.internalNavigationButton)).setImageResource(R.drawable.ic_active_order_inapp_nav);
        }
    }
}
