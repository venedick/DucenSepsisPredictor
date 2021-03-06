package com.ducen.predictor.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ducen.predictor.r4.entity.R4Appointment;
import com.ducen.predictor.r4.entity.R4Patient;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.view.R;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {

    private List<R4Patient> patientList;
    private List<R4Appointment> appointmentList;

    public PatientAdapter(List<R4Patient> patientList,List<R4Appointment> appointmentList){
        this.patientList = patientList;
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_patient_row_layout, parent, false);

        if (itemView.getLayoutParams ().height == RecyclerView.LayoutParams.MATCH_PARENT)
            itemView.getLayoutParams ().height = parent.getHeight();
        {
            return new ViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PatientAdapter.ViewHolder holder, int position) {
        try {
            R4Patient r4Patient = patientList.get(position);
            List<HumanName> humanNames = r4Patient.getHumanName();
            Log.d("TEST","AdapterException: " + humanNames.toString());
            for (HumanName humanName : humanNames){
                String familyName = humanName.getFamily();
                String givenNames = humanName.getGiven().get(0);
                String fullName = givenNames + familyName;
                holder.tvFullName.setText(fullName);
                holder.tvGender.setText(r4Patient.getGender());
            }

            R4Appointment r4Appointment = appointmentList.get(position);
            String description = r4Appointment.getDescription();
            String dateAppointed = r4Appointment.getStart();
            holder.tvDesc.setText(description);
            holder.tvDate.setText(dateAppointed);

        }  catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public int getItemCount() {
        return  patientList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFullName, tvId, tvGender, tvAge;
        private TextView tvDesc, tvDate;
        ViewHolder(View view) {
            super(view);
            tvFullName = view.findViewById(R.id.tv_patientFullName);
            tvId = view.findViewById(R.id.tv_patientId);
            tvGender = view.findViewById(R.id.tv_gender);
            //tvAge = view.findViewById(R.id.tv_age);
            tvDesc = view.findViewById(R.id.tv_desc);
            tvDate = view.findViewById(R.id.tv_app_date);

        }
    }

    public interface clickListener {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private clickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final clickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
