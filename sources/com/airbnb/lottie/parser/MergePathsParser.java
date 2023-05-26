package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class MergePathsParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9581a = JsonReader.Options.a("nm", "mm", "hd");

    private MergePathsParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9581a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        jsonReader.N();
                        jsonReader.O();
                    } else {
                        z7 = jsonReader.k();
                    }
                } else {
                    mergePathsMode = MergePaths.MergePathsMode.a(jsonReader.m());
                }
            } else {
                str = jsonReader.t();
            }
        }
        return new MergePaths(str, mergePathsMode, z7);
    }
}
