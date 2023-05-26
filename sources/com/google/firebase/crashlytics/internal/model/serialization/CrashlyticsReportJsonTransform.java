package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class CrashlyticsReportJsonTransform {

    /* renamed from: a */
    private static final DataEncoder f16112a = new JsonDataEncoderBuilder().j(AutoCrashlyticsReportEncoder.f15777a).k(true).i();

    /* loaded from: classes3.dex */
    public interface ObjectParser<T> {
        T a(@NonNull JsonReader jsonReader) throws IOException;
    }

    @NonNull
    private static CrashlyticsReport A(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Builder b8 = CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c8 = 5;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c8 = 6;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c8 = 7;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    b8.f(y(jsonReader));
                    break;
                case 1:
                    b8.h(jsonReader.nextString());
                    break;
                case 2:
                    b8.b(jsonReader.nextString());
                    break;
                case 3:
                    b8.d(jsonReader.nextString());
                    break;
                case 4:
                    b8.e(jsonReader.nextString());
                    break;
                case 5:
                    b8.g(jsonReader.nextInt());
                    break;
                case 6:
                    b8.c(jsonReader.nextString());
                    break;
                case 7:
                    b8.i(B(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return b8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session B(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Builder a8 = CrashlyticsReport.Session.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c8 = 5;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c8 = 6;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c8 = 7;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c8 = '\b';
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c8 = '\t';
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c8 = '\n';
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.l(jsonReader.nextLong());
                    break;
                case 1:
                    a8.j(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 2:
                    a8.e(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 3:
                    a8.d(m(jsonReader));
                    break;
                case 4:
                    a8.f(k(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.a
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.Session.Event n8;
                            n8 = CrashlyticsReportJsonTransform.n(jsonReader2);
                            return n8;
                        }
                    }));
                    break;
                case 5:
                    a8.k(z(jsonReader));
                    break;
                case 6:
                    a8.b(i(jsonReader));
                    break;
                case 7:
                    a8.m(C(jsonReader));
                    break;
                case '\b':
                    a8.g(jsonReader.nextString());
                    break;
                case '\t':
                    a8.c(jsonReader.nextBoolean());
                    break;
                case '\n':
                    a8.h(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.User C(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.User.Builder a8 = CrashlyticsReport.Session.User.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("identifier")) {
                jsonReader.skipValue();
            } else {
                a8.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Application i(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Application.Builder a8 = CrashlyticsReport.Session.Application.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -519438642:
                    if (nextName.equals("developmentPlatform")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 213652010:
                    if (nextName.equals("developmentPlatformVersion")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c8 = 5;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.e(jsonReader.nextString());
                    break;
                case 1:
                    a8.b(jsonReader.nextString());
                    break;
                case 2:
                    a8.c(jsonReader.nextString());
                    break;
                case 3:
                    a8.g(jsonReader.nextString());
                    break;
                case 4:
                    a8.f(jsonReader.nextString());
                    break;
                case 5:
                    a8.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.ApplicationExitInfo j(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.ApplicationExitInfo.Builder a8 = CrashlyticsReport.ApplicationExitInfo.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case 110987:
                    if (nextName.equals("pid")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 111312:
                    if (nextName.equals("pss")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 113234:
                    if (nextName.equals("rss")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 722137681:
                    if (nextName.equals("reasonCode")) {
                        c8 = 5;
                        break;
                    }
                    break;
                case 723857505:
                    if (nextName.equals("traceFile")) {
                        c8 = 6;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c8 = 7;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.c(jsonReader.nextInt());
                    break;
                case 1:
                    a8.e(jsonReader.nextLong());
                    break;
                case 2:
                    a8.g(jsonReader.nextLong());
                    break;
                case 3:
                    a8.h(jsonReader.nextLong());
                    break;
                case 4:
                    a8.d(jsonReader.nextString());
                    break;
                case 5:
                    a8.f(jsonReader.nextInt());
                    break;
                case 6:
                    a8.i(jsonReader.nextString());
                    break;
                case 7:
                    a8.b(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static <T> ImmutableList<T> k(@NonNull JsonReader jsonReader, @NonNull ObjectParser<T> objectParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.a(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.b(arrayList);
    }

    @NonNull
    public static CrashlyticsReport.CustomAttribute l(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.CustomAttribute.Builder a8 = CrashlyticsReport.CustomAttribute.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("key")) {
                if (!nextName.equals(AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                    jsonReader.skipValue();
                } else {
                    a8.c(jsonReader.nextString());
                }
            } else {
                a8.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Device m(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Device.Builder a8 = CrashlyticsReport.Session.Device.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c8 = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c8 = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c8 = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c8 = '\b';
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.i(jsonReader.nextBoolean());
                    break;
                case 1:
                    a8.e(jsonReader.nextString());
                    break;
                case 2:
                    a8.h(jsonReader.nextLong());
                    break;
                case 3:
                    a8.b(jsonReader.nextInt());
                    break;
                case 4:
                    a8.d(jsonReader.nextLong());
                    break;
                case 5:
                    a8.c(jsonReader.nextInt());
                    break;
                case 6:
                    a8.f(jsonReader.nextString());
                    break;
                case 7:
                    a8.j(jsonReader.nextInt());
                    break;
                case '\b':
                    a8.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    public static CrashlyticsReport.Session.Event n(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Builder a8 = CrashlyticsReport.Session.Event.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c8 = 4;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.c(q(jsonReader));
                    break;
                case 1:
                    a8.b(o(jsonReader));
                    break;
                case 2:
                    a8.d(u(jsonReader));
                    break;
                case 3:
                    a8.f(jsonReader.nextString());
                    break;
                case 4:
                    a8.e(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application o(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Builder a8 = CrashlyticsReport.Session.Event.Application.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1332194002:
                    if (nextName.equals("background")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -80231855:
                    if (nextName.equals("internalKeys")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c8 = 4;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.b(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 1:
                    a8.d(r(jsonReader));
                    break;
                case 2:
                    a8.e(k(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.c
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.CustomAttribute l8;
                            l8 = CrashlyticsReportJsonTransform.l(jsonReader2);
                            return l8;
                        }
                    }));
                    break;
                case 3:
                    a8.c(k(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.c
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.CustomAttribute l8;
                            l8 = CrashlyticsReportJsonTransform.l(jsonReader2);
                            return l8;
                        }
                    }));
                    break;
                case 4:
                    a8.f(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage p(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder a8 = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c8 = 3;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.c(jsonReader.nextString());
                    break;
                case 1:
                    a8.d(jsonReader.nextLong());
                    break;
                case 2:
                    a8.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a8.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Device q(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Device.Builder a8 = CrashlyticsReport.Session.Event.Device.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c8 = 5;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    a8.c(jsonReader.nextInt());
                    break;
                case 2:
                    a8.e(jsonReader.nextInt());
                    break;
                case 3:
                    a8.d(jsonReader.nextLong());
                    break;
                case 4:
                    a8.g(jsonReader.nextLong());
                    break;
                case 5:
                    a8.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application.Execution r(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Builder a8 = CrashlyticsReport.Session.Event.Application.Execution.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c8 = 4;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.b(j(jsonReader));
                    break;
                case 1:
                    a8.f(k(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.d
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.Session.Event.Application.Execution.Thread w7;
                            w7 = CrashlyticsReportJsonTransform.w(jsonReader2);
                            return w7;
                        }
                    }));
                    break;
                case 2:
                    a8.e(v(jsonReader));
                    break;
                case 3:
                    a8.c(k(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.e
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.Session.Event.Application.Execution.BinaryImage p8;
                            p8 = CrashlyticsReportJsonTransform.p(jsonReader2);
                            return p8;
                        }
                    }));
                    break;
                case 4:
                    a8.d(s(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application.Execution.Exception s(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder a8 = CrashlyticsReport.Session.Event.Application.Execution.Exception.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c8 = 4;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.c(k(jsonReader, new f()));
                    break;
                case 1:
                    a8.e(jsonReader.nextString());
                    break;
                case 2:
                    a8.f(jsonReader.nextString());
                    break;
                case 3:
                    a8.b(s(jsonReader));
                    break;
                case 4:
                    a8.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame t(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder a8 = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c8 = 4;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.d(jsonReader.nextLong());
                    break;
                case 1:
                    a8.f(jsonReader.nextString());
                    break;
                case 2:
                    a8.e(jsonReader.nextLong());
                    break;
                case 3:
                    a8.b(jsonReader.nextString());
                    break;
                case 4:
                    a8.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Log u(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Log.Builder a8 = CrashlyticsReport.Session.Event.Log.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("content")) {
                jsonReader.skipValue();
            } else {
                a8.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application.Execution.Signal v(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder a8 = CrashlyticsReport.Session.Event.Application.Execution.Signal.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals("address")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals("code")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c8 = 2;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.b(jsonReader.nextLong());
                    break;
                case 1:
                    a8.c(jsonReader.nextString());
                    break;
                case 2:
                    a8.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread w(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder a8 = CrashlyticsReport.Session.Event.Application.Execution.Thread.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c8 = 2;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.b(k(jsonReader, new f()));
                    break;
                case 1:
                    a8.d(jsonReader.nextString());
                    break;
                case 2:
                    a8.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    public static CrashlyticsReport.FilesPayload.File x(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.File.Builder a8 = CrashlyticsReport.FilesPayload.File.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("filename")) {
                if (!nextName.equals("contents")) {
                    jsonReader.skipValue();
                } else {
                    a8.b(Base64.decode(jsonReader.nextString(), 2));
                }
            } else {
                a8.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.FilesPayload y(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.Builder a8 = CrashlyticsReport.FilesPayload.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("files")) {
                if (!nextName.equals("orgId")) {
                    jsonReader.skipValue();
                } else {
                    a8.c(jsonReader.nextString());
                }
            } else {
                a8.b(k(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.b
                    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                    public final Object a(JsonReader jsonReader2) {
                        CrashlyticsReport.FilesPayload.File x7;
                        x7 = CrashlyticsReportJsonTransform.x(jsonReader2);
                        return x7;
                    }
                }));
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.OperatingSystem z(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.OperatingSystem.Builder a8 = CrashlyticsReport.Session.OperatingSystem.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c8 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c8 = 3;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    a8.b(jsonReader.nextString());
                    break;
                case 1:
                    a8.c(jsonReader.nextBoolean());
                    break;
                case 2:
                    a8.e(jsonReader.nextString());
                    break;
                case 3:
                    a8.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a8.a();
    }

    @NonNull
    public CrashlyticsReport D(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport A = A(jsonReader);
            jsonReader.close();
            return A;
        } catch (IllegalStateException e8) {
            throw new IOException(e8);
        }
    }

    @NonNull
    public String E(@NonNull CrashlyticsReport crashlyticsReport) {
        return f16112a.b(crashlyticsReport);
    }

    @NonNull
    public CrashlyticsReport.Session.Event g(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport.Session.Event n8 = n(jsonReader);
            jsonReader.close();
            return n8;
        } catch (IllegalStateException e8) {
            throw new IOException(e8);
        }
    }

    @NonNull
    public String h(@NonNull CrashlyticsReport.Session.Event event) {
        return f16112a.b(event);
    }
}
