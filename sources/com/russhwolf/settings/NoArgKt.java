package com.russhwolf.settings;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoArg.kt */
/* loaded from: classes3.dex */
public final class NoArgKt {

    /* renamed from: a  reason: collision with root package name */
    private static Context f19594a;

    public static final Settings a() {
        Context context = f19594a;
        Intrinsics.c(context);
        SharedPreferences delegate = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        Intrinsics.e(delegate, "delegate");
        return new SharedPreferencesSettings(delegate, false, 2, null);
    }
}
