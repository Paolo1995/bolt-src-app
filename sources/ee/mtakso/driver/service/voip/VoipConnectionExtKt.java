package ee.mtakso.driver.service.voip;

import ee.mtakso.driver.network.client.contact.VoipContactDetails;
import ee.mtakso.voip_client.VoipConnection;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipConnectionExt.kt */
/* loaded from: classes3.dex */
public final class VoipConnectionExtKt {
    public static final VoipConnection a(VoipContactDetails voipContactDetails) {
        Map c8;
        Intrinsics.f(voipContactDetails, "voipContactDetails");
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("context", voipContactDetails.a()));
        return new VoipConnection(c8);
    }

    public static final String b(VoipConnection voipConnection) {
        Intrinsics.f(voipConnection, "<this>");
        return voipConnection.a().get("context");
    }

    public static final Boolean c(VoipConnection voipConnection) {
        Intrinsics.f(voipConnection, "<this>");
        String str = voipConnection.a().get("isOrderFinished");
        if (str != null) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        return null;
    }
}
