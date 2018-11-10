package com.xxcc.project

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.content.*


/**
 * Created by xxcc on 2018/11/9.
 */
class ContentFragment : Fragment() {

    companion object {
        fun newInstance(value: String): ContentFragment {
            var args = Bundle()
            args.putString("ContentFragment", value)
            var fragment = ContentFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.content, container, false)
        var tvText = view.findViewById<TextView>(R.id.text)
        tvText.text = arguments?.getString("ContentFragment")
        initView(view)
        return view
    }


    private var lastY = 0
    private var defaultY = 0
    @SuppressLint("ClickableViewAccessibility")
    private fun initView(view: View?) {
        var button = view?.findViewById<Button>(R.id.button)
        var layout1 = view?.findViewById<LinearLayout>(R.id.layout1)

        button?.measure(0, 0)
        button?.setOnTouchListener { v, event ->
            var dy: Int = event.rawY.toInt()
            if (defaultY == 0) {
                defaultY = dy
            }
            if (event.action == MotionEvent.ACTION_DOWN) {
                lastY = dy
            } else if (event.action == MotionEvent.ACTION_MOVE) {
                var offset: Int = dy - lastY
                var b=v.top
                var t=resources.displayMetrics.heightPixels-v.height
                if (dy > defaultY && dy < resources.displayMetrics.heightPixels) {
                    v.offsetTopAndBottom(offset)
                    scrollView?.offsetTopAndBottom(offset)
                    lastY = dy
                }
            }
            true
        }
        layout1?.setOnTouchListener { v, event ->
            true
        }


    }


}