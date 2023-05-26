package com.clevertap.android.sdk.pushnotification;

import com.clevertap.android.sdk.pushnotification.PushConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PushNotificationUtil {
    private PushNotificationUtil() {
    }

    public static ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (PushConstants.PushType pushType : PushConstants.PushType.values()) {
            arrayList.add(pushType.name());
        }
        return arrayList;
    }

    public static PushConstants.PushType[] b(ArrayList<String> arrayList) {
        PushConstants.PushType[] pushTypeArr = new PushConstants.PushType[0];
        if (arrayList != null && !arrayList.isEmpty()) {
            pushTypeArr = new PushConstants.PushType[arrayList.size()];
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                pushTypeArr[i8] = PushConstants.PushType.valueOf(arrayList.get(i8));
            }
        }
        return pushTypeArr;
    }
}
