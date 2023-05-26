package eu.bolt.chat.chatcore.network.security;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstallerApi19;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecurityProviderInstallerApi19.kt */
/* loaded from: classes5.dex */
public final class SecurityProviderInstallerApi19 implements SecurityProviderInstaller {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38376a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f38377b;

    public SecurityProviderInstallerApi19(Context context, Logger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(logger, "logger");
        this.f38376a = context;
        this.f38377b = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SecurityProviderInstallerApi19 this$0) {
        Intrinsics.f(this$0, "this$0");
        try {
            ProviderInstaller.installIfNeeded(this$0.f38376a);
        } catch (GooglePlayServicesNotAvailableException unused) {
            this$0.f38377b.b("Google Play services are not available");
        } catch (GooglePlayServicesRepairableException e8) {
            this$0.f38377b.d("Google Play services are out of date");
            GoogleApiAvailability.getInstance().showErrorNotification(this$0.f38376a, e8.getConnectionStatusCode());
        }
    }

    @Override // eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller
    public Completable a() {
        Completable u7 = Completable.u(new Action() { // from class: m6.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                SecurityProviderInstallerApi19.c(SecurityProviderInstallerApi19.this);
            }
        });
        Intrinsics.e(u7, "fromAction {\n        try…ailable\")\n        }\n    }");
        return u7;
    }
}
