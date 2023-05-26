package com.clevertap.android.sdk.inapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.gif.GifImageView;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CTInAppNativeInterstitialFragment extends CTInAppBaseFullNativeFragment {

    /* renamed from: x  reason: collision with root package name */
    private static long f11333x;

    /* renamed from: m  reason: collision with root package name */
    private boolean f11334m = false;

    /* renamed from: n  reason: collision with root package name */
    private Dialog f11335n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView f11336o;

    /* renamed from: p  reason: collision with root package name */
    private GifImageView f11337p;

    /* renamed from: q  reason: collision with root package name */
    private SimpleExoPlayer f11338q;

    /* renamed from: r  reason: collision with root package name */
    private PlayerView f11339r;

    /* renamed from: s  reason: collision with root package name */
    private RelativeLayout f11340s;

    /* renamed from: t  reason: collision with root package name */
    private FrameLayout f11341t;

    /* renamed from: u  reason: collision with root package name */
    private ViewGroup.LayoutParams f11342u;

    /* renamed from: v  reason: collision with root package name */
    private ViewGroup.LayoutParams f11343v;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup.LayoutParams f11344w;

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        ((ViewGroup) this.f11339r.getParent()).removeView(this.f11339r);
        this.f11339r.setLayoutParams(this.f11343v);
        FrameLayout frameLayout = this.f11341t;
        int i8 = R$id.video_frame;
        ((FrameLayout) frameLayout.findViewById(i8)).addView(this.f11339r);
        this.f11336o.setLayoutParams(this.f11344w);
        ((FrameLayout) this.f11341t.findViewById(i8)).addView(this.f11336o);
        this.f11341t.setLayoutParams(this.f11342u);
        ((RelativeLayout) this.f11340s.findViewById(R$id.interstitial_relative_layout)).addView(this.f11341t);
        this.f11334m = false;
        this.f11335n.dismiss();
        this.f11336o.setImageDrawable(ContextCompat.getDrawable(this.f11285h, R$drawable.ct_ic_fullscreen_expand));
    }

    private void f0() {
        this.f11336o.setVisibility(8);
    }

    private void g0() {
        this.f11335n = new Dialog(this.f11285h, 16973834) { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialFragment.4
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (CTInAppNativeInterstitialFragment.this.f11334m) {
                    CTInAppNativeInterstitialFragment.this.e0();
                }
                super.onBackPressed();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        this.f11344w = this.f11336o.getLayoutParams();
        this.f11343v = this.f11339r.getLayoutParams();
        this.f11342u = this.f11341t.getLayoutParams();
        ((ViewGroup) this.f11339r.getParent()).removeView(this.f11339r);
        ((ViewGroup) this.f11336o.getParent()).removeView(this.f11336o);
        ((ViewGroup) this.f11341t.getParent()).removeView(this.f11341t);
        this.f11335n.addContentView(this.f11339r, new ViewGroup.LayoutParams(-1, -1));
        this.f11334m = true;
        this.f11335n.show();
    }

    private void i0() {
        this.f11339r.requestFocus();
        this.f11339r.setVisibility(0);
        this.f11339r.setPlayer(this.f11338q);
        this.f11338q.setPlayWhenReady(true);
    }

    private void j0() {
        FrameLayout frameLayout = (FrameLayout) this.f11340s.findViewById(R$id.video_frame);
        this.f11341t = frameLayout;
        frameLayout.setVisibility(0);
        this.f11339r = new PlayerView(this.f11285h);
        ImageView imageView = new ImageView(this.f11285h);
        this.f11336o = imageView;
        imageView.setImageDrawable(ResourcesCompat.f(this.f11285h.getResources(), R$drawable.ct_ic_fullscreen_expand, null));
        this.f11336o.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!CTInAppNativeInterstitialFragment.this.f11334m) {
                    CTInAppNativeInterstitialFragment.this.h0();
                } else {
                    CTInAppNativeInterstitialFragment.this.e0();
                }
            }
        });
        if (this.f11287j.U() && O()) {
            this.f11339r.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 408.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 229.0f, getResources().getDisplayMetrics())));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()));
            layoutParams.gravity = 8388613;
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()), 0);
            this.f11336o.setLayoutParams(layoutParams);
        } else {
            this.f11339r.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 240.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 134.0f, getResources().getDisplayMetrics())));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
            layoutParams2.gravity = 8388613;
            layoutParams2.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()), 0);
            this.f11336o.setLayoutParams(layoutParams2);
        }
        this.f11339r.setShowBuffering(1);
        this.f11339r.setUseArtwork(true);
        this.f11339r.setControllerAutoShow(false);
        this.f11341t.addView(this.f11339r);
        this.f11341t.addView(this.f11336o);
        this.f11339r.setDefaultArtwork(ResourcesCompat.f(this.f11285h.getResources(), R$drawable.ct_audio, null));
        TransferListener build = new DefaultBandwidthMeter.Builder(this.f11285h).build();
        this.f11338q = new SimpleExoPlayer.Builder(this.f11285h).setTrackSelector(new DefaultTrackSelector(this.f11285h, new AdaptiveTrackSelection.Factory())).build();
        Context context = this.f11285h;
        this.f11338q.prepare(new HlsMediaSource.Factory(new DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getApplicationContext().getPackageName()), build)).createMediaSource(Uri.parse(this.f11287j.u().get(0).c())));
        this.f11338q.setRepeatMode(1);
        this.f11338q.seekTo(f11333x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFullFragment, com.clevertap.android.sdk.inapp.CTInAppBaseFragment
    public void D() {
        super.D();
        GifImageView gifImageView = this.f11337p;
        if (gifImageView != null) {
            gifImageView.i();
        }
        SimpleExoPlayer simpleExoPlayer = this.f11338q;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.f11338q.release();
            this.f11338q = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        ArrayList arrayList = new ArrayList();
        if (this.f11287j.U() && O()) {
            inflate = layoutInflater.inflate(R$layout.tab_inapp_interstitial, viewGroup, false);
        } else {
            inflate = layoutInflater.inflate(R$layout.inapp_interstitial, viewGroup, false);
        }
        final FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_interstitial_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.interstitial_relative_layout);
        this.f11340s = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f11287j.c()));
        int i8 = this.f11286i;
        if (i8 != 1) {
            if (i8 == 2) {
                this.f11340s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialFragment.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CTInAppNativeInterstitialFragment.this.f11340s.getLayoutParams();
                        if (CTInAppNativeInterstitialFragment.this.f11287j.U() && CTInAppNativeInterstitialFragment.this.O()) {
                            CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment = CTInAppNativeInterstitialFragment.this;
                            cTInAppNativeInterstitialFragment.W(cTInAppNativeInterstitialFragment.f11340s, layoutParams, frameLayout, closeImageView);
                        } else if (CTInAppNativeInterstitialFragment.this.O()) {
                            CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment2 = CTInAppNativeInterstitialFragment.this;
                            cTInAppNativeInterstitialFragment2.V(cTInAppNativeInterstitialFragment2.f11340s, layoutParams, frameLayout, closeImageView);
                        } else {
                            CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment3 = CTInAppNativeInterstitialFragment.this;
                            cTInAppNativeInterstitialFragment3.U(cTInAppNativeInterstitialFragment3.f11340s, layoutParams, closeImageView);
                        }
                        CTInAppNativeInterstitialFragment.this.f11340s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            this.f11340s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    RelativeLayout relativeLayout2 = (RelativeLayout) frameLayout.findViewById(R$id.interstitial_relative_layout);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout2.getLayoutParams();
                    if (CTInAppNativeInterstitialFragment.this.f11287j.U() && CTInAppNativeInterstitialFragment.this.O()) {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment = CTInAppNativeInterstitialFragment.this;
                        cTInAppNativeInterstitialFragment.T(cTInAppNativeInterstitialFragment.f11340s, layoutParams, frameLayout, closeImageView);
                    } else if (CTInAppNativeInterstitialFragment.this.O()) {
                        CTInAppNativeInterstitialFragment cTInAppNativeInterstitialFragment2 = CTInAppNativeInterstitialFragment.this;
                        cTInAppNativeInterstitialFragment2.S(cTInAppNativeInterstitialFragment2.f11340s, layoutParams, frameLayout, closeImageView);
                    } else {
                        CTInAppNativeInterstitialFragment.this.R(relativeLayout2, layoutParams, closeImageView);
                    }
                    CTInAppNativeInterstitialFragment.this.f11340s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        if (!this.f11287j.u().isEmpty()) {
            if (this.f11287j.u().get(0).h()) {
                CTInAppNotification cTInAppNotification = this.f11287j;
                if (cTInAppNotification.p(cTInAppNotification.u().get(0)) != null) {
                    ImageView imageView = (ImageView) this.f11340s.findViewById(R$id.backgroundImage);
                    imageView.setVisibility(0);
                    CTInAppNotification cTInAppNotification2 = this.f11287j;
                    imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.u().get(0)));
                }
            } else if (this.f11287j.u().get(0).g()) {
                CTInAppNotification cTInAppNotification3 = this.f11287j;
                if (cTInAppNotification3.j(cTInAppNotification3.u().get(0)) != null) {
                    GifImageView gifImageView = (GifImageView) this.f11340s.findViewById(R$id.gifImage);
                    this.f11337p = gifImageView;
                    gifImageView.setVisibility(0);
                    GifImageView gifImageView2 = this.f11337p;
                    CTInAppNotification cTInAppNotification4 = this.f11287j;
                    gifImageView2.setBytes(cTInAppNotification4.j(cTInAppNotification4.u().get(0)));
                    this.f11337p.k();
                }
            } else if (this.f11287j.u().get(0).i()) {
                g0();
                j0();
                i0();
            } else if (this.f11287j.u().get(0).f()) {
                j0();
                i0();
                f0();
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.f11340s.findViewById(R$id.interstitial_linear_layout);
        Button button = (Button) linearLayout.findViewById(R$id.interstitial_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(R$id.interstitial_button2);
        arrayList.add(button2);
        TextView textView = (TextView) this.f11340s.findViewById(R$id.interstitial_title);
        textView.setText(this.f11287j.B());
        textView.setTextColor(Color.parseColor(this.f11287j.C()));
        TextView textView2 = (TextView) this.f11340s.findViewById(R$id.interstitial_message);
        textView2.setText(this.f11287j.v());
        textView2.setTextColor(Color.parseColor(this.f11287j.x()));
        ArrayList<CTInAppNotificationButton> f8 = this.f11287j.f();
        if (f8.size() == 1) {
            int i9 = this.f11286i;
            if (i9 == 2) {
                button.setVisibility(8);
            } else if (i9 == 1) {
                button.setVisibility(4);
            }
            Y(button2, f8.get(0), 0);
        } else if (!f8.isEmpty()) {
            for (int i10 = 0; i10 < f8.size(); i10++) {
                if (i10 < 2) {
                    Y((Button) arrayList.get(i10), f8.get(i10), i10);
                }
            }
        }
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CTInAppNativeInterstitialFragment.this.F(null);
                if (CTInAppNativeInterstitialFragment.this.f11337p != null) {
                    CTInAppNativeInterstitialFragment.this.f11337p.i();
                }
                CTInAppNativeInterstitialFragment.this.getActivity().finish();
            }
        });
        if (!this.f11287j.M()) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GifImageView gifImageView = this.f11337p;
        if (gifImageView != null) {
            gifImageView.i();
        }
        if (this.f11334m) {
            e0();
        }
        SimpleExoPlayer simpleExoPlayer = this.f11338q;
        if (simpleExoPlayer != null) {
            f11333x = simpleExoPlayer.getCurrentPosition();
            this.f11338q.stop();
            this.f11338q.release();
            this.f11338q = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f11287j.u().isEmpty() && this.f11338q == null) {
            if (this.f11287j.u().get(0).i() || this.f11287j.u().get(0).f()) {
                j0();
                i0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        GifImageView gifImageView = this.f11337p;
        if (gifImageView != null) {
            CTInAppNotification cTInAppNotification = this.f11287j;
            gifImageView.setBytes(cTInAppNotification.j(cTInAppNotification.u().get(0)));
            this.f11337p.k();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GifImageView gifImageView = this.f11337p;
        if (gifImageView != null) {
            gifImageView.i();
        }
        SimpleExoPlayer simpleExoPlayer = this.f11338q;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.f11338q.release();
        }
    }
}
