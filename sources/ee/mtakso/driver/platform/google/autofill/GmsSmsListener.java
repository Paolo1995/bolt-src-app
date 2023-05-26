package ee.mtakso.driver.platform.google.autofill;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ee.mtakso.driver.platform.Platform;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.platform.di.PlatformDependencies;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: GmsSmsListener.kt */
/* loaded from: classes3.dex */
public final class GmsSmsListener extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f23287a;

    public GmsSmsListener() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ConfirmationCodeRetriever>() { // from class: ee.mtakso.driver.platform.google.autofill.GmsSmsListener$retriever$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ConfirmationCodeRetriever invoke() {
                PlatformDependencies a8 = Platform.f23272a.a();
                if (a8 != null) {
                    return a8.Y();
                }
                throw new IllegalStateException("Platform dependencies are not initialised".toString());
            }
        });
        this.f23287a = b8;
    }

    private final ConfirmationCodeRetriever a() {
        return (ConfirmationCodeRetriever) this.f23287a.getValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            a().c(intent);
        }
    }
}
