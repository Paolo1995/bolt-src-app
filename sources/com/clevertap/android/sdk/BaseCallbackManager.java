package com.clevertap.android.sdk;

import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.interfaces.OnInitCleverTapIDListener;
import com.clevertap.android.sdk.product_config.CTProductConfigListener;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener;
import com.clevertap.android.sdk.pushnotification.amp.CTPushAmpListener;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class BaseCallbackManager {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    public abstract void b();

    public abstract FailureFlushListener c();

    public abstract CTFeatureFlagsListener d();

    public abstract GeofenceCallback e();

    public abstract InAppNotificationButtonListener f();

    public abstract InAppNotificationListener g();

    public abstract OnInitCleverTapIDListener h();

    public abstract CTProductConfigListener i();

    public abstract CTPushAmpListener j();

    public abstract CTPushNotificationListener k();

    public abstract SyncListener l();

    public abstract void m(ArrayList<CleverTapDisplayUnit> arrayList);

    public abstract void n(String str);

    public abstract void o(FailureFlushListener failureFlushListener);

    public abstract void p(CTInboxListener cTInboxListener);
}
