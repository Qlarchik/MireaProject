package com.mirea.shakhnazaryan.mireaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Student> students;

    RecyclerViewAdapter(Context context, List<Student> students) {
        this.students = students;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.history_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.nameView.setText(student.name);
        holder.universityView.setText(student.university);
        holder.ageView.setText(student.age);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final TextView universityView;
        final TextView ageView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.textView8);
            universityView = view.findViewById(R.id.textView9);
            ageView = view.findViewById(R.id.textView10);
        }
    }
}
