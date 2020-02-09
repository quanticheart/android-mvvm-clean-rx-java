@file:Suppress("UNCHECKED_CAST")

package com.quanticheart.core.extentions.activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.quanticheart.core.R
import kotlinx.android.synthetic.main.activity_base.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass


abstract class BaseActivity<ViewModelType : ViewModel> :
    AppCompatActivity() {

    lateinit var viewModel: ViewModelType
    abstract fun setLayoutContent(): Int
    abstract fun initLayout(savedInstanceState: Bundle?)
    abstract fun initViewModel(viewModel: ViewModelType)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(setLayoutContent(), null)
        baseContent.addView(view)

        initLayout(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val viewModel1: ViewModelType by viewModel(getKClass())
        this.viewModel = viewModel1
        initViewModel(viewModel)
    }

    private fun getKClass(): KClass<ViewModelType> =
        ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModelType>).kotlin

    private var snackbar: Snackbar? = null
    // Showing the status in Snackbar
    protected fun Boolean.connStatus() {
        if (!this) {
            snackbar?.let {
                snackbar?.show()
            } ?: run {
                snackbar = Snackbar.make(baseContent, "Sem conexâo", Snackbar.LENGTH_INDEFINITE)
                snackbar?.show()
            }
        } else {
            snackbar?.dismiss()
            snackbar = null
        }
    }
}