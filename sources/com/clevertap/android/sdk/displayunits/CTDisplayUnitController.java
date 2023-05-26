package com.clevertap.android.sdk.displayunits;

import android.text.TextUtils;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTDisplayUnitController {

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, CleverTapDisplayUnit> f11134a = new HashMap<>();

    public synchronized void a() {
        this.f11134a.clear();
        Logger.b("DisplayUnit : ", "Cleared Display Units Cache");
    }

    public synchronized ArrayList<CleverTapDisplayUnit> b(JSONArray jSONArray) {
        a();
        ArrayList<CleverTapDisplayUnit> arrayList = null;
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList<CleverTapDisplayUnit> arrayList2 = new ArrayList<>();
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                try {
                    CleverTapDisplayUnit c8 = CleverTapDisplayUnit.c((JSONObject) jSONArray.get(i8));
                    if (TextUtils.isEmpty(c8.getError())) {
                        this.f11134a.put(c8.b(), c8);
                        arrayList2.add(c8);
                    } else {
                        Logger.b("DisplayUnit : ", "Failed to convert JsonArray item at index:" + i8 + " to Display Unit");
                    }
                } catch (Exception e8) {
                    Logger.b("DisplayUnit : ", "Failed while parsing Display Unit:" + e8.getLocalizedMessage());
                    return null;
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            }
            return arrayList;
        }
        Logger.b("DisplayUnit : ", "Null json array response can't parse Display Units ");
        return null;
    }
}
