package com.example.sunshine.admin;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshine.user.TimestampConverter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.example.sunshine.R;
import com.example.sunshine.database.Permission;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PermissionAdapter extends RecyclerView.Adapter<PermissionAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Permission> mPermissions = new ArrayList<>();
    FirebaseFirestore database;
    String currentUserId;
    PermissionFragment permissionFragment;

    public PermissionAdapter(Context context, ArrayList<Permission> permissions, String currentUserId, PermissionFragment permissionFragment) {
        this.mContext = context;
        this.mPermissions= permissions;
        this.database = FirebaseFirestore.getInstance();
        this.currentUserId = currentUserId;
        this.permissionFragment = permissionFragment;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_permission_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       // holder.commentTime.setText(TimestampConverter.getTime(comments.get(position).getPostTime()));

        // TODO: show user avatar
        //   holder.txtUsername.setText(requests.get(position).getPostBy());
       // holder.txtUsername.setText(mPermissions.get(position).getUs());
        //  holder.txtStatus.setText(posts.get(position).getStatus());
        holder.txtTime.setText(TimestampConverter.getTime(mPermissions.get(position).getPermissionTime()));
        //   holder.txtTitle.setText(posts.get(position).getBookName());
        //  holder.txtContent.setText(posts.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mPermissions.size();}
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;

        TextView  txtTime,txtUsername;
       // ImageButton btnReport;
        Button acceptBtn, declineBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
           // imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            txtUsername = (TextView) itemView.findViewById(R.id.txtUsername);
            txtTime = (TextView) itemView.findViewById(R.id.time_tv);
            acceptBtn = (Button) itemView.findViewById(R.id.acceptBtn);
            declineBtn = (Button) itemView.findViewById(R.id.declineBtn);
        }
    }
}
