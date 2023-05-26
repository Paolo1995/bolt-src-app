package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzng;
import com.google.android.gms.internal.measurement.zznj;
import com.google.android.gms.internal.measurement.zznm;
import com.google.android.gms.internal.measurement.zznp;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzny;
import com.google.android.gms.internal.measurement.zzob;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzoh;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzoq;
import com.google.android.gms.internal.measurement.zzot;
import com.google.android.gms.internal.measurement.zzow;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.internal.measurement.zzpl;
import com.google.android.gms.internal.measurement.zzpo;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzpu;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzeh {
    public static final zzeg zzG;
    public static final zzeg zzH;
    public static final zzeg zzI;
    public static final zzeg zzJ;
    public static final zzeg zzK;
    public static final zzeg zzL;
    public static final zzeg zzM;
    public static final zzeg zzN;
    public static final zzeg zzO;
    public static final zzeg zzP;
    public static final zzeg zzQ;
    public static final zzeg zzR;
    public static final zzeg zzS;
    public static final zzeg zzT;
    public static final zzeg zzU;
    public static final zzeg zzV;
    public static final zzeg zzW;
    public static final zzeg zzX;
    public static final zzeg zzY;
    public static final zzeg zzZ;
    public static final zzeg zzaA;
    public static final zzeg zzaB;
    public static final zzeg zzaC;
    public static final zzeg zzaD;
    public static final zzeg zzaE;
    public static final zzeg zzaF;
    public static final zzeg zzaG;
    public static final zzeg zzaH;
    public static final zzeg zzaa;
    public static final zzeg zzab;
    public static final zzeg zzac;
    public static final zzeg zzad;
    public static final zzeg zzae;
    public static final zzeg zzaf;
    public static final zzeg zzag;
    public static final zzeg zzah;
    public static final zzeg zzai;
    public static final zzeg zzaj;
    public static final zzeg zzak;
    public static final zzeg zzal;
    public static final zzeg zzam;
    public static final zzeg zzan;
    public static final zzeg zzao;
    public static final zzeg zzap;
    public static final zzeg zzaq;
    public static final zzeg zzar;
    public static final zzeg zzas;
    public static final zzeg zzat;
    public static final zzeg zzau;
    public static final zzeg zzav;
    public static final zzeg zzaw;
    public static final zzeg zzax;
    public static final zzeg zzay;
    public static final zzeg zzaz;
    private static final List zzaI = Collections.synchronizedList(new ArrayList());
    private static final Set zzaJ = Collections.synchronizedSet(new HashSet());
    public static final zzeg zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbj
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzb());
        }
    });
    public static final zzeg zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbb
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzl());
        }
    });
    public static final zzeg zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbn
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzd());
        }
    });
    public static final zzeg zzd = zza("measurement.config.url_scheme", "https", "https", new zzed() { // from class: com.google.android.gms.measurement.internal.zzbz
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return zznp.zzK();
        }
    });
    public static final zzeg zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", new zzed() { // from class: com.google.android.gms.measurement.internal.zzcl
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return zznp.zzJ();
        }
    });
    public static final zzeg zzf = zza("measurement.upload.max_bundles", 100, 100, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcx
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzw());
        }
    });
    public static final zzeg zzg = zza("measurement.upload.max_batch_size", 65536, 65536, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdj
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzE());
        }
    });
    public static final zzeg zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdv
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzv());
        }
    });
    public static final zzeg zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdz
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzz());
        }
    });
    public static final zzeg zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzea
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzA());
        }
    });
    public static final zzeg zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbu
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzy());
        }
    });
    public static final zzeg zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcf
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzB());
        }
    });
    public static final zzeg zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcq
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzx());
        }
    });
    public static final zzeg zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdb
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzD());
        }
    });
    public static final zzeg zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdm
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzg());
        }
    });
    public static final zzeg zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", new zzed() { // from class: com.google.android.gms.measurement.internal.zzdx
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return zznp.zzL();
        }
    });
    public static final zzeg zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzeb
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzs());
        }
    });
    public static final zzeg zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzec
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzH());
        }
    });
    public static final zzeg zzs = zza("measurement.upload.interval", 3600000L, 3600000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzaz
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzu());
        }
    });
    public static final zzeg zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzba
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzm());
        }
    });
    public static final zzeg zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbc
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zze());
        }
    });
    public static final zzeg zzv = zza("measurement.upload.minimum_delay", 500L, 500L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbd
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzk());
        }
    });
    public static final zzeg zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbe
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzj());
        }
    });
    public static final zzeg zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbf
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzp());
        }
    });
    public static final zzeg zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbg
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzn());
        }
    });
    public static final zzeg zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbh
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzt());
        }
    });
    public static final zzeg zzA = zza("measurement.upload.retry_time", 1800000L, 1800000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbi
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzG());
        }
    });
    public static final zzeg zzB = zza("measurement.upload.retry_count", 6, 6, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbk
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzF());
        }
    });
    public static final zzeg zzC = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbl
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Long.valueOf(zznp.zzC());
        }
    });
    public static final zzeg zzD = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbm
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzf());
        }
    });
    public static final zzeg zzE = zza("measurement.audience.filter_result_max_count", 200, 200, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbo
        @Override // com.google.android.gms.measurement.internal.zzed
        public final Object zza() {
            zzeg zzegVar = zzeh.zza;
            return Integer.valueOf((int) zznp.zzi());
        }
    });
    public static final zzeg zzF = zza("measurement.upload.max_public_user_properties", 25, 25, null);

    static {
        Integer valueOf = Integer.valueOf((int) CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
        zzG = zza("measurement.upload.max_event_name_cardinality", valueOf, valueOf, null);
        zzH = zza("measurement.upload.max_public_event_params", 25, 25, null);
        zzI = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbp
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzo());
            }
        });
        Boolean bool = Boolean.FALSE;
        zzJ = zza("measurement.test.boolean_flag", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbq
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzot.zzg());
            }
        });
        zzK = zza("measurement.test.string_flag", "---", "---", new zzed() { // from class: com.google.android.gms.measurement.internal.zzbr
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return zzot.zzf();
            }
        });
        zzL = zza("measurement.test.long_flag", -1L, -1L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbs
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zzot.zzd());
            }
        });
        zzM = zza("measurement.test.int_flag", -2, -2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbt
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zzot.zzc());
            }
        });
        Double valueOf2 = Double.valueOf(-3.0d);
        zzN = zza("measurement.test.double_flag", valueOf2, valueOf2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbv
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Double.valueOf(zzot.zzb());
            }
        });
        zzO = zza("measurement.experiment.max_ids", 50, 50, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbw
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzh());
            }
        });
        zzP = zza("measurement.max_bundles_per_iteration", 100, 100, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbx
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzc());
            }
        });
        zzQ = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzby
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzq());
            }
        });
        zzR = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzca
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzr());
            }
        });
        Boolean bool2 = Boolean.TRUE;
        zzS = zza("measurement.collection.log_event_and_bundle_v2", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcb
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoz.zzc());
            }
        });
        zzT = zza("measurement.quality.checksum", bool, bool, null);
        zzU = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcc
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoe.zze());
            }
        });
        zzV = zza("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcd
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoe.zzd());
            }
        });
        zzW = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzce
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoe.zzf());
            }
        });
        zzX = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcg
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpr.zzc());
            }
        });
        zzY = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzch
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzon.zzc());
            }
        });
        zzZ = zza("measurement.lifecycle.app_in_background_parameter", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzci
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoq.zzc());
            }
        });
        zzaa = zza("measurement.integration.disable_firebase_instance_id", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcj
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpo.zzd());
            }
        });
        zzab = zza("measurement.collection.service.update_with_analytics_fix", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzck
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpu.zzc());
            }
        });
        zzac = zza("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcm
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzob.zzd());
            }
        });
        zzad = zza("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcn
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzok.zzd());
            }
        });
        zzae = zza("measurement.collection.synthetic_data_mitigation", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzco
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpl.zzc());
            }
        });
        zzaf = zza("measurement.service.storage_consent_support_version", 203600, 203600, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcp
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zzns.zzb());
            }
        });
        zzag = zza("measurement.client.click_identifier_control.dev", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcr
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznj.zzc());
            }
        });
        zzah = zza("measurement.service.click_identifier_control", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcs
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznm.zzc());
            }
        });
        zzai = zza("measurement.module.pixie.fix_array", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzct
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzow.zzd());
            }
        });
        zzaj = zza("measurement.adid_zero.only_request_adid_if_enabled", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcu
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzng.zzc());
            }
        });
        zzak = zza("measurement.service.refactor.package_side_screen", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcv
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpf.zzd());
            }
        });
        zzal = zza("measurement.enhanced_campaign.service", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcw
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zze());
            }
        });
        zzam = zza("measurement.enhanced_campaign.client", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcy
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zzd());
            }
        });
        zzan = zza("measurement.enhanced_campaign.srsltid.client", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcz
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zzf());
            }
        });
        zzao = zza("measurement.enhanced_campaign.srsltid.service", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzda
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zzg());
            }
        });
        zzap = zza("measurement.service.store_null_safelist", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdc
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzny.zzd());
            }
        });
        zzaq = zza("measurement.service.store_safelist", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdd
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzny.zze());
            }
        });
        zzar = zza("measurement.redaction.no_aiid_in_config_request", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzde
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzl());
            }
        });
        zzas = zza("measurement.redaction.config_redacted_fields", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdf
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzf());
            }
        });
        zzat = zza("measurement.redaction.upload_redacted_fields", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdg
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzo());
            }
        });
        zzau = zza("measurement.redaction.upload_subdomain_override", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdh
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzp());
            }
        });
        zzav = zza("measurement.redaction.device_info", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdi
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzg());
            }
        });
        zzaw = zza("measurement.redaction.user_id", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdk
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzq());
            }
        });
        zzax = zza("measurement.redaction.google_signals", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdl
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzk());
            }
        });
        zzay = zza("measurement.collection.enable_session_stitching_token.service", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdn
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpi.zze());
            }
        });
        zzaz = zza("measurement.collection.enable_session_stitching_token.client.dev", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdo
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpi.zzd());
            }
        });
        zzaA = zza("measurement.redaction.app_instance_id", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdp
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzd());
            }
        });
        zzaB = zza("measurement.redaction.populate_ephemeral_app_instance_id", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdq
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzj());
            }
        });
        zzaC = zza("measurement.redaction.enhanced_uid", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdr
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzi());
            }
        });
        zzaD = zza("measurement.redaction.e_tag", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzds
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzh());
            }
        });
        zzaE = zza("measurement.redaction.client_ephemeral_aiid_generation", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdt
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zze());
            }
        });
        zzaF = zza("measurement.redaction.retain_major_os_version", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdu
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzm());
            }
        });
        zzaG = zza("measurement.redaction.scion_payload_generator", bool, bool, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdw
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzn());
            }
        });
        zzaH = zza("measurement.audience.dynamic_filters.oob_fix", bool2, bool2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdy
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoh.zzd());
            }
        });
    }

    @VisibleForTesting
    static zzeg zza(String str, Object obj, Object obj2, zzed zzedVar) {
        zzeg zzegVar = new zzeg(str, obj, obj2, zzedVar, null);
        zzaI.add(zzegVar);
        return zzegVar;
    }

    public static Map zzc(Context context) {
        com.google.android.gms.internal.measurement.zzhe zza2 = com.google.android.gms.internal.measurement.zzhe.zza(context.getContentResolver(), com.google.android.gms.internal.measurement.zzhp.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzay
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.internal.measurement.zzia.zzd();
            }
        });
        if (zza2 == null) {
            return Collections.emptyMap();
        }
        return zza2.zzc();
    }
}
