package com.example.profile.ui.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
//import androidx.appcompat.app.AppCompatActivity;

import com.example.profile.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    int currentImage = 0;
    ImageButton prev,next;
    ImageView pic;
    TextView text;


    public GalleryFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root
                = inflater.inflate(R.layout.fragment_gallery, container, false);
        MediaController mc = new MediaController(getActivity());

        final TextView textView = root.findViewById(R.id.text);
        final VideoView videoView = root.findViewById(R.id.video_gallery);

        // getPackageName() is defined in activity so cannot use it dorectly in fragment
        String path = "android.resource://" + getActivity().getPackageName() + "/" + "/raw/clip";
        // "android.resources://com.example.profile.ui.gallery/" + R.raw.clip;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mc);
        videoView.start();

        // handling image view with image button




        //
        prev = root.findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String idX = "pic" + currentImage;
                //now get integer id of image from it's string id and that integer id is stored internally by android
                int x = view.getResources().getIdentifier(idX, "id",getActivity().getPackageName());
                pic = root.findViewById(x);

                pic.setAlpha(0f);


                // circulate image in a round way manner and because we have only 4 images  so used 4
                currentImage = (4 + currentImage - 1) % 4;
                String idY = "pic" + currentImage;
                //now get integer id of image from it's string id and that integer id is stored internally by android
                int y = view.getResources().getIdentifier(idY, "id",getActivity().getPackageName());
                pic = (ImageView) root.findViewById(y);
                pic.setAlpha(1f);
            }
        });


        //0 1 2 3 0 1 2 3
        next = root.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String idX = "pic" + currentImage;
                //now get integer id of image from it's string id and that integer id is stored internally by android
                int x = getResources().getIdentifier(idX, "id",getActivity().getPackageName());
                pic = root.findViewById(x);

                pic.setAlpha(0f);


                // circulate image in a round way manner and because we have only 4 images  so used 4
                currentImage = (currentImage + 1) % 4;
                String idY = "pic" + currentImage;
                //now get integer id of image from it's string id and that integer id is stored internally by android
                int y = getResources().getIdentifier(idY, "id",getActivity().getPackageName());
                pic = root.findViewById(y);
                pic.setAlpha(1f);
            }
        });









        //public void prevFunction(View v)
      //  {



       // }

      //  public void nextFunction(View v)
       // {

      //  }


        //galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
        //    }
        //})
        // ;
        return root;
    }
}
