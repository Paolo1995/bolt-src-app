package ee.mtakso.driver.navigation;

import android.content.Intent;
import android.net.Uri;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidIntentBuilder.kt */
/* loaded from: classes3.dex */
public final class AndroidIntentBuilder {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f21191d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final NavigationOption.IntentDataHolder f21192a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f21193b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f21194c;

    /* compiled from: AndroidIntentBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AndroidIntentBuilder(ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption r13, ee.mtakso.driver.service.geo.GeoCoordinate r14) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.navigation.AndroidIntentBuilder.<init>(ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption, ee.mtakso.driver.service.geo.GeoCoordinate):void");
    }

    public final Intent a() {
        Set<Map.Entry<String, Object>> entrySet;
        Intent intent = new Intent();
        NavigationOption.IntentDataHolder intentDataHolder = this.f21192a;
        if (intentDataHolder != null) {
            intent.setAction(intentDataHolder.getAction());
            intent.setDataAndType(this.f21193b, intentDataHolder.getType());
            intent.setPackage(intentDataHolder.getPackageName());
            Map<String, Object> map = this.f21194c;
            if (map != null && (entrySet = map.entrySet()) != null) {
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        Object value2 = entry.getValue();
                        Intrinsics.d(value2, "null cannot be cast to non-null type kotlin.String");
                        intent.putExtra((String) entry.getKey(), (String) value2);
                    } else if (value instanceof Float) {
                        Object value3 = entry.getValue();
                        Intrinsics.d(value3, "null cannot be cast to non-null type kotlin.Float");
                        intent.putExtra((String) entry.getKey(), ((Float) value3).floatValue());
                    } else if (value instanceof Double) {
                        Object value4 = entry.getValue();
                        Intrinsics.d(value4, "null cannot be cast to non-null type kotlin.Double");
                        intent.putExtra((String) entry.getKey(), ((Double) value4).doubleValue());
                    }
                }
            }
        }
        intent.setFlags(268435456);
        return intent;
    }
}
