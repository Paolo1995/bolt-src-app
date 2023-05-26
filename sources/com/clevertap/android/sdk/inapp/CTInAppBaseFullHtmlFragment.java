package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CTWebInterface;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.utils.UriHelper;
import java.net.URLDecoder;

/* loaded from: classes.dex */
public abstract class CTInAppBaseFullHtmlFragment extends CTInAppBaseFullFragment {

    /* renamed from: m  reason: collision with root package name */
    protected CTInAppWebView f11294m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class InAppWebViewClient extends WebViewClient {
        InAppWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String string;
            try {
                Bundle a8 = UriHelper.a(str, false);
                if (a8.containsKey("wzrk_c2a") && (string = a8.getString("wzrk_c2a")) != null) {
                    String[] split = string.split("__dl__");
                    if (split.length == 2) {
                        a8.putString("wzrk_c2a", URLDecoder.decode(split[0], "UTF-8"));
                        str = split[1];
                    }
                }
                CTInAppBaseFullHtmlFragment.this.E(a8, null);
                Logger.a("Executing call to action for in-app: " + str);
                CTInAppBaseFullHtmlFragment.this.H(str, a8);
            } catch (Throwable th) {
                Logger.q("Error parsing the in-app notification action!", th);
            }
            return true;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private View X(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        try {
            View inflate = layoutInflater.inflate(R$layout.inapp_html_full, viewGroup, false);
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R$id.inapp_html_full_relative_layout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            Z(layoutParams);
            this.f11294m = new CTInAppWebView(this.f11285h, this.f11287j.getWidth(), this.f11287j.getHeight(), this.f11287j.H(), this.f11287j.l());
            this.f11294m.setWebViewClient(new InAppWebViewClient());
            if (this.f11287j.P()) {
                this.f11294m.getSettings().setJavaScriptEnabled(true);
                this.f11294m.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
                this.f11294m.getSettings().setAllowContentAccess(false);
                this.f11294m.getSettings().setAllowFileAccess(false);
                this.f11294m.getSettings().setAllowFileAccessFromFileURLs(false);
                this.f11294m.addJavascriptInterface(new CTWebInterface(CleverTapAPI.K(getActivity(), this.f11284g)), "CleverTap");
            }
            if (b0()) {
                relativeLayout.setBackground(new ColorDrawable(-1157627904));
            } else {
                relativeLayout.setBackground(new ColorDrawable(0));
            }
            relativeLayout.addView(this.f11294m, layoutParams);
            if (a0()) {
                this.f11283f = new CloseImageView(this.f11285h);
                RelativeLayout.LayoutParams Y = Y();
                this.f11283f.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppBaseFullHtmlFragment.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CTInAppBaseFullHtmlFragment.this.F(null);
                    }
                });
                relativeLayout.addView(this.f11283f, Y);
            }
            return inflate;
        } catch (Throwable th) {
            this.f11284g.n().t(this.f11284g.c(), "Fragment view not created", th);
            return null;
        }
    }

    private void Z(RelativeLayout.LayoutParams layoutParams) {
        char z7 = this.f11287j.z();
        if (z7 != 'b') {
            if (z7 != 'c') {
                if (z7 != 'l') {
                    if (z7 != 'r') {
                        if (z7 == 't') {
                            layoutParams.addRule(10);
                        }
                    } else {
                        layoutParams.addRule(11);
                    }
                } else {
                    layoutParams.addRule(9);
                }
            } else {
                layoutParams.addRule(13);
            }
        } else {
            layoutParams.addRule(12);
        }
        layoutParams.setMargins(0, 0, 0, 0);
    }

    private boolean a0() {
        return this.f11287j.T();
    }

    private boolean b0() {
        return this.f11287j.K();
    }

    private void c0() {
        this.f11294m.a();
        if (this.f11287j.i().isEmpty()) {
            Point point = this.f11294m.f11417f;
            int i8 = point.y;
            int i9 = point.x;
            float f8 = getResources().getDisplayMetrics().density;
            String replaceFirst = this.f11287j.n().replaceFirst("<head>", "<head>" + ("<style>body{width:" + ((int) (i9 / f8)) + "px; height: " + ((int) (i8 / f8)) + "px; margin: 0; padding:0;}</style>"));
            Logger.n("Density appears to be " + f8);
            this.f11294m.setInitialScale((int) (f8 * 100.0f));
            this.f11294m.loadDataWithBaseURL(null, replaceFirst, "text/html", "utf-8", null);
            return;
        }
        String i10 = this.f11287j.i();
        this.f11294m.setWebViewClient(new WebViewClient());
        this.f11294m.loadUrl(i10);
    }

    protected RelativeLayout.LayoutParams Y() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, this.f11294m.getId());
        layoutParams.addRule(1, this.f11294m.getId());
        int i8 = -(K(40) / 2);
        layoutParams.setMargins(i8, 0, 0, i8);
        return layoutParams;
    }

    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return X(layoutInflater, viewGroup);
    }

    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        c0();
    }
}
