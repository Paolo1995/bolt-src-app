package com.clevertap.android.sdk.validation;

import com.clevertap.android.sdk.Logger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class Validator {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f11829b = {".", ":", "$", "'", "\"", "\\"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f11830c = {".", ":", "$", "'", "\"", "\\"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f11831d = {"'", "\"", "\\"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f11832e = {"Stayed", "Notification Clicked", "Notification Viewed", "UTM Visited", "Notification Sent", "App Launched", "wzrk_d", "App Uninstalled", "Notification Bounced", "Geocluster Entered", "Geocluster Exited"};

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f11833a;

    /* loaded from: classes.dex */
    private enum RestrictedMultiValueFields {
        Name,
        Email,
        Education,
        Married,
        DOB,
        Gender,
        Phone,
        Age,
        FBID,
        GPID,
        Birthday
    }

    /* loaded from: classes.dex */
    public enum ValidationContext {
        Profile,
        Event
    }

    private ValidationResult a(String str, JSONArray jSONArray, JSONArray jSONArray2, boolean z7, ValidationResult validationResult) {
        int i8;
        BitSet bitSet = null;
        if (jSONArray == null) {
            validationResult.f(null);
            return validationResult;
        } else if (jSONArray2 == null) {
            validationResult.f(jSONArray);
            return validationResult;
        } else {
            JSONArray jSONArray3 = new JSONArray();
            HashSet hashSet = new HashSet();
            int length = jSONArray.length();
            int length2 = jSONArray2.length();
            if (!z7) {
                bitSet = new BitSet(length + length2);
            }
            int k8 = k(jSONArray2, hashSet, bitSet, length);
            if (!z7 && hashSet.size() < 100) {
                i8 = k(jSONArray, hashSet, bitSet, 0);
            } else {
                i8 = 0;
            }
            for (int i9 = i8; i9 < length; i9++) {
                if (z7) {
                    try {
                        String str2 = (String) jSONArray.get(i9);
                        if (!hashSet.contains(str2)) {
                            jSONArray3.put(str2);
                        }
                    } catch (Throwable unused) {
                    }
                } else if (!bitSet.get(i9)) {
                    jSONArray3.put(jSONArray.get(i9));
                }
            }
            if (!z7 && jSONArray3.length() < 100) {
                for (int i10 = k8; i10 < length2; i10++) {
                    try {
                        if (!bitSet.get(i10 + length)) {
                            jSONArray3.put(jSONArray2.get(i10));
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
            if (k8 > 0 || i8 > 0) {
                ValidationResult b8 = ValidationResultFactory.b(521, 12, str, "100");
                validationResult.d(b8.a());
                validationResult.e(b8.b());
            }
            validationResult.f(jSONArray3);
            return validationResult;
        }
    }

    private ArrayList<String> g() {
        return this.f11833a;
    }

    private int k(JSONArray jSONArray, Set<String> set, BitSet bitSet, int i8) {
        String str;
        if (jSONArray != null) {
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                try {
                    Object obj = jSONArray.get(length);
                    if (obj != null) {
                        str = obj.toString();
                    } else {
                        str = null;
                    }
                    if (bitSet == null) {
                        if (str != null) {
                            set.add(str);
                        }
                    } else {
                        if (str != null && !set.contains(str)) {
                            set.add(str);
                            if (set.size() == 100) {
                                return length;
                            }
                        }
                        bitSet.set(length + i8, true);
                    }
                } catch (Throwable unused) {
                }
            }
            return 0;
        }
        return 0;
    }

    public ValidationResult b(String str) {
        ValidationResult validationResult = new ValidationResult();
        String trim = str.trim();
        for (String str2 : f11829b) {
            trim = trim.replace(str2, "");
        }
        if (trim.length() > 512) {
            trim = trim.substring(0, 511);
            ValidationResult b8 = ValidationResultFactory.b(510, 11, trim.trim(), "512");
            validationResult.e(b8.b());
            validationResult.d(b8.a());
        }
        validationResult.f(trim.trim());
        return validationResult;
    }

    public ValidationResult c(String str) {
        ValidationResult e8 = e(str);
        String str2 = (String) e8.c();
        try {
            if (RestrictedMultiValueFields.valueOf(str2) != null) {
                ValidationResult b8 = ValidationResultFactory.b(523, 24, str2);
                e8.e(b8.b());
                e8.d(b8.a());
                e8.f(null);
            }
        } catch (Throwable unused) {
        }
        return e8;
    }

    public ValidationResult d(String str) {
        ValidationResult validationResult = new ValidationResult();
        String lowerCase = str.trim().toLowerCase();
        for (String str2 : f11831d) {
            lowerCase = lowerCase.replace(str2, "");
        }
        try {
            if (lowerCase.length() > 512) {
                lowerCase = lowerCase.substring(0, 511);
                ValidationResult b8 = ValidationResultFactory.b(521, 11, lowerCase, "512");
                validationResult.e(b8.b());
                validationResult.d(b8.a());
            }
        } catch (Exception unused) {
        }
        validationResult.f(lowerCase);
        return validationResult;
    }

    public ValidationResult e(String str) {
        ValidationResult validationResult = new ValidationResult();
        String trim = str.trim();
        for (String str2 : f11830c) {
            trim = trim.replace(str2, "");
        }
        if (trim.length() > 120) {
            trim = trim.substring(0, 119);
            ValidationResult b8 = ValidationResultFactory.b(520, 11, trim.trim(), "120");
            validationResult.e(b8.b());
            validationResult.d(b8.a());
        }
        validationResult.f(trim.trim());
        return validationResult;
    }

    public ValidationResult f(Object obj, ValidationContext validationContext) throws IllegalArgumentException {
        String str;
        ArrayList arrayList;
        ValidationResult validationResult = new ValidationResult();
        if (!(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Boolean) && !(obj instanceof Double) && !(obj instanceof Long)) {
            if (!(obj instanceof String) && !(obj instanceof Character)) {
                if (obj instanceof Date) {
                    validationResult.f("$D_" + (((Date) obj).getTime() / 1000));
                    return validationResult;
                }
                boolean z7 = obj instanceof String[];
                if ((z7 || (obj instanceof ArrayList)) && validationContext.equals(ValidationContext.Profile)) {
                    String[] strArr = null;
                    if (obj instanceof ArrayList) {
                        arrayList = (ArrayList) obj;
                    } else {
                        arrayList = null;
                    }
                    if (z7) {
                        strArr = (String[]) obj;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (strArr != null) {
                        for (String str2 : strArr) {
                            try {
                                arrayList2.add(str2);
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            try {
                                arrayList2.add((String) it.next());
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
                    if (strArr2.length > 0 && strArr2.length <= 100) {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        for (String str3 : strArr2) {
                            jSONArray.put(str3);
                        }
                        try {
                            jSONObject.put("$set", jSONArray);
                        } catch (JSONException unused3) {
                        }
                        validationResult.f(jSONObject);
                    } else {
                        ValidationResult b8 = ValidationResultFactory.b(521, 13, strArr2.length + "", "100");
                        validationResult.e(b8.b());
                        validationResult.d(b8.a());
                    }
                    return validationResult;
                }
                throw new IllegalArgumentException("Not a String, Boolean, Long, Integer, Float, Double, or Date");
            }
            if (obj instanceof Character) {
                str = String.valueOf(obj);
            } else {
                str = (String) obj;
            }
            String trim = str.trim();
            for (String str4 : f11831d) {
                trim = trim.replace(str4, "");
            }
            try {
                if (trim.length() > 512) {
                    trim = trim.substring(0, 511);
                    ValidationResult b9 = ValidationResultFactory.b(521, 11, trim.trim(), "512");
                    validationResult.e(b9.b());
                    validationResult.d(b9.a());
                }
            } catch (Exception unused4) {
            }
            validationResult.f(trim.trim());
            return validationResult;
        }
        validationResult.f(obj);
        return validationResult;
    }

    public ValidationResult h(String str) {
        ValidationResult validationResult = new ValidationResult();
        if (str == null) {
            ValidationResult b8 = ValidationResultFactory.b(510, 14, new String[0]);
            validationResult.d(b8.a());
            validationResult.e(b8.b());
            return validationResult;
        }
        if (g() != null) {
            Iterator<String> it = g().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (str.equalsIgnoreCase(it.next())) {
                    ValidationResult b9 = ValidationResultFactory.b(513, 17, str);
                    validationResult.d(b9.a());
                    validationResult.e(b9.b());
                    Logger.a(str + " s a discarded event name as per CleverTap. Dropping event at SDK level. Check discarded events in CleverTap Dashboard settings.");
                    break;
                }
            }
        }
        return validationResult;
    }

    public ValidationResult i(String str) {
        ValidationResult validationResult = new ValidationResult();
        if (str == null) {
            ValidationResult b8 = ValidationResultFactory.b(510, 14, new String[0]);
            validationResult.d(b8.a());
            validationResult.e(b8.b());
            return validationResult;
        }
        for (String str2 : f11832e) {
            if (str.equalsIgnoreCase(str2)) {
                ValidationResult b9 = ValidationResultFactory.b(513, 16, str);
                validationResult.d(b9.a());
                validationResult.e(b9.b());
                Logger.n(b9.b());
                return validationResult;
            }
        }
        return validationResult;
    }

    public ValidationResult j(JSONArray jSONArray, JSONArray jSONArray2, String str, String str2) {
        return a(str2, jSONArray, jSONArray2, "multiValuePropertyRemoveValues".equals(str), new ValidationResult());
    }

    public void l(ArrayList<String> arrayList) {
        this.f11833a = arrayList;
    }
}
