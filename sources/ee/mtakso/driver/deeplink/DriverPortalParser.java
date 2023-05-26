package ee.mtakso.driver.deeplink;

import android.net.Uri;
import com.google.android.gms.common.Scopes;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class DriverPortalParser extends NoIntentDeeplinkParser {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f20019a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f20020b;

    public DriverPortalParser() {
        Set<String> f8;
        Set<String> a8;
        f8 = SetsKt__SetsKt.f(Scopes.PROFILE, "documents", "orders", "vehicles", "v2/vehicles", "v2/vehicles/add", "rider-invoices", "invoices", "compensations", "balance-reports", "tax-reports", "payouts");
        this.f20019a = f8;
        a8 = SetsKt__SetsJVMKt.a("fleetInvitation");
        this.f20020b = a8;
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        String str;
        Intrinsics.f(uri, "uri");
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments != null) {
            str = CollectionsKt___CollectionsKt.f0(pathSegments, "/", null, null, 0, null, null, 62, null);
        } else {
            str = null;
        }
        String queryParameter = uri.getQueryParameter("hash");
        if (str == null) {
            return new DeeplinkCall.DriverPortalRoot();
        }
        if (this.f20020b.contains(str) && queryParameter != null) {
            return new DeeplinkCall.DriverPortalWithHash(str, queryParameter);
        }
        if (this.f20019a.contains(str)) {
            return new DeeplinkCall.DriverPortal(str);
        }
        return new DeeplinkCall.DriverPortalRoot();
    }
}
