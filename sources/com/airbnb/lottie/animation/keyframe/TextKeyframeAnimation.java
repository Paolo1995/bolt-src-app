package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public DocumentData i(Keyframe<DocumentData> keyframe, float f8) {
        DocumentData documentData;
        float floatValue;
        DocumentData documentData2;
        LottieValueCallback<A> lottieValueCallback = this.f9171e;
        if (lottieValueCallback != 0) {
            float f9 = keyframe.f9666g;
            Float f10 = keyframe.f9667h;
            if (f10 == null) {
                floatValue = Float.MAX_VALUE;
            } else {
                floatValue = f10.floatValue();
            }
            DocumentData documentData3 = keyframe.f9661b;
            DocumentData documentData4 = documentData3;
            DocumentData documentData5 = keyframe.f9662c;
            if (documentData5 == null) {
                documentData2 = documentData3;
            } else {
                documentData2 = documentData5;
            }
            return (DocumentData) lottieValueCallback.b(f9, floatValue, documentData4, documentData2, f8, d(), f());
        } else if (f8 == 1.0f && (documentData = keyframe.f9662c) != null) {
            return documentData;
        } else {
            return keyframe.f9661b;
        }
    }

    public void q(final LottieValueCallback<String> lottieValueCallback) {
        final LottieFrameInfo lottieFrameInfo = new LottieFrameInfo();
        final DocumentData documentData = new DocumentData();
        super.n(new LottieValueCallback<DocumentData>() { // from class: com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation.1
            @Override // com.airbnb.lottie.value.LottieValueCallback
            /* renamed from: d */
            public DocumentData a(LottieFrameInfo<DocumentData> lottieFrameInfo2) {
                DocumentData g8;
                lottieFrameInfo.h(lottieFrameInfo2.f(), lottieFrameInfo2.a(), lottieFrameInfo2.g().f9266a, lottieFrameInfo2.b().f9266a, lottieFrameInfo2.d(), lottieFrameInfo2.c(), lottieFrameInfo2.e());
                String str = (String) lottieValueCallback.a(lottieFrameInfo);
                if (lottieFrameInfo2.c() == 1.0f) {
                    g8 = lottieFrameInfo2.b();
                } else {
                    g8 = lottieFrameInfo2.g();
                }
                DocumentData documentData2 = g8;
                documentData.a(str, documentData2.f9267b, documentData2.f9268c, documentData2.f9269d, documentData2.f9270e, documentData2.f9271f, documentData2.f9272g, documentData2.f9273h, documentData2.f9274i, documentData2.f9275j, documentData2.f9276k);
                return documentData;
            }
        });
    }
}
