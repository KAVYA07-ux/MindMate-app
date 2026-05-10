package com.kavya.mindmate;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.*;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import java.text.SimpleDateFormat;
import java.util.*;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        MoodViewModel viewModel = new ViewModelProvider(this).get(MoodViewModel.class);
        List<kotlin.Triple<String, String, Long>> moods = viewModel.getMoodHistory();

        // Setup RecyclerView
        RecyclerView rv = findViewById(R.id.rvMoodHistory);
        MoodAdapter adapter = new MoodAdapter(moods);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        // Setup Chart
        setupChart(moods);

        findViewById(R.id.btnBackHistory).setOnClickListener(v -> finish());
    }

    private void setupChart(List<kotlin.Triple<String, String, Long>> moods) {
        BarChart chart = findViewById(R.id.moodChart);
        chart.setBackgroundColor(Color.TRANSPARENT);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);

        String[] moodNames = {"Happy", "Sad", "Anxious", "Angry", "Calm", "Tired"};
        int[] colors = {
                Color.parseColor("#10B981"),
                Color.parseColor("#60A5FA"),
                Color.parseColor("#F59E0B"),
                Color.parseColor("#EF4444"),
                Color.parseColor("#A78BFA"),
                Color.parseColor("#6B7280")
        };

        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String name : moodNames) counts.put(name, 0);
        for (kotlin.Triple<String, String, Long> entry : moods) {
            if (counts.containsKey(entry.getFirst()))
                counts.put(entry.getFirst(), counts.get(entry.getFirst()) + 1);
        }

        List<BarEntry> entries = new ArrayList<>();
        int i = 0;
        for (int count : counts.values()) entries.add(new BarEntry(i++, count));

        BarDataSet dataSet = new BarDataSet(entries, "");
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.WHITE);

        chart.setData(new BarData(dataSet));

        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(moodNames));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(8f);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);

        chart.getAxisLeft().setTextColor(Color.WHITE);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setEnabled(false);
        chart.animateY(800);
        chart.invalidate();
    }

    static class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.VH> {
        private final List<kotlin.Triple<String, String, Long>> moods;
        private static final Map<String, String> EMOJIS = new HashMap<>();
        static {
            EMOJIS.put("Happy", "😊"); EMOJIS.put("Sad", "😢");
            EMOJIS.put("Anxious", "😰"); EMOJIS.put("Angry", "😡");
            EMOJIS.put("Calm", "😌"); EMOJIS.put("Tired", "😴");
            EMOJIS.put("Custom", "💭");
        }

        MoodAdapter(List<kotlin.Triple<String, String, Long>> moods) { this.moods = moods; }

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mood, parent, false);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {
            kotlin.Triple<String, String, Long> entry = moods.get(position);
            holder.tvMood.setText(entry.getFirst());
            holder.tvEmoji.setText(EMOJIS.getOrDefault(entry.getFirst(), "💭"));
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, hh:mm a", Locale.getDefault());
            holder.tvTime.setText(sdf.format(new Date(entry.getThird())));
        }

        @Override
        public int getItemCount() { return moods.size(); }

        static class VH extends RecyclerView.ViewHolder {
            TextView tvMood, tvEmoji, tvTime;
            VH(View v) {
                super(v);
                tvMood = v.findViewById(R.id.tvItemMood);
                tvEmoji = v.findViewById(R.id.tvItemEmoji);
                tvTime = v.findViewById(R.id.tvItemTime);
            }
        }
    }
}