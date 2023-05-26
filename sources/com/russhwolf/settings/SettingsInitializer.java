package com.russhwolf.settings;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoArg.kt */
/* loaded from: classes3.dex */
public final class SettingsInitializer implements Initializer<Context> {
    @Override // androidx.startup.Initializer
    /* renamed from: b */
    public Context a(Context context) {
        Intrinsics.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        NoArgKt.f19594a = applicationContext;
        Intrinsics.e(applicationContext, "context.applicationConte….also { appContext = it }");
        return applicationContext;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
