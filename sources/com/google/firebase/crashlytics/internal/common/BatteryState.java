package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes3.dex */
class BatteryState {

    /* renamed from: a  reason: collision with root package name */
    private final Float f15569a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f15570b;

    private BatteryState(Float f8, boolean z7) {
        this.f15570b = z7;
        this.f15569a = f8;
    }

    public static BatteryState a(Context context) {
        Float f8 = null;
        boolean z7 = false;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z7 = e(registerReceiver);
                f8 = d(registerReceiver);
            }
        } catch (IllegalStateException e8) {
            Logger.f().e("An error occurred getting battery state.", e8);
        }
        return new BatteryState(f8, z7);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra != -1 && intExtra2 != -1) {
            return Float.valueOf(intExtra / intExtra2);
        }
        return null;
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        if (intExtra != 2 && intExtra != 5) {
            return false;
        }
        return true;
    }

    public Float b() {
        return this.f15569a;
    }

    public int c() {
        Float f8;
        if (this.f15570b && (f8 = this.f15569a) != null) {
            if (f8.floatValue() < 0.99d) {
                return 2;
            }
            return 3;
        }
        return 1;
    }
}
