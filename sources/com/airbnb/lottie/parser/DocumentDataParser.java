package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {

    /* renamed from: a  reason: collision with root package name */
    public static final DocumentDataParser f9541a = new DocumentDataParser();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9542b = JsonReader.Options.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private DocumentDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public DocumentData a(JsonReader jsonReader, float f8) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.e();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f9 = 0.0f;
        int i8 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i9 = 0;
        int i10 = 0;
        float f12 = 0.0f;
        boolean z7 = true;
        while (jsonReader.j()) {
            switch (jsonReader.I(f9542b)) {
                case 0:
                    str = jsonReader.t();
                    break;
                case 1:
                    str2 = jsonReader.t();
                    break;
                case 2:
                    f9 = (float) jsonReader.l();
                    break;
                case 3:
                    int m8 = jsonReader.m();
                    justification2 = DocumentData.Justification.CENTER;
                    if (m8 <= justification2.ordinal() && m8 >= 0) {
                        justification2 = DocumentData.Justification.values()[m8];
                        break;
                    }
                    break;
                case 4:
                    i8 = jsonReader.m();
                    break;
                case 5:
                    f10 = (float) jsonReader.l();
                    break;
                case 6:
                    f11 = (float) jsonReader.l();
                    break;
                case 7:
                    i9 = JsonUtils.d(jsonReader);
                    break;
                case 8:
                    i10 = JsonUtils.d(jsonReader);
                    break;
                case 9:
                    f12 = (float) jsonReader.l();
                    break;
                case 10:
                    z7 = jsonReader.k();
                    break;
                default:
                    jsonReader.N();
                    jsonReader.O();
                    break;
            }
        }
        jsonReader.h();
        return new DocumentData(str, str2, f9, justification2, i8, f10, f11, i9, i10, f12, z7);
    }
}
