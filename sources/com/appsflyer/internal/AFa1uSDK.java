package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1oSDK;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AFa1uSDK {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum AFa1wSDK {
        UNKNOWN(0),
        ACCELEROMETER(1),
        MAGNETOMETER(2),
        RESERVED(3),
        GYROSCOPE(4);
        
        private int afDebugLog;

        AFa1wSDK(int i8) {
            this.afDebugLog = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum AFa1xSDK {
        UNKNOWN("uk"),
        ACCELEROMETER("am"),
        MAGNETOMETER("mm"),
        RESERVED("rs"),
        GYROSCOPE("gs");
        
        String values;

        AFa1xSDK(String str) {
            this.values = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum AFa1ySDK {
        NONE,
        FIRST,
        ALL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<BigDecimal> AFInAppEventType(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        Float f8 = (Float) arrayList.get(0);
        Float f9 = (Float) arrayList.get(1);
        Float f10 = (Float) arrayList.get(2);
        ArrayList arrayList2 = new ArrayList();
        try {
            arrayList2.add(BigDecimal.valueOf(AFc1oSDK.AFa1xSDK.AFInAppEventType(f8.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1oSDK.AFa1xSDK.AFInAppEventType(f9.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1oSDK.AFa1xSDK.AFInAppEventType(f10.toString())));
        } catch (ParseException e8) {
            AFLogger.afErrorLogForExcManagerOnly("failed to parse string to number", e8);
        }
        return arrayList2;
    }
}
