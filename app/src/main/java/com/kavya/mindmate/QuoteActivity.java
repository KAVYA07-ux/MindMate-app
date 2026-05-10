package com.kavya.mindmate;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuoteActivity extends AppCompatActivity {

    private static final java.util.Map<String, String[]> QUOTES = new java.util.HashMap<>();

    static {
        QUOTES.put("Happy", new String[]{
                "Happiness is not something ready-made. It comes from your own actions.",
                "Keep smiling, because life is a beautiful thing!",
                "The most wasted of days is one without laughter."
        });
        QUOTES.put("Sad", new String[]{
                "Even the darkest night will end and the sun will rise.",
                "Tears come from the heart and not from the brain.",
                "It's okay to not be okay. Just don't give up."
        });
        QUOTES.put("Anxious", new String[]{
                "You don't have to control your thoughts. You just have to stop letting them control you.",
                "Breathe. You are enough. You have enough. You do enough.",
                "Anxiety is a thin stream of fear trickling through the mind."
        });
        QUOTES.put("Angry", new String[]{
                "For every minute you are angry you lose sixty seconds of peace.",
                "Speak when you are angry and you will make the best speech you will ever regret.",
                "Take a deep breath. It's just a bad day, not a bad life."
        });
        QUOTES.put("Calm", new String[]{
                "Peace comes from within. Do not seek it without.",
                "Calm mind brings inner strength and self-confidence.",
                "Within you there is a stillness and a sanctuary."
        });
        QUOTES.put("Tired", new String[]{
                "Rest when you're weary. Refresh and renew yourself.",
                "Almost everything will work again if you unplug it for a few minutes.",
                "Take rest; a field that has rested gives a bountiful crop."
        });
        QUOTES.put("Custom", new String[]{
                "Your feelings are valid. Take a moment for yourself.",
                "Every emotion you feel is telling you something important.",
                "Be gentle with yourself. You are a child of the universe."
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        String mood = getIntent().getStringExtra("mood");
        if (mood == null) mood = "Happy";

        String[] quotes = QUOTES.getOrDefault(mood, QUOTES.get("Custom"));
        String quote = quotes[(int)(Math.random() * quotes.length)];

        TextView tvMoodTitle = findViewById(R.id.tvMoodTitle);
        TextView tvQuote = findViewById(R.id.tvQuote);
        TextView tvEmoji = findViewById(R.id.tvEmoji);

        tvMoodTitle.setText("Feeling " + mood);
        tvQuote.setText(quote);

        java.util.Map<String, String> emojis = new java.util.HashMap<>();
        emojis.put("Happy", "😊");
        emojis.put("Sad", "😢");
        emojis.put("Anxious", "😰");
        emojis.put("Angry", "😡");
        emojis.put("Calm", "😌");
        emojis.put("Tired", "😴");
        emojis.put("Custom", "💭");
        tvEmoji.setText(emojis.getOrDefault(mood, "💭"));

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}