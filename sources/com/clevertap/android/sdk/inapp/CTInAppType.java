package com.clevertap.android.sdk.inapp;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public enum CTInAppType {
    CTInAppTypeHTML("html"),
    CTInAppTypeCoverHTML("coverHtml"),
    CTInAppTypeInterstitialHTML("interstitialHtml"),
    CTInAppTypeHeaderHTML("headerHtml"),
    CTInAppTypeFooterHTML("footerHtml"),
    CTInAppTypeHalfInterstitialHTML("halfInterstitialHtml"),
    CTInAppTypeCover("cover"),
    CTInAppTypeInterstitial("interstitial"),
    CTInAppTypeHalfInterstitial("half-interstitial"),
    CTInAppTypeHeader("header-template"),
    CTInAppTypeFooter("footer-template"),
    CTInAppTypeAlert("alert-template"),
    CTInAppTypeCoverImageOnly("cover-image"),
    CTInAppTypeInterstitialImageOnly("interstitial-image"),
    CTInAppTypeHalfInterstitialImageOnly("half-interstitial-image");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f11416f;

    CTInAppType(String str) {
        this.f11416f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CTInAppType a(String str) {
        str.hashCode();
        char c8 = 65535;
        switch (str.hashCode()) {
            case -1698613420:
                if (str.equals("half-interstitial-image")) {
                    c8 = 0;
                    break;
                }
                break;
            case -1258935355:
                if (str.equals("cover-image")) {
                    c8 = 1;
                    break;
                }
                break;
            case -1160074422:
                if (str.equals("halfInterstitialHtml")) {
                    c8 = 2;
                    break;
                }
                break;
            case -1141304454:
                if (str.equals("interstitial-image")) {
                    c8 = 3;
                    break;
                }
                break;
            case -728863497:
                if (str.equals("interstitialHtml")) {
                    c8 = 4;
                    break;
                }
                break;
            case -334055316:
                if (str.equals("footer-template")) {
                    c8 = 5;
                    break;
                }
                break;
            case -37253685:
                if (str.equals("alert-template")) {
                    c8 = 6;
                    break;
                }
                break;
            case 3213227:
                if (str.equals("html")) {
                    c8 = 7;
                    break;
                }
                break;
            case 94852023:
                if (str.equals("cover")) {
                    c8 = '\b';
                    break;
                }
                break;
            case 604727084:
                if (str.equals("interstitial")) {
                    c8 = '\t';
                    break;
                }
                break;
            case 894039686:
                if (str.equals("half-interstitial")) {
                    c8 = '\n';
                    break;
                }
                break;
            case 1189018554:
                if (str.equals("header-template")) {
                    c8 = 11;
                    break;
                }
                break;
            case 1420225510:
                if (str.equals("footerHtml")) {
                    c8 = '\f';
                    break;
                }
                break;
            case 1977176024:
                if (str.equals("headerHtml")) {
                    c8 = '\r';
                    break;
                }
                break;
            case 1979390978:
                if (str.equals("coverHtml")) {
                    c8 = 14;
                    break;
                }
                break;
        }
        switch (c8) {
            case 0:
                return CTInAppTypeHalfInterstitialImageOnly;
            case 1:
                return CTInAppTypeCoverImageOnly;
            case 2:
                return CTInAppTypeHalfInterstitialHTML;
            case 3:
                return CTInAppTypeInterstitialImageOnly;
            case 4:
                return CTInAppTypeInterstitialHTML;
            case 5:
                return CTInAppTypeFooter;
            case 6:
                return CTInAppTypeAlert;
            case 7:
                return CTInAppTypeHTML;
            case '\b':
                return CTInAppTypeCover;
            case '\t':
                return CTInAppTypeInterstitial;
            case '\n':
                return CTInAppTypeHalfInterstitial;
            case 11:
                return CTInAppTypeHeader;
            case '\f':
                return CTInAppTypeFooterHTML;
            case '\r':
                return CTInAppTypeHeaderHTML;
            case 14:
                return CTInAppTypeCoverHTML;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.f11416f;
    }
}
