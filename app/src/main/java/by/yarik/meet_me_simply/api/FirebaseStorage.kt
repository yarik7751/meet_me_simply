package by.yarik.meet_me_simply.api

import android.net.Uri
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import java.io.File

object FirebaseStorage {

    val TAG = "FirebaseStorage_log"
    val STORAGE_PATH = "gs://meetmesimply.appspot.com"

    fun uploadVideo(
            path: String,
            onSuccessListener: OnSuccessListener<UploadTask.TaskSnapshot>,
            onFailureListener: OnFailureListener) {
        var splitPath = path.split("/")
        val uri = Uri.fromFile(File(path))
        val storageReference = FirebaseStorage
                .getInstance(STORAGE_PATH)
                .reference
                .child(splitPath[splitPath.size - 1])
        storageReference.putFile(uri)
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener)
    }
}