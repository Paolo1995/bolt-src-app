package com.google.android.gms.internal.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public final class zao extends ContextCompat {
    @Deprecated
    public static Intent zaa(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i8;
        Intent registerReceiver;
        if (zan.zaa()) {
            if (true != zan.zaa()) {
                i8 = 0;
            } else {
                i8 = 2;
            }
            registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, i8);
            return registerReceiver;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
