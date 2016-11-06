package de.davidgollasch.emiexercise1;

import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Virtualizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.IOException;

public class AudioPlaybackActivity extends AppCompatActivity {

    private TextView textfield;

    /**
     * Switches (play/pause music)
     */
    private Switch sEasternEmotion, sReggaeFeeling;

    /**
     * Media Players (components to control MP3 playback)
     */
    private MediaPlayer mpEasternEmotion, mpReggaeFeeling;

    /**
     * Toggle Buttons to enable or disable Bass Boost and Virtualiser
     */
    private ToggleButton tbtnBassBoost, tbtnVirtualizer;

    /**
     * BassBoost and Virtualiser components
     */
    private BassBoost bassBoost;
    private Virtualizer virtualizer;

    /**
     * BassBoost and Virtualiser active monitoring
     */
    private boolean bassbEasternEmotion = false, bassbReggaeFeeling = false;
    private boolean virtEasternEmotion = false, virtReggaeFeeling = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_playback);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tuAkzentfarbe1BlauHell)));

        InitializeActivity();
    }

    /**
     * Initialises widgets and event handlers
     */
    private void InitializeActivity() {
        sEasternEmotion = (Switch) findViewById(R.id.switchEasternEmotion);
        sReggaeFeeling = (Switch) findViewById(R.id.switchReggaeFeeling);
        textfield = (TextView) findViewById(R.id.textView16);

        sEasternEmotion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EasternEmotionToggled();
            }
        });

        sReggaeFeeling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ReggaeFeelingToggled();
            }
        });

        mpEasternEmotion = MediaPlayer.create(this, R.raw.eastern_emotion_terrasound_de);
        mpReggaeFeeling = MediaPlayer.create(this, R.raw.reggae_feeling_terrasound_de);

        mpEasternEmotion.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sEasternEmotion.setChecked(false);
            }
        });

        mpReggaeFeeling.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sReggaeFeeling.setChecked(false);
            }
        });

        tbtnBassBoost = (ToggleButton) findViewById(R.id.toggleButtonBassBoost);
        tbtnVirtualizer = (ToggleButton) findViewById(R.id.toggleButtonVirtualizer);

        tbtnBassBoost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BassBoostClicked();
            }
        });

        tbtnVirtualizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VirtualizerClicked();
            }
        });


    }

    /**
     * Configures the sound FX setup based on a given session
     *
     * @param sessionID The session to apply FX on
     */
    private void ConfigureSoundEffects(int sessionID) {
        // Disable all prior FX
        if (bassBoost != null) {
            bassBoost.setEnabled(false);
        }
        if (virtualizer != null) {
            virtualizer.setEnabled(false);
        }

        // BASS BOOST
        bassBoost = new BassBoost(0, sessionID);
        if (bassBoost.getStrengthSupported()) {
            bassBoost.setStrength((short) 1000);
        }
        bassBoost.setEnabled(true);
        tbtnBassBoost.setChecked(true);

        // VIRTUALIZER
        virtualizer = new Virtualizer(0, sessionID);
        virtualizer.setStrength((short) 1000);
        virtualizer.setEnabled(true);
        tbtnVirtualizer.setChecked(true);
    }


    /**
     * Handle toggling of Eastern Emotion switch
     */
    private void EasternEmotionToggled() {

        /* TODO: IMPLEMENT THIS */
        boolean checked = sEasternEmotion.isChecked();
        if (checked) PlaybackEasternEmotion();
        else PauseEasternEmotion();

    }

    /**
     * Starts playback of first audio
     */
    private void PlaybackEasternEmotion() {

        /* TODO: IMPLEMENT THIS */
        // Safe previous sound effect setting
        boolean tbbass_previous = tbtnBassBoost.isChecked();
        boolean tbvirt_previous = tbtnVirtualizer.isChecked();
        // Pause other tracks
        if (sReggaeFeeling.isChecked()) sReggaeFeeling.setChecked(false);
        // Setup sound-effects
        ConfigureSoundEffects(mpEasternEmotion.getAudioSessionId());
        //Now both are active at first - disable if not prev. set:
        if (!tbbass_previous) {
            bassBoost.setEnabled(false);
            tbtnBassBoost.setChecked(false);
        }
        if (!tbvirt_previous) {
            virtualizer.setEnabled(false);
            tbtnVirtualizer.setChecked(false);
        }
        mpEasternEmotion.start();

    }

    /**
     * Halts playback of first audio
     */
    private void PauseEasternEmotion() {

        /* TODO: IMPLEMENT THIS*/
        mpEasternEmotion.pause();

    }

    /**
     * Handle toggling of Reggae Feeling switch
     */
    private void ReggaeFeelingToggled() {

        /* TODO: IMPLEMENT THIS */
        boolean checked = sReggaeFeeling.isChecked();
        if (checked) PlaybackReggaeFeeling();
        else PauseReggaeFeeling();

    }

    /**
     * Starts playback of second audio
     */
    private void PlaybackReggaeFeeling() {

        /* TODO: IMPLEMENT THIS */
        // Safe previous sound effect setting
        boolean tbbass_previous = tbtnBassBoost.isChecked();
        boolean tbvirt_previous = tbtnVirtualizer.isChecked();
        // Pause other tracks
        if (sEasternEmotion.isChecked()) sEasternEmotion.setChecked(false);
        // Setup sound-effects
        ConfigureSoundEffects(mpReggaeFeeling.getAudioSessionId());
        //Now both are active at first - disable if not prev. set:
        if (!tbbass_previous) {
            bassBoost.setEnabled(false);
            tbtnBassBoost.setChecked(false);
        }
        if (!tbvirt_previous) {
            virtualizer.setEnabled(false);
            tbtnVirtualizer.setChecked(false);
        }
        mpReggaeFeeling.start();

    }

    /**
     * Halts playback of second audio
     */
    private void PauseReggaeFeeling() {

        /* TODO: IMPLEMENT THIS */
        mpReggaeFeeling.pause();

    }

    /**
     * Handle Bass Boost Switch
     */
    private void BassBoostClicked() {
        /* TODO: IMPLEMENT THIS */
        boolean playingEE = sEasternEmotion.isChecked();
        boolean playingRF = sReggaeFeeling.isChecked();
        boolean activate = tbtnBassBoost.isChecked();

        if (activate) { //Aktivieren Anweisung
            if (playingEE) {
                if (bassBoost != null) {
                    mpEasternEmotion.pause();
                    bassBoost.setEnabled(true);
                    mpEasternEmotion.start();
                }
                return;
            }
            if (playingRF) {
                if (bassBoost != null) {
                    mpReggaeFeeling.pause();
                    bassBoost.setEnabled(true);
                    mpReggaeFeeling.start();
                }
                return;
            }
            return; //Keiner der beiden aktiv.
        }

        //Nicht aktiv ab hier

        if (bassBoost != null) {
            bassBoost.setEnabled(false);
        }
    }

    /**
     * Handle Virtualizer Switch
     */
    private void VirtualizerClicked() {

        /* TODO: IMPLEMENT THIS */
        boolean playingEE = sEasternEmotion.isChecked();
        boolean playingRF = sReggaeFeeling.isChecked();
        boolean activate = tbtnVirtualizer.isChecked();

        if (activate) { //Aktivieren Anweisung
            if (playingEE) {
                if (virtualizer != null) {
                    mpEasternEmotion.pause();
                    virtualizer.setEnabled(true);
                    mpEasternEmotion.start();
                }
                return;
            }
            if (playingRF) {
                if (virtualizer != null) {
                    mpReggaeFeeling.pause();
                    virtualizer.setEnabled(true);
                    mpReggaeFeeling.start();
                }
                return;
            }
            return; //Keiner der beiden aktiv.
        }

        //Nicht aktiv ab hier

        if (virtualizer != null) {
            virtualizer.setEnabled(false);
        }

    }

}
