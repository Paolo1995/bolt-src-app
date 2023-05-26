package ee.mtakso.driver.ui.screens.order.v2;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatUiDelegate.kt */
/* loaded from: classes3.dex */
public final class ChatUiDelegate {

    /* renamed from: g  reason: collision with root package name */
    private static final Companion f31918g = new Companion(null);
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    private static final long f31919h = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: a  reason: collision with root package name */
    private final View f31920a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderViewModel f31921b;

    /* renamed from: c  reason: collision with root package name */
    private final RoutingManager f31922c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f31923d;

    /* renamed from: e  reason: collision with root package name */
    private ChatMessageEntity f31924e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f31925f;

    /* compiled from: ChatUiDelegate.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChatUiDelegate(View containerView, OrderViewModel viewModel, RoutingManager routingManager) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(viewModel, "viewModel");
        Intrinsics.f(routingManager, "routingManager");
        this.f31925f = new LinkedHashMap();
        this.f31920a = containerView;
        this.f31921b = viewModel;
        this.f31922c = routingManager;
        this.f31923d = new Handler();
        ((ImageView) d(R.id.chatButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatUiDelegate.e(ChatUiDelegate.this, view);
            }
        });
        ((AppCompatTextView) d(R.id.chatText)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatUiDelegate.f(ChatUiDelegate.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ChatUiDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f31921b.L3();
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ChatUiDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f31921b.L3();
        this$0.i();
    }

    private final void j() {
        this.f31923d.removeCallbacksAndMessages(null);
    }

    private final void k(ChatMessageEntity chatMessageEntity) {
        this.f31924e = chatMessageEntity;
        int i8 = R.id.chatText;
        AppCompatTextView appCompatTextView = (AppCompatTextView) d(i8);
        String k8 = chatMessageEntity.k();
        if (k8 == null) {
            k8 = "";
        }
        appCompatTextView.setText(k8);
        AppCompatTextView chatText = (AppCompatTextView) d(i8);
        Intrinsics.e(chatText, "chatText");
        ViewExtKt.e(chatText, false, 0, 3, null);
        j();
        this.f31923d.postDelayed(new Runnable() { // from class: ee.mtakso.driver.ui.screens.order.v2.c0
            @Override // java.lang.Runnable
            public final void run() {
                ChatUiDelegate.l(ChatUiDelegate.this);
            }
        }, f31919h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ChatUiDelegate this$0) {
        Intrinsics.f(this$0, "this$0");
        AppCompatTextView chatText = (AppCompatTextView) this$0.d(R.id.chatText);
        Intrinsics.e(chatText, "chatText");
        ViewExtKt.e(chatText, false, 0, 2, null);
    }

    public View d(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31925f;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View g8 = g();
            if (g8 == null || (findViewById = g8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public View g() {
        return this.f31920a;
    }

    public final void h() {
        j();
        AppCompatTextView chatText = (AppCompatTextView) d(R.id.chatText);
        Intrinsics.e(chatText, "chatText");
        ViewExtKt.e(chatText, false, 0, 2, null);
    }

    public final void i() {
        j();
        AppCompatTextView chatText = (AppCompatTextView) d(R.id.chatText);
        Intrinsics.e(chatText, "chatText");
        ViewExtKt.e(chatText, false, 0, 2, null);
        this.f31922c.c(DriverChatSdk.f40388a.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(java.util.List<ee.mtakso.driver.ui.screens.order.v2.order.ChatButtonInfo> r12) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.ChatUiDelegate.m(java.util.List):void");
    }
}
