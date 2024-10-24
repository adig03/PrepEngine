package com.example.codemastery.pdf

import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Tasks
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch

class PdfRepository {

    private val storage = FirebaseStorage.getInstance()
    private val storageRef = storage.reference


    suspend fun getAllPdfUrls(subject: String, onSuccess: (List<String>) -> Unit, onFailure: (Exception) -> Unit) {

        val folderRef = storageRef.child(subject)

        folderRef.listAll().addOnSuccessListener { listResult ->
            val pdfUrls = mutableListOf<String>()
            val tasks = listResult.items.map { item ->
                item.downloadUrl.addOnSuccessListener { uri ->
                    pdfUrls.add(uri.toString())
                }
            }


            Tasks.whenAll(tasks).addOnCompleteListener {
                if (tasks.isNotEmpty()) {
                    onSuccess(pdfUrls)
                } else {
                    onFailure(Exception("No PDFs found in the folder"))
                }
            }

        }.addOnFailureListener { exception ->
            onFailure(exception)
        }
    }

    suspend fun getPdfNames(subject: String, onSuccess: (List<String>) -> Unit, onFailure: (Exception) -> Unit) {
        val pdfRef = storageRef.child(subject)

        pdfRef.listAll().addOnSuccessListener { listResult ->
            val pdfNames = listResult.items.map { it.name } // Get the names of the files
            onSuccess(pdfNames)
        }.addOnFailureListener { exception ->
            onFailure(exception)
        }
    }
}
