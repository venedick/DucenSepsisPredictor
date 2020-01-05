package com.ducen.predictor.view.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ducen.predictor.model.RecentPatient;
import com.ducen.predictor.view.R;

import java.util.List;

public class RecentPatientAdapter extends RecyclerView.Adapter<RecentPatientAdapter.ViewHolder> {

    private List<RecentPatient> recentPatientList;

    public RecentPatientAdapter(List<RecentPatient> recentPatientList) {
        this.recentPatientList = recentPatientList;
    }

    @NonNull
    @Override
    public RecentPatientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_patient_row_layout, parent, false);

        if (itemView.getLayoutParams().height == RecyclerView.LayoutParams.MATCH_PARENT)
            itemView.getLayoutParams().height = parent.getHeight();
        {
            return new ViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecentPatientAdapter.ViewHolder holder, int position) {
        try {

            RecentPatient recentPatient = recentPatientList.get(position);

            String patientId = checkNull(recentPatient.getPatientId());
            String fullName = checkNull(recentPatient.getFullname());
            String gender = checkNull(recentPatient.getGender());
            String birthDate = checkNull(recentPatient.getBirthDate());
            String appointmentDescription = checkNull(recentPatient.getAppointmentDescription());
            String appointmentDate = checkNull(recentPatient.getAppointmentDate());

            holder.tvId.setText("Patient Id : " + patientId);
            holder.tvFullName.setText("Full Name : " + fullName);
            holder.tvGender.setText("Gender : " + gender);
            holder.tvbDay.setText("Birth date: " + birthDate);
            holder.tvDesc.setText("Description : " + appointmentDescription);
            holder.tvDate.setText("Date of Appointment : " + appointmentDate);

//            Log.d("TEST", "holder patient id: " + patientId);
//            Log.d("TEST", "holder fullname : " + fullname);
//            Log.d("TEST", "holder gender : " + gender);
//            Log.d("TEST", "holder age : " + patientId);
//            Log.d("TEST", "holder appointmentDescription : " + appointmentDescription);
//            Log.d("TEST", "holder appointmentDate : " + appointmentDate);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    String checkNull(String value) {
        if (value == null) {
            return "Default";
        } else if (value.equalsIgnoreCase("")) {
            return "Default";
        } else {
            return value;
        }
    }

    @Override
    public int getItemCount() {
        return this.recentPatientList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFullName, tvId, tvGender, tvbDay;
        private TextView tvDesc, tvDate;

        ViewHolder(View view) {
            super(view);
            tvFullName = view.findViewById(R.id.tv_patientFullName);
            tvId = view.findViewById(R.id.tv_patientId);
            tvGender = view.findViewById(R.id.tv_gender);
            tvbDay = view.findViewById(R.id.tv_bDay);
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
