/**
 * MAPD711
 * Assignment 2 - Group 7
 * Quoc Phong Ngo studentId:301148406
 * Feiliang Zhou studentId:301216989
 */
package com.example.a2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BahamasFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bahamas, container, false)
    }


}