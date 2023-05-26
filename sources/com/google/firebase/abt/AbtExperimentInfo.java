package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class AbtExperimentInfo {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f15400g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* renamed from: h  reason: collision with root package name */
    static final DateFormat f15401h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    private final String f15402a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15403b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15404c;

    /* renamed from: d  reason: collision with root package name */
    private final Date f15405d;

    /* renamed from: e  reason: collision with root package name */
    private final long f15406e;

    /* renamed from: f  reason: collision with root package name */
    private final long f15407f;

    public AbtExperimentInfo(String str, String str2, String str3, Date date, long j8, long j9) {
        this.f15402a = str;
        this.f15403b = str2;
        this.f15404c = str3;
        this.f15405d = date;
        this.f15406e = j8;
        this.f15407f = j9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AbtExperimentInfo a(Map<String, String> map) throws AbtException {
        String str;
        e(map);
        try {
            Date parse = f15401h.parse(map.get("experimentStartTime"));
            long parseLong = Long.parseLong(map.get("triggerTimeoutMillis"));
            long parseLong2 = Long.parseLong(map.get("timeToLiveMillis"));
            String str2 = map.get("experimentId");
            String str3 = map.get("variantId");
            if (map.containsKey("triggerEvent")) {
                str = map.get("triggerEvent");
            } else {
                str = "";
            }
            return new AbtExperimentInfo(str2, str3, str, parse, parseLong, parseLong2);
        } catch (NumberFormatException e8) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e8);
        } catch (ParseException e9) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e9);
        }
    }

    private static void e(Map<String, String> map) throws AbtException {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : f15400g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f15402a;
    }

    long c() {
        return this.f15405d.getTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnalyticsConnector.ConditionalUserProperty d(String str) {
        String str2;
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.f15417a = str;
        conditionalUserProperty.f15429m = c();
        conditionalUserProperty.f15418b = this.f15402a;
        conditionalUserProperty.f15419c = this.f15403b;
        if (TextUtils.isEmpty(this.f15404c)) {
            str2 = null;
        } else {
            str2 = this.f15404c;
        }
        conditionalUserProperty.f15420d = str2;
        conditionalUserProperty.f15421e = this.f15406e;
        conditionalUserProperty.f15426j = this.f15407f;
        return conditionalUserProperty;
    }
}
