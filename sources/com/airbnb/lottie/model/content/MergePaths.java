package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

/* loaded from: classes.dex */
public class MergePaths implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9362a;

    /* renamed from: b  reason: collision with root package name */
    private final MergePathsMode f9363b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9364c;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode a(int i8) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z7) {
        this.f9362a = str;
        this.f9363b = mergePathsMode;
        this.f9364c = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (!lottieDrawable.A()) {
            Logger.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new MergePathsContent(this);
    }

    public MergePathsMode b() {
        return this.f9363b;
    }

    public String c() {
        return this.f9362a;
    }

    public boolean d() {
        return this.f9364c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f9363b + '}';
    }
}
