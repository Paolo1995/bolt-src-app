package eu.bolt.verification.sdk;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.provider.FontRequest;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.FontRequestEmojiCompatConfig;
import eu.bolt.android.rib.ViewRouter;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.verification.R$array;
import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.Cdo;
import eu.bolt.verification.sdk.internal.co;
import eu.bolt.verification.sdk.internal.g;
import eu.bolt.verification.sdk.internal.jc;
import eu.bolt.verification.sdk.internal.jg;
import eu.bolt.verification.sdk.internal.ln;
import eu.bolt.verification.sdk.internal.m3;
import eu.bolt.verification.sdk.internal.rn;
import eu.bolt.verification.sdk.internal.xi;
import eu.bolt.verification.sdk.internal.yn;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class VerificationSDKActivity extends jg implements co, jc.b {

    /* renamed from: o  reason: collision with root package name */
    public static final a f41928o = new a(null);

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f41929m;

    /* renamed from: n  reason: collision with root package name */
    private final Lazy f41930n;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends VerificationSDKConfiguration> void a(Application application, String flowId, Class<T> configClass) {
            Intrinsics.f(application, "application");
            Intrinsics.f(flowId, "flowId");
            Intrinsics.f(configClass, "configClass");
            Intent intent = new Intent(application, VerificationSDKActivity.class);
            intent.putExtra("args_CNFG", new b(flowId, configClass));
            intent.addFlags(268435456);
            application.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b<T extends VerificationSDKConfiguration> implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final String f41931f;

        /* renamed from: g  reason: collision with root package name */
        private final Class<T> f41932g;

        public b(String flowId, Class<T> configClass) {
            Intrinsics.f(flowId, "flowId");
            Intrinsics.f(configClass, "configClass");
            this.f41931f = flowId;
            this.f41932g = configClass;
        }

        public final Class<T> a() {
            return this.f41932g;
        }

        public final String b() {
            return this.f41931f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f41931f, bVar.f41931f) && Intrinsics.a(this.f41932g, bVar.f41932g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f41931f.hashCode() * 31) + this.f41932g.hashCode();
        }

        public String toString() {
            String str = this.f41931f;
            Class<T> cls = this.f41932g;
            return "InternalConfig(flowId=" + str + ", configClass=" + cls + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function0<b<?>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final b<?> invoke() {
            Serializable serializableExtra = VerificationSDKActivity.this.getIntent().getSerializableExtra("args_CNFG");
            b<?> bVar = serializableExtra instanceof b ? (b) serializableExtra : null;
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalStateException("Verification activity was runned without configuration");
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function0<VerificationSDKConfiguration> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final VerificationSDKConfiguration invoke() {
            return (VerificationSDKConfiguration) VerificationSDKActivity.this.k0().a().newInstance();
        }
    }

    public VerificationSDKActivity() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new c());
        this.f41929m = b8;
        b9 = LazyKt__LazyJVMKt.b(new d());
        this.f41930n = b9;
    }

    private final ln i0(ViewGroup viewGroup) {
        ln.a c8 = m3.a().d(new g(this)).c(this);
        VerificationSDKConfiguration sdkConfig = l0();
        Intrinsics.e(sdkConfig, "sdkConfig");
        return c8.b(sdkConfig).a(viewGroup).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b<?> k0() {
        return (b) this.f41929m.getValue();
    }

    private final VerificationSDKConfiguration l0() {
        return (VerificationSDKConfiguration) this.f41930n.getValue();
    }

    @Override // eu.bolt.android.rib.RibActivity
    protected ViewRouter<?> V(ViewGroup parentViewGroup) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new rn(i0(frameLayout)).b(frameLayout, new yn(k0().b()));
    }

    @Override // eu.bolt.verification.sdk.internal.jc.b
    public jc.c a() {
        return null;
    }

    public void j0(String storyId) {
        Intrinsics.f(storyId, "storyId");
        ViewRouter<?> Y = Y();
        Intrinsics.d(Y, "null cannot be cast to non-null type eu.bolt.verification.core.rib.VerificationFlowRouter");
        DynamicStateController1Arg.k(((Cdo) Y).f1(), new xi.a(storyId), false, 2, null);
    }

    @Override // eu.bolt.verification.sdk.internal.jg, eu.bolt.android.rib.RibActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        EmojiCompat.f(new FontRequestEmojiCompatConfig(this, new FontRequest("com.google.android.gms.fonts", "com.google.android.gms", "Noto Color Emoji Compat", R$array.com_google_android_gms_fonts_certs)));
        super.onCreate(bundle);
    }

    @Override // eu.bolt.verification.sdk.internal.co
    public void v(VerificationFlowStatus status) {
        Intrinsics.f(status, "status");
        VerificationStatusCallback b8 = l0().b();
        if (b8 != null) {
            b8.a(status);
        }
        finish();
    }
}
