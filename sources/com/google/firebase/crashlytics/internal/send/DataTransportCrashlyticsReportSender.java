package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class DataTransportCrashlyticsReportSender {

    /* renamed from: c  reason: collision with root package name */
    private static final CrashlyticsReportJsonTransform f16132c = new CrashlyticsReportJsonTransform();

    /* renamed from: d  reason: collision with root package name */
    private static final String f16133d = e("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e  reason: collision with root package name */
    private static final String f16134e = e("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f  reason: collision with root package name */
    private static final Transformer<CrashlyticsReport, byte[]> f16135f = new Transformer() { // from class: b0.a
        @Override // com.google.android.datatransport.Transformer
        public final Object apply(Object obj) {
            byte[] d8;
            d8 = DataTransportCrashlyticsReportSender.d((CrashlyticsReport) obj);
            return d8;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final ReportQueue f16136a;

    /* renamed from: b  reason: collision with root package name */
    private final Transformer<CrashlyticsReport, byte[]> f16137b;

    DataTransportCrashlyticsReportSender(ReportQueue reportQueue, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.f16136a = reportQueue;
        this.f16137b = transformer;
    }

    public static DataTransportCrashlyticsReportSender b(Context context, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        TransportRuntime.f(context);
        TransportFactory g8 = TransportRuntime.c().g(new CCTDestination(f16133d, f16134e));
        Encoding b8 = Encoding.b("json");
        Transformer<CrashlyticsReport, byte[]> transformer = f16135f;
        return new DataTransportCrashlyticsReportSender(new ReportQueue(g8.a("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, b8, transformer), settingsProvider.b(), onDemandCounter), transformer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] d(CrashlyticsReport crashlyticsReport) {
        return f16132c.E(crashlyticsReport).getBytes(Charset.forName("UTF-8"));
    }

    private static String e(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length());
            for (int i8 = 0; i8 < str.length(); i8++) {
                sb.append(str.charAt(i8));
                if (str2.length() > i8) {
                    sb.append(str2.charAt(i8));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    @NonNull
    public Task<CrashlyticsReportWithSessionId> c(@NonNull CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z7) {
        return this.f16136a.h(crashlyticsReportWithSessionId, z7).getTask();
    }
}
